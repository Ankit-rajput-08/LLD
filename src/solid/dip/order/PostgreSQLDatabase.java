package solid.dip.order;

class PostgreSQLDatabase implements Database {
    public void save(Order order) {
        System.out.println("Saving to PostgreSQL: " + order.getId());
    }
    public void saveOrder(Order order){
        System.out.println("Saving order to PostgreSQL: " + order.getId());
    }

    public Order findById(Long id) {
        System.out.println("Fetching from PostgreSQL: " + id);
        return new Order(id, "Item Name", 0.0);
    }
}