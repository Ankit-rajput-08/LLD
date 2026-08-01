package solid.dip.order;

class OrderService {

    private Database database;

    public OrderService(Database database) { // injected from outside
        this.database = database;
    }

    public void placeOrder(Order order) {
        database.save(order);
    }
}