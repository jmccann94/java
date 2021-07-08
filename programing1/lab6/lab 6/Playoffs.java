import java.util.*;

public class Playoffs {
  
  
  public static void main(String[] args) { 
    System.out.println("Lab 6 written by Justin McCann");
    System.out.println("Enter the percent chance that team one will win:");
    int percent = 51;
    while ((percent <= 100)&&(percent >= 0)){
      int ran = Math.random(100);
    }
    game();
  }
  public static void game(){
    int per = 51;
    int ran = (1 + Math.random(100));
    if (ran < per){
      System.out.println("Team 1 wins!");
    }else {
      System.out.println("Team 2 wins!");
    }
  }
  
  
}
