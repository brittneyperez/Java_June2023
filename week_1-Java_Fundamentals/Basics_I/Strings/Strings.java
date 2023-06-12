public class Strings {
    public static void main(String[] args) {
        // * METHODS OF THE STRING CLASS
        
        // * Length
        String ninja = "Coding Dojo is Awesome";
        int length = ninja.length();
        System.out.println("String Length is : " + length); // String Length is : 22
        
        
        // * Concatenate
        String string1 = "My name is ";
        String string2 = "Jane";
        String string3 = string1.concat(string2);
        System.out.println(string3); // My name is Jane
        
        
        // * Format
        String ninjaDebt = String.format("Hi %s, you owe me $%.2f !", "Jack", 25.0);
        /* 
        ? %.2f is expecting a float data type. The value 2 will just place two values to right of the decimal point. 
        */
        System.out.println(ninjaDebt);
        /*
            String Length is : 22
            My name is Jane
            Hi Jack, you owe me $25.00 !
        */
        
        
        // * IndexOf
        String welcome = "Welcome to Coding Dojo!";
        int a = welcome.indexOf("Coding"); // a is 11
        int b = welcome.indexOf("co"); // b is 3
        int c = welcome.indexOf("pizza"); // c is -1, "pizza" is not found
        
        
        // * Trim
        String sentence = "    spaces everywhere!    ";
        System.out.println(sentence.trim()); // spaces everywhere!
        
        
        // * Uppercase & Lowercase
        String d = "HELLO";
        String e = "world";
        System.out.println(d.toLowerCase()); // hello
        System.out.println(e.toUpperCase()); // WORLD
        
        
        // * Equality
        String f = "same string";
        String g = "same string";
        System.out.println(f == g); // true
        // ? Creating new strings as separate objects (another way to create a String)
        f = new String("same letters");
        g = new String("same letters");
        System.out.println(f == g); // false; not the same object in memory
        System.out.println(f.equals(g)); // true; same exact characters
        
        
        System.out.println("=======");
        
        // * == vs `.equals()`
        String h = new String( "Dojo" );
        System.out.println( h == "Dojo" ); // Surprisingly this will print out `false`
        System.out.println( h.equals("Dojo") ); // This actually will print out true
    }
}