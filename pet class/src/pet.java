
public class Pet {

// variables
		private int name;
		private int age;
		private int location;
		private int type;
		
 // Constructors
 public Pet(int emptyName, int emptyAge, int emptyLocation) {
	 location = emptyLocation;
		  age = emptyAge;
		 name = emptyName;
 }
  
// Getter 
 private int getName() {
	  return name;
  }
 private int getAge() {
	 return age;
 }
 private int getType() {
	 return type;
 }
 
 //Setter
 public void setName(int newName) {
		this.name = newName;
 }		
 public void setAge(int newAge) {
	this.age = newAge;
}
 public void setLocation(int newLocation) {
	 this.type = newLocation;
 }	 
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub 
}
}	
 



