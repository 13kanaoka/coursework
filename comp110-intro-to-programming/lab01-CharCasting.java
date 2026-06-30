import java.util.Scanner;

public class CharCasting {
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a letter");
        String s = scanner.nextLine();
        char ch = s.charAt(0);

        if (Character.isLetter(ch))
        {
            ch = Character.toLowerCase(ch);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
                System.out.println(ch + " is a vowel");
            else
                System.out.println(ch + " is a consonant");
        }
        else
            System.out.println(ch + " is not a valid input");


        scanner.close();
    }
}
