//importing util for keyboard input
import java.util.*;
public class Tables {
  //class constant for keyboard
  public static final Scanner CONSOLE = new Scanner(System.in);
  //main method
  public static void main(String[] args) { 
    System.out.println("Project 1 written by Justin McCann\n");
    eXponent();
    remainDer();
  }
  //exponent method
  public static void eXponent() {
    //declaring variables
    int b;
    int x;
    //inputing variables from keyboard
    System.out.println("Enter the base:");
    b = CONSOLE.nextInt();
    System.out.println("Enter the exponent:");
    x = CONSOLE.nextInt();
    System.out.println("The base is " + b + " and the maximum exponent is " + x + ".\n");
    System.out.println("Powers of " + b);
    System.out.println("x\t" + b + "^x");
    //creating power table with for loop
    for (int a = 0;a<=x;a++){
      System.out.println(a + "\t" + (int)Math.pow(b, a));
    }
    System.out.println();
  }
  //remainder method
  public static void remainDer() {
    //declare variables
    int n;
    int d;
    //input variables from keyboard
    System.out.println("Enter the maximum numerator:");
    n = CONSOLE.nextInt();
    System.out.println("Enter the maximum demonater:");
    d = CONSOLE.nextInt();
    System.out.println("The maximum numerator is " + n + " and the maximum denominator is " + d + ".\n");
    System.out.println("Remainders\n");
    System.out.print("n\t");
    //top row 
    for (int c = 1;c<=d;c++){
      System.out.print("n%" + c + "\t");
    }
    System.out.println();
    // table or remainders
    for (int e = 1;e<=n;e++){
      System.out.print(e + "\t");
      for (int f = 1;f<=d;f++){
        System.out.print(e%f + "\t");
      }
      System.out.println();
    }
  }
  
}
