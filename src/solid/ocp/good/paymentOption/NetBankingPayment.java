package solid.ocp.good.paymentOption;

import solid.ocp.good.interfac.PaymentStrategy;

class NetBankingPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Processing NetBanking payment of " + amount);
    }
}