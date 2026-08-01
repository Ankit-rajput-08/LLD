package solid.dip.order;

class MySQLDatabase implements Database {
    public void save(Order order) {
        System.out.println("Saving to MySQL: " + order.getId());
    }

    public Order findById(Long id) {
        System.out.println("Fetching from MySQL: " + id);
        return new Order(id, "Item Name", 0.0);
    }
}