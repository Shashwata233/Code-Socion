public class Message {
    private final String sender;
    private final String receiver;
    private final String content;
    private final LocalDateTime timestamp;

    public Message(String sender, String receiver, String content) {
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
        this.timestamp = LocalDateTime.now();
    }

    public String getSender() {
        return sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "[" + timestamp.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "] "
                + sender + " -> " + receiver + ": " + content;
    }
}









import java.util.ArrayList;
import java.util.List;

public class Chat {
    private final List<Message> messages;

    public Chat() {
        this.messages = new ArrayList<>();
    }

    public void sendMessage(Message message) {
        messages.add(message);
    }

    public List<Message> getMessages() {
        return messages;
    }

    public List<Message> getMessagesForUser(String username) {
        List<Message> result = new ArrayList<>();
        for (Message message : messages) {
            if (message.getSender().equals(username) || message.getReceiver().equals(username)) {
                result.add(message);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Chat chat = new Chat();

        Message message1 = new Message("Alice", "Bob", "Hi Bob, how are you?");
        chat.sendMessage(message1);

        Message message2 = new Message("Bob", "Alice", "I'm fine, thanks! How about you?");
        chat.sendMessage(message2);

        List<Message> aliceMessages = chat.getMessagesForUser("Alice");
        System.out.println("Messages for Alice:");
        for (Message message : aliceMessages) {
            System.out.println(message);
        }

        List<Message> bobMessages = chat.getMessagesForUser("Bob");
        System.out.println("Messages for Bob:");
        for (Message message : bobMessages) {
            System.out.println(message);
        }
    }
}





