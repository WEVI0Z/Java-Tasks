import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

    }
}

class Bank {
    ArrayList<SavingsAccount> savingsAccounts = new ArrayList<SavingsAccount>();
    ArrayList<CurrentAccount> currentAccounts = new ArrayList<CurrentAccount>();

    <T extends Account> void createAccount(ArrayList<T> accounts, T account) {
        accounts.add(account);
    }

    void createSavingsAccount(String ownerName) {
        SavingsAccount account = new SavingsAccount(ownerName);

        this.createAccount(this.savingsAccounts, account);
    }

    void createCurrentAccount(String ownerName) {
        CurrentAccount account = new CurrentAccount(ownerName);

        this.createAccount(this.currentAccounts, account);
    }
}

interface Account {
    public void deposit(int number);
    public void withdraw(int number);
    public double calculateInterest();
    public int viewBalance();
}

class SavingsAccount implements Account {
    int balance = 0;
    int id;
    static int nextId = 0;
    String ownerName;
    double interest = 2.3;

    SavingsAccount(String ownerName) {
        id = nextId++;
        this.ownerName = ownerName;
    }

    @Override
    public void deposit(int number) {
        balance += number;
    }

    @Override
    public void withdraw(int number) {
     balance -= number;
    }

    @Override
    public double calculateInterest() {
        return interest;
    }

    @Override
    public int viewBalance() {
        return balance;
    }

    public double calculateSavings(int years) {
        return balance * (years * interest);
    }
}
class CurrentAccount implements Account {
    int balance = 0;
    int id;
    static int nextId = 0;
    double interest = 1.2;
    String ownerName;

    CurrentAccount(String ownerName) {
        id = nextId++;
        this.ownerName = ownerName;
    }

    @Override
    public void deposit(int number) {
        balance += number;
    }

    @Override
    public void withdraw(int number) {
        balance -= number;
    }

    @Override
    public double calculateInterest() {
        return interest * balance;
    }

    @Override
    public int viewBalance() {
        return balance;
    }

    public double calculateDiscount() {
        return interest * 1.3;
    }
}