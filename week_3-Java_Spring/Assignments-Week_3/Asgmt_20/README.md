# Daikichi Path Variables

This Java Spring project demonstrates the use of path variables in handling HTTP requests. Path variables allow dynamic values to be extracted from the URL and used in the controller methods.

### Path Variables in Java Spring

Path variables are placeholders in the URL that can be replaced with actual values. In Java Spring, path variables are denoted by curly braces `{}` in the request mapping. They allow capturing dynamic parts of the URL and passing them as method parameters.

### Using `@RequestMapping("/daikichi")` to Limit Repeating Route

The `@RequestMapping` annotation is used to map URLs to controller methods. By specifying `@RequestMapping("/daikichi")` at the class level of the **DaikichiController**, it establishes a base URL prefix for all the routes defined within the class. This means that routes defined within this class will be appended to the base URL [/daikichi](#), reducing the repetition of writing the base URL for each method.

## Routes and Logic

1. **Welcome Route:**
    
    - HTTP GET request: [http://localhost:8080/daikichi](#)
    - Description: This route returns a welcome message for the Daikichi Path Variables project.
    - Logic: The `welcome()` method is invoked, which simply returns the welcome message.

2. **Travel Route:**
    
    - HTTP GET request: [http://localhost:8080/daikichi/travel/{cityVariable}](#)
    - Description: This route takes a string input for the `cityVariable` path variable and displays a congratulatory message for the provided city.
    - Logic: The `travel(String city)` method is invoked, which captures the cityVariable path variable using `@PathVariable` and formats a congratulatory message using `String.format()`. The message is then returned.

3. **Lotto Route:**
    
    - HTTP GET request: [http://localhost:8080/daikichi/lotto/{number}](#)
    - Description: This route takes an integer input for the number path variable and returns different messages based on whether the number is even or odd.
    - Logic: The `lotto(int number)` method is invoked, which captures the number path variable using `@PathVariable`. It checks if the number is even or odd using the modulo operator `%` and returns the corresponding message.
