
// Main program
public class ECommerceApp {
    public static void main(String[] args) {
        // Singleton Pattern
        ShoppingCart.getInstance();

        // Factory Pattern
        PaymentMethod paymentMethod = PaymentFactory.createPayment("credit");
        paymentMethod.pay(100.0);

        // Observer Pattern
        Order order = new Order();
        User user = new User("Mia");
        order.addListener(user);
        order.ship();
    }
}
