import java.util.ArrayList;
import java.util.Scanner;

public class ATMStimulation 
{

    private static double balance = 1000.00; // Initial balance
    private static int pin = 1234; // Default PIN
    private static ArrayList<String> transactionHistory = new ArrayList<>();

    public static void main(String[] args) 
      {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your PIN: ");
        int inputPin = scanner.nextInt();

        if (inputPin != pin)
        {
            System.out.println("Invalid PIN. Exiting...");
            return;
        }

        while (true)
        {
            System.out.println("\nWelcome to the ATM!");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw Cash");
            System.out.println("3. Deposit Cash");
            System.out.println("4. Change PIN");
            System.out.println("5. View Transaction History");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) 
            {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    withdrawCash(scanner);
                    break;
                case 3:
                    depositCash(scanner);
                    break;
                case 4:
                    changePIN(scanner);
                    break;
                case 5:
                    viewTransactionHistory();
                    break;
                case 6:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void checkBalance() 
    {
        System.out.printf("Your current balance is: $%.2f%n", balance);
    }

    private static void withdrawCash(Scanner scanner) 
      {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();

        if (amount > balance) 
        {
            System.out.println("Insufficient balance.");
        } else if (amount <= 0) 
        {
            System.out.println("Invalid amount.");
        } else 
        {
            balance -= amount;
            System.out.printf("You have withdrawn $%.2f. Remaining balance: $%.2f%n", amount, balance);
            transactionHistory.add("Withdrawn: $" + amount);
        }
    }

    private static void depositCash(Scanner scanner)
    {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();

        if (amount <= 0) 
        {
            System.out.println("Invalid amount.");
        } else 
        {
            balance += amount;
            System.out.printf("You have deposited $%.2f. New balance: $%.2f%n", amount, balance);
            transactionHistory.add("Deposited: $" + amount);
        }
    }

    private static void changePIN(Scanner scanner) 
      {
        System.out.print("Enter your current PIN: ");
        int currentPin = scanner.nextInt();

        if (currentPin != pin)
        {
            System.out.println("Incorrect current PIN.");
        } else
        {
            System.out.print("Enter your new PIN: ");
            int newPin = scanner.nextInt();
            pin = newPin;
            System.out.println("Your PIN has been changed successfully.");
        }
    }

    private static void viewTransactionHistory() 
      {
        if (transactionHistory.isEmpty()) 
        {
            System.out.println("No transactions available.");
        } else
        {
            System.out.println("Transaction History:");
            for (String transaction : transactionHistory)
            {
                System.out.println(transaction);
            }
        }
    }
}