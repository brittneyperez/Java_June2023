import java.lang.reflect.Array;
import java.util.ArrayList;

public class DynamicArray {
    public static void main(String[] args) {
        
        
        ArrayList<Integer> myList = new ArrayList<Integer>();
        System.out.println(myList); // []
        // * This is good! This means we can add to the array.
        
        myList.add(10);
        myList.add(11);
        myList.add(12);
        System.out.println(myList); // [10, 11, 12]
        
        // * Getters & Setters
        // - arrayLists do NOT use bracket notation
        // to remove an index of an arrayList:
        Integer num = myList.get(0); // ? getter
        System.out.println(num); // 10
        // This does not remove from arrayList; it just prints the number
        
        myList.set(0, 9); // ? setter, replaces 10 with 9
        System.out.println(myList); // [9, 11, 12]
        
        ArrayList<Object> things = new ArrayList<Object>();
        things.add(10);
        things.add("Hello");
        things.add(new ArrayList<Integer>());
        things.add(12.5);
        System.out.println(things);
        
    }
}
