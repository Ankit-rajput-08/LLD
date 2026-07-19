package solid.ocp.good;

class PaymentService {
    private PaymentStrategy strategy;

    public PaymentService(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void processPayment(double amount) {
        strategy.pay(amount);
    }
    public void processPaymentt(String type, double amount) {
        PaymentStrategy strategy = PaymentStrategyFactory.getStrategy(type);
        strategy.pay(amount);
    }
}