package designPattern.factory.payment;

public class CashProcessor implements Payment{
    @Override
    public void pay() {
        System.out.println("Paying with Cash..");
    }
}
