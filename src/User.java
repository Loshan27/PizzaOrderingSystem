import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private List<Pizza> favoritePizzas;
    private int loyaltyPoints;

    public User(String name) {
        this.name = name;
        this.favoritePizzas = new ArrayList<>();
        this.loyaltyPoints = 0;
    }

    public void addFavoritePizza(Pizza pizza) {
        favoritePizzas.add(pizza);
    }

    public List<Pizza> getFavoritePizzas() {
        return favoritePizzas;
    }

    public void addLoyaltyPoints(int points) {
        loyaltyPoints += points;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public String getName() {
        return name;
    }
}
