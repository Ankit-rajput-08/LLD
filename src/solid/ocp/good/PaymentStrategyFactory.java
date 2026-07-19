package solid.ocp.good;

class PaymentStrategyFactory {

    public static PaymentStrategy getStrategy(String type) {
        if (type.equals("UPI"))    return new UpiPayment();
        if (type.equals("CARD"))   return new CardPayment();
        if (type.equals("WALLET")) return new WalletPayment();
        throw new IllegalArgumentException("Unknown payment type: " + type);
    }
}