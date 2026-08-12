package designPattern.factory.payment;

public class PaymentImplement implements PaymentProcessor {
    public Payment createPayment(String paymentType) {
        switch (paymentType) {
            case "creditcard":
                return new CreditCardProcessor();
            case "upi":
                return new UPIProcessor();
            case "cash":
                return new CashProcessor();
            default:
                throw new IllegalArgumentException("Invalid payment type");
        }
    }
}
