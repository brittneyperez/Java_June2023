public class Bat extends Mammal {
    
    // ? Each Bat will be created with a set energyLevel.
    public Bat() { // therefore no params needed
        super(300); // int energyLevel = 300;
    }
    
    // * GETTER METHOD
    public int getEnergyLevel() {
        return this.energyLevel;
    }
    
    // * METHODS
    // Print the sound of a bat taking off and decrease its energy by 50.
    public void fly() {
        int energyCost = 50;
        if (this.energyLevel < energyCost) {
            System.out.println("The bat needs more energy.");
            return;
        }
        System.out.println("  *Flap-Flap.*  ");
        this.energyLevel -= energyCost;
    }
    
    // Print the so- well, never mind, just increase its energy by 25.
    public void eatHumans() {
        System.out.println("  *people screaming...*  ");
        this.energyLevel += 25;
        if (this.energyLevel > 300) {
            this.energyLevel = 300;
        }
    }
    
    // Print the sound of a town on fire and decrease its energy by 100.
    public void attackTown() {
        int energyCost = 100;
        if (this.energyLevel < energyCost) {
            System.out.println("The bat needs more energy.");
            return;
        }
        System.out.println("  *sizzle-sizzle.* *crackle.*  ");
        this.energyLevel -= energyCost;
    }
}

