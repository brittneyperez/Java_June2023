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

The `User.java` file is the model class representing the user entity. It contains various member variables with corresponding getters and setters. The class is annotated with JPA annotations to define the mapping to the database table. Additionally, it includes validation annotations from the Jakarta Bean Validation API to enforce data integrity. The newly added field `dateOfBirth` represents the user's date of birth and is annotated with `@NotNull` to ensure it is provided. The password field has also been updated with a new validation annotation `@Pattern` to enforce a secure password that includes at least one lowercase letter, one uppercase letter, one number, and one special symbol.

2. **LoginUser.java**: This file represents the validator model for the login functionality. It contains member variables `loginCredential` and `password`, which correspond to the login form fields. The class includes annotations for validation, such as `@NotEmpty` and `@Size`, to enforce validation rules for the login form. This class is used for validating the login credentials provided by the user during the login process.

These files play a crucial role in the **LoginAndRegistration** project. `User.java` defines the structure and validation rules for the user model, while `LoginUser.java` provides the validation rules for the login form. Together, they enable the application to store and validate user information, allowing users to register, log in, and perform various authentication-related operations.

---

### The Repository: **`UserRepository.java`**

The `UserRepository` interface serves as the repository for the `User` entity, providing methods to interact with the database. It extends the `CrudRepository` interface, which provides basic CRUD (Create, Read, Update, Delete) operations. The `UserRepository` interface includes additional custom methods to retrieve users by their email, username, and date of birth. These methods utilize the `Optional` class to handle potential null values returned from the database queries. The repository includes the following additional methods specific to the user model:
- `findAll()`: Retrieves all users from the database.
- `findByEmail(String email)`: Retrieves a user by their email.
- `findByUsername(String username)`: Retrieves a user by their username.
- `findByDateOfBirth(LocalDate dateOfBirth)`: Retrieves a user by their dateOfBirth.

These methods are used to query the database and retrieve user information based on specific criteria.

### The Service: **`UserService.java`**

The `UserService` class is responsible for implementing the business logic related to user operations. It is annotated with `@Service` to indicate that it's a service component in the Spring framework. The class includes the `UserRepository` as a dependency, which is injected using the `@Autowired` annotation. The `UserService` class provides several methods:
- `findUserById`: This method retrieves an existing user by their ID from the database. It utilizes the `findById` method of the `UserRepository`.

- `validateAge`: This private method is used to validate the age of a user during registration. It calculates the user's age based on the provided date of birth and the current date using the `LocalDate` class. If the age is less than 10, it adds a validation error to the `BindingResult`.

- `registerUser`: This method is used to register a new user. It performs various validations, such as checking if the email and username are already registered, ensuring the passwords match, and validating the user's age using the `validateAge` method. If any validation errors occur, the method returns `null`. If all validations pass, the user's password is hashed using BCrypt, and the user is saved to the database using the `save` method of the `UserRepository`.

- `loginUser`: This method is used to authenticate a user during the login process. It checks if the login credential (email or username) exists in the database and verifies the password using BCrypt. If the credentials are valid, it returns the user object. If not, it adds a validation error to the `BindingResult` and returns `null`.

The `UserService` class plays a crucial role in implementing the application's logic for user registration, login, and age validation. It interacts with the `UserRepository` to perform database operations and uses BCrypt for secure password hashing.


## The Controller: **`MainController.java`**

The `MainController` class is responsible for handling HTTP requests and mapping them to appropriate methods. It is annotated with `@Controller` to indicate that it's a controller component in the Spring framework. The class includes the `UserService` as a dependency, which is injected using the `@Autowired` annotation.

The `MainController` class provides several methods:
- `index`: This method handles the GET request to the root URL ("/authenticate"). It initializes the `newUser` and `loginUser` objects to be used in the registration and login forms, respectively. It returns the "index.jsp" view.

- `register`: This method handles the POST request to the "/register" URL. It receives the `registeringUser` object from the registration form, along with the `BindingResult`, `Model`, and `HttpSession` objects. It calls the `registerUser` method of the `UserService` to perform user registration. If there are validation errors, it returns the "index.jsp" view with the validation errors. If the registration is successful, it stores the user's ID in the session and redirects to the "/authenticate/home" URL.

- `login`: This method handles the POST request to the "/login" URL. It receives the `newLoginObject` object from the login form, along with the `BindingResult`, `Model`, and `HttpSession` objects. It calls the `loginUser` method of the `UserService` to authenticate the user. If there are validation errors, it returns the "index.jsp" view with the validation errors. If the login is successful, it stores the user's ID in the session and redirects to the "/authenticate/home" URL.

- `home`: This method handles the GET request to the "/home" URL. It retrieves the user's ID from the session and calls the `findUserById` method of the `UserService` to retrieve the corresponding user object. It calculates the user's age based on the current date and the user's date of birth using the `Period` class. It formats the date of birth using `DateTimeFormatter` and adds the user object, formatted date of birth, and age to the model. It returns the "dashboard.jsp" view.

- `logout`: This method handles the GET request to the "/logout" URL. It invalidates the session and redirects to the root URL ("/").

## The Views: **`index.jsp`** and **`dashboard.jsp`**

- The `index.jsp` view is the login and registration page. It includes two forms: one for user registration and another for user login. The forms use the Spring form tags (`form:form`, `form:input`, `form:label`, `form:errors`) to bind the form fields to the corresponding properties of the `newUser` and `loginUser` objects. The form fields are validated using the `form:errors` tag, which displays any validation errors returned by the controller. The registration form includes an additional field for the date of birth, which is represented as an input type of "date".

- The `dashboard.jsp` view is the user's dashboard page. It displays the user's details, such as their name, email, username, password (not actually displayed), date of birth, and the date they joined. The date of birth is formatted using the `fmt:formatDate` tag. The age is calculated in the controller and displayed alongside the formatted date of birth. The user can also click the "Logout" button, which triggers the `/authenticate/logout` URL to log out the user.

These views provide a user-friendly interface for user registration, login, and displaying user details on the dashboard. The forms handle data binding and validation, while the controller coordinates the business logic and data retrieval from the `UserService`.


### Summary

In conclusion, the **LoginAndRegistration** project demonstrates the implementation of user authentication and registration in a Java Spring application. The models `User` and `LoginUser` define the data structures and validations for user information and login credentials. The `UserRepository` interface provides methods to retrieve user data from the database, and the `UserService` class handles user registration, authentication, and password hashing. The `MainController` acts as the central component for request handling, coordinating the interaction between the views and the backend services. The views, implemented using JSP templates, provide user-friendly forms for registration, login, and a dashboard to display user information. The notable addition to this project is the ability to log in with a username, providing users with a convenient alternative to email-based authentication.


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
