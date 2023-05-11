import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ChatMessage {
    private String sender;
    private String recipient;
    private Date timestamp;
    private String text;
    private boolean deletedBySender;
    private boolean deletedForEveryone;

    public ChatMessage(String sender, String recipient, String text) {
        this.sender = sender;
        this.recipient = recipient;
        this.text = text;
        this.timestamp = new Date();
    }

    public String getSender() {
        return sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getText() {
        return text;
    }

    public boolean isDeletedBySender() {
        return deletedBySender;
    }

    public void setDeletedBySender(boolean deletedBySender) {
        this.deletedBySender = deletedBySender;
    }

    public boolean isDeletedForEveryone() {
        return deletedForEveryone;
    }

    public void setDeletedForEveryone(boolean deletedForEveryone) {
        this.deletedForEveryone = deletedForEveryone;
    }
}

public class Chat {
    private List<ChatMessage> messages;

    public Chat() {
        this.messages = new ArrayList<>();
    }

    public void addMessage(ChatMessage message) {
        messages.add(message);
    }

    public List<ChatMessage> getMessages() {
        return messages;
    }

    public void deleteMessage(ChatMessage message, boolean deleteForEveryone) {
        if (deleteForEveryone) {
            // Mark message as deleted for everyone
            message.setDeletedForEveryone(true);
        } else {
            // Mark message as deleted for sender only
            message.setDeletedBySender(true);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Chat chat = new Chat();
        ChatMessage message1 = new ChatMessage("Alice", "Bob", "Hello Bob!");
        ChatMessage message2 = new ChatMessage("Bob", "Alice", "Hi Alice!");
        chat.addMessage(message1);
        chat.addMessage(message2);

        // Delete message for sender only
        chat.deleteMessage(message1, false);

        // Delete message for everyone
        chat.deleteMessage(message2, true);

        for (ChatMessage message : chat.getMessages()) {
            if (!message.isDeletedBySender() && !message.isDeletedForEveryone()) {
                System.out.println(message.getSender() + ": " + message.getText());
            }
        }
    }
}
