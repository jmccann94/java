/**
 * Dinosaur is a Java class containing a dinosaurs name, type, and diet
 * 
 * @author Justin McCann guz232
 *
 */

public class Dinosaur {
	
	//class variables
	private String dinoName;
	private String dinoType;
	private boolean vegetarian;
	
	//contructor
	public Dinosaur(String type, String name, boolean veg) {
		this.dinoType = type;
		this.dinoName = name;
		this.vegetarian = veg;
	}
	
	//toString to list the dino type, name, and diet
	public String toString() {
		String ret = "* " + this.dinoType;
		ret += " - " + this.dinoName;
		ret += " (" + getVegetarian() + ")";
		return ret;
	}
	
	//getters and setters
	public String getDinoName() {
		return this.dinoName;
	}
	
	public String getDinoType() {
		return this.dinoType;
	}
	
	public String getVegetarian() {
		if (this.vegetarian) {
			return "not carnivore";
		}else {
			return "carnivore";
		}
	}
	
	public void setDinoName(String name) {
		this.dinoName = name;
	}
	
	public void setDinoType(String type) {
		this.dinoType = type;
	}
	
	public void setVegetarian(boolean veg) {
		this.vegetarian = veg;
	}
	

}
