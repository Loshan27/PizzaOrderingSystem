public class Order {
    private int orderId;
    private Pizza pizza;
    private String status;

    // Constructor
    public Order(int orderId, Pizza pizza) {
        this.orderId = orderId;
        this.pizza = pizza;
        this.status = "Order placed"; 
    }

    // Getters
    public int getOrderId() {
        return orderId;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public String getStatus() {
        return status;
    }

    // Method to update the status of the order
    public void updateStatus(String status) {
        this.status = status;
    }
}
