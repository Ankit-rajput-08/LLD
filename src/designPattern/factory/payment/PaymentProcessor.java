package designPattern.factory.payment;

public interface PaymentProcessor {
    Payment createPayment(String paymentType);
}
