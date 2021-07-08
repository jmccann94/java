import java.lang.reflect.Field;

public class Reflect {
	private static class Stuff {
	  public Integer a = 1;
	  public Double b = 200.0;
	  public Integer c = 3;
	  public Double d = 400.0;
	  public String m = "a";
	  public String n = "xy";
	  
	  public void prt() {
		  System.out.println("[" + a + ", " + b + ", " + c + ", " + d + ", " + m + ", " + n + "]");
	  }
	}
	
	private void info(Object obj) {
		//first get the field array 
		Field[] f = obj.getClass().getDeclaredFields();
		//for each element in the array print
		for(Field item : f){
			System.out.println("** Field = " + item.getName() + " is " + item.getType().getSimpleName() );
		}
	}
	
	private void modify(Object obj) {
		
		try {
			//First get the Field array
			Field[] f = obj.getClass().getDeclaredFields();
			//For each element in the array
			for(Field item : f){
				//If item is integer
				if(item.getType().getSimpleName().equals("Integer")){
					//Set the item to accesible
					item.setAccessible(true);
					//Set multiply value by 10
					item.set(obj, 10*((int)item.get(obj)));
				}
				//Else if item is a double 
				else if(item.getType().getSimpleName().equals("Double")){
					//Set the item to accesible
					item.setAccessible(true);
					//Add 10 the value
					item.set(obj, 10.0 + ((double)item.get(obj)));
				}
				//Else if item is a String
				else if(item.getType().getSimpleName().equals("String")){
					//Set the item to accesible
					item.setAccessible(true);
					//Add the string to itself
					item.set(obj, ((String)item.get(obj)) + ((String)item.get(obj)));
				}
			}
		} catch (IllegalAccessException ex) {
			ex.printStackTrace();
		}
	}
	
	private void doit() {
		Stuff s = new Stuff();
		info(s); s.prt();
		modify(s); s.prt();
		modify(s); s.prt();
	}
	
	public static void main(String[] args) {
		Reflect r = new Reflect();
		r.doit();
	}
}
