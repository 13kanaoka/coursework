import java.util.Scanner;
public class QuadraticEquation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a, b, c: ");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        QuadEq q = new QuadEq (a, b, c);
        System.out.println("Root 1 = " + q.getRoot1());
        System.out.println("Root 2 = " + q.getRoot2());

    }
}
class QuadEq
{
    private double a;
    private double b;
    private double c;
    QuadEq (double a, double b, double c)
    {
        this.a = a; this.b = b; this.c = c;
    }
    double geta ()      {     return a;       }
    double getb ()      {     return b;       }
    double getc ()      {     return c;       }
    double getDiscriminant ()
    {
        return b * b - 4 * a * c;
    }
    double getRoot1 ()
    {
        if (getDiscriminant () < 0)
            return 0;
        else
            return (-b + Math.sqrt (getDiscriminant ())) / (2 * a);
    }
    double getRoot2 ()
    {
        if (getDiscriminant () < 0)
            return 0;
        else
            return (-b - Math.sqrt (getDiscriminant ())) / (2 * a);

    }
}