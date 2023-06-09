public class CafeJava {
    
    public static void main(String[] args) {
        
        // * APP VARIABLES
        // ? Lines of text that will appear in the app.
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly.";
        String readyMessage = ", your order is ready! ";
        String displayTotalMessage = "Your total is $";
        
        //* Menu Variables
        double mochaPrice = 3.5;
        double dripCoffeePrice = 2.15;
        double lattePrice = 4.16;
        double cappucinoPrice = 4.36;
        
        //* Customer name variables
        String customer1 = "Cindhuri";
        String customer2 = "Noah";
        String customer3 = "Sam";
        String customer4 = "Jimmy";
        
        //* Order completions
        boolean isReadyOrder1 = false;
        boolean isReadyOrder2 = true;
        boolean isReadyOrder3 = true;
        boolean isReadyOrder4 = true;
        
        
        // ** APP INTERACTION SIMULATION ** //
        // Your your code for the challenges & customer interaction print statements will go here
        
        // Todo: ① Cindhuri ordered a coffee
        System.out.println("\n" + generalGreeting + customer1 + ".");
        System.out.println(customer1 + pendingMessage + ".\n");
        
        
        // Todo: ② Noah ordered a cappucino (Use an "if" Statement)
        System.out.println(generalGreeting + customer2 + ".");
        if ( isReadyOrder2 ) {
            System.out.println( customer2 + readyMessage );
            System.err.println( displayTotalMessage + cappucinoPrice + ".\n" );
        } else { System.out.println(customer2 + pendingMessage + ".\n"); }
        
        
        // Todo: ③ Sam ordered 2 lattes
        System.out.println(generalGreeting + customer3 + ".");
        System.out.println(( isReadyOrder3 ? customer3+readyMessage + displayTotalMessage + String.format("%.2f", (lattePrice * 2)) + ".\n" : customer3+pendingMessage + ".\n"));
        // System.out.println(displayTotalMessage + (lattePrice * 2) + ".");
        
        
        // Todo: ④ Jimmy ordered a latte, but he was charged for a coffee
        System.out.println(generalGreeting +  customer4 + ".");
        System.out.println(displayTotalMessage + dripCoffeePrice + ".");
        System.out.println(customer4 + ": I didn't order that! I ordered a latte!");
        System.out.println("Cafe Java: My apologies. We'll fix that up right now!");
        System.out.println(displayTotalMessage + String.format("%.2f", (lattePrice - dripCoffeePrice)) + ".\n");
    }
}
