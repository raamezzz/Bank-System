import java.util.ArrayList;
import java.util.Scanner;

public class bank {
    private String name;
    private int numberOfAccounts;
    private ArrayList<account> accounts = new ArrayList<>();

    public bank(String name) {
        this.name = name;
        numberOfAccounts = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfAccounts() {
        return numberOfAccounts;
    }

    public void setNumberOfAccounts(int numberOfAccounts) {
        this.numberOfAccounts = numberOfAccounts;
    }

    public ArrayList<account> getAccounts() {
        return accounts;
    }

    public void setAccounts(ArrayList<account> accounts) {
        this.accounts = accounts;
    }
public account getAccountById(int id){
        account a = new account (null,0);
        for(int i = 0; i < numberOfAccounts; i++){
            if (accounts.get(i).getId()==id) a = accounts.get(i);
            else a = null;
        } return a;
    }
    public account getAccountByName(String name){
        account a = new account (null,0);
        for(int i = 0; i < numberOfAccounts; i++){
            if (accounts.get(i).getName().equals(name)) a = accounts.get(i);
            else a = null;
        } return a;
    }

    public account newAccount(){
        Scanner input = new Scanner(System.in);

        System.out.print("first and last name: ");
        String fName = input.next();
        String lName = input.next();
        System.out.println(" ");

        System.out.print("balance: ");
        double balance = input.nextDouble();
        System.out.println(" ");

        account a = new account(fName + lName, balance);
        numberOfAccounts++;
        a.setId(numberOfAccounts);
        accounts.add(a);
        return a;
    }
}
