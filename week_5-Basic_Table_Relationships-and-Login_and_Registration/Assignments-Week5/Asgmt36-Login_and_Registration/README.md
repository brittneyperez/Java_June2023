# Login & Registration

### Overview

<!-- **Dojos & Ninjas** is a Java Spring project designed to track ninjas and the dojos they're being trained in. The project follows the MVC (Model-View-Controller) architecture to manage and display dojo and ninja data through JSP (JavaServer Pages) for the view layer. -->

The **LoginAndRegistration** project is a Java Spring application that provides user authentication and registration functionality. It allows users to create an account, log in, and access their personalized dashboard. The project implements server-side validations, password hashing using BCrypt, and the option to log in with either an email or username. This README provides an overview of the project structure, file descriptions, and highlights the newly added feature of logging in with a username. It serves as a guide for understanding the purpose of each file and how they contribute to the overall functionality of the application.

## Configuration

<details>
<summary>Database and View Configuration</summary>

1. `spring.datasource.url=jdbc:mysql://localhost:3306/java-login-registration?createDatabaseIfNotExist=true`: This line specifies the URL for connecting to the MySQL database. The URL indicates that the database is located on `localhost` at port `3306` and its name is `java-login-registration`. The `createDatabaseIfNotExist=true` parameter instructs the system to create the database if it doesn't already exist.

2. `spring.datasource.username=root`: This line specifies the username to be used when connecting to the database. In this case, it is set to `root`.

3. `spring.datasource.password=rootroot`: This line specifies the password associated with the username used to connect to the database. In this case, the password is set to `rootroot`.

4. `spring.jpa.hibernate.ddl-auto=update`: This line configures the behavior of Hibernate, the ORM (Object-Relational Mapping) framework used by Spring Data JPA. The `ddl-auto` property controls the automatic generation and update of database schema. In this case, it is set to `update`, which means that Hibernate will update the schema based on the entity classes defined in your project.

5. `spring.mvc.view.prefix=/WEB-INF/`: This line configures the prefix for resolving view templates in Spring MVC. It indicates that the view templates are located in the `/WEB-INF/` directory.

6. `spring.mvc.hiddenmethod.filter.enabled=true`: This line enables the hidden method filter in Spring MVC. This filter allows you to use the hidden input field technique for submitting forms with methods other than GET and POST, such as DELETE or PUT.

These configuration properties define various aspects of the Java Spring application, **Dojos-and-Ninjas**, including the database connection, ORM behavior, and view resolution settings.
</details>

<details>
<summary>Dependencies</summary>

A brief explanation of each dependency in the `pom.xml` file:

1. `spring-boot-starter-data-jpa`: This dependency includes the necessary libraries and configurations for using Spring Data JPA, which simplifies database access and ORM (Object-Relational Mapping) with JPA (Java Persistence API).

2. `spring-boot-starter-web`: This dependency provides the essential components for building web applications with Spring, including the embedded web server, Spring MVC, and other web-related features.

3. `spring-boot-devtools`: This dependency enables development-time features, such as automatic application restart and hot swapping of code changes, to enhance developer productivity.

4. `mysql-connector-j`: This dependency allows connectivity to a MySQL database using JDBC (Java Database Connectivity), enabling your application to interact with the MySQL database server.

5. `spring-boot-starter-tomcat`: This dependency provides the embedded Apache Tomcat server, which allows you to deploy and run your Spring application as a standalone web server.

6. `spring-boot-starter-test`: This dependency includes testing frameworks and libraries for unit and integration testing of Spring applications.

7. `jakarta.servlet.jsp.jstl-api`: This dependency provides the Jakarta Standard Tag Library (JSTL) API, which enables the usage of JSP (JavaServer Pages) tags in your application.

8. `jakarta.servlet.jsp.jstl`: This dependency includes the implementation of the JSTL tags, allowing you to use them in your JSP pages.

9. `tomcat-embed-jasper`: This dependency provides support for using JSP files with the embedded Tomcat server.

10. `jbcrypt`: This dependency is a Java implementation of the bcrypt hashing algorithm, which is commonly used for secure password hashing.

11. `spring-boot-starter-validation`: This dependency includes the necessary libraries for validating and enforcing constraints on domain models using annotations like `@NotNull`, `@Size`, etc.

12. `webjars-locator`: This dependency is a utility for locating and managing WebJar assets, which are client-side libraries packaged as JAR files.

13. `bootstrap`: This dependency includes the Bootstrap framework, which provides CSS and JavaScript components for creating responsive and visually appealing web interfaces.

These dependencies provide the necessary functionality and libraries for developing a Java Spring application with Spring Data JPA, web capabilities, database connectivity, testing support, JSP usage, password hashing, validation, and integration of Bootstrap for front-end styling and components.
</details>


## Models, Repository and Service

### The Models: **`User.java`** and **`LoginUser.java`**

1. **User.java**: This file represents the model for a user in the application. It is annotated with `@Entity` to indicate that it is an entity to be persisted in the database. It contains member variables corresponding to user attributes such as `id`, `firstName`, `lastName`, `email`, `username`, `password`, and `confirmPassword`. The class includes annotations for validation, such as `@NotEmpty`, `@Size`, `@Email`, and `@Pattern`, which define the validation rules for each attribute. Additionally, there are annotations and methods for date fields (`createdAt` and `updatedAt`) to handle the persistence lifecycle.

2. **LoginUser.java**: This file represents the validator model for the login functionality. It contains member variables `loginCredential` and `password`, which correspond to the login form fields. The class includes annotations for validation, such as `@NotEmpty` and `@Size`, to enforce validation rules for the login form. This class is used for validating the login credentials provided by the user during the login process.

These files play a crucial role in the **LoginAndRegistration** project. `User.java` defines the structure and validation rules for the user model, while `LoginUser.java` provides the validation rules for the login form. Together, they enable the application to store and validate user information, allowing users to register, log in, and perform various authentication-related operations.

---

### The Repository: **`UserRepository.java`**

The `UserRepository` interface extends the `CrudRepository` interface provided by Spring Data. It allows the application to perform CRUD operations on the `User` entity. The repository includes the following additional methods specific to the user model:
- `findAll()`: Retrieves all users from the database.
- `findByEmail(String email)`: Retrieves a user by their email.
- `findByUsername(String username)`: Retrieves a user by their username.

These methods are used to query the database and retrieve user information based on specific criteria.

### The Service: **`UserService.java`**

The `UserService` class is a service component responsible for handling the business logic related to user operations. It interacts with the `UserRepository` to perform database operations and provides additional functionalities. The class includes the following methods:

1. `findUserById(Long id)`: Retrieves an existing user by their ID. It calls the `findById()` method of the `UserRepository` to retrieve the user from the database.

2. `registerUser(User newUser, BindingResult result)`: Registers a new user in the system. It performs various validations using `BindingResult` and checks if the email and username provided by the user already exist in the database. If the validations pass, it hashes the user's password using BCrypt and saves the user to the database using the `UserRepository`.

3. `loginUser(LoginUser newLoginObject, BindingResult result)`: Authenticates a user based on the provided login credentials (email/username and password). It first checks if the login credential is an email and searches for a user with the given email in the database. If not found, it searches for a user with the given username. If a user is found, it compares the hashed password with the provided password using BCrypt. If the credentials are valid, it returns the user; otherwise, it adds an error message to the `BindingResult`.

The new feature added to the `loginUser` method is the ability to authenticate a user using their username. If the provided login credential is not an email, it searches for a user with the given username in the database and performs the password validation. This allows users to log in using either their email or username, providing flexibility in the authentication process.


## The Controller: **`MainController.java`**

In the **`MainController`** class, the controller methods handle the HTTP requests and define the behavior for each request. Here's a summary of the role of each method:

1. The `index` method handles the GET request for the root URL ("/authenticate") and renders the index.jsp view. It adds a new user object (`newUser`) and a login user object (`loginUser`) to the model.

2. The `register` method handles the POST request for the "/authenticate/register" URL. It receives the form data from the registration form (`registeringUser`) and performs user registration by calling the `registerUser` method of the `UserService`. If there are validation errors (`result.hasErrors()`), it adds the necessary attributes to the model and returns to the index.jsp view. If the registration is successful, it sets the user ID in the session and redirects to the "/authenticate/home" URL.

3. The `login` method handles the POST request for the "/authenticate/login" URL. It receives the form data from the login form (`newLogin`) and performs user login by calling the `loginUser` method of the `UserService`. If there are validation errors (`result.hasErrors()`), it adds the necessary attributes to the model and returns to the index.jsp view. If the login is successful, it sets the user ID in the session and redirects to the "/authenticate/home" URL.

4. The `home` method handles the GET request for the "/authenticate/home" URL. It retrieves the user ID from the session, uses the `findUserById` method of the `UserService` to get the user object, and adds it to the model. It renders the dashboard.jsp view, which displays the user's information.

5. The `logout` method handles the GET request for the "/authenticate/logout" URL. It invalidates the session and redirects to the root URL ("/").

## The Views: **`index.jsp`** and **`dashboard.jsp`**

In the views, the JSP files define the structure and content of the web pages. Here's a summary of each view:

1. `index.jsp`: This view displays the registration and login forms side by side. It uses form tags from the Spring framework to bind the form data to the `newUser` and `loginUser` objects. It also includes error messages using the `form:errors` tag for form validation.

2. `dashboard.jsp`: This view displays the user's information after a successful login. It retrieves the user object from the model and uses JSTL tags (`c:out` and `fmt:formatDate`) to display the user's data.

The views utilize Bootstrap CSS classes for styling and provide a user-friendly interface for registration, login, and viewing the user's dashboard.

Overall, the controller handles HTTP requests, performs necessary validations, interacts with the UserService to handle business logic, and the views are responsible for rendering the HTML content to display the user interface.

### Summary

In conclusion, the **LoginAndRegistration** project demonstrates the implementation of user authentication and registration in a Java Spring application. The models `User` and `LoginUser` define the data structures and validations for user information and login credentials. The `UserRepository` interface provides methods to retrieve user data from the database, and the `UserService` class handles user registration, authentication, and password hashing. The `MainController` acts as the central component for request handling, coordinating the interaction between the views and the backend services. The views, implemented using JSP templates, provide user-friendly forms for registration, login, and a dashboard to display user information. The notable addition to this project is the ability to log in with a username, providing users with a convenient alternative to email-based authentication. By following this README, developers can gain a comprehensive understanding of the project's structure and contribute to its further development.


### Screenshots

<div style="display: flex; flex-wrap: wrap; justify-content: center; align-items: center;">
<figure style="margin-bottom: 2rem;">
    <img src="loginreg-readme-assets/Login_and_Registration-Responsiveness-Demo.GIF" alt="Login_and_Registration-Responsiveness-Demo" width="450">
    <figcaption>Login and Registration - Responsiveness Demo</figcaption>
</figure>
<figure style="margin-bottom: 2rem;">
    <img src="loginreg-readme-assets/Login_and_Registration-Field-Validations-Demo.GIF" alt="Login_and_Registration-Field-Validations-Demo" width="450">
    <figcaption>Login and Registration - Validations Demo</figcaption>
</figure>
<figure style="margin-bottom: 2rem;">
    <img src="loginreg-readme-assets/Login_and_Registration-App-Demo.GIF" alt="Login_and_Registration-App-Demo" width="450">
    <figcaption>Login and Registration - Demo</figcaption>
</figure>
</div>
