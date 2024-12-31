import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PizzaShop {
    private Scanner scanner = new Scanner(System.in);
    private OrderTracker orderTracker = new OrderTracker();
    private User currentUser;

    public void startOrderingProcess() {
        System.out.println("\n=====================================");
        System.out.println("      WELCOME TO THE PIZZA SHOP!   ");
        System.out.println("=====================================");
        System.out.print("Please enter your name: ");
        String userName = scanner.nextLine();
        currentUser = new User(userName);

        while (true) {
            System.out.println("\n==============================");
            System.out.println("Please select an option:");
            System.out.println("1. Place Order");
            System.out.println("2. Create Pizza");
            System.out.println("3. View Favorite Pizzas");
            System.out.println("4. Provide Feedback");
            System.out.println("5. Track My Order");
            System.out.println("6. Seasonal Specials and Promotions");
            System.out.println("7. Exit");
            System.out.print("Your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    placeOrder();
                    break;
                case 2:
                    Pizza pizza = createPizza();
                    currentUser.addFavoritePizza(pizza);
                    break;
                case 3:
                    viewFavoritePizzas();
                    break;
                case 4:
                    provideFeedback();
                    break;
                case 5:
                    trackOrder();
                    break;
                case 6:
                    showSeasonalSpecials();
                    break;
                case 7:
                    System.out.println("Thank you for visiting!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private Pizza createPizza() {
        System.out.println("\nCreating a new pizza...");
        System.out.print("Enter pizza name: ");
        String name = scanner.nextLine();

        System.out.println("Choose crust:");
        System.out.println("1. Thin");
        System.out.println("2. Thick");
        System.out.print("Your choice: ");
        String crust = scanner.nextInt() == 1 ? "Thin" : "Thick";
        scanner.nextLine(); // Consume newline

        System.out.println("Choose sauce:");
        System.out.println("1. Tomato");
        System.out.println("2. BBQ");
        System.out.print("Your choice: ");
        String sauce = scanner.nextInt() == 1 ? "Tomato" : "BBQ";
        scanner.nextLine(); // Consume newline

        List<String> toppings = new ArrayList<>();
        boolean addingToppings = true;

        while (addingToppings) {
            System.out.println("Available toppings:");
            System.out.println("1. Pepperoni");
            System.out.println("2. Mushrooms");
            System.out.println("3. Onions");
            System.out.println("4. Sausage");
            System.out.println("5. Bacon");
            System.out.println("6. Extra Cheese");
            System.out.println("7. Green Peppers");
            System.out.println("8. Olives");
            System.out.println("9. Finish adding toppings");
            System.out.print("Select a topping (1-9): ");
            int toppingChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (toppingChoice) {
                case 1:
                    toppings.add("Pepperoni");
                    break;
                case 2:
                    toppings.add("Mushrooms");
                    break;
                case 3:
                    toppings.add("Onions");
                    break;
                case 4:
                    toppings.add("Sausage");
                    break;
                case 5:
                    toppings.add("Bacon");
                    break;
                case 6:
                    toppings.add("Extra Cheese");
                    break;
                case 7:
                    toppings.add("Green Peppers");
                    break;
                case 8:
                    toppings.add("Olives");
                    break;
                case 9:
                    addingToppings = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        double price = 10.0 + (toppings.size() * 2.0); // Base price + $2 for each topping

        return new PizzaBuilder()
                .setName(name)
                .setCrust(crust)
                .setSauce(sauce)
                .setPrice(price)
                .addToppings(toppings)
                .build();
    }

    private void viewFavoritePizzas() {
        System.out.println("\nFavorite Pizzas:");
        if (currentUser.getFavoritePizzas().isEmpty()) {
            System.out.println("No favorite pizzas found.");
        } else {
            for (Pizza pizza : currentUser.getFavoritePizzas()) {
                System.out.println(pizza);
            }
        }
        backToMainMenu();
    }

    private void placeOrder() {
        System.out.println("\nPlacing order...");
        Pizza pizza = createPizza(); // Create a new pizza for the order
        int orderId = (int) (Math.random() * 1000); // Simulate order ID
        Order order = new Order(orderId, pizza);
        orderTracker.updateOrderStatus(orderId, "Order placed");
        System.out.println("Order ID: " + orderId);
        System.out.println("Tracking your order...");
        orderTracker.updateOrderStatus(orderId, "In preparation");
        orderTracker.updateOrderStatus(orderId, "Out for delivery");
        System.out.println("Order Status: " + orderTracker.getOrderStatus(orderId));

        // Mock payment process
        System.out.println("Choose payment method:");
        System.out.println("1. Credit Card");
        System.out.println("2. Cash on Delivery");
        System.out.print("Your choice: ");
        int paymentChoice = scanner.nextInt();
        PaymentStrategy paymentStrategy;
        if (paymentChoice == 1) {
            paymentStrategy = new CreditCardPayment();
        } else {
            paymentStrategy = new CashOnDelivery();
        }
        paymentStrategy.pay(pizza.getPrice());

        // Print detailed final bill
        printFinalBill(order);
        backToMainMenu();
    }

    private void printFinalBill(Order order) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        System.out.println("\n==============================");
        System.out.println("          FINAL BILL          ");
        System.out.println("==============================");
        System.out.println("Customer Name: " + currentUser.getName());
        System.out.println("Pizza Name: " + order.getPizza().toString());
        System.out.println("Order ID: " + order.getOrderId());
        System.out.println("Total Price: $" + order.getPizza().getPrice());
        System.out.println("Date and Time: " + formatter.format(date));
        System.out.println("Thank you for your order!");
        System.out.println("==============================\n");
    }

    private void provideFeedback() {
        System.out.println("\nProviding feedback...");
        System.out.print("Enter pizza name for feedback: ");
        String pizzaName = scanner.nextLine();
        System.out.print("Enter your rating (1-5): ");
        int rating = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter your comments: ");
        String comments = scanner.nextLine();

        Feedback feedback = new Feedback(currentUser.getName(), pizzaName, rating, comments);
        System.out.println("Feedback submitted: " + feedback);
        System.out.println("Thank you for your valuable feedback!\n");
        backToMainMenu();
    }

    private void trackOrder() {
        System.out.print("Enter your Order ID to track: ");
        int orderId = scanner.nextInt();
        System.out.println("Your order is processing. Current Status: " + orderTracker.getOrderStatus(orderId));
        backToMainMenu();
    }

    private void showSeasonalSpecials() {
        System.out.println("\n--- Seasonal Specials and Promotions ---");
        System.out.println("1. Buy 1 Get 1 Free on Medium Pizzas!");
        System.out.println("2. 20% off on all Toppings this weekend!");
        System.out.println("3. Free Delivery on orders over $30!");
        System.out.println("---------------------------------------\n");
        backToMainMenu();
    }

    private void backToMainMenu() {
        System.out.println("Press Enter to return to the main menu...");
        scanner.nextLine(); // Wait for user to press Enter
    }
}
