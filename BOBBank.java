package Abs_Inter;

import java.util.ArrayList;
import java.util.List;

// Account interface
interface Account {
    void deposit(double amount);

    void withdraw(double amount);

    void calculateInterest();

    double getBalance();
}

// Concrete class representing a SavingsAccount
class SavingsAccount1 implements Account {
    private double balance;
    private double interestRate;

    public SavingsAccount1(double initialBalance, double interestRate) {
        this.balance = initialBalance;
        this.interestRate = interestRate;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit successful. New balance: $" + balance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: $" + balance);
        } else {
            System.out.println("Insufficient funds for withdrawal.");
        }
    }

    @Override
    public void calculateInterest() {
        double interest = balance * interestRate;
        balance += interest;
        System.out.println("Interest calculated. New balance: $" + balance);
    }

    @Override
    public double getBalance() {
        return balance;
    }

    // Unique method for SavingsAccount
    public void applyBonus() {
        System.out.println("Bonus applied to SavingsAccount.");
    }
}

// Concrete class representing a CurrentAccount
class CurrentAccount1 implements Account {
    private double balance;
    private double overdraftLimit;

    public CurrentAccount1(double initialBalance, double overdraftLimit) {
        this.balance = initialBalance;
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit successful. New balance: $" + balance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= balance + overdraftLimit) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: $" + balance);
        } else {
            System.out.println("Exceeds overdraft limit. Withdrawal not allowed.");
        }
    }

    @Override
    public void calculateInterest() {
        System.out.println("No interest calculation for CurrentAccount.");
    }

    @Override
    public double getBalance() {
        return balance;
    }

    // Unique method for CurrentAccount
    public void applyOverdraftFee() {
        System.out.println("Overdraft fee applied to CurrentAccount.");
    }
}

// Bank class
class Bank {
    private List<Account> accounts;

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void displayAccountBalances() {
        System.out.println("Account Balances:");
        for (Account account : accounts) {
            System.out.println("Balance for account: $" + account.getBalance());
        }
    }
}

public class BOBBank {
	public static void main(String[] args) {
        // Create instances of SavingsAccount and CurrentAccount
        SavingsAccount1 savingsAccount = new SavingsAccount1(1000, 0.05);
        CurrentAccount1 currentAccount = new CurrentAccount1(2000, 1000);

        // Create a Bank and add accounts to it
        Bank bank = new Bank();
        bank.addAccount(savingsAccount);
        bank.addAccount(currentAccount);

        // Perform operations on accounts
        savingsAccount.deposit(500);
        savingsAccount.calculateInterest();
        savingsAccount.applyBonus();

        System.out.println(); // Blank line for better output separation

        currentAccount.withdraw(2500);
        currentAccount.applyOverdraftFee();

        // Display account balances in the bank
        bank.displayAccountBalances();
    }
}
