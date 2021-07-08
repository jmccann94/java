import java.awt.*;
import java.util.*;
public class Randomwalk { 
  public static void main(String[] args) { 
    //main method prints name and calls method to start walk
    System.out.println("Lab 7 written by Justin McCann\n");
    walk();    
  }
  public static int[] userinput(){
    //creating scanner object and asking for color and radius
    Scanner console = new Scanner(System.in);
    System.out.print("Enter the color of the circle(red or blue): ");
    String colorinput = console.nextLine( );
    System.out.print("Enter radius of the circle(between 50 and 400): ");
    int circleradius = console.nextInt( );
    //test to make sure the radius is between 50 and 400
    while ((circleradius < 50)||(circleradius > 400)){
      System.out.println("Try again(between 50 and 400): ");
      circleradius = console.nextInt( );
    }
    //creates variables to set for the color test
    int circlecolor = 2;
    boolean red = false;
    boolean blue = false;
    boolean check = true;
    //calls to method to test the color inputs
    red = matchesChoice(colorinput, "red");
    blue = matchesChoice(colorinput, "blue");
    //checks if color was true
    if (red){
      check = false;
    } if (blue){
      check = false;
    }
    //if color wasnt correct then enters while loop
    while (check){
      //lets user keep trying until input is correct
      System.out.println("Please enter a color(blue or red): ");
      colorinput = console.nextLine( );
      red = matchesChoice(colorinput, "red");
      blue = matchesChoice(colorinput, "blue");
      if (red){
        check = false;
      } if (blue){
        check = false;
      }
    }
    //sets circle color 
    if (red){
      circlecolor = 0;
    } 
    if (blue){
      circlecolor = 1;
    }
    //math to create circle and panelsize
    int cdiameter = circleradius*2;
    int panelsize = circleradius*3;
    int cxy = (panelsize/2) - circleradius;
    //creates array to return for the circles info
    int[] circleinfo = new int[4];
    circleinfo[0] = cdiameter;
    circleinfo[1] = circlecolor;
    circleinfo[2] = panelsize;
    circleinfo[3] = cxy;
    //closing scanner
    console.close();
    return circleinfo;
  }
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
      return test;
    } if (test2){
      return test2;
    }
    return false;
  }
  
  public static void walk(){
    //create an array to make returning multiple values easy
    int[] input = new int[4];
    //call to the user input method to create array for the circles information
    input = userinput();
    //creates drawing panel and circle based on array
    DrawingPanel panel = new DrawingPanel(input[2], input[2]);
    Graphics g = panel.getGraphics();
    if (input[1] == 0){
      g.setColor(Color.RED);
    }else if(input[1] == 1){
      g.setColor(Color.BLUE);
    }
    g.drawOval(input[3], input[3], input[0], input[0]);
    //creating random object and declaring start of walking line 
    Random rand = new Random( );
    int xycircle = ((input[2])/2);
    int xr = ((input[2])/2);
    int yr = ((input[2])/2);
    int rr = ((input[0])/2);
    g.setColor(Color.BLACK);
    g.drawLine(xr, yr, xr, yr);
    int direction = 0;
    boolean out = true; 
    //enters while loop until line exits circle
    while (out){
      {g.setColor(Color.BLACK);
        g.drawLine(xr, yr, xr, yr);
        direction = rand.nextInt(4);
        if (direction == 0){
          xr = xr + 1;
        } else if (direction == 1){
          yr = yr + 1;
        } else if (direction == 2){
          xr = xr - 1;
        } else if (direction == 3){
          yr = yr - 1;
        }}
      //creates variables to test while the line is in the circle
      int a = (((xycircle-xr)*(xycircle-xr))+((xycircle-yr)*(xycircle-yr)));
      int c = (int)(Math.sqrt((double)a));
      if (c <= rr){
        out = true;
      }else {
        out = false;
      }
    }
  }
}
