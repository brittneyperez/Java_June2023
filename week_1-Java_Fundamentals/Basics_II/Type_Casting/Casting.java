public class Casting {
    public static void main( String[] args ) {
        int i = 120;
        // byte b = i; //! Type mismatch: cannot convert from int to byte
        
        //                                               bigger (4 bytes)  smaller (1 byte)
        // * We lose precision/conversion trying to convert the int down to a byte.
        // * We can get around this by explicit casting, by also declaring "i" as (byte).
        // * Now the compiler will allow the conversion of i from a int value into a byte value.
        
        byte b = (byte) i;
        System.out.println(b);
        
        // * But what if we make the integer value outside the scope of what a byte value is?
        // * Turning "int i = 130" will not cause a compiling error but it will cause the i turn into -126.
        // * This occurs becuause we're converting from a bigger number into a smaller number.
        
        
        // * What if we are converting from a smaller value into a bigger value—a byte into an int.
        byte a = 127;
        int z = a;
        System.out.println(z);
        /* 
            * This is considered implicit casting. We should have no issue converting when doing this casting type.
            ? Why does this happen? Because more things can fit into a bigger size than a smaller size,
            ? its easier to convert up than down.
        */
    }
}
