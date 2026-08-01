package solid.dip.order;

interface Database {
    void save(Order order);
    Order findById(Long id);
}