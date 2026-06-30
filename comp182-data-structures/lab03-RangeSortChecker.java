import java.util.Scanner;
public class RangeSortChecker {
    public static void main(String[]args) {
        Scanner scanner = new Scanner(System.in);

        //declaring array size
        System.out.print("Please enter your array size: ");
        int arraySize = scanner.nextInt();

        //declare array
        int[] userList = new int[arraySize];

        //declaring array's data
        System.out.print("Enter " + arraySize + " integers, separated by a space: ");

        for (int i = 0; i < arraySize; i++) {
            int arrayData = scanner.nextInt();
            userList[i] = arrayData;
        }

        //start and end positions
        System.out.print("Please enter your start and end positions, separated by a space: ");

            int start = scanner.nextInt();
            int end = scanner.nextInt();

        //checking for sort 
        boolean sorted = true;
        for (int k = start - 1; k < end - 1; k++)
        {
            if (userList[k] > userList[k + 1])
            {
                sorted = false;
                break;
            }
        }
        if (sorted)
            System.out.println("Sorted: yes");
        else
            System.out.println("Sorted: no");
     
            scanner.close();
    }
}