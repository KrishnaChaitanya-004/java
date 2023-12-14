//Create three threads namely Factorial, SumOfSeries and MultiplicationTable. Fact thread should produce factorial value. Sum thread should produce sum of natural numbers. MultiplicationTable thread class should produce  multiplication table. From the main class, create the thread objects and perform three thread operations simultaneously. Ensure that the main program terminates after all the threads completes its execution
import java.util.Scanner;

// A class to calculate the factorial of a number
class Factorial implements Runnable {
    int n, fact = 1, i = 1;

    Factorial(int n) {
        this.n = n;
    }

    public void run() {
        while (n >= i) {
            fact = fact * i;
            i++;
        }
        System.out.println("\n Factorial value=" + fact);
    }
}

// A class to calculate the sum of digits in a series
class SumofSeries implements Runnable {
    int n, sum, rem;

    SumofSeries(int n) {
        this.n = n;
    }

    public void run() {
        while (n > 0) {
            sum = sum + n;
            n--;
        }
        System.out.println("Sum of digits =" + sum);
    }
}

// A class to display the multiplication table of a number
class MultiplicationTable implements Runnable {
    int n, i = 1;

    MultiplicationTable(int n) {
        this.n = n;
    }

    public void run() {
        System.out.println("Multiplication Table is");
        while (i <= 10) {
            System.out.println(n + " * " + i + " = " + n * i);
            i++;
        }
    }
}

// Main class to demonstrate threading and execute the factorial, sum of series, and multiplication table concurrently
class ThreadDemo {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.println("Main Thread Starting");
        System.out.println("Enter a Number ");
        int n = in.nextInt();

        // Create instances of Runnable classes
        Factorial f1 = new Factorial(n);
        SumofSeries s1 = new SumofSeries(n);
        MultiplicationTable m1 = new MultiplicationTable(n);

        // Create threads for each Runnable
        Thread f = new Thread(f1);
        Thread s = new Thread(s1);
        Thread m = new Thread(m1);

        // Start threads
        f.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Main Thread Interrupted");
        }

        s.start();
        m.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Main Thread Interrupted");
        }

        System.out.println("Main Thread Terminating");
        in.close();
    }
}
