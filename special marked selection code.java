public class User {
    private String username;
    private String password;
    private boolean isSpecialMarked;

    // constructor and getters/setters
}



public List<User> getSpecialMarkedUsers() {
    List<User> userList = // get all users from database or in-memory list
    List<User> specialMarkedUsers = new ArrayList<>();

    for (User user : userList) {
        if (user.isSpecialMarked()) {
            specialMarkedUsers.add(user);
        }
    }

    return specialMarkedUsers;
}


List<User> specialMarkedUsers = userService.getSpecialMarkedUsers();

for (User user : specialMarkedUsers) {
    // add user to dropdown list
}
