package solid.ocp.good;

class WalletPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Processing Wallet payment of " + amount);
    }
}