//1.Create a class MyMath and add addition ,multiplication and power methods. 
//Overload all these methods for different data types. Test these method from a demo class.
public class mymatho {
    void addition(int a,int b)//overloaded addition method:1a
    {
        int c=a+b;//addition of two int parameters
        System.out.println("added valued="+c);
    }
    void addition(double a,int b)//overloaded addition method:1b
    {
        double c=a+b;//addition of double,int parameters
        System.out.println("added valued="+c);
    }
    void addition(double a,double b)//overloaded addition method:1c
    {
        double c=a+b;//addition of two double parameters
        System.out.println("added valued="+c);
    }
    void power(int a,int b)//overloaded power method:2a
    {
        double c=(Math.pow(a, b));//power of two int parameters
        System.out.println("power vale="+c);
    }
    void power(double a,int b)//overloaded power method:2b
    {
        double c=(Math.pow(a, b));//addition of double,int parameters
        System.out.println("power vale="+c);
    }
    void power(double a,double b)//overloaded power method:2c
    {
        double c=(Math.pow(a, b));//addition of two double parameters
        System.out.println("power vale="+c);
    }
    void multiplication(int a,int b)//overloaded multiplication method:3a
    {
        int c=a*b;//power of two int parameters
        System.out.println("multiplication valued="+c);
    }
    void multiplication(double a,int b)//overloaded multiplication method:3b
    {
        double c=a*b;//power of double,int parameters
        System.out.println("multiplication valued="+c);
    }
    void multiplication(double a,double b)//overloaded multiplication method:3c
    {
        double c=a*b;//power of two double parameters
        System.out.println("multiplication valued="+c);
    }
    public static void main(String[] args)
    {
    mymatho a=new mymatho();
    a.addition(2, 3);//calling overloaded addition method:1a
    a.addition(8.0, 5);//calling overloaded addition method:1b
    a.addition(4.0, 0.2);//calling overloaded addition method:1c
    a.power(2, 3);//calling overloaded power method:2a
    a.power(9.0, 7);//calling overloaded power method:2b
    a.power(4.0, 0.8);//calling overloaded power method:2c
    a.multiplication(3, 4);//calling overloaded multiplication method:3a
    a.multiplication(3.4, 5);//calling overloaded multiplication method:3b
    a.multiplication(6.2, 0.4);//calling overloaded multiplication method:3c
    }
}
