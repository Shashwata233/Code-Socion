import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class FileDownloader {
    
    public static void downloadFile(String fileURL, String saveDir) throws IOException {
        URL url = new URL(fileURL);
        URLConnection conn = url.openConnection();
        InputStream inputStream = new BufferedInputStream(conn.getInputStream());
        String fileName = getFileName(conn);
        String saveFilePath = saveDir + "/" + fileName;
        
        FileOutputStream outputStream = new FileOutputStream(saveFilePath);
        byte[] buffer = new byte[1024];
        int bytesRead = -1;
        
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }
        
        outputStream.close();
        inputStream.close();
        System.out.println("File downloaded: " + saveFilePath);
    }
    
    private static String getFileName(URLConnection conn) {
        String fileName = "";
        String contentDisposition = conn.getHeaderField("Content-Disposition");
        String contentType = conn.getContentType();
        int contentLength = conn.getContentLength();
        
        if (contentDisposition != null) {
            int index = contentDisposition.indexOf("filename=");
            if (index > 0) {
                fileName = contentDisposition.substring(index + 10, contentDisposition.length() - 1);
            }
        } else {
            fileName = "file";
        }
        
        return fileName;
    }
    
}
