public class Gorilla extends Mammal {
    
    // ? Each Gorilla will be created with whatever energyLevel assigned.
    public Gorilla( int energyLevel ) {
        super(energyLevel);
    }
    
    // * GETTER METHOD
    public int getEnergyLevel() {
        return this.energyLevel;
    }
    
    // * METHODS
    // Print out a message indicating that the gorilla has thrown something, as well as decrease the energy level by 5
    public void throwSomething() {
        int energyCost = 5;
        if (this.energyLevel < energyCost) { // To prevent ebergyLevel going below 0
            System.out.println("The gorilla needs more energy.");
            return;
        }
        System.out.println("The gorilla has thrown something.");
        this.energyLevel -= energyCost;
    }
    
    // Print out a message indicating the gorilla's satisfaction and increase its energy by 10
    public void eatBananas() {
        System.out.println("The gorilla is eating a banana.");
        this.energyLevel += 10;
        if (this.energyLevel > 100) {
            this.energyLevel = 100;
        }
    }
    
    // Print out a message indicating the gorilla has climbed a tree and decrease its energy by 10
    public void climb() {
        int energyCost = 10;
        if (this.energyLevel < energyCost) {
            System.out.println("The gorilla needs more energy.");
            return;
        }
        System.out.println("The gorilla is climbing a tree.");
        this.energyLevel -= energyCost;
    }
}
