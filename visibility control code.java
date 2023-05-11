public class User {
    private String name;
    private String profilePicture;
    private String status;
    private String bio;
    private boolean profilePictureVisibility;
    private boolean statusVisibility;
    private boolean bioVisibility;
    
    // Constructor
    public User(String name) {
        this.name = name;
        profilePictureVisibility = true; // Set default visibility to true
        statusVisibility = true;
        bioVisibility = true;
    }
    
    // Getters and setters
    public String getName() {
        return name;
    }
    
    public String getProfilePicture() {
        if (profilePictureVisibility) {
            return profilePicture;
        } else {
            return "Profile picture is not visible.";
        }
    }
    
    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }
    
    public String getStatus() {
        if (statusVisibility) {
            return status;
        } else {
            return "Status is not visible.";
        }
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getBio() {
        if (bioVisibility) {
            return bio;
        } else {
            return "Bio is not visible.";
        }
    }
    
    public void setBio(String bio) {
        this.bio = bio;
    }
    
    public void setProfilePictureVisibility(boolean visibility) {
        profilePictureVisibility = visibility;
    }
    
    public void setStatusVisibility(boolean visibility) {
        statusVisibility = visibility;
    }
    
    public void setBioVisibility(boolean visibility) {
        bioVisibility = visibility;
    }
}
