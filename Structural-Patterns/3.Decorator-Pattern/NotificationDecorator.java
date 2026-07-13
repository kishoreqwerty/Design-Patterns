// Component interface
interface Notification {
    String getMessage();
    double getCost();
}

// Base notification implementation
class EmailNotification implements Notification {

    @Override
    public String getMessage() {
        return "Email Notification";
    }

    @Override
    public double getCost() {
        return 2.0;
    }
}

// Base decorator class
abstract class NotificationDecorator implements Notification {

    protected Notification notification;

    public NotificationDecorator(Notification notification) {
        this.notification = notification;
    }
}

// Adds SMS support to existing notification
class SMSNotification extends NotificationDecorator {

    public SMSNotification(Notification notification) {
        super(notification);
    }

    @Override
    public String getMessage() {
        return notification.getMessage() + " + SMS Notification";
    }

    @Override
    public double getCost() {
        return notification.getCost() + 1.5;
    }
}

// Adds Push Notification support
class PushNotification extends NotificationDecorator {

    public PushNotification(Notification notification) {
        super(notification);
    }

    @Override
    public String getMessage() {
        return notification.getMessage() + " + Push Notification";
    }

    @Override
    public double getCost() {
        return notification.getCost() + 0.5;
    }
}

// Adds Slack notification support
class SlackNotification extends NotificationDecorator {

    public SlackNotification(Notification notification) {
        super(notification);
    }

    @Override
    public String getMessage() {
        return notification.getMessage() + " + Slack Notification";
    }

    @Override
    public double getCost() {
        return notification.getCost() + 1.0;
    }
}

// Driver class
public class Main {

    public static void main(String[] args) {

        // Basic email notification
        Notification notification =
                new EmailNotification();

        // Dynamically add additional channels
        notification =
                new SMSNotification(notification);

        notification =
                new PushNotification(notification);

        notification =
                new SlackNotification(notification);

        System.out.println(
                "Notification Channels: "
                        + notification.getMessage());

        System.out.println(
                "Total Cost: $"
                        + notification.getCost());
    }
}