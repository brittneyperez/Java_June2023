package D4.src.classes;
public class Animal {
    private String name;
    private double height;
    private int weight;
    static int animalCount; // this can be incremented in our construtor
    
    public Animal() {
        this.setName("default");
        this.height = 0;
        this.weight = 0;
        animalCount++;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Animal( String name ) {
        this.setName(name);
        this.height = 0;
        this.weight = 0;
        animalCount++;
    }
    
    public Animal( String name, double height, int weight ) {
        this.setName(name);
        this.height = height;
        this.weight = weight;
        animalCount++;
    }
}