import java.util.HashMap;
import java.util.Map;

public class OrderTracker {
    private Map<Integer, String> orderStatus;

    public OrderTracker() {
        orderStatus = new HashMap<>();
    }

    public void updateOrderStatus(int orderId, String status) {
        orderStatus.put(orderId, status);
    }

    public String getOrderStatus(int orderId) {
        return orderStatus.getOrDefault(orderId, "Order not found.");
    }
}
