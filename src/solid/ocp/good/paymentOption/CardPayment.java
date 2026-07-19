package solid.ocp.good.paymentOption;

import solid.ocp.good.interfac.PaymentStrategy;

public class CardPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Processing Card payment of " + amount);
    }
}