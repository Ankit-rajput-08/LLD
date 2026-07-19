package solid.srp.good;

import java.util.List;

public class InvoiceCalculator {
    public int calculateTotal(List<Integer> items){
        return items.size() * 10;
    }
    public int applyDiscount(int amount){
        int discount = amount / 10;
        return amount - discount;
    }
}
