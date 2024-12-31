import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private String crust;
    private String sauce;
    private List<String> toppings;
    private double price;

    public Pizza(String name, String crust, String sauce, List<String> toppings, double price) {
        this.name = name;
        this.crust = crust;
        this.sauce = sauce;
        this.toppings = toppings;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "name='" + name + '\'' +
                ", crust='" + crust + '\'' +
                ", sauce='" + sauce + '\'' +
                ", toppings=" + toppings +
                ", price=" + price +
                '}';
    }

    public double getPrice() {
        return price;
    }
}
