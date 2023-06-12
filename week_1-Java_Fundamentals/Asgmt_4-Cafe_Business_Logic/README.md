# Cafe Business Logic

### **Synopsis**
Now that you've familiarized yourself with Java a bit, you decided you really wanted to try and find an internship working on Cafe Java's dev team. After applying, you were sent descriptions of requested behavior for each of the methods needed for creating the CafeUtil library for their application, as well as some sample test cases.


## `CafeUtil` and `TestCafe` File

For this assignment you will have two files, CafeUtil.java and TestCafe.java. All methods will be written inside the CafeUtil class. The second file is a test file, TestCafe.java that includes the main method. 


## Methods to be implemented

1. `int getStreakGoal()`

    Cafe Java wants to implement a reward system for customers who always buy more drinks than they did the week before. To calculate how many drinks they need after 10 weeks, write a method that sums together every consecutive integer from 1 to 10 and returns the sum. In other words, add 1 + 2 + 3.. and so on up to 10 and return the result.
    
    Ninja Bonus: Add a parameter, numWeeks so that an admin can change the number from 10 to whatever they want.

2. `double getOrderTotal(double[] prices)`
    
    Given an array of item prices from an order, sum all of the prices in the array and return the total.
    
3. `void displayMenu(ArrayList<String> menuItems)`

    Given an ArrayList of menu items (strings), print out each index and menu item. Sample output given an ArrayList with the items "dripCoffee", "cappuccino", "latte", and "mocha".
    ```
    0 drip coffee
    1 cappuccino
    2 latte
    3 mocha
    ```
 
4. `addCustomer(ArrayList<String> customers)`

    Inside this method:
    
    - Print this string to the console: "Please enter your name:"
    - Then add this line of code to get user input from the terminal and store it in the variable userName:
        ```
        String userName = System.console().readLine();
        ```
    - Next print the userName to the console, saying "Hello, [user name here]!"
    - Next print "There are ___ people in front of you" using the number for how many people are ahead of them (how many items already in the array)
    - Then, add the customer's name to the given customers list. And print the list.
    (No need to return anything.)




### Ninja Bonuses

1. `void printPriceChart(String product, double price, int maxQuantity)`
    
    Given a product, price and a maxQuantity, create a method that prints the cost for buying 1, then the price for buying 2, then for 3.. and so on, up to the max. For example, if the product is "Columbian Coffee Grounds" with a price of 15.0 and maxQuantity of 3, you should print:
    ```
    Columbian Coffee Grounds
    1 - $15.00
    2 - $30.00
    3 - $45.00
    ```
    Tip: You can use the escape character \\n within your string for line breaks.


    - **Sensei bonus**: Format the prices as currency. Hint: **https://docs.oracle.com/javase/tutorial/java/data/numberformat.html**

    - **Senpai Bonus**: Take $0.50 more off of the original price every time the quantity increases.
        
        Example: Given a $2.00 price and 4 max, where the prices would normally be $2, $4, $6 and $8, the discount would yield $2, $3.50, $5, and $6.50, progressively taking off $0.50, then $1, then $1.50 from the group tag price:
        ```
        1 - $2.00
        2 - $3.50
        3 - $5.00
        4 - $6.50
        ```



2. `boolean displayMenu(ArrayList<String> menuItems, ArrayList<Double> prices)`
    
    - Let's overload the display menu! Given 2 arrays, an ArrayList of menu items (strings), and an ArrayList of prices (doubles) print a menu!
    
    - However, first check: if the arrays are not the same size, immediately return false.

    - To print the menu, iterate from 0 to the last index. Each time through, print on the same line:
        - a.) The index,
        - b.) The menu item at that index, and
        - c.) The price at that index.
    
    - Finally, return true.

    - Sample output:
        ```
        0 drip coffee -- $1.50
        1 cappucino -- $3.50
        2 latte -- $4.50
        3 mocha -- $3.50
        ```


### Sensei Bonus

Make a method `addCustomers` where a barista can enter multiple customers. Hint: You can use a while loop and ask the user to type "q" when they are finished entering names.