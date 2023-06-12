public class ArraysAndLists {
    public static void main(String[] args) {
        
        // How to set up a Fixed Array:
        // arrays can be initialized on the same line
        // int[] myArray // ? we can also initialise without declaring anything yet
        // we need to define how big the array will be so space 
            // can be allocated in memory
            
        int[] myArray = new int[5];
        
        // Because arrays start with nothing in it, we need to initialize with a value:
        myArray[0] = 4; // 4
        myArray[1] = 8; // 8
        myArray[2] = 8; // 8
        myArray[3] = 5; // 5
        myArray[4] = 5; // 5
        
        // System.out.println(myArray); // [I@7ad041f3
        // ? What does all this mean? (see below)
        /* Representations
            * [ = there's an array,
            * I = what type an array it holds
            * @7ad041f3 = "at this place of memory"
        */
        
        for(int i = 0; i < myArray.length; i++) {
            System.out.println(myArray[i]); // the default value (0 printed 5x) is a primitive type
        }
        //                      arrays are in {}
        String[] fruits = {"strawberry", "banana", "apple", "watermelon"};
        String temp = fruits[0];
        //          size of an array can be accessed within
        fruits[0] = fruits[fruits.length - 1];
        fruits[fruits.length - 1] = temp;
        
        for(int i = 0; i < fruits.length; i++) {
            System.out.println(fruits[i]);
        }
    }
}
