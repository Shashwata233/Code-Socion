import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class DataConnectionStatus {
    
    // check if the data connection is on
    public static boolean isDataConnectionOn(Context context) {
        ConnectivityManager connManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connManager.getActiveNetworkInfo();
        return (networkInfo != null && networkInfo.isConnected());
    }
    
    public static void main(String[] args) {
        // check if the data connection is on
        boolean isDataConnectionOn = DataConnectionStatus.isDataConnectionOn(context);
        System.out.println("Is the data connection on? " + isDataConnectionOn);
    }
}
