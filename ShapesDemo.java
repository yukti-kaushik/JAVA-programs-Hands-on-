package Abs_Inter;

abstract class Shape {
    // Abstract method to calculate area (to be implemented by subclasses)
    public abstract double calculateArea();

    // Abstract method to calculate perimeter (to be implemented by subclasses)
    public abstract double calculatePerimeter();
}

// Concrete subclass Circle
class Circle extends Shape {
    private double radius;

    // Constructor for Circle
    public Circle(double radius) {
        this.radius = radius;
    }

    // Implementation of calculateArea for Circle
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    // Implementation of calculatePerimeter for Circle
    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
}

// Concrete subclass Triangle
class Triangle extends Shape {
    private double sideA;
    private double sideB;
    private double sideC;

    // Constructor for Triangle
    public Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    // Implementation of calculateArea for Triangle
    @Override
    public double calculateArea() {
        // Using Heron's formula to calculate the area of a triangle
        double s = (sideA + sideB + sideC) / 2;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }

    // Implementation of calculatePerimeter for Triangle
    @Override
    public double calculatePerimeter() {
        return sideA + sideB + sideC;
    }
}

public class ShapesDemo {
	public static void main(String[] args) {
        // Create instances of Circle and Triangle
        Circle circle = new Circle(5);
        Triangle triangle = new Triangle(3, 4, 5);

        // Test area and perimeter calculation for Circle
        System.out.println("Circle Details:");
        System.out.println("Radius: " + circle.calculateArea());
        System.out.println("Area: " + circle.calculateArea());
        System.out.println("Perimeter: " + circle.calculatePerimeter());

        System.out.println(); // Blank line for better output separation

        // Test area and perimeter calculation for Triangle
        System.out.println("Triangle Details:");
        System.out.println("Sides: " + triangle.calculateArea());
        System.out.println("Area: " + triangle.calculateArea());
        System.out.println("Perimeter: " + triangle.calculatePerimeter());
    }
}
