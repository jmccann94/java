
public class Testtest {
  
  
  public static void main(String[] args) { 
    int a = 1000;
    int b = 1000;
    int r = 10;
    System.out.println(windOw2(a,b,r));
    
  }
  
  public static int windOw2(int x, int y, int r){
    int z = 0;
    if ( x - r < 0){
      if ( y - r < 0){ 
        z = -1;
          }}
    if ( x + r > 300){
      if ( y + r > 400){
        z = -1;
      }}
     else if ( x - r < 0){
      z = 1;
    } else if ( x + r > 300){
      z = 1;
    } else if ( y - r < 0){ 
      z = 1;
    } else if ( y + r > 400){
      z = 1;
    } else {
      z = 0;
    }
    return z;
  }
}
  

