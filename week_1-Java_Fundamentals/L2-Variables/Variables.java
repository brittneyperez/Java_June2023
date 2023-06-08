public class Variables {
    public static void main(String[] args) {
        
        // * Variables are written in camelCase
        
        int ourInt; // we can declare a variable without setting its value
        ourInt = 400; // we can assign a value to the variable latter in our code
        double pi = 3.14159265; // we can also declare and assign on the same line
        boolean bool = true;
        char singleCharacter = 'A';
        
        String multipleCharacters = "ABC";
        
        
        String firstName = "Brittney";
        firstName = "Coder"; // reassigning variable firstName again
        
        System.out.println(firstName);
        
        double price1 = 3;
        double price2 = price1;
        
        double total = 0;
        total = price1 + price2;
        System.out.println(total);
        
    }
}
