public class FirstClass {
    
    public static void main(String[] args) {
        
        System.out.println("Hello World!");
        
        // * Defining Variables
        // String myName = "Brittney";
        // int favoriteNumber;
        // favoriteNumber = 7;
        // long monthsSinceKindergarden = 123456789;
        // double minasAge = 2.5;
        // boolean isHappy = true;
        // char inital = 'a';
        // * Wrapper Classes
        // Integer $mySistersAge = 15;
        // System.out.println($mySistersAge);
        // String _mySistersName = "Rei";
        // Long bigNumber;
        // Double decimalNumber = 7.58;
        // Integer result = $mySistersAge/favoriteNumber;
        // System.out.println(result);
        // System.out.println(favoriteNumber);
        
        // FirstClass firstClass = new FirstClass();
        // firstClass.ternary();
    }
    
    void conditionals() { // Todo: Conditionals
        /* Structure of a Conditional Statement
        * if(condition) {
            ? What to do if condition is true,...
            ? ... can have 1 or many if statements.
        }
        * else if(2nd condition) {
            ? What to do if 2nd condition is true,...
            ? ... can have 0 to many else-if statements.
        * } else {
            ? What to do if one of the previous conditions are met,...
            ? can have 1 or no else statements
        }
        ? In loop, you can use continue/break to implement flow control on the current loop
        */
        
        // Double double1 = 123d;
        Double double1 = 789d;
        // Double double2 = 123d;
        Double double2 = 456d;
        
        /* if (double1 == double2) {} // ! This will not work!
            ! bc "==" is comparing the same address in memory. 
            ! not the variables' values. Fix this by using a 
            ! wrapper class and .compare()
        */
        if ( Double.compare(double1, double2) == 0 ) {
            System.out.println("They're the same.");
        } else if ( Double.compare(double1, double2) > 0 ) {
            System.out.println("double1 > double2");
        } else {
            System.out.println("double1 < double2");
        }
    }
    
    void switches() { //  Todo: Switches
        /* Structure of Switch Statements
        * switch( parameterValueToCheck ) {
            * case1 parameterValueToCheck:
                ? Do stuff and things
                ? break
            * case2 parameterValueToCheck:
                ? Do stuff and things
                ? break
            * default:
                ? Do stuff and things
        * }
        */
        
        int day = 4;
        switch( day ) {
            case 1:
                System.out.println("月曜日");
                break;
            case 2:
                System.out.println("火曜日");
                break;
            case 3:
                System.out.println("水曜日");
                break;
            case 4:
                System.out.println("木曜日");
                break;
            case 5:
                System.out.println("金曜日");
                break;
            case 6:
                System.out.println("土曜日");
                break;
            case 7:
                System.out.println("日曜日");
                break;
            default:
                System.out.println("There are only seven days in a week...");
        }
    }
    
    void ternary() { // Todo Ternary
        /* Structure of Ternary Statements 
        * The ternary operator consists of three pieces
            ① the condition
            ② the return value if the condition is true, and
            ③ the return value if the condition is false
            ? variable = (condition) ? expressionIfTrue : expressionIfFalse
        */
        boolean isHappy = true;
        String output = (isHappy) ? "Yay :)" : "That's terrible :()";
        System.out.println(output);
    }
    
    void strings() { // Todo Strings
        System.out.println("\nWhat is your name?");
        String name = System.console().readLine();
        String consoleResponse = String.format("こんにちは、%s。よろしくお願いします", name);
        // System.out.println(consoleResponse);
        
        char punctuation = '。';
        System.out.println(consoleResponse + punctuation);
        double myBalance = 100.255075;
        String announceMyBalance = String.format("%s、あなたは%.2fドルを持っています%s", name, myBalance, punctuation);
        System.out.println(announceMyBalance);
        
    }
}