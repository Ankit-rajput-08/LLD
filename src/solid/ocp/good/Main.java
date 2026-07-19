package solid.ocp.good;

public class Main {

    public static void main(String[] args) {

        String userChoice = "UPI"; // comes from UI, API request, config, etc.

        PaymentStrategy strategy;

        if (userChoice.equals("UPI")) {
            strategy = new UpiPayment();
        } else if (userChoice.equals("CARD")) {
            strategy = new CardPayment();
        } else {
            strategy = new WalletPayment();
        }

        PaymentService service = new PaymentService(strategy);
        service.processPayment(500.0);
        System.out.println("helo");


        PaymentStrategy strateg = PaymentStrategyFactory.getStrategy(userChoice);
        PaymentService servic = new PaymentService(strateg);
        servic.processPaymentt("UPI",500.0);
    }
}