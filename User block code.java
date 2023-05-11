import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private List<User> blockedUsers;

    public User(String username) {
        this.username = username;
        this.blockedUsers = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public void blockUser(User user) {
        blockedUsers.add(user);
    }

    public void unblockUser(User user) {
        blockedUsers.remove(user);
    }

    public boolean isBlocked(User user) {
        return blockedUsers.contains(user);
    }
}

public class Main {
    public static void main(String[] args) {
        User alice = new User("Alice");
        User bob = new User("Bob");
        User charlie = new User("Charlie");

        alice.blockUser(bob);

        System.out.println(alice.isBlocked(bob)); // true
        System.out.println(alice.isBlocked(charlie)); // false

        alice.unblockUser(bob);

        System.out.println(alice.isBlocked(bob)); // false
    }
}
