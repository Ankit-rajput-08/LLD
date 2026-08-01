package solid.dip.notification;

class EmailSender implements NotificationSender {
    public void send(String message) {
        System.out.println("Sending email: " + message);
    }
}