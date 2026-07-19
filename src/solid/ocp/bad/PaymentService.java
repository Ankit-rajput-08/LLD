package solid.ocp.bad;

public class PaymentService {

    // Decides which option to call and performa that calling
    // Deciding of payment is not dependent on actual business logic
    // The logic is to process the payment no matter which option is given

    public void processPayment(String type, double amount) {
        if (type.equals("UPI")) {
            System.out.println("Processing UPI payment of " + amount);
        } else if (type.equals("CARD")) {
            System.out.println("Processing Card payment of " + amount);
        } else if (type.equals("WALLET")) {
            System.out.println("Processing Wallet payment of " + amount);
        }
        // tomorrow: add NetBanking → edit this class again
        // next week: add Crypto → edit this class again
        // forever: every new method = open this file and modify it
    }
}
