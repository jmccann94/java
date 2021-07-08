//importing util for scanner and math, and text for cents formating
import java.util.*;
import java.text.*;
public class FutureValues {
  public static final Scanner CONSOLE = new Scanner(System.in);
  public static void main(String[] args) { 
    System.out.println("Lab 3 written by Justin McCann\n"+
                       "\tCompound Interest\n"+
                       "Enter Present Value:");
    //declaring variables for compound interest using the scanner
    double p;
    double i;
    double y;
    p = CONSOLE.nextDouble();    
    System.out.println("Enter Interest Rate:");
    i = CONSOLE.nextDouble();
    System.out.println("Enter Years:");
    y = CONSOLE.nextDouble();
    //printing compound interest 
    System.out.println("Future Value: " + compouNd(p, i, y) + 
                       "\n\n\tAnnuity\n" +
                       "Enter Present Value:" ); 
    //declaring variables for annuity using the keyboard
    double pp;
    double ii;
    double yy;
    pp = CONSOLE.nextDouble();    
    System.out.println("Enter Interest Rate:");
    ii = CONSOLE.nextDouble();
    System.out.println("Enter Years:");
    yy = CONSOLE.nextDouble();
    //printing the annuity values
    System.out.println("Future Value: " + annuiTy(pp, ii, yy));
  }
  //method for the compound interest calculation
  public static String compouNd(double p,double i,double y){
    double vc;
    vc = p*(Math.pow((1 + (i/100)), y));  
    //conerting result to dollars and cents
    DecimalFormat dollarsAndCents = new DecimalFormat("$#0.00");
    return dollarsAndCents.format(vc);
  }
  //method for the annuity calculations
  public static String annuiTy(double pp,double ii,double yy){
    double va;
    va = pp*(((Math.pow((1 + (ii/100)), yy)) - 1)/(ii/100));
    //converting result to dollars and cents
    DecimalFormat dollarsAndCents = new DecimalFormat("$#0.00");
    return dollarsAndCents.format(va);
  }
}
