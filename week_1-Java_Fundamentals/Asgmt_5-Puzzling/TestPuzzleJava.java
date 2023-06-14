import java.util.ArrayList;
// import java.util.Random;
import java.util.Arrays;

public class TestPuzzleJava {
	public static void main(String[] args) {
		PuzzleJava generator = new PuzzleJava(); //? creating an instance of PuzzleJava methods file.
		
		ArrayList<Integer> randomRolls = generator.getTenRolls(); //? calls a method on that instance to obtain an ArrayList of random numbers.
		System.out.println(randomRolls); //? This will produce an array of 10 random numbers. Everytime the file runs, it will return a different set of 10 numbers.
		System.out.println("Random Letter: " + generator.getRandomLetterWithArray());
		System.out.println("Simple Password: " + generator.generatePassword());
		System.out.println("Newly Generated Passwords: " + generator.getNewPasswordSet(4));
		
		//* 先生Bonus: shuffleArray()
		int[] numbersArray = {1,2,3,4,5}; //? this array will be passed into the shuffleArray method
		generator.shuffleArray(numbersArray);
		System.out.println(Arrays.toString(numbersArray));
	}
}