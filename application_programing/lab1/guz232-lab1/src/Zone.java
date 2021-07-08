/**
 * Zone is a Java class containing the name of a Zone, and an array 
 * of dinosaur objects.
 * 
 * @author Justin McCann guz232
 *
 */

public class Zone {
	
	//class variables
	private String zoneName;
	private Dinosaur[] aDinosaurs;
	private int numDinosaurs;
	
	//constructor
	public Zone (String zoneName, int size) {
		this.zoneName = zoneName;
		this.aDinosaurs = new Dinosaur[size];
		this.numDinosaurs = 0;
	}
	
	//toString that list out all the dinos in the zone
	public String toString() {
		String ret = zoneName + " Zone:\n";
		for(int i = 0; i < numDinosaurs; i++) {			//for loop to get all the dinos
			ret += aDinosaurs[i].toString() + "\n";		//in the array
		}
		ret += " \n";
		return ret;
	}

	//getters and setters
	public Dinosaur[] getaDinosaurs() {
		return aDinosaurs;
	}

	public void setaDinosaurs(Dinosaur[] aDinosaurs) {
		this.aDinosaurs = aDinosaurs;
	}
	
	public String getZoneName() {
		return this.zoneName;
	}

	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}

	//adder for adding new dino to the zone
	public void addDino(Dinosaur newDinosaur) {
		this.aDinosaurs[this.numDinosaurs] = newDinosaur;
		this.numDinosaurs += 1;
	}

}
