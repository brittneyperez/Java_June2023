# Zookeeper

### Synopsis

A zookeeper has asked for your help creating a way for her to track her animals' energy levels. In particular, she is having difficulty tracking the mammals. Every mammal should have an energy level (default 100). They should all be able to display their energy levels when asked through the `displayEnergy` method, which should print and return the energy level.

Once this is done, she has asked that you also create a separate class of gorilla, which can throw things at people but will lose energy (`-5`) whenever this is done. The gorilla should also be able to `eatBananas` and regain energy (`+10`). The gorilla should also be able to climb at the expense of energy (`-10`).

She asks that you demonstrate that the class works as expected by having the gorilla throw things 3 times, eat bananas twice and climb once; then print the gorilla's energy level.

The zookeeper has also captured a rare specimen. Its default energy is much higher than most mammals, its energy level is 300. It also can do a lot more than climb - it can fly. Moreover, this specimen doesn't eat bananas, it eats humans... and it doesn't throw things, but attacks towns. The zookeeper has caught a giant Bat and wants your help to track its energy levels.

The bat should be tested by **attacking three towns**, **eating two humans**, **flying twice**, and then **displaying its energy**. Use the display energy from the superclass!

## Overview of Each Class/File

### **`Mammal` Class**
The `Mammal` class serves as a base class for mammals and contains the following:

- `energyLevel` (protected int): Represents the energy level of the mammal.
- `Mammal(int energyLevel)`: Constructor to create a mammal object with the specified energy level.
- `displayEnergy()`: Method to display and return the energy level of the mammal.

### **`Gorilla` Class**
The `Gorilla` class is a subclass of `Mammal` and represents a gorilla. It inherits the attributes and methods from the `Mammal` class and includes the following additional methods:

- `Gorilla(int energyLevel)`: Constructor to create a gorilla object with the specified energy level.
- `throwSomething()`: Prints a message indicating that the gorilla has thrown something and decreases its energy level by 5.
- `eatBananas()`: Prints a message indicating the gorilla's satisfaction and increases its energy level by 10.
- `climb()`: Prints a message indicating that the gorilla has climbed a tree and decreases its energy level by 10.

### **`GorillaTest` Class**
The `GorillaTest` class contains the `main` method and is used to test the functionality of the `Gorilla` class. It creates a `Gorilla` object, performs various actions (such as throwing something, eating bananas, and climbing), and displays the energy level after each action.

### **`Bat` Class**
The `Bat` class is a subclass of `Mammal` and represents a bat. It inherits the attributes and methods from the `Mammal` class and includes the following additional methods:

- `Bat()`: Constructor to create a bat object with a fixed energy level of 300.
- `fly()`: Prints the sound of a bat taking off and decreases its energy level by 50.
- `eatHumans()`: Prints the sound of people screaming and increases the bat's energy level by 25.
- `attackTown()`: Prints the sound of a town on fire and decreases the bat's energy level by 100.

### **`BatTest` Class**
The `BatTest` class contains the `main` method and is used to test the functionality of the `Bat` class. It creates a `Bat` object, performs various actions (such as attacking a town, eating humans, and flying), and displays the energy level after each action.

Note: The classes `Mammal`, `Gorilla`, `GorillaTest`, `Bat`, and `BatTest` should be defined in separate files with the same names and the `.java` extension.