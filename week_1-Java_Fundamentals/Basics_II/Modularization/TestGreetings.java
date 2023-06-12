public class TestGreetings {
    
    public static void main(String[] args) {
        // * This is our launching point, where we will bring methods from different files
        // We will not be writing methods here
        
        // * Dependency Injections = creating an instance of another class using varibles
        // Type variableName = newObjectInstance classReference();
        Greetings greeterApp = new Greetings(); // our instance
        // The file we are referring to will also be compiled when we compile this one.
        
        //                 =ourVariable.method();
        String dateMessage = greeterApp.getCurrentDate();
        System.out.println(dateMessage);
    }
}
