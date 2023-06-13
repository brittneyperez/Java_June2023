import java.util.ArrayList;

public class FirstController {
    
    // * Entry Point Method AKA "Main Method"
    public static void main(String[] args) {
        
        FirstClass firstClass = new FirstClass();
        // firstClass.conditionals();
        // firstClass.switches();
        // firstClass.ternary();
        // firstClass.strings();
        
        // * D3 Methods
        // firstClass.fixedArrays(); // use this if the method is "void"
        // System.out.println(firstClass.fixedArrays());
        
        // firstClass.arrayLists();
        // firstClass.maps();
        ArrayList<Character> alphabetSoup = firstClass.alphabet();
        System.out.println(alphabetSoup); // [a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z]
    }
}
