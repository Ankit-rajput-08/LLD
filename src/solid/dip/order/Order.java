package solid.dip.order;

public class Order {
    private Long id;
    private String itemName;
    private Double amount;

    public Long getId(){
        return id;
    }

    public String getItemName() {
        return itemName;
    }

    public Double getAmount() {
        return amount;
    }

    public Order(Long id, String itemName, Double amount) {
        this.id = id;
        this.itemName = itemName;
        this.amount = amount;
    }
}
