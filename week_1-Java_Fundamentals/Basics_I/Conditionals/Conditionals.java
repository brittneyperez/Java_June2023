public class Conditionals {
    public static void main(String[] args) {
        // * Conditionals in Java
        
        // Todo: If-Else Statements Chains
        /*
            * if(condition) {
                ? what to do if condition is true
            * }
            * else if(2nd condition) {        
                ? what to do if 2nd condition is true
            * }
            ? can have 0 to many else-if statements...
            
            * else {                           
                ? what to do if none of the previous conditions are met
            * }
            ? can have 1 or no else statement
        */
        
        // Example 1:
        boolean isRaining = true;
        if(isRaining) {
            System.out.println("Bring an umbrella.");
        } else {
            System.out.println("Have fun!");
        }
        
        // Example 2:
        int temperature = 85;
        boolean isCloudy = true;
        if(temperature < 40 && isCloudy){
            System.out.println("It might snow.");
        } else if(isCloudy){
            System.out.println("It might rain.");
        } else{
            System.out.println("We should have nice weather today.");
        }
    }
}
