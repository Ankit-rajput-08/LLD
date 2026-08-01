package solid.isp.work;

public class RobotWorker implements Workable {
    @Override
    public void work() {
        System.out.println("Robot is working.");
    }

    @Override
    public void attendMeeting() {
        System.out.println("Robots don't attend meetings.");
    }
}
