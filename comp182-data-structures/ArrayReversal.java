import java.util.Scanner;
public class ArrayReversal
{
    public static void main(String[] args) 
    {
        //reading user's input
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many integers?");
        //create the array
        int numberOfItems = scanner.nextInt();
        int[] userList = new int[numberOfItems];

        //add integers to the array
        System.out.println("Please enter integers.");
        for (int i = 0; i < numberOfItems; i++)
        {
        int userInput = scanner.nextInt();
            userList[i] = userInput;
        }

        //print integers
        System.out.println(" ");
        System.out.println("Output");
        for (int j = (numberOfItems - 1); j >= 0; j--)
        {
            System.out.print(userList[j] + ",");
        }

        scanner.close();
    }
}