import java.util.ArrayList;

public class EnhancedForLoop {
    public static void main(String[] args) {
        ArrayList<String> dynamicArray = new ArrayList<>();
        // Add elements to the dynamicArray
        
        for(int i = 0; i < dynamicArray.size(); i++){
            String name = dynamicArray.get(i);
            System.out.println("hello " + name);
            // other operations using name
        }
        
        // * When not to use the Enhanced For Loop
        
        ArrayList<String> snacks = new ArrayList<String> ();
        snacks.add("Apples");
        snacks.add("Almonds");
        snacks.add("Pretzels");
        snacks.add("Yogurt");
        // for(String snack : snacks ) {
        //     if(snack.charAt(0) == 'A') {
        //         snacks.remove(snack);
        //     }
        // }
        /* 
        Running this code would produce the following error:
        ! Exception in thread "main" java.util.ConcurrentModificationException
        If we're modifying the ArrayList that we are looping over, the enhanced for loop may encounter this error. 
        If we write a conventional for loop instead, we can get this to work.
        */
        
        for(int i=0; i<snacks.size(); i++) {
            if(snacks.get(i).charAt(0) == 'A') {
                snacks.remove(i);
            }
        }
        System.out.println(snacks); // [Almonds, Pretzels, Yogurt]
        // This for loop is missing one more step...
        for(int i=0; i<snacks.size(); i++) {
            if(snacks.get(i).charAt(0) == 'A') {
                snacks.remove(i);
                i--; // Here we move one step back
            }
        }
        System.out.println(snacks); // [Pretzels, Yogurt]
        
        
        
    }
}
