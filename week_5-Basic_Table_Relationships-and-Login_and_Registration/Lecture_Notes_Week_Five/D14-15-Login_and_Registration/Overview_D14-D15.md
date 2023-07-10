## **Week 5** - D1４ |  ２０２３年０７月０６日（木）

### Recap

- **Database Relationships**
    - Relationships
    - `@OneToOne`
    - `@OneToMany`
    - `@ManyToOne`
    - More Data Binding

## Topics to Cover
- **Database Relationships** (continued...)
    - Project Set Up Review
    - Creating a "Helper" Class
    - Updating User.java
    - Login & Reg `.jsp`
    - Data Binding multiple forms on one view
    - Password Security
    - Service Authentication/Validation Logic


# Authentication Demo

<details>
    <summary>### Database and View Configuration</summary>

1. `spring.datasource.url=jdbc:mysql://localhost:3306/java-authentication-demo?createDatabaseIfNotExist=true`: This line specifies the URL for connecting to the MySQL database. The URL indicates that the database is located on `localhost` at port `3306` and its name is `java-authentication-demo`. The `createDatabaseIfNotExist=true` parameter instructs the system to create the database if it doesn't already exist.

2. `spring.datasource.username=root`: This line specifies the username to be used when connecting to the database. In this case, it is set to `root`.

3. `spring.datasource.password=rootroot`: This line specifies the password associated with the username used to connect to the database. In this case, the password is set to `rootroot`.

4. `spring.jpa.hibernate.ddl-auto=update`: This line configures the behavior of Hibernate, the ORM (Object-Relational Mapping) framework used by Spring Data JPA. The `ddl-auto` property controls the automatic generation and update of database schema. In this case, it is set to `update`, which means that Hibernate will update the schema based on the entity classes defined in your project.

5. `spring.mvc.view.prefix=/WEB-INF/`: This line configures the prefix for resolving view templates in Spring MVC. It indicates that the view templates are located in the `/WEB-INF/` directory.

6. `spring.mvc.hiddenmethod.filter.enabled=true`: This line enables the hidden method filter in Spring MVC. This filter allows you to use the hidden input field technique for submitting forms with methods other than GET and POST, such as DELETE or PUT.

These configuration properties define various aspects of the Java Spring application, **AuthenticationDemo**, including the database connection, ORM behavior, and view resolution settings.
</details>

<details>
<summary>### Dependencies</summary>

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

## Model, Repositories, Services, and Validators


### Model: **User.java**:

This file represents the `User` model in the application. It is an entity class annotated with `@Entity` and corresponds to the `users` table in the database. The class contains member variables for attributes such as `firstName`, `lastName`, `email`, `password`, etc. It also includes JPA annotations for database mapping and validation annotations for field validation. Additionally, there are methods for setting up timestamps before persisting and updating the entity. The file provides getters and setters for accessing and modifying the attributes.

### Repository **UserRepository.java**:
This file defines the `UserRepository` interface, which extends the `CrudRepository` interface provided by Spring Data JPA. The repository provides methods for performing CRUD (Create, Read, Update, Delete) operations on the `User` entity. It includes methods like `findAll()` to retrieve all users, and `findByEmail()` to find a user by their email. The interface is annotated with `@Repository` to enable Spring to create a bean for dependency injection.

### The Service: **UserService.java**

The `UserService` class handles the business logic and acts as an intermediary between the controller and the repository. It provides methods for user registration and login. The `registerUser` method validates the user input, checks for duplicate email addresses, and hashes the password before saving the user to the database. The `loginUser` method validates the login credentials by retrieving the user from the database based on the provided email, comparing the password hash, and returning the authenticated user.

### The Validator: **LoginValidator.java**:

This file contains the `LoginValidator` class, which acts as a helper class for validating user login credentials. It includes member variables for `email` and `password`, along with validation annotations to enforce data constraints. The class provides getters and setters for accessing and modifying the fields. It is not an entity class and doesn't have a database representation, but it serves the purpose of validating login inputs.

These files together form the core components of the AuthenticationDemo project. The `User` model represents user data, the `UserRepository` provides database operations for user management, and the `LoginValidator` helps validate login credentials. They are crucial for implementing user registration, login, and related functionality in the application.

## Controllers

The `UserController` class is responsible for managing user-related requests and interactions in the AuthenticationDemo project.

- The `index()` method handles the `GET` request to the root path (`/users`) and binds an empty `User` object and a new `LoginValidator` object to the model. It returns the `index.jsp` view, which displays the registration and login forms.

- The `register()` method handles the `POST` request to `/users/register` when a user submits the registration form. It validates the submitted `User` object using the `registerUser()` method in the `UserService`. If there are validation errors, it adds the `LoginValidator` object to the model and re-renders the `index.jsp` view with the registration form errors. If there are no errors, it saves the registered user to the database, stores the user's ID in the session, and redirects to `/users/home`.

- The `login()` method handles the `POST` request to `/users/login` when a user submits the login form. It validates the submitted `LoginValidator` object using the `loginUser()` method in the `UserService`. If there are validation errors, it adds an empty `User` object to the model and re-renders the `index.jsp` view with the login form errors. If there are no errors, it stores the user's ID in the session and redirects to `/users/home`.

- The `home()` method handles the `GET` request to `/users/home`, which represents the user's dashboard. It retrieves the user's ID from the session, fetches the user's information using the `findUserById()` method in the `UserService`, adds the user to the model as "currentUser," and returns the `dashboard.jsp` view.

- The `logout()` method handles the `GET` request to `/users/logout`. It invalidates the session and redirects to the root path (`/`).

### Java Beans

Java Beans are used to maintain form data between requests. In the `index()` method, an empty `User` object and a new `LoginValidator` object are bound to the model. When the form is submitted, the form data is automatically populated into these objects based on their field names and the `@ModelAttribute` annotation. This allows the form data to be passed between requests, and any validation errors can be displayed on the form using the `BindingResult` object. By using Java Beans, the controller can easily handle form data and validation while maintaining the state of the form across requests.

## Views

### **index.jsp**

The `index.jsp` file represents the view for the registration and login forms. It includes HTML markup and JSP tags to dynamically generate the form elements and display validation errors.

In the registration form section, the JSP tags are used to bind form inputs to the `User` object attributes. For example, `<form:input type="text" path="firstName" class="form-control" />` binds the input value to the `firstName` attribute of the `newUser` object. Validation errors for each field are displayed using `<form:errors>` tags with the corresponding `path` attribute.

Similarly, in the login form section, the form inputs are bound to the `LoginValidator` object attributes. Any errors related to the email and password inputs are displayed using `<form:errors>` tags.

### **dashboard.jsp**

The `dashboard.jsp` file represents the view for the user's dashboard after successful registration or login. It displays the user's information retrieved from the model attributes.

The `<c:out>` tag is used to output the values of the `currentUser` object's attributes, such as the user's first name, last name, and email. The `userId` is also displayed using `<c:out>` to show the user's ID.

Lastly, a "Logout" button is provided with a link to `/users/logout` to allow the user to log out of the application.

Overall, both JSP files utilize JSP tags, form bindings, and model attributes to render dynamic content and handle form submissions with proper validation and error display.