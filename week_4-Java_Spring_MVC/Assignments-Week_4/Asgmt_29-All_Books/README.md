# All Books

### Overview
The **All Books** project is a Java Spring application that provides an API for managing books. It includes models, a repository interface, services, controllers, and JSP files for rendering views. Let's go through each component and their purpose:

## Configuration
The `application.properties` file contains the configuration settings for the project. In this case, it specifies the database connection details (URL, username, and password) and sets the Hibernate DDL mode to "update," which means that the database schema will be automatically updated based on the entity classes. The line `spring.mvc.view.prefix=/WEB-INF/` sets the prefix for the JSP view files. And finally, `spring.mvc.hiddenmethod.filter.enabled=true` enables the hidden method filter in Spring MVC. This filter allows the use of hidden input fields in forms to send HTTP requests with non-GET methods (such as PUT, DELETE, etc.), which is useful for RESTful APIs.

### Dependencies
The project includes several dependencies in the `pom.xml` file that are necessary for its proper functioning:

1. **tomcat-embed-jasper**: This dependency allows the use of JSP (JavaServer Pages) for rendering dynamic web pages.
2. **spring-boot-starter-validation**: It provides support for validation annotations used in the model classes to enforce data constraints.
3. **jakarta.servlet.jsp.jstl-api** and **jakarta.servlet.jsp.jstl**: These dependencies enable the use of JSTL (JavaServer Pages Standard Tag Library) tags in JSP files.
4. **webjars-locator** and **bootstrap**: These dependencies allow the usage of Bootstrap, a popular CSS framework, in the project.

## Models, Repository, and Service

These three files serve as the foundation of mananging books in this Java Spring project. The **`Book`** model class represents the structure and validation rules for a book. The **`BookRepository`** interface defines the database operations for the Book entity. Finally, the **`BookService`** class provides a layer of abstraction and encapsulates the business logic for working with books, utilizing the repository to perform database operations. Below is more information on each of their roles.

### Models
The model class, `Book`, represents a book entity in the application. It contains various attributes such as title, description, language, and number of pages. The class is annotated with JPA (Java Persistence API) annotations to map it to the database table. It also includes validation annotations to enforce data constraints.

### Repository Interface
The `BookRepository` interface extends the `CrudRepository` interface, which provides basic CRUD (Create, Read, Update, Delete) operations for the `Book` entity. It includes additional custom methods such as finding books by description, counting books with a specific title, and deleting books by title.

### Service
The `BookService` class acts as an intermediary between the controller and the repository. It provides methods for performing various operations on books, such as retrieving all books, creating a new book, finding a book by ID, updating a book, and deleting a book. It uses the `BookRepository` to interact with the database.

### Controller
The `BookController` class acts as the controller in the Books API project, handling interactions between the user interface and the backend services. It handles the incoming HTTP requests related to books and interacts with the `BookService` to perform the necessary operations. It defines methods for creating, reading, updating, and deleting books. The controller maps the requests to appropriate methods and uses the `Model` object to pass data to the views. It also utilizes annotations for request mapping and validation.

## JSP Files
The following JSP(JavaServer Pages) files define the views for displaying book-related information:

- **`index.jsp`**: This view displays a table of all books. It uses JSTL (JavaServer Pages Standard Tag Library) to iterate over the collection of books obtained from the model and render them in HTML table rows.

- **`create-form.jsp`**: This view provides a form for creating a new book. It uses the Spring `<form:form>` tag to bind the form fields to the model attributes. User input is submitted to the "`/books`" URL, which is handled by the corresponding controller.

- **`show.jsp`**: This view displays the details of a single book. It retrieves book information from the model and renders it using JSP tags.

- **`edit.jsp`**: This view is similar to `create-form.jsp` but is used for editing an existing book. It pre-fills the form fields with the book's current information and submits the changes to the corresponding controller URL.

### Summary

In summary, the All Books project is a Java Spring application that provides an API for managing books. It leverages the Spring Boot framework and includes components such as models, repository interfaces, services, and controllers to handle CRUD operations on book entities. The project utilizes JSP files and JSTL tags for rendering book data and includes dependencies for JSP rendering, validation, and the Bootstrap framework.