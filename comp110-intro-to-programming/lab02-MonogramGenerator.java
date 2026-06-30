import java.util.Scanner;
public class MonogramGenerator {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is your name?");
        String s = scanner.nextLine();
        char ch1 = s.charAt(0);
        int length = s.length() - 1;
        char ch2 = s.charAt(length);
        ch1 = Character.toUpperCase(ch1);
        ch2 = Character.toUpperCase(ch2);
        System.out.println("First letter is " + ch1);
        System.out.println("Last letter is " + ch2);

        scanner.close();
    }
}
