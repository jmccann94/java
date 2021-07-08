import java.io.File;
import java.io.IOException;
import java.util.*;
import java.io.FileWriter;
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
	private ArrayList<Zone> aZones;
	
	//Constructor 
	public Park (String parkName) {
		this.parkName = parkName;
		this.aZones = new ArrayList<Zone>();
	}
	
	//toString method to print out the park and all its zones and dinos
	public String toString() {
		String ret ="Welcome to " + parkName + "!\n";
		ret += "-------------------------\n";
		for(int i = 0 ; i < this.aZones.size() ; i++) {	//for loop to go through the array
			ret += this.aZones.get(i).toString();
		}
		
		return ret;
	}
	
	//getters and setters
	public String getParkName() {
		return this.parkName;
	}
	
	public ArrayList<Zone> getaZones() {
		return this.aZones;
	}
	
	public void setParkName(String parkName) {
		this.parkName = parkName;
	}

	public void setaZones(ArrayList<Zone> aZones) {
		this.aZones = aZones;
	}

	/**
	 * Adds new zones to the park
	 * takes in a Zone and adds it to the arraylist
	 * 
	 * @param newZone
	 */
	public void addZone(Zone newZone) {
		this.aZones.add(newZone);
	}
	
	/**
	 * Reads from zone file and adds them to the park
	 * takes in the file name, and reads from it
	 * 
	 * throws exception if file is not found
	 * @param fileName
	 * @throws IOException
	 */
	public void loadZones(String fileName) throws IOException {
		//open the file for reading
		Scanner scan = new Scanner ( new File(fileName) );
		
		//read in, line by line, creating zones
		while ( scan.hasNextLine() ) {
			String line = scan.nextLine();
			String[] tokens = line.split(",");
			Zone tmp = null;
			
			tmp = new Zone(tokens[0], tokens[1], tokens[2]);
			
			this.addZone(tmp);
			
		}
		//close file
		scan.close();
	
	}
	
	
	/**
	 * Reads from dino file and adds them to zones
	 * takes in file name 
	 * 
	 * throws exception if file is not found
	 * @param fileName
	 * @throws IOException
	 */
	public void loadDinosaurs(String fileName) throws IOException {
		//open the file for reading
		Scanner scan = new Scanner ( new File(fileName) );
		
		//read in, line by line, creating dinosaurs, adding to zones
		while( scan.hasNextLine() ) {
			String line = scan.nextLine();
			String[] tokens = line.split(",");
			boolean veg;
			if (tokens[2] == "true") {
				veg = true;
			}else {
				veg = false;
			}
			 //tmp = null;
			
			Dinosaur tmp = new Dinosaur(tokens[1], tokens[0], veg, tokens[3]);
			
			for ( int i=0; i<this.aZones.size(); i++) {
				if(this.aZones.get(i).getZoneCode().equals(tokens[3])) {
					this.aZones.get(i).addDinosaur(tmp);
				}
			}
			
		}
		//close file
		scan.close();

	}
	
	/**
	 * Relocates dinosaur to a new zone
	 * 
	 * takes in a dinosaurs name and a new zonecode
	 * loops through zones to find dinosaur
	 * saves dinosaurs info, removes it from old zone 
	 * then adds it to new zone
	 * 
	 * @param dinoName
	 * @param newZoneCode
	 */
	public void relocate(String dinoName, String newZoneCode) {
		Dinosaur tmp = null;
		int dinoInt = 0;
		int newZoneInt = 0;
		int oldZoneInt = 0;
		
		for (int i=0; i < this.aZones.size(); i++) {
			if(this.aZones.get(i).getZoneCode().equals(newZoneCode) ) {
				newZoneInt = i;
			}
			for (int j=0;j < this.aZones.get(i).getaDinosaurs().size(); j++) {
				if (this.aZones.get(i).getaDinosaurs().get(j).getDinoName().equals(dinoName) ) {
					dinoInt = j;
					oldZoneInt = i;
				}
			}
		}
		tmp = this.aZones.get(oldZoneInt).getaDinosaurs().get(dinoInt);
		this.aZones.get(oldZoneInt).removeDinosaur(tmp);
		tmp.setZoneCode(newZoneCode);
		this.aZones.get(newZoneInt).addDinosaur(tmp);
	}
	
	/**
	 * Save zone and dino info to files
	 * overwrites old data files with any new info
	 * 
	 * throws exception if files are not found
	 * @throws IOException
	 */
	public void save() throws IOException {
		//open the file for writing
		FileWriter writer1 = new FileWriter( new File("data/zones.csv") );
		
		//write out line by line
		for( int i = 0; i < this.aZones.size(); i++) {
			Zone tmpZ = this.aZones.get(i);
			writer1.write(tmpZ.getZoneName() + "," + tmpZ.getCriticalSafetyRating() + "," + tmpZ.getZoneCode() + "\n");
		}
		
		//close the file
		writer1.close();
		
		//open the file for writing
		FileWriter writer2 = new FileWriter( new File("data/dinos.csv") );
		//write out line by line
		for( int j = 0; j < this.aZones.size(); j++) {	
			for ( int k = 0; k < this.aZones.get(j).getaDinosaurs().size() ; k++) {
				Dinosaur tmpD = this.aZones.get(j).getaDinosaurs().get(k);
				writer2.write(tmpD.getDinoName() + "," + tmpD.getDinoType() + "," + tmpD.getVegetarian() + "," + tmpD.getZoneCode() + "\n");
			}
		}
		
		//close the file
		writer2.close();
	}

}
