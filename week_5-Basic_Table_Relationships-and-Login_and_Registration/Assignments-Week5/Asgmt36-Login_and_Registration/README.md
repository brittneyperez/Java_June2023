# Login & Registration

### Overview

<!-- **Dojos & Ninjas** is a Java Spring project designed to track ninjas and the dojos they're being trained in. The project follows the MVC (Model-View-Controller) architecture to manage and display dojo and ninja data through JSP (JavaServer Pages) for the view layer. -->

**LoginAndRegistration** is a Java Spring project that provides user authentication and registration functionality. It incorporates server-side validations, authentication logic, password hashing using BCrypt, session management, and user data retrieval. The project follows the MVC (Model-View-Controller) architectural pattern and utilizes Spring Boot, JPA (Java Persistence API), and Thymeleaf templating engine. With its robust features and clean code structure, **LoginAndRegistration** serves as a solid foundation for building secure user authentication systems in Spring applications.

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

The **`User.java`** file represents the `User` model in the Login and Registration application. It is an entity class annotated with `@Entity` to indicate that it is mapped to a database table. The class defines various member variables, such as `id`, `createdAt`, `updatedAt`, `firstName`, `lastName`, `email`, `username`, `password`, and `confirmPassword`, along with their respective getters and setters. It also includes validation annotations from the `jakarta.validation.constraints` package to enforce data validation rules. The class has additional lifecycle callback methods `@PrePersist` and `@PreUpdate` to set the `createdAt` and `updatedAt` timestamps before saving or updating the entity.

The **`LoginUser.java`** file represents the `LoginUser` validator model in the Login and Registration application. It is a simple POJO (Plain Old Java Object) class that contains member variables `email` and `password`, along with their respective getters and setters. The class includes validation annotations from the `jakarta.validation.constraints` package to enforce data validation rules for the email and password fields. This class is used for validating the user login credentials.

Both files play an essential role in the application. The `User.java` file defines the user model with its attributes and validation rules, while the `LoginUser.java` file provides a validator model specifically for validating the user login credentials. Together, these files help ensure data integrity and perform validations for user registration and authentication in the Login and Registration application.

---

### The Repository: **`UserRepository.java`**

The `UserRepository` interface is responsible for defining database operations related to the `User` entity. It extends the `CrudRepository` interface, which provides basic CRUD (Create, Read, Update, Delete) operations. The repository interface includes additional methods specific to user-related queries. In this case, it has methods such as `findAll()` to retrieve all users from the database, `findByEmail(String email)` to retrieve a user by their email, and `findByUsername(String username)` to retrieve a user by their username. These methods are implemented by the Spring Data JPA framework based on their naming conventions.

### The Service: **`UserService.java`**

The `UserService` class is a service component that handles the business logic related to user operations. It is annotated with `@Service` to indicate that it is a service bean in the Spring application context. The service class is responsible for interacting with the `UserRepository` to perform operations such as registering a new user and logging in a user.

- The `registerUser()` method in the `UserService` class performs the registration process for a new user. It first checks if the email and username provided by the user are already registered in the database. If a user with the same email or username exists, it adds appropriate error messages to the `BindingResult` object. It then validates the password and confirms password fields to ensure they match. If there are any validation errors, it returns `null` to indicate the registration was unsuccessful. If all validations pass, the password is hashed using `BCrypt` and the user is saved to the database using the `UserRepository`. The saved user object is returned as the result of the registration process.

- The `loginUser()` method in the `UserService` class handles the user login process. It retrieves the user with the provided email from the database using the `UserRepository`. If the user exists, it checks if the password provided matches the hashed password stored in the database using `BCrypt`. If the password doesn't match, it adds an error message to the `BindingResult`. If the user does not exist in the database, it also adds an error message. Depending on the result, it either returns the logged-in user object or `null` to indicate a failed login.

Overall, the repository and service work together to provide data access and business logic for user-related operations in the Login and Registration application.


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

These views provide the user interface for registration, login, and displaying user information. The controller methods handle the requests and interact with the `UserService` to perform the necessary operations.

### Summary

In summary, the project consists of several key files that work together to deliver a comprehensive user authentication and registration system. The `User` and `LoginUser` models define the structure and validation rules for user data. The `UserRepository` interface provides methods for database operations related to users, while the `UserService` handles user-related logic and interacts with the repository. The `MainController` acts as the central controller, handling requests, performing validations, and rendering views. The project includes well-designed views using JSP (JavaServer Pages) to provide a user-friendly interface. By combining these components, **LoginAndRegistration** delivers a robust and secure user authentication solution for Java Spring applications.

### Screenshots

<div style="display: flex; flex-wrap: wrap; justify-content: center; align-items: center;">
<figure style="width: 300px; margin-bottom: 2rem;">
    <img src="loginreg-readme-assets/Login_and_Registration-Responsiveness-Demo.GIF" alt="Login_and_Registration-Responsiveness-Demo">
    <figcaption>Login and Registration - Responsiveness Demo</figcaption>
</figure>
<figure style="width: 300px; margin-bottom: 2rem;">
    <img src="loginreg-readme-assets/Login_and_Registration-Validations-Demo.GIF" alt="Login_and_Registration-Validations-Demo">
    <figcaption>Login and Registration - Validations Demo</figcaption>
</figure>
<figure style="width: 300px; margin-bottom: 2rem;">
    <img src="loginreg-readme-assets/Login_and_Registration-Demo.GIF" alt="Login_and_Registration-Demo">
    <figcaption>Login and Registration - Demo</figcaption>
</figure>
</div>
