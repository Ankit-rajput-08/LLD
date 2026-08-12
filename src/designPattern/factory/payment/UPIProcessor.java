package designPattern.factory.payment;

public class UPIProcessor implements Payment{
    @Override
    public void pay() {
        System.out.println("Paying via UPI");
    }
}
