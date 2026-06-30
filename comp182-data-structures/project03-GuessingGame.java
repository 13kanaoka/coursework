import TreePackage.*;
import java.util.Scanner;
public class GuessingGame {
  public static void main(String[] args){
     Scanner scanner = new Scanner(System.in);
     String response;

     DecisionTree<String> gameTree = new DecisionTree<>("Is it in North America?", "Brazil", "U.S.A.");
     do
     {
        System.out.println("Think of a country and I will guess it. ");
        gameTree = play(gameTree);
       
        System.out.print("Play again? ");
        response = getUserResponse();                  


     }
     while (response.toLowerCase().equals("yes"));
     System.out.println("Bye!");
  } 
 
  public static String getUserResponse(){
 
     Scanner userResponseInput = new Scanner(System.in);

     String userResponse = userResponseInput.nextLine();
     return userResponse;
    
  }
 
  public static boolean isUserResponseYes()
  {
     String answer = getUserResponse();
     if (answer.toLowerCase().equals("yes"))
        return true;
     else
        return false;
  }

  public static DecisionTree<String> play(DecisionTree<String> gameTree){
  
      gameTree.resetCurrentNode();
      while (!gameTree.isAnswer()) {
        System.out.println(gameTree.getCurrentData());  
        if (isUserResponseYes())
           gameTree.advanceToYes();

        else
           gameTree.advanceToNo();
     }
     assert gameTree.isAnswer();

     System.out.println("My guess is " + gameTree.getCurrentData() + ". Am I right?");
    
    if (isUserResponseYes())
     System.out.println("I win.");
    else
        learn(gameTree);
     return gameTree;
  }

  public static void learn(DecisionTree<String> gameTree){
     Scanner Scanner = new Scanner(System.in);

     System.out.println("I give up; what are you thinking of? ");

     String correctAnswer = getUserResponse();
     String currentAnswer = gameTree.getCurrentData();
          
     System.out.println("Give me a question whose answer is yes for " + correctAnswer + " but no for " + currentAnswer);
     String newQuestion = getUserResponse();

     gameTree.setCurrentData(newQuestion);
     gameTree.setResponses(currentAnswer, correctAnswer);
  }
}