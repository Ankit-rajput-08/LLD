package solid.srp.good;

import java.util.ArrayList;
import java.util.List;

public class InvoiceRepository {
    public void saveInvoice(Object invoice){
        List<Object> db = new ArrayList<>();
        db.add(invoice);
    }
}
