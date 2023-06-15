public class TestOrders {
    
    public static void main(String[] args) {
        
        //* APP VARIABLES
        //* Menu Items
        Item item1 = new Item("mocha", 3.5);
        Item item2 = new Item("drip coffee", 2.15);
        Item item3 = new Item("latte", 4.16);
        Item item4 = new Item("cappuccino", 4.36);
        
        //Todo: 2 unspecified orders
        Order order1 = new Order();
        Order order2 = new Order();
        
        //Todo: 3 named orders
        Order order3 = new Order("Cindhuri");
        Order order4 = new Order("Jimmy");
        Order order5 = new Order("Noah");
        
        //Todo: Add 2 items to each order and call display after
        order1.addOrderedItem(item4);
        order3.addOrderedItem(item2);
        
        order2.addOrderedItem(item1);
        order2.addOrderedItem(item4);
        
        order3.addOrderedItem(item1);
        order3.addOrderedItem(item4);
        
        order4.addOrderedItem(item3);
        order4.addOrderedItem(item3);
        
        order5.addOrderedItem(item3);
        order5.addOrderedItem(item2);
        
        //Todo: Test status
        System.out.println(order5.getStatusMessage());
        order5.setIsReady(true);
        System.out.println(order5.getStatusMessage());
        //? ^getStatusMessage doesn't print the msg, it just returns it, so we need to print the whole command
        
        //Todo: Test order total
        System.out.println(order5.getOrderTotal());
        order5.display();
    }
}
