package solid.ocp.good.paymentOption;

import solid.ocp.good.interfac.PaymentStrategy;

public class UpiPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Processing UPI payment of " + amount);
    }
}