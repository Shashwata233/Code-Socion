import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScheduledMessageSender {
    public static void main(String[] args) {
        // create a new Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // prompt the user to enter the message to send
        System.out.print("Enter the message to send: ");
        String message = scanner.nextLine();

        // prompt the user to enter the date and time to send the message
        System.out.print("Enter the date and time to send the message (yyyy-MM-dd HH:mm:ss): ");
        String dateString = scanner.nextLine();

        // parse the date string into a Date object
        Date date;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            date = dateFormat.parse(dateString);
        } catch (Exception e) {
            System.out.println("Invalid date format. Please try again.");
            return;
        }

        // calculate the delay between now and the specified date and time
        long delay = date.getTime() - new Date().getTime();

        // create a new Timer object
        Timer timer = new Timer();

        // create a new TimerTask that sends the message
        TimerTask task = new TimerTask() {
            public void run() {
                // code to send the message goes here
                System.out.println("Sending message: " + message);
            }
        };

        // schedule the task to run at the specified time
        timer.schedule(task, delay);

        // let the user know that the message has been scheduled
        System.out.println("Message scheduled to send at " + date + ".");
    }
}
