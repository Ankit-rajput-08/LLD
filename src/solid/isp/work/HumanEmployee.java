package solid.isp.work;

public class HumanEmployee implements Workable,Claimable,Biological{
    @Override
    public void work() {
        System.out.println("Human employee is working.");
    }

    @Override
    public void attendMeeting() {
        System.out.println("Human employee is attending a meeting.");
    }

    @Override
    public void claim() {
        System.out.println("Human employee is claiming benefits.");
    }

    @Override
    public void eat() {
        System.out.println("Human employee is eating.");
    }

    @Override
    public void sleep() {
        System.out.println("Human employee is sleeping.");
    }
}
