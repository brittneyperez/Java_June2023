package classes;

public class Deer extends Animal {
	
	static int deerCount;
	
	// * CONSTRUCTOR
	public Deer(String name) {
		super(name);
		this.energy = 30;
		deerCount++;
	}
	
	// METHODS
	public void display() {
		System.out.println("\n*** Deer SubClass ***");
		super.display(); // calls everything from the Animal SuperClass
		System.out.printf("All Deers: %s\n", deerCount);
	}
	public void run() {
		if (this.isAliveCheck()) {
			super.decrementEnergy(15);
			System.out.println(" *Leap-leap* The deer has ran. Energy is now: "+ this.energy);
		} else {
			System.out.printf("%s is dead, therefore it cannot run.\n", this.getName());
			deerCount--;
			System.out.printf("%s has died. Deer Count: %s.\n", this.getName(), deerCount);
		}
	}
}
