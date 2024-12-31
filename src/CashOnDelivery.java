public class CashOnDelivery implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Cash on delivery: $" + amount);
    }
}
