import java.util.ArrayList;
import java.util.Arrays;

public class TestCafe {
    public static void main(String[] args) {
        // Todo: Create an Instance of CafeUtil class √
        CafeUtil appTest = new CafeUtil(); // accesses CafeUtil file
        

        /* ============ App Test Cases ============= */
        
        System.out.println("\n----- Streak Goal Test -----");
        // System.out.printf("Purchases needed by week 10: %s \n", appTest.getStreakGoal());
        int numWeeks = 5; // setting the desired number of weeks...
        System.out.printf("Purchases needed by week %d: %s \n", numWeeks, appTest.getStreakGoal(numWeeks));
        
        
        System.out.println("\n----- Order Total Test-----");
        double[] lineItems = {3.5, 1.5, 4.0, 4.5};
        System.out.printf("Order total: $%.2f\n", appTest.getOrderTotal(lineItems));
        
        
        System.out.println("\n----- Print Price Chart Test -----");
        appTest.printPriceChart("Columbian Coffee Grounds", 15.0, 3);
        
        
        System.out.println("\n----- Display Menu Test-----");
        ArrayList<String> menu = new ArrayList<String>();
        menu.add("drip coffee");
        menu.add("cappuccino");
        menu.add("latte");
        menu.add("mocha");
        
        ArrayList<Double> prices = new ArrayList<Double>();
        prices.add(1.50);
        prices.add(3.50);
        prices.add(4.50);
        prices.add(3.50);
        
        appTest.displayMenu(menu, prices);
        
        
        System.out.println("\n----- Add Customer Test-----");
        ArrayList<String> customers = new ArrayList<String>();
        // --- Test 4 times ---
        for (int i = 0; i < 4; i++) {
            appTest.addCustomer(customers);
            System.out.println("\n");
        }
    }
}
