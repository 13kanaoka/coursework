import java.util.Scanner;
public class SignedNumberStats {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Matthew Rohde");
        int numOfPos = 0;
        int numOfNeg = 0;
        int count = 0;
        int sum = 0;
        System.out.print("Enter a number! ");
        int num = scanner.nextInt();

        while (num != 0)
        {
            if (num > 0) numOfPos++;
            if (num < 0) numOfNeg++;
            count++;
            sum += num;
            System.out.print("Enter a number! ");
            num = scanner.nextInt();
        }
        if (count == 0)
        {
            System.out.println("No number read");
        }
        else
        {
            System.out.println("Total Numbers: " + count);
            System.out.println("Total = " + sum);
            System.out.println("Positives = " + numOfPos);
            System.out.println("Negatives = " + numOfNeg);
            System.out.println("Average = " + (double)sum / count);
        }

        scanner.close();
    }
}
