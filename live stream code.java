import com.github.philippheuer.credentialmanager.domain.ObsCredentials;
import com.github.philippheuer.credentialmanager.CredentialManager;
import com.github.philippheuer.credentialmanager.domain.CredentialType;
import com.github.philippheuer.credentialmanager.identityprovider.TwitchIdentityProvider;
import com.github.philippheuer.events4j.simple.SimpleEventHandler;
import com.github.philippheuer.events4j.simple.domain.EventSubscriber;
import com.github.philippheuer.events4j.simple.domain.EventSubscriberOrder;
import com.github.philippheuer.events4j.simple.domain.IEvent;
import com.github.philippheuer.events4j.simple.listener.SimpleEventListener;
import com.github.philippheuer.events4j.simple.listener.SimpleEventListenerAdapter;
import com.github.philippheuer.events4j.simple.listener.SimpleEventSubscriber;
import com.github.philippheuer.gcf4j.api.IStreamingService;
import com.github.philippheuer.gcf4j.api.domain.IGCFChannel;
import com.github.philippheuer.gcf4j.api.domain.IGCFStream;
import com.github.philippheuer.gcf4j.api.domain.IGCFUser;
import com.github.philippheuer.gcf4j.api.domain.IGCFViewer;
import com.github.philippheuer.gcf4j.api.enumeration.StreamState;
import com.github.philippheuer.gcf4j.api.exceptions.StreamerException;
import com.github.philippheuer.gcf4j.core.GCF;
import com.github.philippheuer.gcf4j.core.GCFBuilder;

public class LiveStream {

    public static void main(String[] args) {

        // Load Twitch Credentials
        CredentialManager credentialManager = new CredentialManager();
        credentialManager.addIdentityProvider(new TwitchIdentityProvider());
        ObsCredentials obsCredentials = credentialManager.getByName(CredentialType.OBS, "default");

        // Init GCF
        IStreamingService streamingService = new GCFBuilder()
            .withStreamer(obsCredentials)
            .build()
            .createService(IStreamingService.class);

        // Start streaming
        try {
            IGCFChannel channel = streamingService.getChannelById("channel_id_here");
            IGCFStream stream = streamingService.getStreamById("stream_id_here");
            streamingService.startStream(channel, stream);
        } catch (StreamerException e) {
            e.printStackTrace();
        }

    }

}
