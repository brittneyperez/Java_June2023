# Rendering Books

### Overview
The **Rendering Books** project is a Java Spring application that provides functionality to render book details using a RESTful API. It utilizes a MySQL database for storing book entities and provides CRUD operations through the provided API endpoints. The project includes models, a repository interface, a service, a controller, and JSP files for rendering the book details.

### Configuration
The `application.properties` file contains the configuration for the database connection. It specifies the URL, username, and password for the MySQL database. The line `spring.mvc.view.prefix=/WEB-INF/` sets the prefix for the JSP view files.

### Dependencies
The project includes several dependencies in the `pom.xml` file. Here are the key dependencies and their purposes:
- `tomcat-embed-jasper`: Enables JSP support for rendering the views.
- `spring-boot-starter-validation`: Provides validation annotations for the domain model, allowing for validation of book data.
- `jakarta.servlet.jsp.jstl-api` and `jakarta.servlet.jsp.jstl`: JSTL (JavaServer Pages Standard Tag Library) dependencies used for tag usage in JSP files.
- `webjars-locator` and `bootstrap`: WebJars dependencies used for Bootstrap styling.

## Models, Repository, and Service

### Model

The `Book` model represents the structure and validation rules for book data. It includes attributes such as title, description, language, number of pages, and timestamps for creation and update. The model is annotated with validation annotations to enforce data integrity.

### Repository

The `BookRepository` interface extends the `CrudRepository` and defines methods for performing database operations on book entities. It includes methods for retrieving, searching, and deleting books based on different criteria.

### Service

The `BookService` class implements the business logic operations related to books. It interacts with the `BookRepository` to perform CRUD operations on books. The service provides methods for retrieving all books, creating a new book, finding a book by ID, updating a book, and deleting a book.

### Controller and JSP Files
The `BookController` class is a Spring MVC controller responsible for handling HTTP requests related to books. It maps incoming requests to appropriate methods and interacts with the `BookService` to perform the requested operations. It includes methods for testing purposes, retrieving and rendering book details based on ID, and other functionalities.

The `show.jsp` file is a JSP (JavaServer Pages) file responsible for rendering the book details. It uses JSTL tags for accessing and displaying book data received from the controller. The JSTL tags provide control structures, loops, and variable access within the JSP file, enabling dynamic rendering of the book details.

These components work together to provide a functional API for managing books and rendering their details using a Java Spring application.