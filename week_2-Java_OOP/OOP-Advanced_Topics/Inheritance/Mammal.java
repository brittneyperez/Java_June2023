public class Mammal {
    
    public int age = 18;
    public String location = "Earth";
    public boolean sleeping = false;
    
    public Mammal() {
        System.out.println("\n*** Superclass Constructor ***");
    }
    
    public Mammal( int age ) {
        this.age = age;
        System.out.println("\n*** Superclass Constructor ***");
    }
    
    public Mammal( int age, String location ) {
        this.age = age;
        this.location = location;
        System.out.println("\n*** Superclass Constructor ***");
    }
    
    public void regulateTemperature() {
        System.out.println("My temperature is just right now.");
    }
    public void startSleeping() {
        sleeping = true;
        System.out.println("ZzZz");
    }
    public boolean isSleeping() {
        return sleeping;
    }
}
