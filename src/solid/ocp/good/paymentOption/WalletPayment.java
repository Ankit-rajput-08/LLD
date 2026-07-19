package solid.ocp.good.paymentOption;

import solid.ocp.good.interfac.PaymentStrategy;

public class WalletPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Processing Wallet payment of " + amount);
    }
}