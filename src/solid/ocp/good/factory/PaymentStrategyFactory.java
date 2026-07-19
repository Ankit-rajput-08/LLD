package solid.ocp.good.factory;

import solid.ocp.good.interfac.PaymentStrategy;
import solid.ocp.good.paymentOption.CardPayment;
import solid.ocp.good.paymentOption.UpiPayment;
import solid.ocp.good.paymentOption.WalletPayment;

public class PaymentStrategyFactory {

    public static PaymentStrategy getStrategy(String type) {
        if (type.equals("UPI"))    return new UpiPayment();
        if (type.equals("CARD"))   return new CardPayment();
        if (type.equals("WALLET")) return new WalletPayment();
        throw new IllegalArgumentException("Unknown payment type: " + type);
    }
}