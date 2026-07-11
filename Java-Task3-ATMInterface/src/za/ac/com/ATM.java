/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.com;
import java.util.ArrayList;
import java.util.Scanner;
import java.text.DecimalFormat;
/**
 *
 * @author User
 */
public class ATM {
    private DecimalFormat df = new DecimalFormat("#,##0.00");

    private Scanner input = new Scanner(System.in);
    private Bank bank = new Bank();
    private ArrayList<Transaction> history = new ArrayList<>();

    public void start() {

    System.out.println("==============================");
    System.out.println("        ATM INTERFACE");
    System.out.println("==============================");

    int attempts = 0;

    while (attempts < 3) {

        System.out.print("Enter User ID: ");
        String userId = input.next();

        System.out.print("Enter PIN: ");
        String pin = input.next();

        if (bank.login(userId, pin)) {

            System.out.println("\nLogin Successful!\n");

            menu();

            return;

        }

        attempts++;

        System.out.println("Invalid User ID or PIN.");
        System.out.println("Attempts Remaining: " + (3 - attempts));
    }

    System.out.println("\nYour account has been locked.");
}
    public void menu() {

    int choice;

    do {

        System.out.println("\n==============================");
        System.out.println("\n           ATM MENU           ");
        System.out.println("\n==============================");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Transfer");
        System.out.println("4. Check Balance");
        System.out.println("5. Transaction History");
        System.out.println("6. Exit");
        System.out.println("\n==============================");

        System.out.print("Choose an option: ");
        choice = input.nextInt();

        switch (choice) {

            case 1:
                deposit();
                break;

            case 2:
                withdraw();
                break;

            case 3:
                transfer();
                break;

            case 4:
                checkBalance();
                break;

            case 5:
                showHistory();
                break;

            case 6:
                System.out.println();
                System.out.println("=================================");
                System.out.println("Thank you for using our ATM.");
                System.out.println("Have a great day!");
                System.out.println("=================================");
                break;

            default:
                System.out.println("Invalid option.");

        }

    } while (choice != 6);

    }
    private void deposit() {

                System.out.print("Enter amount to deposit: R");
                double amount = input.nextDouble();

                if (amount <= 0) {
                    System.out.println("Invalid amount.");
                    return;
                }

                bank.getAccount().deposit(amount);

                history.add(new Transaction("Deposit", amount));

                System.out.println("Deposit successful.");
                System.out.println("Current Balance: R" + bank.getAccount().getBalance());

            }

            private void withdraw() {

                System.out.print("Enter amount to withdraw: R");
                double amount = input.nextDouble();

                if (amount <= 0) {
                    System.out.println("Invalid amount.");
                    return;
                }

                if (bank.getAccount().withdraw(amount)) {

                    history.add(new Transaction("Withdraw", amount));

                    System.out.println("Withdrawal successful.");
                    System.out.println("Current Balance: R" + bank.getAccount().getBalance());

                } else {

                    System.out.println("Insufficient funds.");

                }

            }

            private void transfer() {

                System.out.print("Enter recipient account number: ");
                String recipient = input.next();

                System.out.print("Enter amount to transfer: R");
                double amount = input.nextDouble();

                if (amount <= 0) {
                    System.out.println("Invalid amount.");
                    return;
                }

                if (bank.getAccount().transfer(amount)) {

                    history.add(new Transaction("Transfer to " + recipient, amount));

                    System.out.println("Transfer successful.");
                    System.out.println("Current Balance: R" + bank.getAccount().getBalance());

                } else {

                    System.out.println("Insufficient funds.");

                }

            }

            private void checkBalance() {

                System.out.println("Current Balance: R" + df.format(bank.getAccount().getBalance()));

            }

            private void showHistory() {

                System.out.println("\n========== TRANSACTION HISTORY ==========");

                if (history.isEmpty()) {

                    System.out.println("No transactions available.");
                    return;

                }

                for (Transaction transaction : history) {

                    System.out.println(transaction);

                }

            }

}
