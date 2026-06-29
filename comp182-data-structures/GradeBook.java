import java.util.Scanner;
import java.util.HashMap;

public class GradeBook {
       
   public static void main (String[] args) {
      Scanner scanner = new Scanner(System.in);
      String studentName;
      double studentGrade;
      
      HashMap<String, Double> studentGrades = new HashMap<String, Double>();
      
      // Students's grades (pre-entered)
      studentGrades.put("Harry Rawlins", 84.3);
      studentGrades.put("Stephanie Kong", 91.0);
      studentGrades.put("Shailen Tennyson", 78.6);
      studentGrades.put("Quincy Wraight", 65.4);
      studentGrades.put("Janine Antinori", 98.2);

      //printing names and grades
      for (String i : studentGrades.keySet()) {
        System.out.println(i + ", " + studentGrades.get(i));
      }

      //user input shenanigans
      System.out.println();
      System.out.print("Which student's grade would you like to change? ");
      studentName = scanner.nextLine();
      double oldStudentGrade = studentGrades.get(studentName); //need to grab old grade to print later
      System.out.print("What is their new grade? ");
      studentGrade = scanner.nextDouble();

      //replacing old grade with new
      studentGrades.replace(studentName, studentGrade);

      //printing the student's new information!
      System.out.println(studentName + "'s original grade: " + oldStudentGrade);
      System.out.println(studentName + "'s new grade: " + studentGrade);
      
      scanner.close();
   }
}