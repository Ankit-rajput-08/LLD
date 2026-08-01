package solid.isp.machine;

public class BasicPrinter implements Printable {
    @Override
    public void printing() {
        System.out.println("Basic printer is printing.");
    }
}
