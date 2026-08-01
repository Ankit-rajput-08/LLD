package solid.dip.notification;

class PushNotificationSender implements NotificationSender {
    public void send(String message) {
        System.out.println("Sending push notification: " + message);
    }
}