import java.util.ArrayList;
import java.util.List;

public class Community {
    private String name;
    private List<User> members;
    
    public Community(String name) {
        this.name = name;
        this.members = new ArrayList<>();
    }
    
    public String getName() {
        return name;
    }
    
    public List<User> getMembers() {
        return members;
    }
    
    public void addMember(User user) {
        members.add(user);
        System.out.println(user.getUsername() + " has joined the community " + name);
    }
    
    public void removeMember(User user) {
        members.remove(user);
        System.out.println(user.getUsername() + " has left the community " + name);
    }
}

public class User {
    private String username;
    
    public User(String username) {
        this.username = username;
    }
    
    public String getUsername() {
        return username;
    }
}

public class CommunityCreation {
    public static void main(String[] args) {
        // Create a new community
        Community community = new Community("Java Developers");
        
        // Add members to the community
        User user1 = new User("Alice");
        User user2 = new User("Bob");
        community.addMember(user1);
        community.addMember(user2);
        
        // Remove a member from the community
        community.removeMember(user2);
    }
}
