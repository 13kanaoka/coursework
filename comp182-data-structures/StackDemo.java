import java.util.Stack;
import java.util.Scanner;

public class StackDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Stack<String> things = new Stack<String>();

        System.out.print("Enter four items, separated by the enter key. ");
        for (int i = 0; i < 4; i++) {
        String userInput = scanner.nextLine();
            things.push(userInput);
        }
        System.out.println();
        System.out.println("Stack: " + things);
        things.pop();

        System.out.println();
        System.out.println("Stack after first item popped: " + things);
        things.pop();

        System.out.println();
        System.out.println("Stack after second item popped: " + things);




        scanner.close();
    }
}