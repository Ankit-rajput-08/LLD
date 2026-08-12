package designPattern.factory.payment;

public class CreditCardProcessor implements Payment{
    @Override
    public void pay() {
        System.out.println("Paying with Credit Card..");
    }
}
