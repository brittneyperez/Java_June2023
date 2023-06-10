import java.util.Date; // We'll be using Date from this library to request current time

public class AlfredQuotes {
    
    // Note: These greetings are not printed to the console,
    //       but returned as a String fo use in the testing file.
    
    public String basicGreeting() { // eaxmple method
        return "Hello, lovely to see you. How are you?";
    }
    
    /*
    Todo NINJA BONUS: See the specs to overload the guestGreeting method
        Using Scanner in the Test file, I'm practicing overloading methods
        and passing variables so Alfred knows how to address the guest. */
    public String guestGreeting(String name) {
        return "Hello, " + name + "! How can I assist you today?";
    }
    
    /* Inputs: String name, String — assume "morning", "afternoon", or "evening".
        Return Type: String
        Output: Returns a greeting Alfred might say,
                That includes the person's name in the greeting. */
    public String guestGreeting(String name, String dayPeriod) {
        return String.format("Good %s, " + name + ". Lovely to see you.", dayPeriod, name);
    }
    
    /* Inputs: None
        Return Type: String
        Output: Returns an announcement of the current date. */
    public String dateAnnouncement() {
        return String.format("It is currently %s", new Date());
    }
    
    /* Input: String (Any Phrase)
        Return Type: String
        Output: A response (String) */
    public String respondBeforeAlexis(String conversation) {
        
        // the -1 is to test if whatever is in the indexOf exists
        if (conversation.indexOf("Alexis") > -1) {
            return "She's really of no help. What can I get for you?";
        }
        if (conversation.indexOf("Alfred") > -1) {
            return "At your service, naturally. How may I be of assistance?";
        }
        
        return "Right. And with that I shall retire.";
    }
    
    
    // SENSEI BONUS
    // Write your own AlfredQuote method using any of the String methods you have learned!
}