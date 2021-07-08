/**
 * Dinosaur is a Java class containing a dinosaurs name, type, diet,
 * and a zone code
 * 
 * @author Justin McCann guz232
 *
 */

public class Dinosaur {
	
	//class variables
	private String dinoName;
	private String dinoType;
	private String zoneCode;
	private boolean vegetarian;
	
	//contructor
	public Dinosaur(String type, String name, boolean veg, String zCode) {
		this.dinoType = type;
		this.dinoName = name;
		this.vegetarian = veg;
		this.zoneCode = zCode;
	}
	
	//toString to list the dino type, name, diet, and zonecode
	public String toString() {
		String Veggies;
		if (this.vegetarian) {
			Veggies = "not carnivore";
		}else {
			Veggies =  "carnivore";
		}
		String ret = "* " + this.dinoType;
		ret += " - " + this.dinoName;
		ret += " (" + Veggies + ")";
		return ret;
	}
	
	//getters and setters
	public String getDinoName() {
		return this.dinoName;
	}
	
	public String getDinoType() {
		return this.dinoType;
	}
	
	public boolean getVegetarian() {
		return this.vegetarian;	
	}
	
	public String getZoneCode() {
		return zoneCode;
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
	
	public void setZoneCode(String zoneCode) {
		this.zoneCode = zoneCode;
	}
	
	

}
