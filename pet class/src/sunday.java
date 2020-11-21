import java.util.Scanner;

public class Sunday {
	public static void main(String[] args) {
	}
		//variables:
		private int suite;
		private int pumps;
	 	private int purse;
	 	private int jewelry;

//constructors: 
public Sunday(int silverPurse, int silverPumps, int silverJewelry) {
	  purse = silverPurse;
      pumps = silverPumps;
	jewelry = silverJewelry; 
}
public Sunday(int newPurse, int newSuite) {
	  purse = newPurse;
      suite = newSuite;
}
//Getters
	private int getPurse() {
	 return purse;
}
	private int getPumps() {
	 return pumps;
}
	private int getJewelry() {
	 return jewelry;
}
//Setters 
public void setSuite(int newSuite){
	 this.suite = newSuite; 
}
public void setPumps(int newPumps){
this.pumps = newPumps; 
}
public void setPurse(int newPurse){
this.suite = newPurse; 
}

public class BooleanEqualsExample1{

	boolean b1 = true;
	boolean b2 = false; 
 
	String s1 = Boolean.toString(b1);
	String s2 = Boolean.toString(b2);
	
	System.out.println("s1, s2");
}
}
	
	




	


