package classes;

public class Deer extends Animal {
	
	// * MEMBER VARIABLES ------------------------------
	static int deerCount;
	
	// * CONSTRUCTOR -----------------------------------
	public Deer(String name) {
		super(name);
		this.energy = 30;
		deerCount++;
	}
	
	// CLASS METHODS METHODS ---------------------------
	public void display() {
		System.out.println("\n*** Deer SubClass ***");
		super.display(); // calls everything from the Animal SuperClass
		System.out.printf("All Deers: %s\n", deerCount);
	}
	
	public void run(int energyUsed) {
		if (this.isAliveCheck()) {
			super.decrementEnergy(energyUsed);
			System.out.println(" *Leap-leap* The deer has ran. Energy is now: "+ this.energy);
		} else {
			System.out.printf("%s is dead, therefore it cannot run.\n", this.getName());
			deerCount--;
			System.out.printf("%s has died. Deer Count: %s.\n", this.getName(), deerCount);
		}
	}
	
	public void move( String movementType) {
		switch(movementType) {
		case "run":
			run(10);
			break;
		default:
			System.out.println("Invalid movement type.");
			break;
		}
	}
	
	
	// * IMPLEMENTED INTERFACE ---------------------------
	@Override
	public void eat(int energy) {
		System.out.println("Deer is eating.");
		this.energy += energy;
		System.out.printf("Energy: %s\n", this.energy);
	}
	
	
	// * GETTERS & SETTERS -------------------------------
	public static int getDeerCount() {
		return deerCount;
	}

	public static void setDeerCount(int deerCount) {
		Deer.deerCount = deerCount;
	}
}
