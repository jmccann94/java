import java.awt.*;
import java.util.*;

public class ColorDisplay {
  //both boolean values are for testing methods with a predetermined color scheme
  //essentially skipping the keyboard input
  public static boolean debug = false;
  public static boolean keyb = true;
  public static final Scanner CONSOLE = new Scanner(System.in);
  
  public static void main(String[] args) {
    System.out.println("This project written by Justin McCann\n");
    Color c1 = readColor();
    if (debug){
      c1 = new Color(255, 0, 0);
    }
    String s1 = colorToString(c1);
    System.out.println("The first color is " + s1 + "\n");
    Color c2 = readColor();
    if (debug){
      c2 = new Color(0, 255, 0);
    }
    String s2 = colorToString(c2);
    System.out.println("The second color is " + s2 + "\n");
    Color c3 = readColor();
    if (debug){
      c3 = new Color(0, 0, 255);
    }
    String s3 = colorToString(c3);
    System.out.println("The third color is " + s3 + "\n");
    Color c4 = readColor();
    if (debug){
      c4 = new Color(0, 0, 0);
    }
    String s4 = colorToString(c4);
    System.out.println("The fourth color is " + s4 + "\n");
    DrawingPanel panel = new DrawingPanel(550,550);
    Graphics g = panel.getGraphics();
    displayColors(g, c1, c2, c3, c4);
  }
  // This method reads three color components (ints between 0 and 255)
  // from the user and returns a color.
  public static Color readColor(){
    if (keyb){
    System.out.print("Enter a color (three values between 0 and 255):");
    int r = CONSOLE.nextInt();
    int g = CONSOLE.nextInt();
    int b = CONSOLE.nextInt();
    int x = 0;
    if ((r < 0)||(r > 255)){
      System.out.println("The red value " + r + " is out of range");
      x++;
    } if ((g < 0)||(g > 255)){
      System.out.println("The green value " + g + " is out of range");
      x++;
    } if ((b < 0)||(b > 255)){
      System.out.println("The blue value " + b + " is out of range");
      x++;
    } if (x > 0){
      System.out.print("Try again to enter a color (three values between 0 and 255)");
      r = CONSOLE.nextInt();
      g = CONSOLE.nextInt();
      b = CONSOLE.nextInt();
      x = 0;
    } if ((r < 0)||(r > 255)){
      x++;
    } if ((g < 0)||(g > 255)){
      x++;
    } if ((b < 0)||(b > 255)){
      x++;
    } if (x > 0){
      System.out.println("One of more values were out of range again, exiting program");
      System.exit(1);
    }
    Color c = new Color(r, g, b);
    return c;
    } else { 
      Color c = new Color(0, 0, 0);
      return c;
    }
  }
  //This method coverts the color into a string
  public static String colorToString(Color c){
    //using the code provided code then trimming off java.awt.Color
    String s = " " + c;
    s = s.substring(15);
    return s;
  }
  // This method displays the four colors and combinations of these colors
  // in the window.
  public static void displayColors (Graphics g, Color c1, Color c2, Color c3, Color c4){
    //nested for loop to create 11x11 grid
    for (int x = 0;x <=10;x++){
      int xx = x*50;
      for (int y = 0;y <=10;y++){
        int yy = y * 50;
        //finding new color by finding wweighted average
        //creating weights 
        int w1 = (10 - x) * (10 - y);  // home is (0,0)
        int w2 = (10 - x) * y;         // home is (0,10)
        int w3 = x * (10 - y);         // home is (10,0)
        int w4 = x * y;                // home is (10,10)
        //putting the 4 reds as int
        int i1 = c1.getRed();
        int i2 = c2.getRed();
        int i3 = c3.getRed();
        int i4 = c4.getRed();
        //finding nemerator for weighted average
        int rnwa = (w1 * i1 + w2 * i2 + w3 * i3 + w4 * i4);
        //denominator for weighted average
        int dwa = w1 + w2 + w3 + w4;
        //finging weighted average
        int r =rnwa/dwa ;
        //repeating weighted average for the other 2 colors
        int j1 = c1.getGreen();
        int j2 = c2.getGreen();
        int j3 = c3.getGreen();
        int j4 = c4.getGreen();
        int gnwa = (w1 * j1 + w2 * j2 + w3 * j3 + w4 * j4);
        int gr =gnwa/dwa ;
        int k1 = c1.getBlue();
        int k2 = c2.getBlue();
        int k3 = c3.getBlue();
        int k4 = c4.getBlue();
        int bnwa = (w1 * k1 + w2 * k2 + w3 * k3 + w4 * k4);
        int b =bnwa/dwa ;
        //creating square with new color
        g.setColor(new Color(r, gr, b));
        g.fillRect(xx, yy, 50, 50);
      }
    }
  }
        
        
}
  
  

    