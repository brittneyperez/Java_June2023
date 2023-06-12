# Alfred Bot

Bruce Wayne's loyal and tireless Butler and best friend, Alfred is getting ready to take some vacation time. He needs to program the Batcomputer to assume his duties through a fully robotic avatar. Although he has mastered numerous arts such as rose breeding, various fields of engineering, nanotechnology, and biotechnology, he doesn't feel like programming his own conversational responses. Therefore, he has contracted you to implement the AlfredQuotes library class. It must rival the "largely unhelpful Alexis", a talking home appliance that Master Wayne bought on Tropics, a large online retailer. To the bat-code!


### **`java.util`**
Throughout this course you will need to import classes from the java.util library. It contains many of the datatypes we will use later in the course like List, ArrayList, HashMap, as well as useful classes like Random and Date to generate pseudo-random numbers.

## `AlfredQuotes` Class File
Going forth, two files will be needed. First, you'll need an `AlfredQuotes`.java file that will hold all of the `AlfredQuotes` functionality. This is where you will do your coding for this assignment. You won't need to compile or run this file directly, as it will be compiled by the `AlfredTest.java` file. We will also only call/invoke `AlfredQuotes` methods from within the `AlfredTest.java` file which is provided.

```java
import java.util.Date;
public class AlfredQuotes {
    
    public String basicGreeting() {
        // You do not need to code here, this is an example method
        return "Hello, lovely to see you. How are you?";
    }
    
    public String guestGreeting(String name) {
        // YOUR CODE HERE
        return "placeholder for guest greeting return string";
    }
    
    public String dateAnnouncement() {
        // YOUR CODE HERE
        return "placeholder for date announcement return string";
    }
    
    public String respondBeforeAlexis(String conversation) {
        // YOUR CODE HERE
        return "for snarky response return string";
    }
    
	// NINJA BONUS
	// See the specs to overload the guestGreeting method
    // SENSEI BONUS
    // Write your own AlfredQuote method using any of the String methods you have learned!
}
```

### Test File
The methods that belong to the AlfredQuotes file do not execute automatically without the test file. For our Java assignments in this section going forward, you will have two files. But you will only need to compile and run the test file, which will compile the other file as well if there is an instance of that class in the test code. You do not need to alter the following file, although you may if you like.

```java
public class AlfredTest {
    /*
    * This main method will always be the launch point for a Java application
    * For now, we are using the main to test all our 
    * AlfredQuotes methods.
    */
    public static void main(String[] args) {
        // Make an instance of AlfredQuotes to access all its methods.
        AlfredQuotes alfredBot = new AlfredQuotes();
        
        // Make some test greetings, providing any necessary data
        String testGreeting = alfredBot.basicGreeting();
        String testGuestGreeting = alfredBot.guestGreeting("Beth Kane");
        String testDateAnnouncement = alfredBot.dateAnnouncement();
        
        String alexisTest = alfredBot.respondBeforeAlexis(
                            "Alexis! Play some low-fi beats."
                            );
        String alfredTest = alfredBot.respondBeforeAlexis(
            "I can't find my yo-yo. Maybe Alfred will know where it is.");
        String notRelevantTest = alfredBot.respondBeforeAlexis(
            "Maybe that's what Batman is about. Not winning. But failing.."
        );
        
        // Print the greetings to test.
        System.out.println(testGreeting);
        
        // Uncomment these one at a time as you implement each method.
        // System.out.println(testGuestGreeting);
        // System.out.println(testDateAnnouncement);
        // System.out.println(alexisTest);
        // System.out.println(alfredTest);
        // System.out.println(notRelevantTest);
    }
}
```

## Methods to be implemented:

### `GuestGreeting`

1. Tip: Try using the `String.format` method for string interpolation in Java.
    - **Description**:	Returns a greeting that includes the person's name.
    - **Inputs**:	String name
    - **Return Type**:	String
    - **Example Output**:	"Hello, Beth Kane. Lovely to see you."


### `dateAnnouncement`

- **Description**:	Returns a polite announcement of the current date and time.
- **Inputs**:	None
- **Return Type**:	String
- **Example Output**:	"It is currently Wed Aug 11 16:34:59 PDT 2022."


### `respondBeforeAlexis`
- Tip: Use the indexOf String method
- **Description**:	AlfredBot will periodically process audio (Alfred is listening.) Write a method that accepts any string of conversation and responds appropriately.
- **Specifications**:
    - If "Alexis" appears in the conversation (in the string) return a snarky response, such as, "Right away, sir. She certainly isn't sophisticated enough for that."
    - If "Alfred" is in the conversation return an obliging response, for example, "At your service. As you wish, naturally."
    - If neither name is found, return an appropriate response, for instance, "Right. And with that I shall retire."
        
        - **Inputs**:	String conversation
        - **Return Type**:	String


## Product Back Log (PBL) ~ Ninja Bonuses

1. Guest Greeting (Ninja Bonus Version!)
    - **Description**: Use method overloading to write another guestGreeting method that returns a greeting including the person's name as well as the day period. Note: It must have the same method name but will have a different method signature.
    - **Inputs**: String name, String `dayPeriod` ("morning", "afternoon" or "evening")
    - **Return Type**: String
    - **Example Output**: "Good evening, Beth Kane. Lovely to see you."
    - **SENSEI VERSION**: Instead of a string for the day period, write the overloaded method with no parameters, and use a Date object to determine the day period.
        - Hint: Use your google-kung-fu! You can use the `SimpleDateFormat` class and the Format class to help. Both are part of the `java.text` library. To the bat-documentation!


### Sensei Bonus

Write your own `AlfredQuote` method using any of the String methods you have learned! For example, maybe he sometimes yells when he's angry.
