public class TestNull {
    public static void main(String[] args) {
        
        Integer a = 10;
        int b = 10;
        a = null;
        // b = null; // ! this will lead to a compiling errror: 
            // ! incompatible types: <null> cannot be converted to int
    }
}
