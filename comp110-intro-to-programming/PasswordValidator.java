import java.util.Scanner;
public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Matthew Rohde");
        System.out.print("Enter a password: ");
        String pw = scanner.nextLine();
        if (validate(pw))
            System.out.println(pw + " is valid");
    }
    public static boolean validate(String pw)
    {
        boolean LD = true;
        int numD = 0;
        for (int i = 0; i < pw.length(); i++)
            if (!Character.isLetterOrDigit(pw.charAt(i))) 
            {
                System.out.println("Non-letter-digit! No good");
                return false;
            }
        for (int i = 0; i < pw.length(); i++)
            if (Character.isDigit(pw.charAt(i)))
                if (++numD >= 2) break;
        if (numD < 2)
        {
            System.out.println("Must have two more digits");
            return false;
        }

        if (pw.length() < 8)
        {
            System.out.println("Password must be 8 or more characters");
            return false;
        }
        return true;
    }
}
