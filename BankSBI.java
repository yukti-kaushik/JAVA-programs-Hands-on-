package Abs_Inter;

abstract class BankAccount {
    private String accountNumber;
    private double balance;

    // Constructor for BankAccount
    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    // Abstract method to deposit money (to be implemented by subclasses)
    public abstract void deposit(double amount);

    // Abstract method to withdraw money (to be implemented by subclasses)
    public abstract void withdraw(double amount);

    // Getter for account number
    public String getAccountNumber() {
        return accountNumber;
    }

    // Getter for balance
    public double getBalance() {
        return balance;
    }
}

// Concrete subclass SavingsAccount
class SavingsAccount extends BankAccount {
    private double interestRate;

    // Constructor for SavingsAccount
    public SavingsAccount(String accountNumber, double initialBalance, double interestRate) {
        super(accountNumber, initialBalance);
        this.interestRate = interestRate;
    }

    // Implementation of deposit for SavingsAccount
    @Override
    public void deposit(double amount) {
        setBalance(getBalance() + amount + (amount * interestRate));
        System.out.println("Deposit successful. New balance (including interest): Rs " + getBalance());
    }

    private void setBalance(double d) {
		// TODO Auto-generated method stub
	}
	// Implementation of withdraw for SavingsAccount
    @Override
    public void withdraw(double amount) {
        if (amount <= getBalance()) {
            setBalance(getBalance() - amount);
            System.out.println("Withdrawal successful. New balance: Rs " + getBalance());
        } else {
            System.out.println("Insufficient funds for withdrawal.");
        }
    }
}

// Concrete subclass CurrentAccount
class CurrentAccount extends BankAccount {
    private double overdraftLimit;

    // Constructor for CurrentAccount
    public CurrentAccount(String accountNumber, double initialBalance, double overdraftLimit) {
        super(accountNumber, initialBalance);
        this.overdraftLimit = overdraftLimit;
    }

    // Implementation of deposit for CurrentAccount
    @Override
    public void deposit(double amount) {
        setBalance(getBalance() + amount);
        System.out.println("Deposit successful. New balance: Rs " + getBalance());
    }

    private void setBalance(double d) {
		// TODO Auto-generated method stub
		
	}

	// Implementation of withdraw for CurrentAccount
    @Override
    public void withdraw(double amount) {
        if (amount <= getBalance() + overdraftLimit) {
            setBalance(getBalance() - amount);
            System.out.println("Withdrawal successful. New balance: Rs " + getBalance());
        } else {
            System.out.println("Exceeds overdraft limit. Withdrawal not allowed.");
        }
    }
}

public class BankSBI {
	public static void main(String[] args) {
        // Create instances of SavingsAccount and CurrentAccount
        SavingsAccount savingsAccount = new SavingsAccount("SA123", 1000, 0.05);
        CurrentAccount currentAccount = new CurrentAccount("CA456", 2000, 1000);

        // Test deposit and withdrawal for SavingsAccount
        System.out.println("Savings Account Details:");
        System.out.println("Account Number: " + savingsAccount.getAccountNumber());
        System.out.println("Initial Balance: Rs" + savingsAccount.getBalance());
        savingsAccount.deposit(500);
        savingsAccount.withdraw(200);

        System.out.println(); // Blank line for better output separation

        // Test deposit and withdrawal for CurrentAccount
        System.out.println("Current Account Details:");
        System.out.println("Account Number: " + currentAccount.getAccountNumber());
        System.out.println("Initial Balance: Rs" + currentAccount.getBalance());
        currentAccount.deposit(800);
        currentAccount.withdraw(2500);
    }
}
