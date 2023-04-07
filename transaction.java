import java.util.Date;

public class transaction {
    private Date date;
    private char type;
    private double amount;
    private double balance;
    private String description;

    public transaction(char type, double amount, double balance, String description) {
        date = new Date();
        this.type = type;
        this.amount = amount;
        this.balance = balance;
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        String type;
        switch (this.type){
            case 'w','W'-> type = "withdrawal";
            case 'D','d'-> type = "deposit";
            default -> type = "wrong input";
        }
        return "\ntransaction:" + date + "\ntype: " + type + "\n amount: " + amount + "\nbalance: " + balance +  "\ndescription: " + description;
        }
}
