import java.util.ArrayList;

public class TestOrders {
    
    public static void main(String[] args) {
        //* APP VARIABLES
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly.";
        String readyMessage = ", your order is ready! ";
        String displayTotalMessage = "Your total is $";
        
        //* APP VARIABLES -- Menu Items
        // These Menu Items are to be added to menuItems ArrayList...
        Item item1 = new Item();
        item1.name = "mocha";
        item1.price = 3.5;
        
        Item item2 = new Item();
        item2.name = "drip coffee";
        item2.price = 2.15;
        
        Item item3 = new Item();
        item3.name = "latte";
        item3.price = 4.16;
        
        Item item4 = new Item();
        item4.name = "cappuccino";
        item4.price = 4.36;
        
        //* Order variables -- order1, order2, etc.
        Order order1 = new Order();
        order1.customerName = "Cindhuri";
        
        Order order2 = new Order();
        order2.customerName = "Jimmy";
        
        Order order3 = new Order();
        order3.customerName = "Noah";
        
        Order order4 = new Order();
        order4.customerName = "Sam";
        
        //* Application Simulations -- Use this example code to test various orders' updates
        // System.out.println(order1); // Order@7344699f -- @location may differ w/ each print
        // System.out.printf("Name: %s\n", order1.customerName); // Name: Cindhuri
        // System.out.printf("Total: $%.2f\n", order1.total); // Total: $0.00
        // System.out.printf("Ready: %s\n", order1.isReady); // Ready: false
        
        
        // Todo: Add `item1` to `order2`'s item list and increment the order's total. √
        System.out.printf("\n%s%s.\n", generalGreeting, order2.customerName);
        order2.orderedItems.add(item1);
        order2.total += item1.price;
        // Todo: Jimmy’s order is now ready. Update his status. √
        order2.isReady = true;
        if( order2.isReady ) {
            System.out.printf("Ready: %s\n", order2.isReady);
            System.out.printf("%s%s\n", order2.customerName, readyMessage);
            System.out.printf("%s $%.2f.\n", displayTotalMessage, order2.total);
        } else {
            System.out.printf("%s%s\n", order2.customerName, pendingMessage);
        }
        
        // Todo: `order3` ordered a cappucino. Add the cappuccino to their order list and to their tab. √
        System.out.printf("\n%s%s.\n", generalGreeting, order3.customerName);
        order3.orderedItems.add(item4);
        order3.isReady = false;
        System.out.printf("%s%s\n", order3.customerName, pendingMessage);
        order3.total += item4.price;
        
        // Todo: `order4` added a latte. Update accordingly. √
        System.out.printf("\n%s%s.\n", generalGreeting, order4.customerName);
        order4.orderedItems.add(item3);
        order4.total += item3.price;
        // Todo: Sam ordered more drinks - 2 lattes. Update their order as well. √
        order4.orderedItems.add(item3);
        order4.orderedItems.add(item3);
        order4.total += (item3.price * 2);
        order4.isReady = true;
        if( order4.isReady ) {
            System.out.printf("Ready: %s\n", order4.isReady);
            System.out.printf("%s%s\n", order4.customerName, readyMessage);
            System.out.printf("%s $%.2f.\n", displayTotalMessage, order4.total);
        } else {
            System.out.printf("%s%s\n", order4.customerName, pendingMessage);
        }
        
        // Todo: Cindhuri’s order is now ready. Update her status. √
        System.out.printf("\n%s%s.\n", generalGreeting, order1.customerName);
        order1.isReady = true;
        System.out.println( 
            order1.isReady ? 
            String.format("Ready: %s\n", order1.isReady) + String.format("%s%s\n", order1.customerName, readyMessage) : 
            String.format("%s%s", order1.customerName,pendingMessage ));
    }
}
