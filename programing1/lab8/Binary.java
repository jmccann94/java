import java.util.*;
public class Binary {
  
 
  public static void main(String[] args) { 
    System.out.println("Lab 8 written by Justin McCann");
    //initiating conolse
    Scanner CONSOLE = new Scanner(System.in);
    //loop for continuing
    boolean loop = true;
    while (loop){
      String prompt = "Enter a positive integer: \n";
      int x = getInt(CONSOLE, prompt);
      int [] binary = convertBinary(x);
      //print array
      printBinaryArray(binary);
      //continue
      System.out.println("\nDo you want to continue (yes or no)?");
      String c = CONSOLE.next();
      loop = matchesChoice(c, "no"); 
    }
    System.out.println("Thank you, Goodbye");
  }
  //prompts until a valid number is entered
  public static int getInt(Scanner console, String prompt) {
    System.out.print(prompt);
    while (!console.hasNextInt()) {
      console.next(); // to discard the input
      System.out.println("Not an integer; try again.");
      System.out.print(prompt);}return console.nextInt();
  }
  //method to convert
  public static int[] convertBinary(int x){
    int xcopy = x;
    int len = 0;
    while (xcopy>0){
      xcopy = xcopy/2;
      len++;
    }
    int[ ] bin = new int[len];
    int index =0;
    while (x>0){
      if((x & 1)==0){
        bin[index] = 0;
      } else {
        bin[index] = 1;
      }
      x = x/2;
      index++;
    }
    return bin;
  }
  public static void printBinaryArray(int[] binary){
    for (int i = binary.length - 1; i >=0; i--) {  
      System.out.print(binary[i]);
    }
  }
  //method to test for yes or no
  public static boolean matchesChoice(String choice, String answer){
    //creating test variables
    boolean test = false;
    boolean test2 = false;
    //setting input to all lowercase, also getting first letter of input
    String lower = choice.toLowerCase( );
    String firstchoice = lower.substring(0,1);
    String firstanswer = answer.substring(0,1);
    //test both options
    test = lower.equals(answer);
    test2 = firstanswer.equals(firstchoice);
    //returns ture if either test is true
    if (test){
      return false;
    } if (test2){
      return false;
    }
    return true;
  }
}
