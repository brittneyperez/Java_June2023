# Puzzling

### Synopsis
After you passed the first challenge, the company decided they wanted to give you a few puzzles to solve that apply to features the company uses in their client-side operations. As they put it: "The first challenge was just to check your familiarity with the language, now we want to see your problem-solving skills."

For this assignment, we are going to use a new class: `Random` to generate random values.

---
## Implemented Methods

Two files will be needed: `PuzzleJava` and `TestPuzzleJava`. Under the class name `PuzzleJava`, we will need to create methods for each of the tasks below and test them in the `main` method in a the `TestPuzzleJava` file.

- Tip: To get a random integer, you can use the `nextInt` method of the `Random` class. **[Random Class documentation](https://docs.oracle.com/javase/8/docs/api/java/util/Random.html)**. Here's some example code for using the Random library to get started.

```java
// You will need to import the Random library from java.util
import java.util.Random;

// To use methods from the Random library you will need to create an instance of Random
Random randMachine = new Random();
// From there you can use any of the methods listed in the documentation. For example:
randMachine.setSeed(35679); // <--- you won't need to use this method.
```

1. **`getTenRolls`**
    
    Write a method that will generate and return an array with 10 random numbers between 1 and 20 inclusive.
    
2. **`getRandomLetter`**
    
    Write a method that will:
    
    1. Create an array within the method that contains all 26 letters of the alphabet (this array must have 26 values).
    2. Generate a random index between 0-25 and use it to pull a random letter out of the array.
    3. Return the random letter.
	
	Note: In the code, an array is used but it is possible to achieve the same result without the use of an array:
	```java
	public String getRandomLetter() {
		Random rand = new Random();
		String alphabetString = "abcdefghijklmnopqrstuvwxyz";
		char randomChar = alphabetString.charAt(rand.nextInt(26));
		
		return String.valueOf(randomChar);
	}
	```
    
3. **`generatePassword`**
    
    Write a method that uses the previous method to create a random string of eight characters and return that string.
	
	Note: In the code, an array is used but it is possible to achieve the same result without the use of an array:
	```java
	public String generatePassword() {
		StringBuilder password = new StringBuilder();
		for (int i = 0; i < 8; i++) {
			String randomLetter = getRandomLetterWithArray();
			password.append(randomLetter);
		}
		return password.toString();
	}
	```
	In situations where you need to concatenate multiple strings in a loop or performance-critical scenarios, using `StringBuilder` or `StringBuffer` is recommended. These classes provide a mutable sequence of characters and allow efficient string concatenation by appending strings using the append() method.
    
4. **`getNewPasswordSet`**
    
    Write a method that takes an `int` length as an argument and creates an array of random eight-character words. The array should be the length passed in as an `int`. Return the array of passwords.
    

---

## Sensei Bonus

**`shuffleArray`**

Write a method that takes an array and mixes up all the values in a pseudo-random way. Hint: use random indexes within the array, and swap values repeatedly.

---

Here's a test file to get you started. But you will need to create your own `PuzzleJava` class file.

```java
import java.util.ArrayList;
import java.util.Random;

public class TestPuzzleJava {

	public static void main(String[] args) {
		PuzzleJava generator = new PuzzleJava();
		ArrayList<Integer> randomRolls = generator.getTenRolls();
		System.out.println(randomRolls);
    	        //..
		// Write your other test cases here.
		//..
	}
}
```