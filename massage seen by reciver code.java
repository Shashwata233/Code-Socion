import java.util.HashMap;
import java.util.Map;

public class MessageStatus {
    
    private Map<Integer, Boolean> messageStatusMap; // stores the read status of each message
    
    public MessageStatus() {
        messageStatusMap = new HashMap<>();
    }
    
    // set the status of a message to read
    public void setMessageRead(int messageId) {
        messageStatusMap.put(messageId, true);
        System.out.println("Message " + messageId + " has been read.");
    }
    
    // check the status of a message
    public boolean isMessageRead(int messageId) {
        if (!messageStatusMap.containsKey(messageId)) {
            return false;
        }
        return messageStatusMap.get(messageId);
    }
    
    public static void main(String[] args) {
        MessageStatus messageStatus = new MessageStatus();
        
        // set some messages as read
        messageStatus.setMessageRead(1);
        messageStatus.setMessageRead(2);
        messageStatus.setMessageRead(3);
        
        // check if a message has been read
        System.out.println("Is message 1 read? " + messageStatus.isMessageRead(1));
        System.out.println("Is message 2 read? " + messageStatus.isMessageRead(2));
        System.out.println("Is message 3 read? " + messageStatus.isMessageRead(3));
        System.out.println("Is message 4 read? " + messageStatus.isMessageRead(4));
    }
}
