import java.util.Scanner;

public class AlfredTest {
    /* This main method will always be the launch point for a Java application
        For now, we are using the main to test all our
        AlfredQuotes methods.
    */
    
    public static void main(String[] args) {
        
        // * Setting up Scanner to expect User Input
        Scanner scanner = new Scanner(System.in);
        
        // Testing out Scanner
        System.out.println("To whom do I have the honor of assisting?");
        String name = scanner.nextLine();
        
        // Todo: Make an instance of AlfredQuotes to access all its methods.
        AlfredQuotes alfredBot = new AlfredQuotes();
        
        /*  Below alfredBot.guestGreeting() is using the variable, name, 
            that has the scanner and is being shared with the method */
        String greeting = alfredBot.guestGreeting(name);
        // System.out.println(greeting);
        
        
        
        // Todo: Make some test greetings, providing any necessary data
        String testGreeting = alfredBot.basicGreeting();
        String testGuestGreeting = alfredBot.guestGreeting( name, "evening" );
        String testDateAnnouncement = alfredBot.dateAnnouncement();
        String alexisTest = alfredBot.respondBeforeAlexis( "Alexis! Play some low-fi beats." );
        String alfredTest = alfredBot.respondBeforeAlexis( "I can't find my yo-yo. Maybe Alfred will know where it is." );
        String notRelevantTest = alfredBot.respondBeforeAlexis( "Maybe that's what Batman is about. Not winning. But failing.." );

        // * Print Test
        // System.out.println(testGreeting);
        
        System.out.println(testGuestGreeting);
        System.out.println(testDateAnnouncement);
        // System.out.println(alexisTest);
        // System.out.println(alfredTest);
        // System.out.println(notRelevantTest);
    }
}