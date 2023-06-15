public class Item {
    
    //* MEMBER VARIABLES
    String name;
    double price;
    
    // CONSTRUCTOR
    // Takes a name and price as arguments and sets them accordingly
    public Item( String name, double price ) {
        this.name = name;
        this.price = price;
    }
    
    // GETTERS & SETTERS - for name and price
    public String getName() {
        return this.name;
    }
    public void setName( String name ) {
        this.name = name;
    }
    
    public double getPrice() {
        return this.price;
    }
    public void setPrice( double price ) {
        this.price = price;
    }
}
