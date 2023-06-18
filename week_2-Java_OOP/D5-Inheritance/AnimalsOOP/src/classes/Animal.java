package classes;

public class Animal { // only one class per file

	// * MEMBER VARIABLES ------------	
	private String name;
	private double height;
	private int weight;
	protected int energy = 20; // default energy is available to extend to other animal classes
	private boolean isAlive = true;
	static int animalCount; // This will be present in every instance of Animal created.
	
	// * CONSTRUCTOR - they share the name of the class, does not need arguments
	// If we don't define each constructor as public, its ok as that is the default
	public Animal() {
		this.name = "Default";
		this.height = 0;
		this.weight = 0;
		animalCount++;
	}
	
	// Method Overloading. We can use the same method name but with differing params
	Animal(String name) {
		this.name = name;
		this.height = 0;
		this.weight = 0;
		animalCount++;
	}
	
	Animal(String name, double height, int weight) {
		this.name = name;
		this.height = height;
		this.weight = weight;
		animalCount++;
	}

	// * CLASS METHODS
	public void display() {
		System.out.println("*** Animal Class ***");
		System.out.printf("Name: %s\n", this.name);
		System.out.printf("Energy: %s\n", this.energy);
		System.out.printf("All Animals: %s\n", animalCount);
	}
	
	public boolean isAliveCheck() {
		if (this.energy <= 0) {
			this.setAlive(false);
			return this.isAlive();
		} else {
			return this.isAlive();
		}
	}
	
	protected void decrementEnergy(int value) {
		this.energy -= value;
	}
	
	
	// * GETTERS & SETTERS	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public static int getAnimalCount() {
		return animalCount;
	}

	public static void setAnimalCount(int animalCount) {
		Animal.animalCount = animalCount;
	}
	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
}
