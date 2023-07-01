# All Books

### Overview
The **All Books** project is a Java Spring application that provides an API for managing books. It includes models, a repository interface, services, controllers, and JSP files for rendering views. Let's go through each component and their purpose:

### Configuration
The `application.properties` file contains the configuration settings for the project. In this case, it specifies the database connection details (URL, username, and password) and sets the Hibernate DDL mode to "update," which means that the database schema will be automatically updated based on the entity classes. The line `spring.mvc.view.prefix=/WEB-INF/` sets the prefix for the JSP view files.

### Dependencies
The project includes several dependencies in the `pom.xml` file that are necessary for its proper functioning:

1. **tomcat-embed-jasper**: This dependency allows the use of JSP (JavaServer Pages) for rendering dynamic web pages.
2. **spring-boot-starter-validation**: It provides support for validation annotations used in the model classes to enforce data constraints.
3. **jakarta.servlet.jsp.jstl-api** and **jakarta.servlet.jsp.jstl**: These dependencies enable the use of JSTL (JavaServer Pages Standard Tag Library) tags in JSP files.
4. **webjars-locator** and **bootstrap**: These dependencies allow the usage of Bootstrap, a popular CSS framework, in the project.

## Models, Repository, and Service

### Models
The project includes a model class called `Book`. This class represents a book entity in the application. It contains various attributes such as title, description, language, and number of pages. The class is annotated with JPA (Java Persistence API) annotations to map it to the database table. It also includes validation annotations to enforce data constraints.

### Repository Interface
The `BookRepository` interface extends the `CrudRepository` interface, which provides basic CRUD (Create, Read, Update, Delete) operations for the `Book` entity. It includes additional custom methods such as finding books by description, counting books with a specific title, and deleting books by title.

### Service
The `BookService` class acts as an intermediary between the controller and the repository. It provides methods for performing various operations on books, such as retrieving all books, creating a new book, finding a book by ID, updating a book, and deleting a book. It uses the `BookRepository` to interact with the database.

### Controller
The `BookController` class is responsible for handling HTTP requests related to books. It is annotated with `@Controller` and `@RequestMapping` to define the base URL path for book-related requests. The controller includes methods for displaying all books and showing details of a specific book. It uses the `BookService` to retrieve book data and passes it to the corresponding JSP views.

## JSP Files & JSTL Tags Used
The project includes two JSP files: `index.jsp` and `show.jsp`. These files define the views for displaying book-related information.

- **`index.jsp`**: This file renders the list of all books. It uses JSTL tags, such as `<c:forEach>`, to iterate over the list of books obtained from the controller and display them in a table format.

- **`show.jsp`**: This file displays detailed information about a specific book. It receives a book object from the controller and uses JSTL tags, such as `<c:out>`, to display the book's attributes.

### Summary

In summary, the All Books project is a Java Spring application that provides an API for managing books. It leverages the Spring Boot framework and includes components such as models, repository interfaces, services, and controllers to handle CRUD operations on book entities. The project utilizes JSP files and JSTL tags for rendering book data and includes dependencies for JSP rendering, validation, and the Bootstrap framework.