import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {

    }
}

class Bank {
    private final ArrayList<SavingsAccount> savingsAccounts = new ArrayList<>();
    private final ArrayList<CurrentAccount> currentAccounts = new ArrayList<>();

    private <T extends Account> void createAccount(ArrayList<T> accounts, T account) {
        accounts.add(account);
    }

    public void createSavingsAccount(String ownerName) {
        SavingsAccount account = new SavingsAccount(ownerName);

        this.createAccount(this.savingsAccounts, account);
    }

    public void createCurrentAccount(String ownerName) {
        CurrentAccount account = new CurrentAccount(ownerName);

        this.createAccount(this.currentAccounts, account);
    }

    public List<SavingsAccount> getSavingsAccounts() {
        return this.savingsAccounts;
    }

    public List<CurrentAccount> getCurrentAccounts() {
        return this.currentAccounts;
    }
}

interface Account {
    void deposit(int number);
    void withdraw(int number);
    double calculateInterest();
    int viewBalance();
    String getOwnerName();
}

class SavingsAccount implements Account {
    private int balance = 0;
    private final int id;
    public static AtomicInteger nextId = new AtomicInteger(0);
    private final String ownerName;
    private final double interest = 2.3;

    SavingsAccount(String ownerName) {
        id = SavingsAccount.nextId.getAndIncrement();
        this.ownerName = ownerName;
    }

    @Override
    public String getOwnerName() {
        return this.ownerName;
    }


    @Override
    public void deposit(int number) {
        this.balance += number;
    }

    @Override
    public void withdraw(int number) {
        this.balance -= number;
    }

    @Override
    public double calculateInterest() {
        return this.interest;
    }

    @Override
    public int viewBalance() {
        return this.balance;
    }

    public double calculateSavings(int years) {
        return this.balance * (years * this.interest);
    }
}
class CurrentAccount implements Account {
    private int balance = 0;
    private final int id;
    public static AtomicInteger nextId = new AtomicInteger(0);
    private final double interest = 1.2;
    private final String ownerName;

    CurrentAccount(String ownerName) {
        id = CurrentAccount.nextId.getAndIncrement();
        this.ownerName = ownerName;
    }

    @Override
    public String getOwnerName() {
        return this.ownerName;
    }

    @Override
    public void deposit(int number) {
        this.balance += number;
    }

    @Override
    public void withdraw(int number) {
        this.balance -= number;
    }

    @Override
    public double calculateInterest() {
        return this.interest * this.balance;
    }

    @Override
    public int viewBalance() {
        return this.balance;
    }

    public double calculateDiscount() {
        return this.interest * 1.3;
    }
}