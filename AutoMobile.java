package Abs_Inter;
abstract class Vehicle {
    // Abstract method to start the engine
    public abstract void startEngine();

    // Abstract method to stop the engine
    public abstract void stopEngine();
}

// Concrete subclass Car
class Car extends Vehicle {
    @Override
    public void startEngine() {
        System.out.println("Car engine started. Vroom!");
    }

    @Override
    public void stopEngine() {
        System.out.println("Car engine stopped. Silence.");
    }
}

// Concrete subclass Motorcycle
class Motorcycle extends Vehicle {
    @Override
    public void startEngine() {
        System.out.println("Motorcycle engine started. Vroom!");
    }

    @Override
    public void stopEngine() {
        System.out.println("Motorcycle engine stopped. Silence.");
    }
}



public class AutoMobile {
	public static void main(String[] args) {
        // Create instances of Car and Motorcycle
        Car myCar = new Car();
        Motorcycle myMotorcycle = new Motorcycle();

        // Test starting and stopping the engines
        myCar.startEngine();
        myCar.stopEngine();

        System.out.println(); // Blank line for better output separation

        myMotorcycle.startEngine();
        myMotorcycle.stopEngine();
    }
}
