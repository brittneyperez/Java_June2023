import java.util.ArrayList;
import java.util.Random;

public class PuzzleJava {
    
    /* //* getTenRolls() √
        Todo: Write a method that will generate and return an array with 10 random numbers between 1 and 20 inclusive.
    */
    public ArrayList<Integer> getTenRolls() {
        ArrayList<Integer> random10Rolls = new ArrayList<Integer>();
        Random random = new Random(); // creating an instance of random
        
        for (int i=1; i <= 10; i++) { // get a roll and add that result to my array of random10Rolls
            random10Rolls.add(random.nextInt(20) + 1);
            /* Long-Hand Version:
                int roll = rand.nextInt(20)+1; //? Getting a roll result.
                random10Rolls.add(roll); //? adding the result to my array of random10Rolls.
            */
        }
        return random10Rolls;
    }
    /* //* getRandomLetter() √
        Todo: Write a method that will...
        ① Create an array within the method that contains all 26 letters of the alphabet (this array must have 26 values).
        ② Generate a random index between 0-25 and use it to pull a random letter out of the array.
        ③ Return the random letter.
    */
    public String getRandomLetterWithArray() {
        Random random = new Random();
        String alphabetString = "abcdefghijklmnopqrstuvwxyz";
        String[] alphabet = new String[26]; // Step 1
        
        for (int i=0; i<26; i++) {
            alphabet[i] = String.valueOf(alphabetString.charAt(i)); // Step 2
        }
        String randomLetter = alphabet[random.nextInt(26)]; // Step 3
        return randomLetter;
    }
    /* //* generatePassword() √ 
        Todo: Write a method that uses the previous method to create a random string of eight characters and return that string.
    */
    public String generatePassword() {
        String password = "";
        for(int i=0; i<8; i++) {
            password += getRandomLetterWithArray(); // runs previous method 8x to add a letter to emptyString
        }
        return password;
    }
    /* //* getNewPasswordSet() √
        Todo: Write a method that takes an int length as an argument and creates an array of random eight-character words. 
        The array should be the length passed in as an int. Return the array of passwords.
    */
    public ArrayList<String> getNewPasswordSet(int length) {
        ArrayList<String> passwordSet = new ArrayList<String>(); // dynamicArray
        
        for(int i=0; i<length; i++) {
            passwordSet.add(generatePassword());
        }
        return passwordSet;
    }
    /* //* 先生Bonus: suffleArray() √
        Todo: Write a method that takes an array and mixes up all the values in a pseudo-random way. 
        Hint: use random indexes within the array, and swap values repeatedly.
    */
    public void shuffleArray( int[] array ) { // method takes in int array as param, but bc of void it returns no value
        Random random = new Random();
        int n = array.length; // assigns length of inputArray; represents # of elements in this array
        
        for (int i=0; i < n; i++) {
            int randomIndex = random.nextInt(n);
            /* Breakdown of line70 
                ? Generates a random index within the array btwn 0(inclusive)
                ? and 'n'(exclusive) using `nextInt()` method of the `Random` class.
                ? `randomIndex` will be used to swap elements within the array
            */
            int tempArray = array[i]; //? `tempArray` = temporarily stores value at the current index
            array[i] = array[randomIndex]; //? `array[i]` = assigns the value at the random idx to the current idx `i`. It's swapping values btwn the 2 indices
            array[randomIndex] = tempArray; //? array[randomIndex] = is assigned the value stored in tempArray to the random idx, completing swapping operation by placing og value at random idx
        }
    }
}
