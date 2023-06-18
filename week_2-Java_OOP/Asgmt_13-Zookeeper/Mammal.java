public class Mammal {
    
    // Todo: Create a Mammal class that has an energyLevel member variable and displayEnergy() method. 
    /* The displayEnergy() method should show the animal's energy level as well as return it. -- this means in the subclasses from mammal—gorilla and bat—we need these attributes and methods to be accessible to them using "protected". */
    //* CLASS ATTRIBUTES / MEMBER VARIABLES
    protected int energyLevel;
    
    //* CONSTRUCTOR - to create mammals under this class.
    public Mammal( int energyLevel ) {
        this.energyLevel = energyLevel;
    }
    
    public int displayEnergy() {
        System.out.println("The mammal's energy level is " + this.energyLevel);
        return this.energyLevel;
    }
}