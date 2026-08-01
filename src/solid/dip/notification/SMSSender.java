package solid.dip.notification;

class SMSSender implements NotificationSender {
    public void send(String message) {
        System.out.println("Sending SMS: " + message);
    }
}