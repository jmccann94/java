/**
 * Lab1 is a Java class containing a main method to run your program when completed.
 * This class will not compile until you have completed the requirements outlined in 
 * the lab description.
 * 
 * @author Amanda Fernandez (abc123)
 * UTSA CS 3443 - Lab 1
 * Spring 2019
 */
public class Lab1 {

	public static void main( String[] args ) {
		Park jurassic = new Park( "Jurassic Park", 7 );
		
		Zone r = new Zone( "Raptor", 10 );
		Zone t = new Zone( "T-Rex", 2 );
		Zone b = new Zone( "Brachiosaurus", 20 );
		
		Dinosaur blue = new Dinosaur( "Velociraptor", "Blue", false );
		Dinosaur delta = new Dinosaur( "Velociraptor", "Delta", false );
		Dinosaur echo = new Dinosaur( "Velociraptor", "Echo", false );
		Dinosaur rex = new Dinosaur( "Tyrannosaurus", "Rex", false );
		Dinosaur littleFoot = new Dinosaur( "Apatosaurus", "Littlefoot", true );
		Dinosaur spike = new Dinosaur( "Stegosaurus", "Spike", true );
		Dinosaur bob = new Dinosaur( "Brachiosaurus", "Bob", true );
		
		r.addDino( blue );
		r.addDino( delta );
		r.addDino( echo );
		t.addDino( rex );
		b.addDino( littleFoot );
		b.addDino( spike );
		b.addDino( bob );
		
		jurassic.addZone( r );
		jurassic.addZone( t );
		jurassic.addZone( b );
		
		System.out.println( jurassic );
	}
}