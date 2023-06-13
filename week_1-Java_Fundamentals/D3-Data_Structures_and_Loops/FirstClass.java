import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class FirstClass {
    // * D1 Material
    public static void main(String[] args) {
        
        System.out.println("Hello World!");
        
        // * Defining Variables
        // String myName = "Brittney";
        // int favoriteNumber;
        // favoriteNumber = 7;
        // long monthsSinceKindergarden = 123456789;
        // double minasAge = 2.5;
        // boolean isHappy = true;
        // char inital = 'a';
        // * Wrapper Classes
        // Integer $mySistersAge = 15;
        // System.out.println($mySistersAge);
        // String _mySistersName = "Rei";
        // Long bigNumber;
        // Double decimalNumber = 7.58;
        // Integer result = $mySistersAge/favoriteNumber;
        // System.out.println(result);
        // System.out.println(favoriteNumber);
        
        // FirstClass firstClass = new FirstClass();
        // firstClass.ternary();
    }
    // * D2 Material
    void conditionals() {
        // Double double1 = 123d;
        Double double1 = 789d;
        // Double double2 = 123d;
        Double double2 = 456d;
        if ( Double.compare(double1, double2) == 0 ) {
            System.out.println("They're the same.");
        } else if ( Double.compare(double1, double2) > 0 ) {
            System.out.println("double1 > double2");
        } else {
            System.out.println("double1 < double2");
        }
    }
    void switches() {
        int day = 4;
        switch( day ) {
            case 1:
                System.out.println("月曜日");
                break;
            case 2:
                System.out.println("火曜日");
                break;
            case 3:
                System.out.println("水曜日");
                break;
            case 4:
                System.out.println("木曜日");
                break;
            case 5:
                System.out.println("金曜日");
                break;
            case 6:
                System.out.println("土曜日");
                break;
            case 7:
                System.out.println("日曜日");
                break;
            default:
                System.out.println("There are only seven days in a week...");
        }
    }
    void ternary() {
        boolean isHappy = true;
        String output = (isHappy) ? "Yay :)" : "That's terrible :()";
        System.out.println(output);
    }
    void strings() {
        System.out.println("\nWhat is your name?");
        String name = System.console().readLine();
        String consoleResponse = String.format("こんにちは、%s。よろしくお願いします", name);
        // System.out.println(consoleResponse);
        
        char punctuation = '。';
        System.out.println(consoleResponse + punctuation);
        double myBalance = 100.255075;
        String announceMyBalance = String.format("%s、あなたは%.2fドルを持っています%s", name, myBalance, punctuation);
        System.out.println(announceMyBalance);
        
    }
    
    // * D3 Material
    String fixedArrays() {
        // We need to instantiate the array by defining and declaring it as a variable. //! just int [] myArray will lead to an error.
        int [] myArray = new int[6]; //? we set the fixed size of the array inside [] the length 
        System.out.println("myArray: " + myArray); // [I@7344699f = this is the place in memory the array is at
        // Another way of defining a fixedArray...
        int [] myOtherArray = {1,2,3,4,5,6};
        System.out.println("myOtherArray: " + myOtherArray); // [I@6b95977
        
        // * For Loops
        // Let's loop through myArray to see it's values
        for (int iterator : myArray ) {
            System.out.println(iterator); // the value 0 will printed 6x, bc there are currently no values inside myArray
        }
        System.out.println("\nmyOtherArray Indexes and Values");
        // Now let's loop through myOtherArray...
        for (int i=0; i<myOtherArray.length; i++) {
            /* Notes:
                We cannot use <= bc the for loop will try to access values beyond myOtherArray that don't exist.
                And we use `.length` bc it allows us to handle arrays of varying sizes without hardcoding the specific length 
                value in the loop condition. It makes the code more flexible and adaptable to different array sizes.
            */
            // System.out.println(i); //? prints the indexes: 012345
            System.out.println("Index: " + i + ", Value: " + myOtherArray[i]); //? for a better visual of what's being printed
        }
        
        return Arrays.toString(myOtherArray); // required: "import java.util.Arrays;"
    }
    void arrayLists() {
        // ? Structure: ArrayList<TYPE> arrayListName = new ArrayList<String>();
        ArrayList<String> myArrayList = new ArrayList<String>(); // required: "import java.util.ArrayList;"
        System.out.println(myArrayList); // []
        /* ArrayLists always start empty []
            We can add and remove values at will unlike fixedArrays.
            Let's add some values to myArrayLists.
        */
        myArrayList.add("Minnie");
        myArrayList.add("미니");
        myArrayList.add("ミーニ");
        myArrayList.add("Miniii");
        System.out.println(myArrayList); // [Minnie, 미니, ミーニ, Miniii]
        myArrayList.remove("Miniii");
        System.out.println(myArrayList); // [Minnie, 미니, ミーニ]
        System.out.println(myArrayList.size()); // 3s
        
        // * While Loop
        // int i = 0;
        // while (i <= 10) {
        //     System.out.println("Doing Stuff and things...");
        //     i++;
        // }
        
        for(String i : myArrayList) {
            System.out.println(i);
            /* Output:
                Minnie
                미니
                ミーニ 
            */
        }
    }
    
    void maps() {
        //? Structure: HashMap<TYPE, TYPE> myMapName = new HashMap<TYPE, TYPE>();
        HashMap<String, String> myMap = new HashMap<String, String>(); // required: "import java.util.HashMap;"
        //        key          value:
        myMap.put("name1", "Bri");
        myMap.put("name2", "Minnie");
        myMap.put("name3", "Stelle");
        myMap.put("name4", "Lumi");
        System.out.println(myMap); // prints keys and values: {name4=Lumi, name3=Stelle, name2=Minnie, name1=Bri}
        System.out.println(myMap.get("name2")); // prints value of that key: Minnie
        
        /* We can iterate through maps by creating a list of keys and use that 
        as our iterators. For best practice, our keys should be Strings */
        Set<String> myMapKeys = myMap.keySet(); // required: "import java.util.Set;"
        for( String i : myMapKeys ) {
            // System.out.println(i); // prints per line: name4 name3 name2 name1
            System.out.println(myMap.get(i)); // prints per line: Lumi Stelle Minnie Bri
        }
    }
    ArrayList<Character> alphabet() {
        ArrayList<Character> alph = new ArrayList<Character>();
        for (char i = 'a'; i <= 'z'; i++) {
            // System.out.println(i); // prints each letter per line
            alph.add(i);
        }
        // System.out.println(alph); // [a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z]
        return alph;
    }
}