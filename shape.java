//Create a Shape class and overload area method to calculate area of different shapes.(Rectangle, circle and triangle).
public class shape//created a class shape 
{
    void area(int s)//overloaded area method:1a
    {
        System.out.println("area of square: "+4*s);//calculating area of square
    }
    void area(int l,int b)//overloaded area method:1b
    {
        System.out.println("area of rectangle: "+l*b);//calculating area of rectangle
    }
    void area(double a)//overloaded area method:1c
    {
        System.out.println("area of circle: "+3.14*a*a);//calculating area of circle
    }
    public static void main(String[] args) 
    {
        shape a=new shape();//creating a obj&initializing obj
        a.area(4);//calling overloaded area method:1a
        a.area(3, 4);//calling overloaded area method:1b
        a.area(5);//calling overloaded area method:1c
    }
    
}
