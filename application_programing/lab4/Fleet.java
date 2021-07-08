package application.model;
import java.io.File;
import java.io.IOException;
import java.util.*;
/*
 * Fleet is a class containing the name and a 
 * list of ships in the fleet
 * 
 * @author Justin McCann guz232
 */
public class Fleet {
	
	//class variables
	private String fleetName;
	private ArrayList<Starship> fStarships;
	
	//Constructor
	public Fleet(String fleetName) {
		this.fleetName = fleetName;
		this.fStarships = new ArrayList<Starship>();
	}

	//toString
	public String toString() {
		String ret = "";
		for( int i = 0; i<this.getfStarships().size(); i++ ) {
			ret += this.fStarships.get(i).toString();
		}
		return ret;
	}
	
	//Getters, Setters and Adders
	public String getFleetName() {
		return fleetName;
	}

	public void setFleetName(String fleetName) {
		this.fleetName = fleetName;
	}

	public ArrayList<Starship> getfStarships() {
		return fStarships;
	}

	public void setfStarships(ArrayList<Starship> fStarships) {
		this.fStarships = fStarships;
	}
	
	public void addStarship(Starship newShip) {
		this.fStarships.add(newShip);
	}
	
	/*
	 * Generates a fleet based on the data, throws 
	 * exception if file is not found 
	 * 
	 * @throws IOException
	 */
	public Fleet fleetGenerator()throws IOException {
		//create fleet to return
		Fleet ret = new Fleet("Federation of Planets");
		//initialize starships then crew
		ret.loadStarShips("data/fleet.csv");
		ret.loadCrewMembers("data/personnel.csv");
		return ret;
	}
	
	/*
	 * Adds all Starships containing the name we passed in
	 * then adds them to an arraylist and returns it
	 * 
	 * @params String 
	 */
	public ArrayList<Starship> getStarshipsByName( String search ){
		//create arraylist to return
		ArrayList<Starship> ret = new ArrayList<Starship>();
		//loop through to see which ships contain what we are looking for
		for (int i = 0; i < this.fStarships.size(); i++) {
			if (this.fStarships.get(i).getShipName().contains(search) ) {
				ret.add(this.fStarships.get(i));
			}
		}
		return ret;
	}
	
	/*
	 * Loads starships from a file that is passed in as a string
	 * 
	 * @params String
	 * @throws IOException
	 */
	public void loadStarShips(String fileName) throws IOException {
		//initialize scanner
		Scanner scan = new Scanner (  new File(fileName)  );
		//scan file, delimiting at commas and creating starships then adding them to fleet
		while( scan.hasNextLine() ) {
			String line = scan.nextLine();
			String[] tokens = line.split(",");
			Starship tmp = null;
			tmp = new Starship(tokens[0], tokens[1], tokens[2]);
			this.addStarship(tmp);
		}
		//close scanner
		scan.close();
	}
	
	/*
	 * Loads Crew Members from file that is passed in as a string
	 * 
	 * @params String
	 * @throws IOException
	 */
	public void loadCrewMembers( String fileName ) throws IOException {
		//initialize scanner
		Scanner scan = new Scanner (  new File(fileName)  );
		//scan file, delimiting by commas and creating crewmembers and adding them to their ships
		while( scan.hasNextLine() ) {
			String line = scan.nextLine();
			String[] tokens = line.split(",");
			CrewMember tmp = null;
			tmp = new CrewMember(tokens[0], tokens[1], tokens[2], tokens[4]);
			for(int i = 0; i < this.fStarships.size(); i++ ) {
				if( this.fStarships.get(i).getsRegistry().equals(tokens[3]) ) {
					this.fStarships.get(i).addCrewMember(tmp);
				}
			}
		}
		//close scanner
		scan.close();
	}
}
