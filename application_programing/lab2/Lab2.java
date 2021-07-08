import java.io.IOException;

/**
 * Lab1 is a Java class containing a main method to run your program when completed.
 * This class will not compile until you have completed the requirements outlined in 
 * the lab description.
 * 
 * @author Amanda Fernandez (abc123)
 * UTSA CS 3443 - Lab 2
 * Spring 2019
 */
public class Lab2 {

	public static void main( String[] args ) {
		Park jurassicPark = new Park( "Jurassic Park" );
		
		try {
			// Load data for the park, and print its status
			jurassicPark.loadZones( "data/zones.csv" );
			jurassicPark.loadDinosaurs( "data/dinos.csv" );
			
			System.out.println( jurassicPark );
			
			// Relocate Blue to the T-Rex zone, and print park status
			jurassicPark.relocate( "Blue", "TY" );
			jurassicPark.save();
			
			System.out.println( jurassicPark );
			
		}catch( IOException e ) {
			System.out.println( "Error loading the file - please check its location." );
			e.printStackTrace();
		}
	}
}
