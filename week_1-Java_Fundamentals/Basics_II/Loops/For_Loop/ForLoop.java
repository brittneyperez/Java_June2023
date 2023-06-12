import java.util.ArrayList;

public class ForLoop {
    public static void main(String[] args) {
    //      init,  term,  incr
        for(int i=0; i<7; i++) {
            System.out.println("bar");
        }
        /* The for loop above will look like this as a while loop below:
            int i = 0;
            while(i<7) {
                System.out.println("bar");
                i++;
            }
        */
        
        System.out.println("");
        // * Using a for loop, we can iterate over any array:
        ArrayList<String> dynamicArray = new ArrayList<String>();
        dynamicArray.add("hello");
        dynamicArray.add("world");
        dynamicArray.add("etc");
        for (int i=0; i<dynamicArray.size(); i++) {
            System.out.println(dynamicArray.get(i));
        }
    }
}
