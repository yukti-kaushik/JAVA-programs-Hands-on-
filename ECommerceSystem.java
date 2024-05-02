package Abs_Inter;

import java.util.ArrayList;
import java.util.List;

// Product interface
interface Product {
    void showProducts();

    void addProduct(String productName, double price);

    void deleteProduct(String productName);

    double calculateProductPrice();
}

// Concrete class representing an online product
class OnlineProduct implements Product {
    private List<String> onlineProducts;
    private List<Double> prices;

    public OnlineProduct() {
        this.onlineProducts = new ArrayList<>();
        this.prices = new ArrayList<>();
    }

    @Override
    public void showProducts() {
        System.out.println("Online Products:");
        for (int i = 0; i < onlineProducts.size(); i++) {
            System.out.println((i + 1) + ". " + onlineProducts.get(i) + " - $" + prices.get(i));
        }
    }

    @Override
    public void addProduct(String productName, double price) {
        onlineProducts.add(productName);
        prices.add(price);
        System.out.println("Product added: " + productName);
    }

    @Override
    public void deleteProduct(String productName) {
        int index = onlineProducts.indexOf(productName);
        if (index != -1) {
            onlineProducts.remove(index);
            prices.remove(index);
            System.out.println("Product deleted: " + productName);
        } else {
            System.out.println("Product not found: " + productName);
        }
    }

    @Override
    public double calculateProductPrice() {
        double total = 0;
        for (Double price : prices) {
            total += price;
        }
        return total;
    }
}

// Concrete class representing a physical product
class PhysicalProduct implements Product {
    private List<String> physicalProducts;
    private List<Double> weights;

    public PhysicalProduct() {
        this.physicalProducts = new ArrayList<>();
        this.weights = new ArrayList<>();
    }

    @Override
    public void showProducts() {
        System.out.println("Physical Products:");
        for (int i = 0; i < physicalProducts.size(); i++) {
            System.out.println((i + 1) + ". " + physicalProducts.get(i) + " - " + weights.get(i) + " kg");
        }
    }

    @Override
    public void addProduct(String productName, double weight) {
        physicalProducts.add(productName);
        weights.add(weight);
        System.out.println("Product added: " + productName);
    }

    @Override
    public void deleteProduct(String productName) {
        int index = physicalProducts.indexOf(productName);
        if (index != -1) {
            physicalProducts.remove(index);
            weights.remove(index);
            System.out.println("Product deleted: " + productName);
        } else {
            System.out.println("Product not found: " + productName);
        }
    }

    @Override
    public double calculateProductPrice() {
        double total = 0;
        for (Double weight : weights) {
            total += weight * 2; // Assuming a cost of $2 per kg
        }
        return total;
    }
}

// Customer class
class Customer {
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    public void placeOrder(Product product) {
        System.out.println("Order placed by " + name);
        product.showProducts();
        System.out.println("Total Price: $" + product.calculateProductPrice());
    }
}

public class ECommerceSystem {
	public static void main(String[] args) {
        // Create instances of OnlineProduct and PhysicalProduct
        OnlineProduct onlineProduct = new OnlineProduct();
        PhysicalProduct physicalProduct = new PhysicalProduct();

        // Add products to OnlineProduct
        onlineProduct.addProduct("Laptop", 800);
        onlineProduct.addProduct("Smartphone", 500);
        onlineProduct.addProduct("Headphones", 100);

        // Add products to PhysicalProduct
        physicalProduct.addProduct("Book", 0.5);
        physicalProduct.addProduct("Clothing", 1.2);
        physicalProduct.addProduct("Fitness Equipment", 5);

        // Create a Customer
        Customer customer = new Customer("John");

        // Customer places an order for online products
        customer.placeOrder(onlineProduct);

        System.out.println(); // Blank line for better output separation

        // Customer places an order for physical products
        customer.placeOrder(physicalProduct);
    }
}

