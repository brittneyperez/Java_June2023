# Cafe Business Logic

Now that you've familiarized yourself with Java a bit, you decided you really wanted to try and find an internship working on Cafe Java's dev team. After applying, you were sent descriptions of requested behavior for each of the methods needed for creating the CafeUtil library for their application, as well as some sample test cases.


## `CafeUtil` File and `TestCafe` File

For this assignment you will have two files, `CafeUtil.java` and `TestCafe.java`. You will be writing all your methods inside the `CafeUtil` class. The second file is a test file, `TestCafe.java` that includes the main method. We have provided the code in its entirety for testing, and you can copy and paste from it from the bottom of this module, but be sure to instantiate your class in the testing file!


## In `CafeUtil.java`

Implement the four methods below. Important: Code all of the following methods in your `CafeUtil.java` file.

### **`int getStreakGoal()`**

Cafe Java wants to implement a reward system for customers who always buy more drinks than they did the week before. To calculate how many drinks they need after 10 weeks, write a method that sums together every consecutive integer from 1 to 10 and returns the sum. In other words, add 1 + 2 + 3.. and so on up to 10 and return the result.

Test your code before moving on! Don't forget to make an instance of your CafeUtil class to use in the test file. The number printed should be 55.

**Ninja Bonus**: Add a parameter, numWeeks so that an admin can change the number from 10 to whatever they want.


### **`double getOrderTotal(double[] prices)`**

Given an array of item prices from an order, sum all of the prices in the array and return the total.

Don't forget to test your code! Find the lines of test code for this method in `TestCafe.java` and uncomment it before you compile and run.


### **`void displayMenu(ArrayList <String>  menuItems)`**

Given an ArrayList of menu items (strings), print out each index and menu item.

Sample output given an ArrayList with the items "drip coffee", "cappuccino", "latte" and "mocha"

```bash
    0 drip coffee
    1 cappuccino
    2 latte
    3 mochacopy
```

**Re-cap of ArrayList Syntax**:
```java
String name = myArray.get(0); // to access an element in an ArrayList using an index
```


### **`addCustomer(ArrayList<String> customers)`**

Inside this method:

1. Print this string to the console: "Please enter your name:"
2. Then add this line of code to get user input from the terminal and store it in the variable `userName`:

    ```java
    String userName = System.console().readLine();
    ```

3. Next print the userName to the console, saying "Hello, [user name here]!"
4. Next print "There are ___ people in front of you" using the number for how many people are ahead of them (how many items already in the array)
5. Then, add the customer's name to the given customers list. And print the list.
6. No need to return anything.


**Re-cap of ArrayList Syntax:**
```java
myArray.add("Heidi"); // to add an item to an ArrayList
```



## How to Test: Test Early and Test Often

Write and test each method one at a time. A good strategy for developing software is to code only a little and test. As they say, "Test early and test often." Go ahead and use the following code in your TestCafe.java file to test your methods by uncommenting the method you are testing. Test one at a time.

*Note*: // are for single line comments and /* ...comments... */ are for multi-line comments.

```java
import java.util.ArrayList;
import java.util.Arrays;
public class TestCafe {
    public static void main(String[] args) {
        
    /* 
        You will need add 1 line to this file to create an instance 
        of the CafeUtil class. 
        Hint: it will need to correspond with the variable name used below..
    */
    	
        /* ============ App Test Cases ============= */
    
        System.out.println("\n----- Streak Goal Test -----");
        System.out.printf("Purchases needed by week 10: %s \n\n", appTest.getStreakGoal());
    
        // System.out.println("----- Order Total Test-----");
        // double[] lineItems = {3.5, 1.5, 4.0, 4.5};
        // System.out.printf("Order total: %s \n\n",appTest.getOrderTotal(lineItems));
        
        // System.out.println("----- Display Menu Test-----");
        
        // ArrayList<String> menu = new ArrayList<String>();
        // menu.add("drip coffee");
        // menu.add("cappuccino");
        // menu.add("latte");
        // menu.add("mocha");
        // appTest.displayMenu(menu);
    
        // System.out.println("\n----- Add Customer Test-----");
        // ArrayList<String> customers = new ArrayList<String>();
        // // --- Test 4 times ---
        // for (int i = 0; i < 4; i++) {
        //     appTest.addCustomer(customers);
        //     System.out.println("\n");
        // }
    }
}
```
`TestCafe.java`


