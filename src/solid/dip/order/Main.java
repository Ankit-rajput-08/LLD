package solid.dip.order;


public class Main {
    public static void main(String[] args) {

        Database db = new MySQLDatabase();       // swap to PostgreSQLDatabase anytime
        OrderService service = new OrderService(db);
        service.placeOrder(new Order(1L, "Item Name", 0.0));
    }
}