public class Message {
    private String sender;
    private String content;
    private boolean isFile;
    // add other fields as needed
    
    // Constructor
    public Message(String sender, String content, boolean isFile) {
        this.sender = sender;
        this.content = content;
        this.isFile = isFile;
    }
    
    // Getters and setters
    public String getSender() {
        return sender;
    }
    
    public String getContent() {
        return content;
    }
    
    public boolean isFile() {
        return isFile;
    }
    
    public void setSender(String sender) {
        this.sender = sender;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
    
    public void setIsFile(boolean isFile) {
        this.isFile = isFile;
    }
}

public class User {
    private String name;
    private List<Message> inbox;
    // add other fields as needed
    
    // Constructor
    public User(String name) {
        this.name = name;
        inbox = new ArrayList<>();
    }
    
    // Getters and setters
    public String getName() {
        return name;
    }
    
    // Methods
    public void receiveMessage(Message message) {
        inbox.add(message);
    }
    
    public void forwardMessage(Message message, User recipient) {
        recipient.receiveMessage(message);
    }
}
