package controllers;

import classes.Animal;
import classes.Deer;
import classes.Frog;

public class AnimalController { // only one class per file

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Animal animal1 = new Animal();
//		System.out.println(animal1.getName());
//		System.out.println("Animal Count: "+ Animal.getAnimalCount()); // 1
//		animal1.display();
		
		Frog frog1 = new Frog("Kermit");
//		System.out.println("Animal Count: "+ Animal.getAnimalCount()); // 2
//		System.out.println("Frog Count: "+ Frog.getFrogCount()); // 1
//		System.out.println("Frog Name: "+ frog1.getName());
		
//		frog1.display();
//		frog1.jump();
//		frog1.jump();
//		frog1.jump();
		frog1.move("swim");
		frog1.move("jump");
//		frog1.move("jump");
		frog1.eat(5);
//		frog1.display();
		
		System.out.println("");
		
		Deer deer1 = new Deer("Bambi");
//		deer1.display();
//		deer1.run();
//		deer1.run();
//		deer1.run();
		deer1.move("run");
		deer1.move("run");
		deer1.move("run");
		deer1.eat(5);
//		deer1.display();
//		deer1.move("run");
	}
}
