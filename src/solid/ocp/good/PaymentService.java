package solid.ocp.good;

import solid.ocp.good.factory.PaymentStrategyFactory;
import solid.ocp.good.interfac.PaymentStrategy;

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