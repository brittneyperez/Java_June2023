# Burger Tracker I

### Overview
The Burger Tracker project is a Java Spring application that allows users to track and manage burger details such as the burger name, restaurant name, rating, and additional notes. The project follows the Model-View-Controller (MVC) architectural pattern and uses JSP (JavaServer Pages) for the view layer.

## Configuration
The `application.properties` file contains the configuration settings for the project. In this case, it specifies the database connection details (URL, username, and password) and sets the Hibernate DDL mode to "update," which means that the database schema will be automatically updated based on the entity classes. The line `spring.mvc.view.prefix=/WEB-INF/` sets the prefix for the JSP view files.

### Dependencies
The project includes several dependencies in the `pom.xml` file that are necessary for its proper functioning:

1. **tomcat-embed-jasper**: This dependency allows the use of JSP (JavaServer Pages) for rendering dynamic web pages.
2. **spring-boot-starter-validation**: It provides support for validation annotations used in the model classes to enforce data constraints.
3. **jakarta.servlet.jsp.jstl-api** and **jakarta.servlet.jsp.jstl**: These dependencies enable the use of JSTL (JavaServer Pages Standard Tag Library) tags in JSP files.
4. **webjars-locator** and **bootstrap**: These dependencies allow the usage of Bootstrap, a popular CSS framework, in the project.

## Models, Repository, and Service

### Models

The `Burger` class represents the model for a burger entry. It contains properties such as `name`, `restaurant`, `rating`, and `notes`. The class is annotated with JPA annotations to map it to the corresponding database table.

### Repository Interface

The `BurgerRepository` interface extends the `CrudRepository` interface from Spring Data JPA. It provides methods for performing CRUD (Create, Read, Update, Delete) operations on the `Burger` entities. In this case, it defines a method to retrieve all burgers from the database.

### Service

The `BurgerService` class acts as an intermediary between the controller and the repository. It encapsulates the business logic related to burgers. The service class provides methods for performing CRUD operations and interacts with the `BurgerRepository` to retrieve and persist data.

## Controllers

### `BurgerApiController`

The `BurgerController` class handles the HTTP requests and serves as the entry point for the application's RESTful API. It defines various methods annotated with `@RequestMapping` to handle different operations such as retrieving all burgers, creating a new burger, updating an existing burger, and deleting a burger. This file was for testing purposes only and not a part of the final product.

### `BurgerController`

The **`BurgerController`** class is a Spring MVC controller responsible for handling HTTP requests and coordinating the flow of data between the view and the service layer. It is annotated with `@Controller` and `@RequestMapping` to define the base URL for burger-related endpoints. The `BurgerController` includes methods for displaying all burgers, adding a new burger, and handling form submissions. It uses the `BurgerService` to perform the necessary operations and updates the model attributes to pass data to the view.


## View

The project includes an `index.jsp` file, which serves as the main view for displaying all burgers and adding new burgers. The `index.jsp` file uses JSTL (JavaServer Pages Standard Tag Library) to iterate over the list of burgers retrieved from the controller and display them in a table. It also includes a form for adding a new burger, with input fields for burger name, restaurant name, rating, and notes. The form submits the data to the BurgerController for processing.

### Summary

In summary, the Burger Tracker project utilizes models to define the structure of burger objects, a repository interface for database operations, a service to handle the business logic, and a controller to handle HTTP requests and manage the flow of data between the view and the service layer. The JSP files provide the user interface for displaying and adding burger information.