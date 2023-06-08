public class SwitchStatements {
    public static void main(String[] args) {
        // *  Switch Statements
        int day = 7;
        switch(day){ //? ⑴ Start with the `switch` keyword and pass in the variable we're checking (i.e., "day").
            //? ⑵ Inside each switch statement, we specify what we want to happen for each possible case.
            case 1:
                System.out.println("Monday"); //? We can see that we print out the day of the week based on the value of our "day" variable.
                break;
                /* ⑶ The "break" Keyword
                    ? This needs to be included as this will ensure that our program exits
                    ? out of the switch block once the desired value has been found.
                */
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            default:
                System.out.println("There are only seven days in a week...");
            /* ⑷ The `default` Keyword
                ? This keyword at the bottom of our switch statement is
                ? equivalent to the "else“ keyword in an if/else statement.
                ! We do not need a break keyword after default as it is the last option in our switch block.
            */
        }
        
        // * Ternary Operators
        boolean isRaining = true;
        /* The Following code...
        
        if(isRaining) {
            System.out.println("Bring an Umbrella");
        } else {
            System.out.println("Have fun!");
        }
        
        ...can also be written as this: */
        System.out.println(isRaining ? "Bring an umbrella" : "Have fun!");
    }
}
