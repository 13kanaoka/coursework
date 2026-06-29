import java.util.Scanner;
public class SortedChecker {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int data [] = new int [10];
        System.out.println("Enter 10 numbers");
        for (int i = 0; i < data.length; i++)
            data [i] = scanner.nextInt();

        boolean sorted = true;
        for (int i = 0; i < data.length - 1; i++)
        {
            if (data [i] > data [i + 1])
            {
                sorted = false;
                break;
            }
        }
        if (sorted)
            System.out.println("Data sorted");
        else
            System.out.println("Data is not sorted");

            scanner.close();
    }
}