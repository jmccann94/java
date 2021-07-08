import java.awt.*;
import java.util.*;
public class Circles {
  //class constants for panel size
  public static final int PANEL_WIDTH = 400;
  public static final int PANEL_HIEGHT = 300;
  public static final Scanner CONSOLE = new Scanner(System.in);
  
  public static void main(String[] args) { 
    System.out.println("Lab 5 written by Justin McCann");
    //create panel
    DrawingPanel panel = new DrawingPanel(PANEL_WIDTH, PANEL_HIEGHT);
    //define radius
    System.out.println("Enter radius of red circle:");
    int RADIUS1 = CONSOLE.nextInt();
    System.out.println("Enter radius of green circle:");
    int RADIUS2 = CONSOLE.nextInt();
    System.out.println("Enter radius of blue circle:");
    int RADIUS3 = CONSOLE.nextInt();
    //convert radius to diameter for filloval
    int DIAM1 = RADIUS1*2;
    int DIAM2 = RADIUS2*2;
    int DIAM3 = RADIUS3*2;
    //centers of the circles
    System.out.println("Enter the x coordinate for the red circle:");
    int CENTER1X = CONSOLE.nextInt();
    System.out.println("Enter the y coordinate for the red circle:");
    int CENTER1Y = CONSOLE.nextInt();
    System.out.println("Enter the x coordinate for the green circle:");
    int CENTER2X = CONSOLE.nextInt();
    System.out.println("Enter the y coordinate for the green circle:");
    int CENTER2Y = CONSOLE.nextInt();
    System.out.println("Enter the x coordinate for the blue circle:");
    int CENTER3X = CONSOLE.nextInt();
    System.out.println("Enter the y coordinate for the blue circle:");
    int CENTER3Y = CONSOLE.nextInt();
    //define location 
    int x1 = CENTER1X - RADIUS1;
    int y1 = CENTER1Y - RADIUS1;
    int x2 = CENTER2X - RADIUS2;
    int y2 = CENTER2Y - RADIUS2;
    int x3 = CENTER3X - RADIUS3;
    int y3 = CENTER3Y - RADIUS3;
    //draw  ovals
    Graphics g = panel.getGraphics();
    g.setColor(Color.RED);
    g.fillOval(x1, y1, DIAM1, DIAM1);
    g.setColor(Color.GREEN);
    g.fillOval(x2, y2, DIAM2, DIAM2);
    g.setColor(Color.BLUE);
    g.fillOval(x3, y3, DIAM3, DIAM3);
    //comparing size of circles
    int x12 = checKsize(DIAM1,DIAM2);
    if (x12 == -1){
      System.out.println("The red circle is smaller than the green circle.");
    } else if (x12 == 1){
      System.out.println("The red circle is bigger than the green circle.");
    } else if (x12 == 0){
      System.out.println("The red circle and the green circle are the same size.");
    } else {
      System.out.println("ERROR!");
    }  
    int x23 = checKsize(DIAM2,DIAM3);
    if (x23 == -1){
      System.out.println("The green circle is smaller than the blue circle.");
    } else if (x23 == 1){
      System.out.println("The green circle is bigger than the blue circle.");
    } else if (x23 == 0){
      System.out.println("The green circle and the blue circle are the same size.");
    } else {
      System.out.println("ERROR!");
    }  
    int x13 = checKsize(DIAM1,DIAM3);
    if (x13 == -1){
      System.out.println("The blue circle is smaller than the red circle.");
    } else if (x13 == 1){
      System.out.println("The blue circle is bigger than the red circle.");
    } else if (x13 == 0){
      System.out.println("The blue circle and the red circle are the same size.");
    } else {
      System.out.println("ERROR!");
    }
    //checking for overlapping
    int y12 = overLap(CENTER1X, CENTER1Y, RADIUS1, CENTER2X, CENTER2Y, RADIUS2);
    if (y12 == 1){
      System.out.println("The red and green circles intercect.");
    } else if (y12 == 0){
      System.out.println("The red and green circles do not intersect.");
    } else {
      System.out.println("Error!");
    }
    int y13 = overLap(CENTER1X, CENTER1Y, RADIUS1, CENTER3X, CENTER3Y, RADIUS3);
    if (y13 == 1){
      System.out.println("The red and blue circles intercect.");
    } else if (y13 == 0){
      System.out.println("The red and blue circles do not intersect.");
    } else {
      System.out.println("Error!");
    }
    int y23 = overLap(CENTER2X, CENTER2Y, RADIUS2, CENTER3X, CENTER3Y, RADIUS3);
    if (y23 == 1){
      System.out.println("The green and blue circles intercect.");
    } else if (y23 == 0){
      System.out.println("The green and blue circles do not intersect.");
    } else {
      System.out.println("Error!");
    }
    //test if the circle fits in the window
    int z1 = windOw(CENTER1X, CENTER1Y, RADIUS1);
    if (z1 == 1){
      System.out.println("The red circle is partially outside of the window.");
    } else if (z1 == 0){
      System.out.println("The red circle is within the window.");
    } else if (z1 == -1){
      System.out.println("The red circle is completley outside of the window!");
    }
    int z2 = windOw(CENTER2X, CENTER2Y, RADIUS2);
    if (z2 == 1){
      System.out.println("The green circle is partially outside of the window.");
    } else if (z2 == 0){
      System.out.println("The green circle is within the window.");
    } else if (z2 == -1){
      System.out.println("The green circle is completley outside of the window!");
    }
    int z3 = windOw(CENTER3X, CENTER3Y, RADIUS3);
    if (z3 == 1){
      System.out.println("The blue circle is partially outside of the window.");
    } else if (z3 == 0){
      System.out.println("The blue circle is within the window.");
    } else if (z3 == -1){
      System.out.println("The blue circle is completley outside of the window!");
    }
  }

  //method to compare the sizes
  public static int checKsize(int D1,int D2){
    int x = 0;
    if (D1 < D2){
      x = -1;
    } else if (D2 < D1){
      x = 1;
    } else if (D1 == D2){
      x = 0;
    }
    return x;
  }

  //method to test for  overlapping
  public static int overLap(int x1, int y1, int r1, int x2, int y2, int r2){
    int x = 0;
    int a = (((x1-x2)*(x1-x2))+((y1-y2)*(y1-y2)));
    int c = (int)(Math.sqrt((double)a));
    int b = (r1+r2);
    if (c <= b){ 
      x = 1;
    } else if (c > b){
      x = 0;
    }
    return x;
  }
  //method to test if the circle is completley within the window
  public static int windOw(int x, int y, int r){
    int z = 0;
    if ( x - r < 0){
      if ( y - r < 0){ 
        z = -1;
      }}
    if ( x + r > PANEL_WIDTH){
      if ( y + r > PANEL_HIEGHT){
        z = -1;
      }}
    if ( x + r > PANEL_WIDTH){
      if ( y - r < 0){
        z = -1;
      }}
    if ( x - r < 0){
      if ( y + r > PANEL_HIEGHT){
        z = -1;
      }}
    else if ( x - r < 0){
      z = 1;
    } else if ( x + r > PANEL_WIDTH){
      z = 1;
    } else if ( y - r < 0){ 
      z = 1;
    } else if ( y + r > PANEL_HIEGHT){
      z = 1;
    } else {
      z = 0;
    }
    return z;
  }
}
  
  
  

 
