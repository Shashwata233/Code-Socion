import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.common.HybridBinarizer;

public class QRCodeScanner {
    public static void main(String[] args) throws IOException, NotFoundException {
        String filePath = "path/to/qr/code.png";
        File qrCodeFile = new File(filePath);
        BufferedImage qrCodeImage = ImageIO.read(qrCodeFile);
        LuminanceSource source = new BufferedImageLuminanceSource(qrCodeImage);
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
        try {
            Result result = new MultiFormatReader().decode(bitmap);
            System.out.println("QR Code contents: " + result.getText());
        } catch (ReaderException e) {
            System.out.println("QR Code not found in the image.");
        }
    }
}
