# Burger Tracker II

### Overview
The Burger Tracker project is a Java Spring application that allows users to track and manage burger details such as the burger name, restaurant name, rating, and additional notes. The project follows the Model-View-Controller (MVC) architectural pattern and uses JSP (JavaServer Pages) for the view layer.

## Configuration
The `application.properties` file contains the configuration settings for the project. In this case, it specifies the database connection details (URL, username, and password) and sets the Hibernate DDL mode to "update," which means that the database schema will be automatically updated based on the entity classes. The line `spring.mvc.view.prefix=/WEB-INF/` sets the prefix for the JSP view files. And finally, `spring.mvc.hiddenmethod.filter.enabled=true` enables the hidden method filter in Spring MVC. This filter allows the use of hidden input fields in forms to send HTTP requests with non-GET methods (such as PUT, DELETE, etc.), which is useful for RESTful APIs.

### Dependencies
The project includes several dependencies in the `pom.xml` file that are necessary for its proper functioning:

1. **`tomcat-embed-jasper`**: This dependency allows the use of JSP (JavaServer Pages) for rendering dynamic web pages.
2. **`spring-boot-starter-validation`**: It provides support for validation annotations used in the model classes to enforce data constraints.
3. **`jakarta.servlet.jsp.jstl-api`** and **jakarta.servlet.jsp.jstl**: These dependencies enable the use of JSTL (JavaServer Pages Standard Tag Library) tags in JSP files.
4. **`webjars-locator`** and **`bootstrap`**: These dependencies allow the usage of Bootstrap, a popular CSS framework, in the project.

## Models, Repository and Service

### Model

The `Burger` class represents the model for a burger entry. It defines the structure and properties of a Burger object, such as its name, restaurant, rating, notes, and timestamps for creation and update. It also includes annotations for database mapping and validation constraints. The Burger class provides getters and setters for accessing and modifying the burger's attributes.

### Repository
The `BurgerRepository` interface extends the `CrudRepository` interface from Spring Data JPA. It serves as the interface between your application and the database, allowing you to perform CRUD (Create, Read, Update, Delete) operations on the Burger objects. The BurgerRepository provides methods for retrieving all burgers from the database and is responsible for interacting with the underlying database implementation.

### Service
The `BurgerService` class acts as an intermediary between the controller and the repository. It acts as an intermediary between the controller and the repository, encapsulating the logic for handling CRUD operations on burgers. The BurgerService class defines methods for retrieving all burgers, creating a new burger, finding a specific burger by its ID, updating a burger, and deleting a burger. It uses the BurgerRepository to interact with the database and performs any necessary data manipulation or validation before delegating the operations to the repository.

These three files work together to implement the `BurgerTracker` application's functionality. The Burger model defines the structure of the burger objects, the `BurgerRepository` handles the database operations, and the `BurgerService` encapsulates the business logic for working with burgers.

## Controller

The `BurgerController` class serves as the controller in your BurgerTracker project. It handles the incoming HTTP requests related to burgers and interacts with the `BurgerService` to perform the necessary operations. The controller includes various methods annotated with `@GetMapping`, `@PostMapping`, `@RequestMapping`, and `@DeleteMapping` to map the corresponding HTTP methods and endpoints. The `index` method retrieves all burgers, `create` creates a new burger, `showBurger` retrieves a specific burger by ID, `editBurger` retrieves a burger for editing, `update` updates an existing burger, and `delete` deletes a burger. The BurgerController acts as the bridge between the user's actions and the underlying service layer, allowing the application to handle HTTP requests and manage burger-related operations.

## View

- **`index.jsp`**: retrieves a list of burgers from the Controller using the `${burgers}` expression, which corresponds to the burgers model attribute returned by the Controller's index method.It iterates over the burgers using the `<c:forEach>` tag, displaying the burger details within the table rows. 

    The Edit and Delete actions are formed as links and forms, respectively, allowing the user to update or delete a specific burger. These actions utilize the endpoints provided by the Controller (`/burgers/${burger.id}/edit` and `/burgers/${burger.id}`).

- **`read-one.jsp`**: displays the details of a specific burger. It accesses the burger details using the `${burger}` expression, which corresponds to the burger model attribute returned by the Controller's `showBurger()` method.
The burger details, such as name, notes, restaurant, and rating, are displayed using the `<c:out>` tag.

- **`update-form.jsp`**: renders a form that allows the user to edit a burger. The form is pre-populated with the existing burger details by accessing the `${burger}` expression, which corresponds to the burger model attribute returned by the Controller's editBurger method. The form's action attribute is set to `/burgers/${burger.id}`, and the _method input field is populated with the value "put", which indicates that the form submission should be treated as an HTTP PUT request. The user can update the burger name, restaurant, rating, and notes using the form fields.

### Summary

In summary, the Burger Tracker project utilizes models to define the structure of burger objects, a repository interface for database operations, a service to handle the business logic, and a controller to handle HTTP requests and manage the flow of data between the view and the service layer. The JSP files provide the user interface for displaying and adding burger information.
