import java.util.ArrayList;

public class CafeUtil {
    
    // Todo: Implement a reward system for customers who always
    //       buy more drinks than they did the week before
    /* public int getStreakGoal() {
        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            sum += i;
        }
        return sum; // will return to the TestCafe file
    } */
    
    // Todo 忍者Bonus: Add parameter (numWeeks) so that an admin
    //                can change the # from 10 to whatever they want.
    public int getStreakGoal(int numWeeks) {
        int sum = 0;
        for (int i = 1; i <= numWeeks; i++) {
            sum += i;
        }
        return sum;
    }
    
    
    // Todo: Return the Total √
    public double getOrderTotal(double[] prices) {
        double total = 0;
        for(int i=0; i < prices.length; i++) {
            total += prices[i];
        }
        return total;
    }
    
    // Todo 忍者Bonus 1: void printPriceChart(String product, double price, int maxQuantity) √
    public void printPriceChart( String product, double price, int maxQuanitity ) {
        System.out.println(product);
        for( int i=1; i <= maxQuanitity; i++ ) {
            double total = price * i;
            // Todo 先生Bonus: Format the prices as currency
            System.out.printf("%s -- $%.2f\n", i, total);
            // Todo 先輩Bonus: Reduce price by $0.50 for each iteration √
            price -= 0.50;
        }
    }
    
    // Todo: void displayMenu(ArrayList<String> menuItems) √
    /* void displayMenu( ArrayList<String> menuItems ) {
        ? menuItems is a fixed array
        for(int i=0; i<menuItems.size(); i++) {
            ? 1st %s = index, 2nd %s = item name from menuItems
            System.out.printf("%s %s\n", i, menuItems.get(i));
        }
    } */
    /* Above code will print:
        0 drip coffee
        1 cappuccino
        2 latte
        3 mocha
    */
    
    // Todo 忍者Bonus 2: boolean displayMenu(ArrayList<String> menuItems, ArrayList<Double> prices)
    //                              i menuItem  -- $ price
    boolean displayMenu( ArrayList<String> menuItems, ArrayList<Double> prices) {
        // ? Check if both arrays are the same size, otherwise return false
        if (menuItems.size() != prices.size()) {
            return false;
        }
        
        for (int i=0; i<menuItems.size(); i++) {
            System.out.printf("%s %s -- $%.2f\n", i, menuItems.get(i), prices.get(i));
        }
        return true;
    }
    
    // Todo: addCustomer(ArrayList<String> customers) √
    // public void addCustomer( ArrayList<String> customers ) {
        
    //     System.out.println("Please enter your name:");
    //     String userName = System.console().readLine();
    //     System.out.println("Hello, " + userName);
        // Increment how many ppl are in line by using .size(), as we are dealing with an ArrayLists
    //     System.out.printf("There are %s people in front of you.", customers.size());
    //     customers.add(userName);
    // }
    
    public void addCustomer(ArrayList<String> customers) {
        String input;
        System.out.println("Please enter your name (type 'q' to quit):");
        
        while (true) {
            input = System.console().readLine();
            if (input.equalsIgnoreCase("q")) {
                break; // Exit the loop if the user enters 'q'
            } else {
                System.out.println("Hello, " + input);
                System.out.printf("There are %s people in front of you.\n", customers.size());
                customers.add(input);
            }
        }
    }
}
