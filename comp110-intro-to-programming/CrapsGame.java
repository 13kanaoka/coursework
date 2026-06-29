import java.lang.Math;
public class CrapsGame {
    public static void main(String[] args)
    {
    System.out.println("Matthew Rohde - Project Three: Craps");
    System.out.println(" ");
    int dieone = (int)(Math.random() * 6) + 1;
    int dietwo = (int)(Math.random() * 6) + 1;

    int sum = (dieone + dietwo);
    System.out.println("Player rolled " + dieone + " + " + dietwo + " = " + sum);

    if (sum == 7 || sum == 11) {
        System.out.println(" ");
        System.out.println("Player wins!");
    }
    else if (sum == 2 || sum == 3 || sum == 12) {
        System.out.println(" ");
        System.out.println("Player loses!");
    }
    else {
        int points = sum;
        System.out.println(" ");
        System.out.println("Point is " + points + ", the game continues!");
        System.out.println(" ");
        int diethree = (int)(Math.random() * 6) + 1;
        int diefour = (int)(Math.random() * 6) + 1;

        int sumtwo = (diethree + diefour);
        System.out.println("Player rolled " + diethree + " + " + diefour + " = " + sumtwo);
        
        if (sumtwo == points) {
            System.out.println(" ");
            System.out.println("You win!");
        }
        else if (sumtwo == 7) {
            System.out.println(" ");
            System.out.println("You lose!");
        }
        else {
            while (sumtwo != 7 || sumtwo != points) {
                int diefive = (int)(Math.random() * 6) + 1;
                int diesix = (int)(Math.random() * 6) + 1;
                sumtwo = (diefive + diesix);
                System.out.println("Player rolled " + diefive + " + " + diesix + " = " + sumtwo);

                if (sumtwo == points) {
                    System.out.println(" ");
                    System.out.println("You win!");
                    break;
                }
                else if (sumtwo == 7) {
                    System.out.println(" ");
                    System.out.println("You lose!");
                    break;
                }
            }
            System.out.println(" ");
            System.out.println("Matthew Rohde - Project Three: Craps");

            }
        }
    }
}