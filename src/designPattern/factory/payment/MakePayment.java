package designPattern.factory.payment;

public class MakePayment {
    public static void main(String[] args) {
        PaymentProcessor paymentProcessor = new PaymentImplement();
        Payment payment = paymentProcessor.createPayment("creditcard");
        payment.pay();
    }
}
