import java.util.ArrayList;
import java.util.List;

public class PizzaBuilder {
    private String name;
    private String crust;
    private String sauce;
    private List<String> toppings = new ArrayList<>();
    private double price;

    public PizzaBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PizzaBuilder setCrust(String crust) {
        this.crust = crust;
        return this;
    }

    public PizzaBuilder setSauce(String sauce) {
        this.sauce = sauce;
        return this;
    }

    
    public PizzaBuilder addToppings(List<String> toppings) {
        this.toppings.addAll(toppings);
        return this;
    }

    public PizzaBuilder setPrice(double price) {
        this.price = price;
        return this;
    }

    public Pizza build() {
        return new Pizza(name, crust, sauce, toppings, price);
    }
}
