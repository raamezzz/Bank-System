
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        bank ramoza = new bank("ramezMoney");
        menu(ramoza);
    }

    public static transaction newTransaction(account a){
      Scanner input = new Scanner(System.in);
      System.out.println("your balance is: " + a.getBalance());

      System.out.println("what is the type for the transaction, enter:\nW: for withdrawal\tD:for deposit");
      char type = input.next().charAt(0);

      System.out.print("enter the amount: ");
      double amount = input.nextDouble();
      System.out.println(" ");
      System.out.print("enter the description (one word): ");
      String description = input.next();

      switch(type){
        case 'W','w' -> a.withdraw(amount, description);
        case 'D', 'd' -> a.deposit(amount, description);
        default -> System.out.println("wrong input, please try again");
      }

         System.out.println("your balance is: " + a.getBalance());
      return new transaction(type, amount, a.getBalance(), description);
    }
    public static void accountMenu(bank b, account a){
        Scanner input = new Scanner(System.in);
        System.out.println("welcome!, " + a.getName() + "\n for a new transaction enter: 0\tfor account details enter: 1" +
                "\nfor the main menu enter: 2");
        byte type = input.nextByte();

        switch (type){
            case 0 -> {
                newTransaction(a);
                System.out.println("for the previous menu press 0\tto exit press 1");
            byte ans = input.nextByte();
                if (ans == 0) {
                    accountMenu(b, a);
                } else if (ans == 1) {
                    System.out.println("thank you for using our services!");
                }else System.out.println("wrong input, please try again later.");
            }
            case 1 -> {
                System.out.println(a);
                System.out.println("for the previous menu press 0\tto exit press 1");
                int ans = input.nextByte();
                if (ans == 0) {
                    accountMenu(b, a);
                }else if (ans == 1) {
                    System.out.println("thank you for using our services!");
                }else System.out.println("wrong input, please try again later.");
            }
            case 2 -> menu(b);
        }
    }
    public static void menu(bank b){
        Scanner input = new Scanner(System.in);
        System.out.println("Good Morning!\nto find an account enter 0\t for opening a new account enter 1");
        byte ans = input.nextByte();
        switch (ans){
            case 0 -> {
                System.out.println("to search by ID enter 0, for name enter 1: ");
                byte ans2 = input.nextByte();
                switch (ans2){
                    case 0 -> {
                        System.out.print("enter the id: ");
                        int id = input.nextInt();
                        accountMenu(b,b.getAccountById(id));
                    }
                    case 1 -> {
                        System.out.println("enter the name (without spaces): ");
                        String name = input.next();
                        accountMenu(b,b.getAccountByName(name));
                    }
                    default -> System.out.println("wrong input");
                }
            }
            case 1 -> accountMenu(b,b.newAccount());
        }
    }

}