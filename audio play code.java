import javax.sound.sampled.*;
import java.io.*;

public class AudioPlayer {
    public static void main(String[] args) {
        try {
            // Open the file
            File file = new File("audiofile.mp3");
            AudioInputStream stream = AudioSystem.getAudioInputStream(file);

            // Get the format of the audio
            AudioFormat format = stream.getFormat();

            // Create a data line for the audio format
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);

            // Open the data line and start playing the audio
            SourceDataLine line = (SourceDataLine) AudioSystem.getLine(info);
            line.open(format);
            line.start();

            // Read the audio data and write it to the data line
            int numBytesRead;
            byte[] data = new byte[line.getBufferSize() / 5];
            while ((numBytesRead = stream.read(data, 0, data.length)) != -1) {
                line.write(data, 0, numBytesRead);
            }

            // Clean up
            stream.close();
            line.drain();
            line.stop();
            line.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
