import java.util.*;

public class StarWarsName {
  //class constant for input
  public static final Scanner console = new Scanner(System.in);
  
  public static void main(String[] args) { 
    System.out.println("Star Wars Name Generator\n\nEnter your first name:");
    //using keyboard to input names, car, mother, and city
    String firstname = console.nextLine( );
    System.out.println("Enter your last name:");
    String lastname = console.nextLine( );
    System.out.println("Enter your mother's maiden name:");
    String mothersmaid = console.nextLine( );
    System.out.println("Enter the city where you were born:");
    String city = console.nextLine( );
    System.out.println("Enter the first car you drove:");
    String car = console.nextLine( );
    //contructing the star wars first name
    String f = firstname.trim();
    String l = lastname.trim();
    String fi = f.substring(0, 3);
    String la = l.substring(0, 2);
    String fila = fi + la;
    //constructing the star wars last name
    String mot = mothersmaid.trim();
    String cit = city.trim();
    String mo = mot.substring(0, 2);
    String ci = cit.substring(0, 3);
    String moci = mo + ci;
    //constructing the planet
    int x = l.length( );
    String la2 = l.substring(x-2);
    String plan= la2 + car;
    System.out.println("You are " + fila.toUpperCase( ) + " " + moci.toUpperCase( ) + " of " + plan.toUpperCase( ));
    
  }
  
}
