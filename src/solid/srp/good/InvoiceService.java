package solid.srp.good;

import java.util.List;

public class InvoiceService {

    /*
     * Orchestrator -> Communicates with all, but has no business logic
     * The class owns logic of communication between two needy services
     * one reason to change -> communaication logic shifts from A to B service
     */

    InvoiceCalculator calculator = new InvoiceCalculator();
    InvoicePrinter printer = new InvoicePrinter();
    InvoiceRepository saveInvoice = new InvoiceRepository();

    public void calculate(List<Integer> items){
        calculator.calculateTotal(items);
    }
    public void getDiscount(int amount){
        calculator.applyDiscount(amount);
    }

    public void getPdf(Object invoice){
        printer.generatePdf(invoice);
    }

    public void savePdf(Object invoice){
        saveInvoice.saveInvoice(invoice);
    }

}
