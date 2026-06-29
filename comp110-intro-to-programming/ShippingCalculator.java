import java.util.Scanner;

public class ShippingCalculator {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        System.out.println("What is the weight, in pounds, of your package?");
        double packageWeight = scanner.nextDouble();

        if (0 < packageWeight && packageWeight <= 1) {
            System.out.println("Your shipping cost is 3.5 dollars");
        }
        else if (1 < packageWeight && packageWeight <= 3) {
            System.out.println("Your shipping cost is 5.5 dollars");
        }
        else if (0 < packageWeight && packageWeight <= 10) {
            System.out.println("Your shipping cost is 8.5 dollars");
        }
        else if (10 < packageWeight && packageWeight <= 20) {
            System.out.println("Your shipping cost is 10.5 dollars");
        }
        else if (20 < packageWeight && packageWeight <= 50) {
            System.out.println("Please contact our shipping services for a specific estimate at (805)216-8569");
            System.out.println("Matt will pick up the phone. He is a very nice guy who can accomodate both English and Japanese speakers!");
        }
        else {
            System.out.println("Your package cannot be shipped");
        }

        scanner.close();
        }
    }