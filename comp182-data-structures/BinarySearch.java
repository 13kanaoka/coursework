import java.util.Scanner;
public class BinarySearch {
    static int rounds = 0;
    public static int BinarySearch(int[] arr, int arraySize, int key) {
        int mid = 0;
        int low = 0;
        int high = arraySize - 1;

        while (high >= low) {
            rounds++;
            mid = (high + low) / 2;
            if (arr[mid] < key) {        // if key is greater than mid
                low = mid + 1;
            }
            else if (arr[mid] > key) {    // if key is less than mid
                high = mid - 1;
            }
            else {
                return mid;
           }
        }
        return -1;
     }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //grab array size, if not large enough, end program.
        System.out.print("Enter the size of your array. It must be greater than 5: ");
        int arraySize = scanner.nextInt();
        if (arraySize <= 5) {
            System.out.println();
            System.out.println("Your array is not large enough.");
            System.exit(0);
        }

        int[] arr = new int[arraySize]; //declaring the array

        System.out.println();
        System.out.print("Enter " + arraySize + " integers, separated by a space: "); //asking user to input data

        for (int i = 0; i < arraySize; i++) { //user inputs into array
            int arrayData = scanner.nextInt();
            arr[i] = arrayData;
        }

    int min;
    System.out.println();
    System.out.print("Sorted array: "); //prep the println
    for (int i = 0; i < arr.length; i++) { //sorting array
        min = i;
        for (int j = i + 1; j < arr.length; j++) {
            if (arr[j] < arr[min]) {
                min = j;
            }
        }
        if (min != i) {
            final int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
        System.out.print(arr[i] + " "); //printing array
    }

    System.out.println(); //spacing for cleanliness
    System.out.println();
    System.out.print("Please enter a value you want to search: "); //asking user to search
    int key = scanner.nextInt();
    System.out.println();

    int keyIndex = BinarySearch(arr, arraySize, key); //declaring keyIndex as the return from Binary Search.
        if (keyIndex == -1) {
            System.out.println(key + " was not found."); //method returns -1 if not found
        }
        else {
            System.out.println("Found " + key + " at index " + keyIndex + "."); //printing searched number and index
            System.out.println("It took " + rounds + " rounds to complete."); //printing the comparison count
        }
        scanner.close();
    }
}
