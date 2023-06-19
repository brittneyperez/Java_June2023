public class Human extends Mammal {
    
    public String name;
    
    public Human(String name) {
        super();
        this.name = name;
        System.out.println("\n *** Subclass Constructor *** ");
    }
    
    public Human(String name, int age) {
        super(age);
        this.name = name;
        System.out.println("\n *** Subclass Constructor *** ");
    }
    
    public Human(String name, int age, String location) {
        super(age, location);
        this.name = name;
        System.out.println("\n *** Subclass Constructor *** ");
    }
    
    public void goToWork() {
        System.out.println("I'm going to work, something only humans can do.");
    }
}
