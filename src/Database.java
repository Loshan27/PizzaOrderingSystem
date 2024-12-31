import java.util.ArrayList;
import java.util.List;

public class Database {
    private List<Pizza> pizzas;
    private List<Feedback> feedbacks;

    public Database() {
        pizzas = new ArrayList<>();
        feedbacks = new ArrayList<>();
    }

    public void savePizza(Pizza pizza) {
        pizzas.add(pizza);
        System.out.println("Pizza saved to database: " + pizza);
    }

    public void saveFeedback(Feedback feedback) {
        feedbacks.add(feedback);
        System.out.println("Feedback saved to database: " + feedback);
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public List<Feedback> getFeedbacks() {
        return feedbacks;
    }
}
