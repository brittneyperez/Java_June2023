public class Loops {
    public static void main(String[] args) {
        
        // Todo: Desired Output: 01234
        
        // System.out.println(0);
        // System.out.println(1);
        // System.out.println(2);
        // System.out.println(3);
        // System.out.println(4);
        // ! This is too redundant! We can just loops this over:
        
        // * Basic For Loop (increase by 1)
        for(int i = 0; i<5; i++) {
            System.out.println(i); // 01234
        }
        
        // * For Loop (increase by 2)
        for(int i = 0; i<5; i+=2) {
            System.out.println(i); // 024
        }
        
        // * For Loop (decreases by 1)
        for(int i = 5; i>0; i--) {
            System.out.println(i); // 54321
        }
        
        // * While Loop (increases by 1)
        int count = 0; // ? count needs to live outside of the loop
        while(count<5) {
            System.out.println(count);
            count++;
        } // 01234
        
        // ? FYI: Use While Loops when we don't how many times we need to iterate through it.
        // ? FYI: Use For Loops when we do know.
        
        // * Enhanced For Loop
        String[] fruits = {"strawberry", "banana", "apple", "cherry"};
        for(String s : fruits) {
            System.out.println(s);
        }
    }
}