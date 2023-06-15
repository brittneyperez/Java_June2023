import java.text.DecimalFormat;
import java.util.ArrayList;

public class Order {
    
    //* MEMBER VARIABLES = object attributes or fields that belong to a data type or class.
    // the values below are all default
    public String customerName; // null
    public boolean isReady; // false, change status in test file
    public ArrayList<Item> orderedItems = new ArrayList<Item>(); // Initialize the ArrayList
    // public double total; // 0
    
    // CONSTRUCTOR
    // No arguments, sets name to "Guest", initializes items as an empty list
    public Order() {
        this.customerName = "Guest"; // generic default name
        this.orderedItems = new ArrayList<Item>();
    }
    // OVERLOADED CONSTRUCTORS
    // Takes a name as an argument, sets name to this custom name.
    public Order( String customerName ) { // if name is provided
        this.customerName = customerName;
        this.orderedItems = new ArrayList<Item>();
    }
    
    
    //* ORDER METHODS
    public void addOrderedItem(Item item) {
        orderedItems.add(item);
    }
    public String getStatusMessage() {
        if( isReady ) {
            return "Your order is ready!";
        }
        return "Thank you for waiting, your order will be ready shortly."; // default unless declared true otherwise
    }
    
    public double getOrderTotal() {
        double total = 0;
        for( Item item : orderedItems ) {
            total += item.getPrice();
        }
        return total;
    }
    
    public void display() {
        System.out.println("\n--- Receipt ---\nCustomer Name: " + this.customerName);
        for( Item item : orderedItems ) {
            System.out.println(item.getName() + " -- $" + item.getPrice());
        }
        // System.out.println("Total: $" + getOrderTotal());
        
        // Format the total to two decimal places
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        String formattedTotal = decimalFormat.format(getOrderTotal());
        System.out.println("----------\nTotal: $" + formattedTotal + "\n"); 
    }
    
    // GETTERS & SETTERS
    public String getCustomerName() {
        return this.customerName;
    }
    public void setName( String customerName ) {
        this.customerName = customerName;
    }
    
    public boolean getIsReady() {
        return this.isReady;
    }
    public void setIsReady( boolean isReady ) {
        this.isReady = isReady;
    }
    
    public ArrayList<Item> getOrderedItems() {
        return this.orderedItems;
    }
    public void setItems( ArrayList<Item> orderedItems ) {
        this.orderedItems = orderedItems;
    }
}
