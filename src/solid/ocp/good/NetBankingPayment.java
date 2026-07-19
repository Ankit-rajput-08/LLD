package solid.ocp.good;

class NetBankingPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Processing NetBanking payment of " + amount);
    }
}