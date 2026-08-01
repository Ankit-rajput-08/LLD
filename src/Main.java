import oop.abstraction.Circle;
import oop.abstraction.Rectangle;
import oop.abstraction.Shape;
import oop.interfaces.Chargeable;
import oop.interfaces.Ev;
import oop.interfaces.HybridCar;
import solid.lsp.penguin.Bird;
import solid.lsp.penguin.MakeBirdFly;
import solid.lsp.penguin.Penguin;
import solid.lsp.penguin.Sparrow;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
//        ElectricCar tesla = new ElectricCar("Tesla", "blue", 120,89);
//        tesla.DisplayInfo();
//        tesla.charge();
//
//        Car hybrid = new ElectricCar("xuv","bmw",120,88);
//        System.out.println("hybrid car: " + hybrid);
//        hybrid.DisplayInfo();

//        RunTime run = new RunTime();
//        run.runtime();

//        Rectangle rc = new Rectangle();
//
//        Shape sh = new Rectangle();
//        Shape ci = new Circle();
//        ci.displayArea();
//        sh.displayArea();

        Chargeable ev = new Ev();
        ev.charge();

        HybridCar hybrid = new HybridCar("xuv"," bmw", 200, 98);
        System.out.println(hybrid);
        hybrid.DisplayInfo();
        hybrid.charge();

        MakeBirdFly bird = new MakeBirdFly();
        bird.makeBirdFly(new Sparrow());




    }

}