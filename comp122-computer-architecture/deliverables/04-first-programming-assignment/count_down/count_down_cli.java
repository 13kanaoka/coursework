import java.util.Scanner;

class count_down_cli {

  static Scanner stdin = new Scanner(System.in);

  public static int count_down(int top) {

    for (int c=top ; c>0; c--) {
      System.out.printf("%d\n", c);
    }
    System.out.printf("!\n");
    return top; 
  }


  public static void main(String[] args) {
    int input;
    int ret_val;


    input = Integer.parseInt(args[0]);
    ret_val = count_down(input);
    System.exit(input);
    return;
  }
}
