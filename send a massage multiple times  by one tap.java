import java.util.Scanner;

public class MessageSender {
    
    public static void main(String[] args) {
        // Get user input
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your message: ");
        String message = input.nextLine();
        System.out.print("Enter the number of times to send the message: ");
        int numTimes = input.nextInt();
        
        // Send message multiple times
        for (int i = 0; i < numTimes; i++) {
            sendMessage(message);
        }
    }
    
    public static void sendMessage(String message) {
        // Code to send message to recipient goes here
        System.out.println("Message sent: " + message);
    }
}
