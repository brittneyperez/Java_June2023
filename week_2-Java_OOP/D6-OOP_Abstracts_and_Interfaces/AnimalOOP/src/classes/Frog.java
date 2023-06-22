package classes;

// To inherit things from a Parent class use this format:
// 	  public class ClassName extends ParentClass {}
public class Frog extends Animal {
	
	static int frogCount;
	
	// * CONSTRUCTOR
	public Frog(String name) {
		super(name);
		this.energy = 15;
		frogCount++;
	}
	
	// METHODS
	public void display() {
		System.out.println("\n*** Frog SubClass ***");
		super.display(); // calls everything from the Animal SuperClass
		System.out.printf("All Frogs: %s\n", frogCount);
	}
	
	public void jump(int energyUsed) {
		
		if (this.isAliveCheck()) {
			super.setEnergy(this.getEnergy()-energyUsed);
			System.out.println(" *Hop-hop* The frog has jumped. Energy is now: "+ this.energy);
		} else {
			System.out.printf("%s is dead, therefore it cannot swim.\n", this.getName());
			frogCount--;
			System.out.printf("%s has died. Frog Count: %s.\n", this.getName(), frogCount);
		}
	}
	public void swim(int energyUsed) {
		
		if (this.isAliveCheck()) {
			super.setEnergy(this.getEnergy()-energyUsed);
			System.out.println(" *Splish-splash* The frog swims. Energy is now: "+ this.energy);
		} else {
			System.out.println("Your frog is dead, therefore it cannot swim.");
			frogCount--;
			System.out.println("Your frog has died. Frog Count: "+ frogCount);
		}
	}
	public void move( String movementType) {
		switch(movementType) {
		case "jump":
			jump(5);
			break;
		case "swim":
			swim(10);
			break;
		default:
			System.out.println("Invalid movement type.");
			break;
		}
	}
	
	
	// * IMPLEMENTED INTERFACE ---------------------------
	@Override
	public void eat(int energy) {
		System.out.println("Frog is eating.");
		this.energy += energy;
		System.out.printf("Energy: %s\n", this.energy);
	}
	
	// * GETTERS & SETTERS -------------------------------
	public static int getFrogCount() {
		return frogCount;
	}

	public static void setFrogCount(int frogCount) {
		Frog.frogCount = frogCount;
	}
}
