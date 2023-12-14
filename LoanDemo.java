/*Create a class Loan with data members loanNo – long, customerName – String, months – int, loanAmount – double, payableAmount – double,
interest – float, and emi - double. Inherit Loan class to CarLoan – (carNo – String) and AgriLoan – (landArea – float). Implement getDetails, display
and calculateEMI methods. In LoanDemo class create objects for CarLoan
and Agri loan and invoke all methods. For agri loan if the loan amount is
less than 200000 and months is less than 24 months then no interest. Modify the Loan class as abstract and its methods as abstract methods. Implement the dynamic method polymorphism. Modify the above created class to process array of objects. Create array of references for parent class and store the objects of child class in it based on user choice. Later invoke the overrided methods calculation and display.
*/import java.util.Scanner;

// Abstract class to represent a loan
abstract class Loan {
    long loanno;
    String customerName;
    int months;
    double loanAmount, payableAmount;
    float interest;
    double Emi;

    // Abstract methods to be implemented by subclasses
    abstract void getDetails();
    abstract void calculate();
    abstract void display(int i);
}

// Subclass for car loans
class CarLoan extends Loan {
    Scanner in = new Scanner(System.in);
    String carNo;

    @Override
    void getDetails() {
        System.out.println("Enter Loan Number");
        loanno = in.nextLong();
        System.out.println("Enter your Name");
        in.nextLine();
        customerName = in.nextLine();
        System.out.println("Enter Loan Amount");
        loanAmount = in.nextDouble();
        System.out.println("Enter Number of months");
        months = in.nextInt();
        System.out.println("Enter the interest in %");
        interest = in.nextFloat();
        System.out.println("Enter car Number");
        in.nextLine();
        carNo = in.nextLine();
    }

    @Override
    void calculate() {
        interest = (int) loanAmount * (months / 12) * interest / 100;
        payableAmount = loanAmount + interest;
        Emi = payableAmount / months;
    }

    @Override
    void display(int i) {
        System.out.println("Customer " + (i + 1) + " Details");
        System.out.println("Loan Number =" + loanno);
        System.out.println("customerName =" + customerName);
        System.out.println("Loan Amount =" + loanAmount);
        System.out.println("Total payable Amount =" + payableAmount);
        System.out.println("Emi Per installement =" + Emi);
        System.out.println("Car Number =" + carNo);
    }
}

// Subclass for agriculture loans
class AgriLoan extends Loan {
    Scanner in = new Scanner(System.in);
    float landArea;

    @Override
    void getDetails() {
        System.out.println("Enter Loan Number");
        loanno = in.nextLong();
        System.out.println("Enter your Name");
        in.nextLine();
        customerName = in.nextLine();
        System.out.println("Enter Loan Amount");
        loanAmount = in.nextDouble();
        System.out.println("Enter Number of months");
        months = in.nextInt();
        System.out.println("Enter Land Area");
        landArea = in.nextFloat();
    }

    @Override
    void calculate() {
        if (loanAmount <= 200000 && months <= 24) {
            interest = 0.0f;
        } else {
            System.out.println("Enter the interest in %");
            interest = in.nextFloat();
        }
        interest = (int) loanAmount * (months / 12) * interest / 100;
        payableAmount = loanAmount + interest;
        Emi = payableAmount / months;
    }

    @Override
    void display(int i) {
        System.out.println("Customer " + (i + 3) + " Details");
        System.out.println("Loan Number =" + loanno);
        System.out.println("customerName =" + customerName);
        System.out.println("Loan Amount =" + loanAmount);
        System.out.println("payable Amount =" + payableAmount);
        System.out.println("Emi Per installement =" + Emi);
        System.out.println("Land Area =" + landArea);
    }
}

// Main class to demonstrate the loan system
class LoanDemo {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter no of Customers");
        int n = in.nextInt();
        Loan l[] = new Loan[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter Customer " + (i + 3) + " Details");
            System.out.println("1. Car loan \n2. Agriculture loan");
            System.out.println("Enter your option");
            int op = in.nextInt();

            switch (op) {
                case 1:
                    l[i] = new CarLoan(); // Creating a CarLoan object
                    l[i].getDetails(); // Getting loan details
                    l[i].calculate(); // Calculating loan details
                    l[i].display(i); // Displaying loan details
                    break;
                case 2:
                    l[i] = new AgriLoan(); // Creating an AgriLoan object
                    l[i].getDetails(); // Getting loan details
                    l[i].calculate(); // Calculating loan details
                    l[i].display(i); // Displaying loan details
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
        in.close();
    }
}

