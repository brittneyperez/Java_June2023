public class GreeterTest {
    
    public static void main(String[] args) {
        // Greeter.testGreeting("Bri"); // Bri, this is a test of a static method.
        //? Without having to instantiate the method, we can compile and print to console what we want to see.
        
        Greeter command = new Greeter();
        
        String greeting = command.greet();
        // String greetingWithName = command.greet("Bri"); // Hello Bri! Welcome to Coding Dojo!
        // String greetingWithName = command.greet("Minnie", "Mouse"); // Hello Minnie Mouse! Welcome to Coding Dojo!
        String greetingWithName = command.greet(); // Hello World! Welcome to Coding Dojo!
        System.out.println(greetingWithName); 
    }
}
