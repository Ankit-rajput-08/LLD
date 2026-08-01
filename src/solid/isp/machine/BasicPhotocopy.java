package solid.isp.machine;

public class BasicPhotocopy implements Photocopy {
    @Override
    public void makeCopy() {
        System.out.println("Basic photocopy device is making a copy.");
    }
}
