// Create class BankAccount with the following attributes: customerId – long,customerName – String, accounted – long, balance – double. Implement the following methods in this class. DepositAmonut(double amount) - adds the amount to existing balance and returns new balance WithdrawAmount(double amount) - deducts the amount from existing balance and returns new balance.However, if amount is greater than balance, returns -1. AddInterest(double percent) - adds amount based on interest percentage and returns new balance. In BankDemo class create bank account object and test above methods. Reuse the BankAccount and BankAccountDemo classes. Create array of bank account objects. Perform the deposit, withdraw operation for the given account number.If the Account Id not found in the array of objects, display proper error message.Reuse the BankAccount class created above. Modify the program to accept input from the user. Add InputMismatchException to check whether the user entered correct numerical values. If the user enters invalid numbers (Ex. Instead of valid amount, strings entered as input) catch the exception and display valid error messages. Create a user defined exception InvalidAmountException. If the user enter negative amount rise this exception and handle it. Modify the same code, handle InvalidAmountException in main method / in deposit, withdraw methods. Modify the same code using throws key word and study the usage of throws key word.
import java.util.Scanner;
import java.util.InputMismatchException;

// Custom exception class for handling invalid amounts
class InvalidAmountException extends Exception {
    InvalidAmountException(String s) {
        super(s);
    }
}

// Class representing a bank account
class BankAccount {
    long customerid, accounted;
    String customerName;
    double balance;
    Scanner in = new Scanner(System.in);

    // Constructor to initialize a bank account
    BankAccount(int i) {
        System.out.println("Enter customer " + (i + 1) + " Details");
        System.out.println("Enter your Customer id");
        customerid = in.nextLong();
        System.out.println("Enter your Customer Name");
        in.nextLine();
        customerName = in.nextLine();
        System.out.println("Enter your current balance");
        balance = in.nextDouble();
    }

    // Method to deposit amount into the account
    double DepositAmount(double amount) throws InvalidAmountException {
        if (amount < 0) {
            throw new InvalidAmountException("Invalid Amount,Amount shouldn't be Negative");
        } else {
            balance = balance + amount;
            System.out.println("Amount deposited Successfully ");
            return balance;
        }
    }

    // Method to withdraw amount from the account
    double withdrawAmount(double amount) throws InvalidAmountException {
        if (amount < 0) {
            throw new InvalidAmountException("Invalid Amount,amount shouldn't be Negative");
        }
        if (balance >= amount) {
            balance = balance - amount;
            System.out.println("Amount Withdrawn Successfully");
            return balance;
        } else {
            return -1;
        }
    }

    // Method to add interest to the account balance
    double AddInterest(double percent) {
        balance = balance + (balance * percent * 12 * 0.01);
        return balance;
    }

    // Method to display customer details
    void display(int i) {
        System.out.println("Customer " + (i + 1) + " details are ");
        System.out.println("Customer Id =" + customerid);
        System.out.println("Customer Name =" + customerName);
    }
}

// Class for demonstrating the bank account functionality
class BankAccountDemo {
    public static void main(String args[]) {
        double res, amount;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter no of Customers");
        int n = in.nextInt();
        BankAccount b[] = new BankAccount[n];

        for (int i = 0; i < n; i++) {
            b[i] = new BankAccount(i);
            System.out.println("1.Deposit \n2.Withdraw \n3.AddInterest");
            System.out.println("Enter your option");
            int op = in.nextInt();

            try {
                switch (op) {
                    case 1:
                        System.out.println("Enter Amount to deposit");
                        try {
                            amount = in.nextDouble();
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input,Please enter a valid numerical value.");
                            continue;
                        }
                        res = b[i].DepositAmount(amount);
                        b[i].display(i);
                        System.out.println("Your Balance =" + res);
                        break;

                    case 2:
                        System.out.println("Enter the amount to withdraw");
                        try {
                            amount = in.nextDouble();
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input,Please enter a valid numerical value.");
                            continue;
                        }
                        res = b[i].withdrawAmount(amount);
                        b[i].display(i);
                        if (res > 0) {
                            System.out.println("Your Balance =" + res);
                        } else {
                            System.out.println("Insufficient Balance");
                        }
                        break;

                    case 3:
                        System.out.println("Enter interest percent");
                        double percent = in.nextDouble();
                        res = b[i].AddInterest(percent);
                        b[i].display(i);
                        System.out.println("After adding interest Your Account balance =" + res);
                        break;
                }
            } catch (InvalidAmountException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        in.close();
    }
}
