package Task_02;

import java.util.Scanner;

public class BankingSystem{
    static double balance = 0;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println();
            System.out.println("------------------------------------------------------");
            System.out.println("|        WELCOME TO [CodeAlpha] BANKING SYSTEM       |");
            System.out.println("------------------------------------------------------");
            System.out.println("|\t1. Deposit                                       |");
            System.out.println("|\t2. Withdraw                                      |");
            System.out.println("|\t3. Check Balance                                 |");
            System.out.println("|\t4. Exit                                          |");
            System.out.println("------------------------------------------------------");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    deposit();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    System.out.println("*******************************************************");
                    System.out.println("| Thank you for using CodeAlpha Banking Application.  |\n" +
                                       "| See You Again !!!                                   |");
                    System.out.println("*******************************************************");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        } while (choice != 4);
    }

    // Money Deposit
    public static void deposit() {
        System.out.print("Enter the amount to deposit: ");
        double amount = scanner.nextDouble();
        if (amount > 0) {
            balance += amount;
            System.out.println();
            System.out.println("******************************************************");
            System.out.println(" Deposit successful. Current balance: $" + balance);
            System.out.println("******************************************************");
        } else {
            System.out.println();
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            System.out.println("| Invalid amount. Please enter an valid amount to Deposit. |");
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        }
    }

    // Money Withdraw
    public static void withdraw() {
        System.out.println();
        System.out.print("Enter the amount to withdraw: ");
        double amount = scanner.nextDouble();
        if (amount > 0) {
            if (balance >= amount) {
                balance -= amount;
                System.out.println();
                System.out.println("******************************************************");
                System.out.println(" 1 Withdrawal successful. Current balance: $" + balance);
                System.out.println("******************************************************");
            } else {
                System.out.println();
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!");
                System.out.println("| Insufficient funds. |");
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!");
            }
        } else {
            System.out.println();
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            System.out.println("| Invalid amount. Please enter an valid amount to Withdraw. |");
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        }
    }

    // Check Balance
    public static void checkBalance() {
        System.out.println();
        System.out.println("*******************************");
        System.out.println("| Current balance: $" + balance);
        System.out.println("*******************************");
    }
}
