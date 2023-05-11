import java.util.HashMap;
import java.util.Map;

public class UserStatus {
    
    private Map<String, Boolean> userStatusMap; // stores the online status of each user
    
    public UserStatus() {
        userStatusMap = new HashMap<>();
    }
    
    // set the status of a user to online
    public void setUserOnline(String username) {
        userStatusMap.put(username, true);
        System.out.println(username + " is now online.");
    }
    
    // set the status of a user to offline
    public void setUserOffline(String username) {
        userStatusMap.put(username, false);
        System.out.println(username + " is now offline.");
    }
    
    // check the status of a user
    public boolean isUserOnline(String username) {
        if (!userStatusMap.containsKey(username)) {
            return false;
        }
        return userStatusMap.get(username);
    }
    
    public static void main(String[] args) {
        UserStatus userStatus = new UserStatus();
        
        // set some users online
        userStatus.setUserOnline("Alice");
        userStatus.setUserOnline("Bob");
        userStatus.setUserOnline("Charlie");
        
        // check if a user is online or offline
        System.out.println("Is Alice online? " + userStatus.isUserOnline("Alice"));
        System.out.println("Is Bob online? " + userStatus.isUserOnline("Bob"));
        System.out.println("Is Charlie online? " + userStatus.isUserOnline("Charlie"));
        System.out.println("Is David online? " + userStatus.isUserOnline("David"));
        
        // set some users offline
        userStatus.setUserOffline("Bob");
        userStatus.setUserOffline("Charlie");
        
        // check if a user is online or offline
        System.out.println("Is Alice online? " + userStatus.isUserOnline("Alice"));
        System.out.println("Is Bob online? " + userStatus.isUserOnline("Bob"));
        System.out.println("Is Charlie online? " + userStatus.isUserOnline("Charlie"));
        System.out.println("Is David online? " + userStatus.isUserOnline("David"));
    }
}
