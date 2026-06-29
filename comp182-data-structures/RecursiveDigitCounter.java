import java.util.Scanner;
public class RecursiveDigitCounter {
    static int digitCount(int yay) 
    {
    if (yay / 10 == 0) {
        return 1;
    }
    else {
        return (1 + digitCount(yay / 10));
    }
}
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter a non-negative integer. ");
        int yay = scanner.nextInt();

        System.out.println("The number of digits is " + digitCount(yay));

        scanner.close();
    }
}
