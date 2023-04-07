import java.util.ArrayList;

public class account {
    private String name;

    private int numberOfAccounts;
    private int id;
    private double balance;
    private final double annualInterest = 12;

    private ArrayList<transaction> transactions = new ArrayList<>();

    public account(String name, double balance) {
        numberOfAccounts++;
        this.name = name;
        id = numberOfAccounts;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public double getAnnualInterest() {
        return annualInterest;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void withdraw(double amount, String description){
        if(amount > balance){
            System.out.println("not enough balance");
        }else{
        balance = balance - amount;
        transactions.add(new transaction('W', amount, balance, description));
        }
    }
    public void deposit(double amount, String description){
        balance = balance + amount;
        transactions.add(new transaction('D', amount, balance, description));
    }

    @Override
    public String toString() {
        return "account: " +
                "\nname: " + name +
                "\nid: " + id +
                "\nbalance: " + balance +
                "\nannualInterest: " + annualInterest + "%" +
                "\ntransactions: \n" + transactions;
    }
}
