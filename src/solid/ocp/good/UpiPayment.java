package solid.ocp.good;

class UpiPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Processing UPI payment of " + amount);
    }
}