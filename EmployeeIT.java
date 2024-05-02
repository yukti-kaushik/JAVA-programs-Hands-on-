package Abs_Inter;

abstract class Employee {
    // Fields common to all employees
    private String name;
    private int employeeId;

    // Constructor for Employee
    public Employee(String name, int employeeId) {
        this.name = name;
        this.employeeId = employeeId;
    }

    // Abstract method to calculate sal
    public abstract double calculateSalary();

    // Abstract method to display employee 
    public abstract void displayInfo();

    // Getters for common fields
    public String getName() {
        return name;
    }

    public int getEmployeeId() {
        return employeeId;
    }
}

// Concrete subclass Manager
class Manager extends Employee {
    // Fields specific to Manager
    private double baseSalary;
    private double bonus;

    // Constructor for Manager
    public Manager(String name, int employeeId, double baseSalary, double bonus) {
        super(name, employeeId);
        this.baseSalary = baseSalary;
        this.bonus = bonus;
    }

    // Implementation of calculateSalary for Manager
    @Override
    public double calculateSalary() {
        return baseSalary + bonus;
    }

    // Implementation of displayInfo for Manager
    @Override
    public void displayInfo() {
        System.out.println("Manager Information:");
        System.out.println("Name: " + getName());
        System.out.println("Employee ID: " + getEmployeeId());
        System.out.println("Base Salary: $" + baseSalary);
        System.out.println("Bonus: $" + bonus);
        System.out.println("Total Salary: $" + calculateSalary());
    }
}

// Concrete subclass Programmer
class Programmer extends Employee {
    // Fields specific to Programmer
    private double hourlyRate;
    private int hoursWorked;

    // Constructor for Programmer
    public Programmer(String name, int employeeId, double hourlyRate, int hoursWorked) {
        super(name, employeeId);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    // Implementation of calculateSalary for Programmer
    @Override
    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }

    // Implementation of displayInfo for Programmer
    @Override
    public void displayInfo() {
        System.out.println("Programmer Information:");
        System.out.println("Name: " + getName());
        System.out.println("Employee ID: " + getEmployeeId());
        System.out.println("Hourly Rate: Rs" + hourlyRate);
        System.out.println("Hours Worked: " + hoursWorked);
        System.out.println("Total Salary: Rs " + calculateSalary());
    }
}


public class EmployeeIT {
	public static void main(String[] args) {
        // Create instances of Manager and Programmer
        Manager manager = new Manager("Jane Manager", 101, 50000, 10000);
        Programmer programmer = new Programmer("A Programmer", 102, 30, 40);

        // Display information for Manager
        manager.displayInfo();

        System.out.println(); // Blank line for better output separation

        // Display information for Programmer
        programmer.displayInfo();
    }
}
