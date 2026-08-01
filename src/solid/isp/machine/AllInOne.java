package solid.isp.machine;

public class AllInOne implements Printable, Scannable, Photocopy, Faxable {
    @Override
    public void printing() {
        System.out.println("All-in-one device is printing.");
    }

    @Override
    public void startScanning() {
        System.out.println("All-in-one device is scanning.");
    }

    @Override
    public void makeCopy() {
        System.out.println("All-in-one device is making a copy.");
    }

    @Override
    public void sendFax() {
        System.out.println("All-in-one device is sending a fax.");
    }

    @Override
    public void receiveFax() {
        System.out.println("All-in-one device is receiving a fax.");
    }
}
