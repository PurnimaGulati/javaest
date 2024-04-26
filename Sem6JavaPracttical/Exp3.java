import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Account {
    double amount;
    abstract double calculateInterest();
}

class FD extends Account {
    int days;
    boolean isNRI;
    FD(double amount, int days, boolean isNRI) {
        this.amount = amount;
        this.days = days;
        this.isNRI = isNRI;
    }
    @Override
    double calculateInterest() {
        double interestRate = isNRI ? 0.06 : 0.05;
        return amount * interestRate;
    }
}
class RD extends Account {
    int months;
    boolean isNRI;
    RD(double amount, int months, boolean isNRI) {
        this.amount = amount;
        this.months = months;
        this.isNRI = isNRI;
    }
    @Override
    double calculateInterest() {
        double interestRate = isNRI ? 0.07 : 0.065;
        return amount * months * interestRate;
    }
}

class AccountHolder {
    String name;
    Account account;
    AccountHolder(String name, Account account) {
        this.name = name;
        this.account = account;
    }
}

public class Exp3 {
    static List<AccountHolder> accountHolders = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Add an account holder");
            System.out.println("2. Calculate interest for an account holder");
            System.out.println("3. Exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addAccountHolder();
                    break;
                case 2:
                    calculateInterest();
                    break;
                case 3:
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
    public static void addAccountHolder() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter account holder name:");
        String name = scanner.nextLine();
        System.out.println("Select account type:");
        System.out.println("1. Fixed Deposit (FD)");
        System.out.println("2. Recurring Deposit (RD)");
        int accountType = scanner.nextInt();
        System.out.println("Is the account holder an NRI? (true/false)");
        boolean isNRI = scanner.nextBoolean();
        Account account;
        if (accountType == 1) {
            System.out.println("Enter FD amount:");
            double amount = scanner.nextDouble();
            System.out.println("Enter FD duration in days:");
            int days = scanner.nextInt();
            account = new FD(amount, days, isNRI);
        } else if (accountType == 2) {
            System.out.println("Enter RD monthly deposit amount:");
            double monthlyDeposit = scanner.nextDouble();
            System.out.println("Enter RD duration in months:");
            int months = scanner.nextInt();
            account = new RD(monthlyDeposit, months, isNRI);
        } else {
            System.out.println("Invalid account type!");
            return;
        }
        AccountHolder accountHolder = new AccountHolder(name, account);
        accountHolders.add(accountHolder);
        System.out.println("Account holder added successfully.");
    }
    public static void calculateInterest() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter account holder name:");
        String name = scanner.nextLine();
        boolean found = false;
        for (AccountHolder holder : accountHolders) {
            if (holder.name.equalsIgnoreCase(name)) {
                double interest = holder.account.calculateInterest();
                System.out.println("Interest for account holder " + holder.name + ": " + interest);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Account holder not found!");
        }
    }
}
