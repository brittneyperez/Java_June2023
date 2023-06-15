import java.util.ArrayList;

public class Order {
    /* Why in some instances `public class Order<Item> {}`?
    This allows for more flexibility in terms of the type of objects that can be stored in menuItems. Reasons:
        ① By using <Item> as a generic type parameter, it allows flexibility for the menuItems ArrayList to hold objects of any type.
        ② However, it's important to note that in this case, the <Item> in the class definition is not related to your Item class.
    */
    
    //* MEMBER VARIABLES = object attributes or fields that belong to a data type or class.
    // the values below are all default
    public String customerName; // null
    public double total; // 0
    public boolean isReady; // false, change status in test file
    public ArrayList<Item> orderedItems = new ArrayList<Item>(); // Initialize the ArrayList
}
