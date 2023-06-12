public class TypeCasting {
    public static void main( String[] args ) {
        
        // * EXPLICIT CASTING
        /* Explicitly Casting = 
            when we declare the type that we want to convert to in our source code
        */
        double d = 35.25;
        double dd = 35.99;
        
        // casting the double d into a int
        int i = (int) d;
        
        // casting the double dd into a int
        int ii = (int) dd;
        System.out.println(i); // 35
        System.out.println(ii); // 35
        
        
        // * Implicit Casting
        /* Implicitly Casting = depening on context, Java will implicitly cast types 
            In the case below, the int is casted to a float. The float has also been casted 
            into the string type for concatenation. Java will allow implicits as long as 
            the target type has a large enough range for the conversion.
        */
        int n = 35;
        float f = n;
        System.out.println("The number is: " + f); // 35.0
        
        
        // * Primitive vs Object Types
        long start = System.currentTimeMillis();
        // Integer sum = 0; 
        // ! thie instance of this integer as a result of a for loop, and its big!
        // Todo: let's change it to an int √
        int sum = 0; // this will make the compiling faster.
        for (int z = 0; z < Integer.MAX_VALUE; z++) {
            sum += z;
        }
        System.out.println("Sum: " + sum);
        long end = System.currentTimeMillis();
        double total = (double) (end - start) / 1000;
        System.out.println("Time of execution: " + total + " seconds");
        
        
        
    }
}
