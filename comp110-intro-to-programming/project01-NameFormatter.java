import java.util.Scanner;
public class NameFormatter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("For grading: Matthew Rohde");

        //grabbing and selecting name
        System.out.print("Enter your full name using last, first middle: ");
        String fullName = scanner.nextLine();
        int indexOfComma = fullName.indexOf(',');
        String lastName = fullName.substring(0, indexOfComma);

        //Converting cases
        lastName = lastName.toLowerCase();
        char lastNameFirstLetter = lastName.charAt(0);
        lastNameFirstLetter = Character.toUpperCase(lastNameFirstLetter);
        lastName = lastNameFirstLetter + lastName.substring(1);

        //Deciding if there's a middle name
        if (fullName.indexOf(' ') == fullName.lastIndexOf(' ')) {
            //No middle name, grabbing first name
            int length = fullName.length();
            int indexOfFirstSpace = fullName.indexOf(' ');
            String firstName = fullName.substring(indexOfFirstSpace, length);
            firstName = firstName.toLowerCase();
            char firstNameFirstLetter = firstName.charAt(1);
            firstNameFirstLetter = Character.toUpperCase(firstNameFirstLetter);
            firstName = firstNameFirstLetter + firstName.substring(2);
            System.out.println("Name is: " + firstName + " " + lastName);

        }
        else {
            //Middle name exists, grabbing first name
            int indexOfFirstSpace = fullName.indexOf(' ');
            int indexOfLastSpace = fullName.lastIndexOf(' ');
            String firstName = fullName.substring(indexOfFirstSpace, indexOfLastSpace);
            firstName = firstName.toLowerCase();
            char firstNameFirstLetter = firstName.charAt(1);
            firstNameFirstLetter = Character.toUpperCase(firstNameFirstLetter);
            firstName = firstNameFirstLetter + firstName.substring(2);

            //grabbing middle name
            int length2 = fullName.length();
            String middleName = fullName.substring(indexOfLastSpace, length2);
            middleName = middleName.toLowerCase();
            char middleNameFirstLetter = middleName.charAt(1);
            middleNameFirstLetter = Character.toUpperCase(middleNameFirstLetter);
            middleName = middleNameFirstLetter + middleName.substring(2);

            System.out.println("Name is: " + firstName + " " + middleName + " " + lastName);
        }
        scanner.close();
    }
}
