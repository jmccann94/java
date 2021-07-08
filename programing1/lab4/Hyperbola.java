import java.awt.*;

public class Hyperbola {

  // The width and height of the DrawingPanel.
  public static final int PANEL_SIZE = 512;
  public static final int LEFT_GRID = 32;
  public static final int RIGHT_GRID = 8;

  // Right now this draws an X, but should draw two hyperbolas.
  public static void main(String[] args) {
    DrawingPanel panel = new DrawingPanel(PANEL_SIZE, PANEL_SIZE);
    Graphics g = panel.getGraphics();
    for (int i = 0;i<=512;i+=LEFT_GRID){
      g.drawLine(0, 0 + i, 0 + i, PANEL_SIZE);  
    }
    for (int j = 0;j<=512;j+=RIGHT_GRID){
      g.drawLine(0 + j, 0, PANEL_SIZE, 0 + j);
    }
  }
}