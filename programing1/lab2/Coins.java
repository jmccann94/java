//import java util for scanner
import java.util.*;

public class Coins {
  //declare scanner
  public static final Scanner CONSOLE = new Scanner(System.in);
  
  
  
  public static void main(String[] args) { 
    //print my name and call two methods 
    System.out.println("Lab 2 written by Justin McCann");
    coin();
    cent();
  }
  
  //coin method
  public static void coin() {
    //declaring variables from input to scanner
    System.out.print("Enter the number of Quarters: ");
    int quarter = CONSOLE.nextInt();
    System.out.print("Enter the number of Dimes:    ");
    int dime = CONSOLE.nextInt();
    System.out.print("Enter the number of Nickels:  ");
    int nickel = CONSOLE.nextInt();
    System.out.print("Enter the number of Pennies:  ");
    int pennie = CONSOLE.nextInt();
    //declare totals for all variables
    double tq = quarter * .25;
    double td = dime * .10;
    double tn = nickel * .05;
    double tp = pennie * .01;
    System.out.println("Total =$" + (tq + td + tn + tp));
  }
  
  //cent method
  public static void cent(){
    //declaring total from scanner input
    System.out.print("Enter total amount of change:");
    int cents = CONSOLE.nextInt();
    //declaring totals after each coin
    int aq = cents % 25;
    int ad = aq % 10;
    int an = ad % 5;
    //printing out total coins
    System.out.println("Quarters:" + cents / 25);
    System.out.println("Dimes   :" + aq / 10);
    System.out.println("Nickels :" + ad / 5);
    System.out.println("Pennies :" + an);
      
  }
      
    
      

}
