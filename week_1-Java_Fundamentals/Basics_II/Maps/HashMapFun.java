import java.util.HashMap;
import java.util.Set;

public class HashMapFun {
    public static void main(String[] args) {
        //     keyType, valueType
        HashMap<String, String> userMap = new HashMap<String, String>();
        userMap.put("nninja@codingdojo.com", "Nancy Ninja");
        userMap.put("ssamurai@codingdojo.com", "Sam Samurai");
        userMap.put("wwizard@codingdojo.com", "Walter Wizard");
        
        // getting the value with the key (i.e., this email)
        String name = userMap.get("nninja@codingdojo.com");
        System.out.println("\nThe full name is: " + name + "\n");
        
        // get the keys by using the keySet method
        Set<String> keys = userMap.keySet(); // ? Set = collection of unordered unique values
        for (String key : keys) {
            System.out.println(key);
            System.out.println(userMap.get(key) + "\n");
        }
    }
}
