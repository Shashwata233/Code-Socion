import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class UrlGenerator {
    
    public static String generateProfileUrl(String username, String baseUrl) {
        String query = "";
        
        try {
            query = String.format("username=%s", URLEncoder.encode(username, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            System.err.println("Error encoding query: " + e.getMessage());
        }
        
        return baseUrl + "?" + query;
    }
    
    public static void main(String[] args) {
        String username = "johndoe";
        String baseUrl = "https://example.com/profile";
        String url = generateProfileUrl(username, baseUrl);
        System.out.println("Profile URL: " + url);
    }
    
}
