public class Greeter {
    //* Parts of a Method Review:
    //? Modifier ReturnType MethodName MethodParameters { MethodBody }
    //  public    String       method( int[] array  ) {}
    
    public String greet() {
        return createGreeting("World");
    }
    
    public String greet( String name ) {
        return createGreeting(name);
    }
    
    public String greet( String firstName, String lastName ) {
        return createGreeting(firstName + " " + lastName);
    }
    
    /* Why make anything private in the first place?
        The "private" access modifier is only available within the method file unlike those with a public modifier
        Private is good for encapsulating our logic and be sure that the class follows a specific procedure
        Public is the default access modifer in cases it's not declared.
    */
    /* Why are return types needed?
        They ensure that we are controlling the right dataType.
        e.g., If we set the returnType to be an int but return a String,
        it will stop running the code to let us know that the wrong type is being returned.
    */
    /* Conventions for Methods:
        Methods are to be written as an action--or a verb(i.e., sayHello, isReady) as a boolean.
        It has to describe what the code will be doing and ease the flow of a program.
    */
    private String createGreeting( String toBeGreeted ) {
        return "Hello " + toBeGreeted + "! Welcome to Coding Dojo!";
    }
    
    /* What is a static modifier?
        This is mostly used in a main method where we test our code.
        It is not an access modifier for this reason.
        It's role is to tell us that the method is a class method, and not an Instance Method.
        A class doesn't need to be instantiated to be made.
    */
    /* Testing Static Modifier 
    public static void testGreeting( String name ) {
        ? void = cannot return anything
        System.out.println(name + ", this is a test of a static method.");
    }
    */
}
