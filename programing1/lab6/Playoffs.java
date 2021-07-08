import java.util.*;

public class Playoffs {
  //for debuging the while loops
  public static boolean debug = false;
  //declaring a class object for random
  public static Random rand = new Random( );
  //class object for scanner
  public static final Scanner CONSOLE = new Scanner(System.in);
  
  public static void main(String[] args) { 
    System.out.println("Lab 6 written by Justin McCann");
    //input percent for team 1
    System.out.println("Enter the percent chance that team one will win:");
    int percent = CONSOLE.nextInt();
    //int percent = 50;
    //test if percent is from 0 to 100 if not it prompts user again
    while ((percent > 100)||(percent < 0)){
      System.out.println("Enter a percent from 0 to 100");
      percent = CONSOLE.nextInt();
    }
    //runs third method and takes the percent parameter
    playoffs(percent);
  }
    //first method for each individual game
  public static int game(int per){
    //creates random number to see if team 1 won
    int ran = (1 + rand.nextInt(100));
    if (ran < per){
      //returns 1 if team 1 wins 
      return 1;
    }else {
      //returns 2 if team 2 wins
      return 2;
    }
  }
  //second method for set of 4 game playoffs
  public static int playoff(int per){
    int team1 = 0;
    int team2 = 0;
    //while loop for running games and adding on to there total victories until 4 is reached
    while ((team1 < 4)&&(team2 < 4)){
      int w = (game(per));
      if (w == 1){
        team1++;
      } else {
        team2++;
      }
    }
    //returns 1 if team 1 won 4 games and 2 if team 2 won 4 games
    if (team1 == 4){
      return 1;
    }else{
      return 2;
    }
  }
  //third method for 10 rounds of playoffs
  public static int playoffs(int per){
    int team1 = 0;
    int team2 = 0;
    //loop to run playoff until a team wins 10 times
    while ((team1 < 10)&&(team2 < 10)){
      int x = (playoff(per));
      if (x == 1){
        team1++;
      }else{
        team2++;
      }
      if(debug){
        System.out.println("t1:"+team1);
      }
      if(debug){
        System.out.println("t2:"+team2);
      }
      //prints the winner after every playoff
      System.out.println("Team "+x+" won!");
    }
    //prints final winner
    if (team1 == 10){
      System.out.println("Team 1 won the playoffs!!");
    }else{
      System.out.println("Team 2 won the playoffs!!");
    }
    return 0;
  }
      
      
  
  
}
