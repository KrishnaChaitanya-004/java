/*Create a package named pkbanking. In that package define a sub package named pkinterface. The package pkinterface contains an interface named Transaction with a data member min balance initialized to 500, two methods namely void withdraw(double) and void deposit(double) and another interface named InterestRate with a data member sbrate with 4%.
Create another package named pkaccount. In that package create an abstract class called Account that has the protected data members accnumber of int type, balance of double, constructors for initialization. Define a subpackage sb in pkaccount. In sb package derive a class called SBAccount from Account
class that implements both Transaction and InterestRate interfaces. Also it has constructors for initialization using super class constructors, deposit(double). withdraw(double), and calc_interest() methods. Provide a parameterized constructor with two parameters account number, and init balance and assign these values to the appropriate data members of the class using super class constructor. The deposit method should take one double type argument amount and adds the amount to the balance if the amount is positive. The withdraw method, should take one double type argument amount and checks if balance amount is greater than min balance. If so, it should subtract the amount from balance. Otherwise it should display error message. The calc_interest() method should compute interest for the balance amount available @sbrate p.a. and the interest amount should be credited to the balance.
Create third package named pkcustomer which contains a class Customer. The data members of the class are cust_id of int type, name, and address of string type, and object of SBAccount. Provide parameterized constructor with cust_id, name, address, account number, initial balance as parameters for opening a SB account for new customer. Provide a method transaction(int type) (type may be withdraw, deposit or calc_interest to perform the requested transaction on the requested Account object.

To demonstrate all the functionalities of above classes, create a class called Bank Demo and declare a main method to create an array of 5 elements of Customer objects, and perform manipulations on the objects by creating SB account, depositing and withdrawing amount from SB accounts.*/
// Package for banking interface
package pkbanking.pkinterface;

// Interface for interest rate
public interface interestRate
{
  public double sbrate=0.04; // Static variable for standard base interest rate
}

// Package for banking interface
package pkbanking.pkinterface;

// Interface for banking transactions
public interface Transaction
{
  public int min_balance=500; // Static variable for minimum balance requirement
  public void withdraw(double amount); // Method for withdrawing funds
  public void deposit(double amount); // Method for depositing funds
}

// Package for account-related classes
package pkaccount;

// Abstract class for bank account
public abstract class Account
{
  protected int Accnumber; // Account number
  protected double balance; // Account balance
  
  // Constructor for Account
  public Account(int Accnumber,double balance)
  {
    this.Accnumber=Accnumber; // Initialize account number
    this.balance=balance; // Initialize account balance
  }
}

// Package for saving account related classes
package pkaccount.sbpackage;

import pkbanking.pkinterface.*; // Import the banking interface
import pkaccount.Account; // Import the Account class

// SbAccount class extending Account and implementing Transaction,interestRate
public class SbAccount extends Account implements Transaction,interestRate
{
  // Constructor for SbAccount
  public SbAccount(int Accnumber,double balance)
  {
    super(Accnumber,balance); // Call the superclass constructor (Account)
  }
  
  // Implementation of deposit method
  public void deposit(double amount)
  {
    if(amount>0)
    {
      balance+=amount; // Add the deposited amount to the balance
      System.out.println("Your Amount Deposited successfully");
      System.out.println("Now Your Balance =" + balance);
    }
    else
    {
      System.out.println("Invalid Amount");
    }
  }

  // Implementation of withdraw method
  public void withdraw(double amount)
  {
    if(balance>amount && balance>min_balance)
    {
      balance-=amount; // Subtract the withdrawn amount from the balance
      System.out.println("Amount Withdrawn Successfully");
      System.out.println("Available Balance =" + balance);
    }
    else
    {
      System.out.println("Insufficient balance");
    }
  }

  // Calculate interest and update balance
  public void calc_interest()
  {
    balance = balance + (balance * sbrate); // Add interest to the balance
    System.out.println("After Adding interest your Account balance =" + balance);
  }
}

// Package for customer-related classes
package pkcustomer;

import pkaccount.sbpackage.*; // Import the SbAccount class
import java.util.Scanner; // Import Scanner class for user input

// Customer class representing a bank customer
public class Customer
{
  Scanner in = new Scanner(System.in); // Scanner for user input
  public int cust_id; // Customer ID
  public String Name, Address; // Customer name and address
  SbAccount s; // SbAccount object for the customer

  // Constructor for Customer
  public Customer(int cust_id, String name, String Address, int Accnumber, double balance)
  {
    this.cust_id = cust_id;
    this.Name = Name;
    this.Address = Address;
    s = new SbAccount(Accnumber, balance); // Initialize the SbAccount object
  }

  // Perform banking transactions
  public void transaction()
  {
    double amount;
    System.out.println("1. Withdraw \n2. Deposit \n3. Calculate interest");
    System.out.println("Enter your option");
    int op = in.nextInt(); // Get user's choice

    switch (op) // Switch based on user's choice
    {
      case 1:
        System.out.println("Enter Amount to Withdraw");
        amount = in.nextDouble(); // Get withdrawal amount
        s.withdraw(amount); // Call withdraw method
        break;
      case 2:
        System.out.println("Enter Amount to Deposit");
        amount = in.nextDouble(); // Get deposit amount
        s.deposit(amount); // Call deposit method
        break;
      case 3:
        s.calc_interest(); // Call calculate interest method
        break;
    }
  }
}

// Demo class for bank operations
import pkbanking.pkinterface.*; // Import the banking interface
import pkaccount.*; // Import the Account class
import pkaccount.sbpackage.*; // Import the SbAccount class
import pkcustomer.*; // Import the Customer class
import java.util.Scanner; // Import Scanner class for user input

class BankDemo
{
  // Main method
  public static void main(String args[])
  {
    Scanner in = new Scanner(System.in); // Scanner for user input
    System.out.println("Enter number of customers");
    int n = in.nextInt(); // Get number of customers
    Customer c[] = new Customer[n]; // Create an array of Customer objects

    for (int i = 0; i < n; i++)
    {
      System.out.println("Enter " + (i + 1) + " customer details");
      System.out.println("Enter customer Id :");
      int cust_id = in.nextInt(); // Get customer ID
      System.out.println("Enter Account Number :");
      int Accnumber = in.nextInt(); // Get account number
      System.out.println("Enter customer Name :");
      in.nextLine();
      String Name = in.nextLine(); // Get customer name
      System.out.println("Enter customer Address :");
      String Address = in.nextLine(); // Get customer address
      System.out.println("Enter initial balance");
      double balance = in.nextDouble(); // Get initial balance
      c[i] = new Customer(cust_id, Name, Address, Accnumber, balance); // Create Customer object
      c[i].transaction(); // Perform transactions for the customer
    }
  }
}
