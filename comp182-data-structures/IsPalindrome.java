import java.util.Scanner;
public class IsPalindrome {
    public static void main(String[]args) {
        Scanner scanner = new Scanner(System.in);

        //user declares array size
        System.out.print("Enter number of integers (maximum 20): ");
        int nums = scanner.nextInt();
        int[] userList = new int[nums];

        //user inputs nums to array
        System.out.print("Enter " + nums + " integers separated by a space: ");
        for (int i = 0; i < nums; i++) {
            int userInput = scanner.nextInt();
            userList[i] = userInput;
        }

        //check for equal values
        boolean palindrome = true;
        for (int low = 0, high = nums - 1; low <= high; low++, high--) {
            if (userList[low] != userList[high]) {
                palindrome = false;
                break;
            }
        }
            if (palindrome) {
                System.out.println("Integer string is a palindrome");
            }
            else {
                System.out.println("Integer string is not a palindrome");
            }
            scanner.close();
        }
    }
