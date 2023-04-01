import java.util.ArrayList;
import java.util.List;

// Product class
class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
}


// Singleton Pattern
class ShoppingCart {
    private static ShoppingCart instance;
    private List<Product> items;

    private ShoppingCart() {
        items = new ArrayList<>();
    }

    public static ShoppingCart getInstance() {
        if (instance == null) {
            instance = new ShoppingCart();
        }
        return instance;
    }

    public void addItem(Product product) {
        items.add(product);
    }

    public List<Product> getItems() {
        return items;
    }
}

// Factory Pattern
abstract class PaymentMethod {
    abstract void pay(double amount);
}

class CreditCardPayment extends PaymentMethod {
    @Override
    void pay(double amount) {
        System.out.println("Paid " + amount + " using credit card.");
    }
}

class PayPalPayment extends PaymentMethod {
    @Override
    void pay(double amount) {
        System.out.println("Paid " + amount + " using PayPal.");
    }
}

class PaymentFactory {
    public static PaymentMethod createPayment(String type) {
        switch (type) {
            case "credit":
                return new CreditCardPayment();
            case "paypal":
                return new PayPalPayment();
            default:
                throw new IllegalArgumentException("Invalid payment type: " + type);
        }
    }
}

// Observer Pattern
interface OrderListener {
    void onOrderShipped(Order order);
}

class Order {
    private List<OrderListener> listeners = new ArrayList<>();

    public void addListener(OrderListener listener) {
        listeners.add(listener);
    }

    public void removeListener(OrderListener listener) {
        listeners.remove(listener);
    }

    public void ship() {
        System.out.println("Order shipped.");
        for (OrderListener listener : listeners) {
            listener.onOrderShipped(this);
        }
    }
}

class User implements OrderListener {
    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void onOrderShipped(Order order) {
        System.out.println("Hi " + name + ", your order has been shipped.");
    }
}