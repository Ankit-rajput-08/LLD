package solid.ocp.good;

class CardPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Processing Card payment of " + amount);
    }
}