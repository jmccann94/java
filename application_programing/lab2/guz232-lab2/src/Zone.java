import java.util.*;
/**
 * Zone is a Java class containing the name of a Zone, an array 
 * of dinosaur objects, and a critical safety rating
 * 
 * @author Justin McCann guz232
 *
 */

public class Zone {
	
	//class variables
	private String zoneName;
	private String zoneCode;
	private ArrayList<Dinosaur> aDinosaurs;
	private String criticalSafetyRating;
	
	//constructor
	public Zone (String zoneName, String csr, String zoneCode) {
		this.zoneName = zoneName;
		this.criticalSafetyRating = csr;
		this.zoneCode = zoneCode;
		this.aDinosaurs = new ArrayList<Dinosaur>();
	}
	
	//toString that list out all the dinos in the zone
	public String toString() {
		String ret =zoneCode + ": " + zoneName + " Zone (" + criticalSafetyRating + " risk):\n";
		for(int i = 0; i < this.aDinosaurs.size(); i++) {			//for loop to get all the dinos
			ret += this.aDinosaurs.get(i).toString() + "\n";		//in the array
		}
		ret += " \n";
		return ret;
	}

	//getters and setters
	public ArrayList<Dinosaur> getaDinosaurs() {
		return aDinosaurs;
	}
	
	public String getZoneName() {
		return this.zoneName;
	}
	
	public String getCriticalSafetyRating() {
		return criticalSafetyRating;
	}
	
	public String getZoneCode() {
		return zoneCode;
	}
	
	public void setaDinosaurs(ArrayList<Dinosaur> aDinosaurs) {
		this.aDinosaurs = aDinosaurs;
	}
	
	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}
	
	public void setCriticalSafetyRating(String criticalSafetyRating) {
		this.criticalSafetyRating = criticalSafetyRating;
	}
	
	public void setZoneCode(String zoneCode) {
		this.zoneCode = zoneCode;
	}

	/**
	 * adder for adding new dino to the zone
	 * Takes in a dinosaur and adds it to the arraylist
	 * 
	 * @param newDinosaur
	 */
	public void addDinosaur(Dinosaur newDinosaur) {
		this.aDinosaurs.add(newDinosaur);
	}
	
	/**
	 * Removes dinosaur from the array list
	 * take in a dinosaur, finds it within the arraylist
	 * then removes it
	 * 
	 * @param remDino
	 */
	public void removeDinosaur(Dinosaur remDino) {
		int i;
		for ( i = 0; i < this.aDinosaurs.size(); i++) {
			if (this.aDinosaurs.get(i).getDinoName().equals(remDino.getDinoName()) ) {
				this.aDinosaurs.remove(i);
			}
		}
	}

	
}
