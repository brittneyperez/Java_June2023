### Week 3 Day 9 | Source Code

# PokéAPIController | Office Hour

This file contains a PokéAPI controller that interacts with the PokéAPI to retrieve information about Pokémon and their types. The controller defines several endpoints to query the PokéAPI using different parameters.

### Concepts Covered

- `@RestController`: Annotates the controller class to indicate that it's a RESTful controller.
- `@GetMapping`: Maps HTTP GET requests to specific methods in the controller.
- `@RequestParam`: Binds a request parameter to a method parameter.
- `@PathVariable`: Binds a path variable to a method parameter.
- `RestTemplate`: A class provided by Spring Framework to make HTTP requests to external APIs.

## Routes and Functionality

1. **GET [/api/test](#)**

   This endpoint is used for testing purposes. It returns a string "Testing... 1, 2, 3!" as well as prints it to the console.

2. **GET [/api?pokemonName={pokeName}](#)**

   This endpoint retrieves information about a Pokémon by its name. The `pokemonName` query parameter specifies the name of the Pokémon. The controller sends an HTTP GET request to the PokéAPI, retrieves the data for the specified Pokémon, and returns it as a string.

3. **GET [/api/{pokeID}](#)**

   This endpoint retrieves information about a Pokémon type by its ID. The `pokeID` path variable specifies the ID of the Pokémon type. The controller sends an HTTP GET request to the PokéAPI, retrieves the data for the specified Pokémon type, and returns it as a string.

4. **GET [/api/{segmentOne}/{segmentTwo}](#)**

   This endpoint retrieves information based on two path variables. The `segmentOne` path variable specifies the specificity of the information (e.g., "pokemon", "ability"), and the `segmentTwo` path variable specifies the name or type (e.g., "charmandar", "fire"). The controller sends an HTTP GET request to the PokéAPI, retrieves the data based on the specified segments, and returns it as a string.

---

# Spring Intro Project: Session, Routes, Flash, Redirect, GET & POST | Lecture

This Java Spring project implements a web application that counts and increments a value using session management. It consists of multiple routes defined in the `SessionController` class and a JSP view file called `counter.jsp`.

### Concepts Covered

- `@Controller`: Annotates the class as a controller component.
- `@RequestMapping`: Maps HTTP requests to specific methods.
- `@GetMapping` and `@PostMapping`: Map HTTP GET and POST requests to methods, respectively.
- `@RequestParam`: Binds request parameters to method parameters.
- `@PathVariable`: Binds path variables to method parameters.
- `HttpSession`: Provides a way to store session data.
- `RedirectAttributes`: Helps to add flash attributes for redirect scenarios.
- JSP: A Java-based technology used for creating dynamic web pages.

## Routes and Functionality

1. **GET [/counting](#)**

   This route renders the `counter.jsp` view, which shows the current count value stored in the session. If the count is not set in the session, it initializes it to 0. The page also provides a form to add a player and increment the count.

2. **POST [/counting/clear](#)**

   This route clears the session count value by removing it from the session. After clearing the session, it redirects back to the `/counting` route.

3. **POST [/counting/increment/`{userId}`](#)**

   This route increments the count value stored in the session. It requires the `playerName` and `amount` as request parameters to identify the player and specify the amount to increment. If the `amount` is not provided, it adds an error message to the flash attributes and redirects back to the `/counting` route. After incrementing, it redirects to the `/counting/pretendRedirect/{userId}` route.

4. **GET [/counting/pretendRedirect/`{newPathVar}`](#)**

   This route receives the `newPathVar` value from the previous redirect and prints it to the console. It serves as an example to demonstrate the flow of data between routes.

### Flow of Data
For **`count`**:
1. The **`count`** value is retrieved from the session and displayed in the **counter.jsp** view.

For **`userId`**:

2. In the `SessionController.java` file, within the `index()` method, the **`userId`** is set as a model attribute with a hardcoded value of 88:
    ```java
    model.addAttribute("userId", 88);
    ```
    This value is defined in the controller and can now be accessed in the `counter.jsp` file.

2. In the `counter.jsp` file, the `userId` attribute is used within a form's action attribute to specify the route for the form's POST method:
    ```html
    <form action="/counting/increment/${userId}" method="POST">
    ```
    Here, the `userId` attribute is accessed as a path variable in the form's action, and it will be replaced with the value specified in the `userId` model attribute when the form is submitted.

3. Back in the `SessionController.java` file, the `userId` is received as a path variable in the `incrementBy()` method:
    ```java
    @PathVariable("userId") Integer incomingId
    ```
    This means that when the form is submitted, the value specified in the `userId` path variable will be assigned to the `incomingId` variable.

4. Step 4: In the same `incrementBy()` method, the `incomingId` variable is used in the redirect route:
    ```java
    return String.format("redirect:/counting/pretendRedirect/%s", incomingId);
    ```
    The value of `incomingId` is included in the redirect route as a path variable, which will be passed to the `redirectMethod()`.

    5. Finally, in the `redirectMethod()` within the `SessionController.java` file, the value of the path variable is accessed and printed:
    ```java
    System.out.println(localVariable);
    ```
    This will print the value of the `userId` passed from the previous step.

In summary, the `userId` starts as a model attribute in the `SessionController` and is made available in the `counter.jsp` file. It is then used as a path variable in the form's action, received in the `incrementBy()` method, passed as a path variable in the redirect route, and finally accessed and printed in the `redirectMethod()`.