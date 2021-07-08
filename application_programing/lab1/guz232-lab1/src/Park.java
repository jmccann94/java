/**
 * Park is a Java class containing the name of a park and an array
 * of zones to be stored within the park. 
 * 
 * @author Justin McCann guz232
 *
 */
public class Park {
	
	//Class varibles
	private String parkName;
	private Zone[] aZones;
	private int numZones;
	
	//Constructor 
	public Park (String parkName, int size) {
		this.parkName = parkName;
		this.aZones = new Zone[size];
		this.numZones = 0;
	}
	
	//toString method to print out the park and all its zones and dinos
	public String toString() {
		String ret ="Welcome to " + parkName + "!\n";
		ret += "-------------------------\n";
		for(int i = 0 ; i < numZones ; i++) {	//for loop to go through the array
			ret += aZones[i].toString();
		}
		
		return ret;
	}
	
	//getters and setters
	public String getParkName() {
		return this.parkName;
	}

	public void setParkName(String parkName) {
		this.parkName = parkName;
	}

	public Zone[] getaZones() {
		return this.aZones;
	}

	public void setaZones(Zone[] aZones) {
		this.aZones = aZones;
	}

	//method to add zones to the park
	public void addZone(Zone newZone) {
		this.aZones[this.numZones] = newZone;
		this.numZones += 1;
		
	}

}
