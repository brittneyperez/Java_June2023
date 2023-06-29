# Books API

**BooksAPI** is a Java Spring project that provides a RESTful API for managing books. It allows users to perform CRUD (Create, Read, Update, Delete) operations on book resources.

## Configuration

The `application.properties` file contains the configuration settings for the project. The following settings are defined:

- `spring.datasource.url`: Specifies the URL of the MySQL database where the books will be stored.
- `spring.datasource.username` and `spring.datasource.password`: Credentials for accessing the database.
- `spring.jpa.hibernate.ddl-auto`: Specifies the behavior of Hibernate for database schema generation. In this case, it is set to `update`, which means that Hibernate will automatically create or update the database schema based on the entity classes.

### Dependencies

The project has several dependencies defined in the `pom.xml` file. These dependencies are required for various aspects of the project:

- `tomcat-embed-jasper`: Dependency for JSP (JavaServer Pages) support. It enables the rendering of JSP views.
- `spring-boot-starter-validation`: Dependency for domain model and validation annotations. It provides support for data validation using annotations like `@NotNull`, `@Size`, etc.
- `jakarta.servlet.jsp.jstl-api` and `jakarta.servlet.jsp.jstl`: Dependencies for JSTL (JavaServer Pages Standard Tag Library) usage. They enable the usage of JSTL tags in JSP views.
- `webjars-locator` and `bootstrap`: Dependencies for Bootstrap framework. They allow the usage of Bootstrap styles and components in the web application.

## Models, Repository, and Service

The project follows the MVC (Model-View-Controller) architecture pattern. Here's a brief overview of each component:

### Models

The `Book` model represents a book entity in the database. It has attributes such as `id`, `title`, `description`, `language`, `numberOfPages`, `createdAt`, and `updatedAt`. The model uses validation annotations to enforce constraints on the data.

### Repository

The `BookRepository` interface extends the `CrudRepository` interface provided by Spring Data JPA. It defines methods for performing CRUD operations on the `Book` entity, such as `findAll()`, `findById()`, `save()`, and `deleteById()`. Additionally, it includes custom query methods like `findByDescriptionContaining()`, `countByTitleContaining()`, and `deleteByTitleStartingWith()`.

### Service

The `BookService` class acts as an intermediary between the repository and the controller. It provides methods for performing business logic operations on book entities. The service uses the `BookRepository` for data access. The methods include `allBooks()` to retrieve all books, `createBook()` to create a new book, `findBook()` to retrieve a book by its ID, `updateBook()` to update an existing book, and `deleteBook()` to delete a book.

## BooksAPIController

The `BooksAPIController` class is a REST controller that handles incoming HTTP requests related to books. It communicates with the `BookService` to perform the requested operations. The controller defines several request mappings:

- `/api/books` (**GET**): Returns a list of all books in the database.
- `/api/books` (**POST**): Creates a new book based on the request parameters.
- `/api/books/{id}` (**GET**): Retrieves a specific book by its ID.
- `/api/books/{id}` (**PUT**): Updates an existing book with new data provided in the request parameters.
- `/api/books/{id}` (**DELETE**): Deletes a book with the specified ID.

The controller maps these request URLs to corresponding methods, which interact with the `BookService` to handle the operations. The methods use annotations like `@PathVariable` and `@RequestParam` to extract data from the request URL or parameters.

## Summary

The BooksAPI project is a Java Spring application that provides a RESTful API for managing books. It uses a MySQL database for storing book entities. The models represent the structure and validation rules for book data. The repository provides CRUD operations for book entities, while the service implements business logic operations. The controller handles incoming HTTP requests and delegates the operations to the service. With this project, users can create, read, update, and delete books through the provided API endpoints.