import java.util.Scanner;

public class AutoReplyChatBot {
    private final String autoReplyMessage;

    public AutoReplyChatBot(String autoReplyMessage) {
        this.autoReplyMessage = autoReplyMessage;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter message: ");
            String message = scanner.nextLine();

            if (message.equals("exit")) {
                break;
            }

            System.out.println("Received message: " + message);

            // Check if auto-reply is enabled
            if (autoReplyMessage != null && !autoReplyMessage.isEmpty()) {
                System.out.println("Auto-replying with message: " + autoReplyMessage);
                // Send auto-reply message
                // ...
            }
        }

        scanner.close();
    }

    public static void main(String[] args) {
        String autoReplyMessage = "Hello, thank you for your message. I am currently out of the office and will respond to your message as soon as possible.";
        AutoReplyChatBot chatBot = new AutoReplyChatBot(autoReplyMessage);
        chatBot.start();
    }
}
