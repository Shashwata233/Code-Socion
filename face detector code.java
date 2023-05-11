import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.videoio.VideoCapture;

public class FaceDetection {

    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        // Load the classifier XML file for face detection
        CascadeClassifier faceDetector = new CascadeClassifier("haarcascade_frontalface_alt.xml");

        // Open the default camera
        VideoCapture camera = new VideoCapture(0);

        // Check if camera is opened successfully
        if (!camera.isOpened()) {
            System.out.println("Failed to open camera.");
            return;
        }

        // Create a new window to display the camera feed
        String windowName = "Face Detection";
        Size windowSize = new Size(640, 480);
        Imgproc.namedWindow(windowName, Imgproc.WINDOW_NORMAL);
        Imgproc.resizeWindow(windowName, windowSize);

        // Process the camera feed in a loop
        Mat frame = new Mat();
        MatOfRect faceDetections = new MatOfRect();
        while (true) {
            // Capture a new frame from the camera
            if (camera.read(frame)) {
                // Convert the frame to grayscale for better face detection
                Mat grayFrame = new Mat();
                Imgproc.cvtColor(frame, grayFrame, Imgproc.COLOR_BGR2GRAY);

                // Detect faces in the grayscale frame
                faceDetector.detectMultiScale(grayFrame, faceDetections);

                // Draw rectangles around the detected faces
                for (Rect rect : faceDetections.toArray()) {
                    Imgproc.rectangle(frame, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height), new Scalar(0, 0, 255), 2);
                }

                // Display the processed frame in the window
                Imgproc.imshow(windowName, frame);
            }

            // Check for user input to exit the loop
            if (Imgproc.waitKey(1) == 27) {
                break;
            }
        }

        // Release the camera and destroy the window
        camera.release();
        Imgproc.destroyAllWindows();
    }
}
