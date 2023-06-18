package classes;

// To inherit things from a Parent class use this format:
// 	  public class ClassName extends ParentClass {}
public class Frog extends Animal {
	
	static int frogCount;
	
	// * CONSTRUCTOR
	public Frog(String name) {
		super(name);
		this.energy = 10;
		frogCount++;
	}
	
	// METHODS
	public void display() {
		System.out.println("\n*** Frog SubClass ***");
		super.display(); // calls everything from the Animal SuperClass
		System.out.printf("All Frogs: %s\n", frogCount);
	}
	public void jump() {
//		if (this.energy <= 0) {
//			this.setAlive(false);
//			System.out.println("Your frog are dead, therefore it cannot jump.");
//			frogCount--;
//			System.out.println("Your frog has died. Frog Count: "+ frogCount);
//		} else {
//		this.energy -= 5;
//		System.out.println(" *Hop-hop* The frog has jumped. Energy is now: "+ this.energy);
//		}
		
		// More Concise code:
		if (this.isAliveCheck()) {
			super.decrementEnergy(5);
			System.out.println(" *Hop-hop* The frog has jumped. Energy is now: "+ this.energy);
		} else {
			System.out.println("Your frog is dead, therefore it cannot jump.");
			frogCount--;
			System.out.println("Your frog has died. Deer Count: "+ frogCount);
		}
	}
	
	// * GETTERS & SETTERS
	public static int getFrogCount() {
		return frogCount;
	}

	public static void setFrogCount(int frogCount) {
		Frog.frogCount = frogCount;
	}
	
}
