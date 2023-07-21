# Book Broker

This Java Spring project is called **BookBroker**. The objectives of the app is to add users to an application with Create and Read capabilities, implements two one-to-many relationships between User and Books and BorrowedBooks, and manages a user session (login status) by storing and reading their ID in session.

## Configuration

<details>
<summary>Database and View Configuration</summary>

1. `spring.datasource.url=jdbc:mysql://localhost:3306/java-book-club?createDatabaseIfNotExist=true`: This line specifies the URL for connecting to the MySQL database. The URL indicates that the database is located on `localhost` at port `3306` and its name is `java-book-club`. The `createDatabaseIfNotExist=true` parameter instructs the system to create the database if it doesn't already exist.

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

### The Models: **`User.java`** and **`Book.java`**

1. **User.java:** This file represents the `User` model in the BookBroker application. It defines the entity class for users, which is mapped to the `users` table in the database. The `User` model contains attributes such as `id`, `firstName`, `lastName`, `email`, `username`, `password`, and `dateOfBirth`, among others, to store user information. It also includes timestamps for `createdAt` and `updatedAt` to track the creation and modification dates. Additionally, the `User` model has a one-to-many relationship with the `Book` model through the `myBooks` attribute, representing the books owned by the user, and the `borrowedBooks` attribute, representing the books borrowed by the user. With these relationships, a user can have multiple books in their possession and can also borrow multiple books from other users.

2. **Book.java:** This file represents the `Book` model in the BookBroker application. It defines the entity class for books, which is mapped to the `books` table in the database. The `Book` model contains attributes such as `id`, `title`, `author`, and `thoughts`, among others, to store book information. It also includes timestamps for `createdAt` and `updatedAt` to track the creation and modification dates. The `Book` model has many-to-one relationships with the `User` model through the `reader` attribute, representing the user who owns the book, and the `borrower` attribute, representing the user who borrowed the book. These relationships allow a book to be associated with a reader (owner) and a borrower. With these modifications, the `borrower` field is added to the `Book` model to track the user who is currently borrowing the book.

### The Model Validator: **`LoginUser.java`**

3. **UserLogin.java:** The `UserLogin` model is a validator model used for user login functionality. However, it is not directly related to the borrowing functionality and modifications described above. This model contains attributes for `username` and `password`, which are used to validate user login credentials. The `UserLogin` model is typically used in the login process to ensure that the provided login details are valid and match the corresponding user's credentials stored in the database.

Overall, the modifications made to the `User` and `Book` models involve adding the necessary attributes and relationships to support the new functionality of borrowing books. The addition of the `borrower` field in the `Book` model allows tracking the user currently borrowing the book, and the one-to-many relationship between `User` and `Book` models enables users to have multiple books in their collection or borrowed from other users. These changes facilitate the implementation of the borrowing and returning functionality in the BookBroker application.


### The Repositories: **`UserRepository.java`** and **`BookRepository.java`**

1. **UserRepository.java:** The `UserRepository` interface is responsible for defining database operations related to the `User` model. It extends the `CrudRepository` interface provided by Spring Data JPA, which provides basic CRUD (Create, Read, Update, Delete) operations out of the box. Additionally, the `UserRepository` interface defines three custom methods to retrieve users based on different criteria. The `findAll()` method retrieves all users from the database. The `findByEmail(String email)` method retrieves a user by their email address, and the `findByUsername(String username)` method retrieves a user by their username. These custom methods allow the application to interact with the database and perform various operations related to user management.

2. **BookRepository.java:** The `BookRepository` interface is responsible for defining database operations related to the `Book` model. Similar to the `UserRepository`, it extends the `CrudRepository` interface to provide basic CRUD operations. The `BookRepository` interface only defines the `findAll()` method, which retrieves all books from the database. This interface allows the application to interact with the database and perform operations related to book management.


### The Services: **`UserService.java`** and **`BookService.java`**



1. **UserService.java:** The `UserService` class is a service that handles business logic and operations related to users. It is annotated with `@Service`, indicating that it is a Spring service component that can be injected into other parts of the application. The `UserService` class has a dependency on the `UserRepository`, which is autowired to allow interaction with the database.

   - The `UserService` class contains several methods to perform user-related operations. The `findByUserById(Long id)` method retrieves an existing user by their ID. The `validateAge(User newUser, BindingResult result)` method is a private helper method used to validate the age of a registering user. The `registerUser(User newUser, BindingResult result)` method performs validations on the registration process, such as checking if the email or username already exists and ensuring that the user is at least 10 years old. If the registration details are valid, it hashes the password and saves the user to the database.

   - The `loginUser(LoginUser newLoginObject, BindingResult result)` method is responsible for validating user login credentials. It first checks if the provided login credential (email or username) exists in the database and then compares the password with the hashed password stored in the database. If the login credentials are valid, it returns the corresponding user; otherwise, it rejects the login attempt.

2. **BookService.java:** The `BookService` class is a service that handles business logic and operations related to books. Similar to the `UserService`, it is annotated with `@Service` to indicate it is a Spring service component, and it has a dependency on the `BookRepository` autowired to interact with the database.

   - The `BookService` class contains methods to perform CRUD operations on books. The `addBook(Book newBook)` method saves a new book to the database. The `getAllBooks()` method retrieves all books from the database. The `getBookById(Long id)` method retrieves a book by its ID. The `updateBook(Book existingBook)` method updates an existing book in the database. The `deleteBookById(Long id)` method deletes a book by its ID.

Overall, the repository interfaces (`UserRepository` and `BookRepository`) provide an abstraction layer to interact with the database, while the corresponding services (`UserService` and `BookService`) contain business logic to perform user and book-related operations, respectively. These separation of concerns allows for clean and maintainable code organization in the BookBroker application.


## Controller and Views

### The Controller: **`MainController.java`**

The `MainController` is responsible for handling user requests and coordinating the interaction between the views, models, and services. It implements the functionalities related to book borrowing and returning, in addition to other book-related operations. Below is an explanation of the controller's main methods and how the functionalities are implemented:

1. **`register()` and `login()` Methods:** These methods handle user registration and login processes, respectively. The `register()` method uses the `UserService` to register a new user by calling the `registerUser()` method. It performs extra validations on the registration details, checks for errors, and saves the user to the database if everything is valid. Similarly, the `login()` method uses the `UserService` to validate user login credentials. If the login is successful, the user's ID is stored in the session for authentication purposes.

2. **`home()` Method:** The `home()` method displays the dashboard page that shows all books. It first checks if the user is logged in by verifying the presence of the user ID in the session. If not logged in, it redirects the user to the login page. If the user is logged in, it retrieves the user's ID from the session, fetches the user details from the database using the `UserService`, and passes them to the view. Additionally, it fetches all books from the database using the `BookService` and passes them to the view.

3. **`addBook()` and `createBookInDb()` Methods:** These methods handle adding new books to the database. The `addBook()` method displays the form for adding a new book. The `createBookInDb()` method is used when the form is submitted. It retrieves the logged-in user's ID from the session, finds the user in the database using the `UserService`, and sets the reader attribute of the new book to the logged-in user. It then saves the book to the database using the `BookService`.

4. **`bookDetails()` Method:** This method displays the details page for a specific book. It retrieves the book's details from the database using the `BookService` based on the provided book ID and passes them to the view. If the user is logged in, it retrieves the user's details from the database and passes them to the view as well.

5. **`editBookDetails()` and `editBook()` Methods:** These methods handle updating book details. The `editBookDetails()` method displays the form for editing a book's details. It retrieves the book's details from the database using the `BookService` based on the provided book ID and passes them to the view. The `editBook()` method is used when the form is submitted. It retrieves the original book details from the database using the `BookService`, updates the attributes that can be changed by the reader (title, author, thoughts), and sets the reader attribute to the logged-in user. It then updates the book in the database using the `BookService`.

6. **`borrowBook()` and `returnBook()` Methods:** These methods handle the book borrowing and returning functionalities. The `borrowBook()` method sets the borrower attribute of the book to the logged-in user and updates the book in the database using the `BookService`. The `returnBook()` method sets the borrower attribute of the book to null (indicating that the book has been returned) and updates the book in the database using the `BookService`.

7. **`deleteBook()` Method:** This method handles book deletion. It receives the book ID as a parameter, and using the `BookService`, it deletes the book from the database.

In summary, the `MainController` implements the necessary methods to handle user registration, login, book creation, book details display, book editing, book borrowing, book returning, and book deletion. The controller interacts with the services (`UserService` and `BookService`) to perform the necessary business logic, interact with the database, and render the appropriate views to the users.


### The Views

1. **`register.jsp`:** This view displays the registration form for new users. It uses the Spring Form taglib (`form`) to generate the form fields and handle form submissions. Here's a breakdown of the view:
   - The form action is set to `/book-club/register`, which maps to the `register()` method in the controller.
   - The form uses the `modelAttribute="newUser"` to bind form data to the `User` object in the controller's `register()` method.
   - The form fields are created using the `<form:input>` tag, and the validation errors are displayed using `<form:errors>`.

2. **`index.jsp`:** This view displays the login form for existing users. It uses the Spring Form taglib (`form`) to generate the form fields and handle form submissions. Here's a breakdown of the view:
   - The form action is set to `/book-club/login`, which maps to the `login()` method in the controller.
   - The form uses the `modelAttribute="loginUser"` to bind form data to the `LoginUser` object in the controller's `login()` method.
   - The form fields are created using the `<form:input>` tag, and the validation errors are displayed using `<form:errors>`.

3. **`home.jsp`:** This view displays the book club dashboard, showing all books available and books that the logged-in user is borrowing. It uses the Core taglib (`c`) for conditional rendering and iterating over books. Here's a breakdown of the view:
   - The view shows a welcome message with the user's first name and username. It also provides a link to log out, which points to `/book-club/logout`.
   - The view displays a link to add a new book, which points to `/book-club/books/new`.
   - It then checks if there are any books available. If there are no books, it displays a message indicating that there are no registered books.
   - If there are books available, it displays a table with the book ID, title, author, and owner's username. The table also includes actions, such as "Edit" and "Delete," which are available only for books owned by the currently logged-in user. For other books not owned by the user, a "Borrow" button is displayed instead.
   - The view also displays a separate table showing the books that the logged-in user is currently borrowing. If the user is not borrowing any books, a message is displayed indicating so. If there are borrowed books, the table shows the book ID, title, author, owner's username, and a "Return" button for each book.

Overall, the views provide an intuitive user interface for user registration, login, and book club dashboard. The views use Bootstrap for styling and formatting to enhance the user experience. The Spring Form and Core taglibs are utilized to handle form submissions, display validation errors, and efficiently loop through books in the dashboard view.

## Demo

<!--
<div style="display: flex; flex-wrap: wrap; justify-content: center; align-items: center;">
    <figure style="margin-bottom: 2rem;">
        <img src="bookclub-readme-assets/Book_Club-Desktop_View.jpg" alt="Book_Club-Desktop_View" width="450">
        <figcaption>Book Club - Desktop View</figcaption>
    </figure>
    <div style="display: flex; justify-content: center; align-items: center;">
        <figure style="margin-bottom: 2rem;">
            <img src="bookclub-readme-assets/Book_Club-Mobile_View.jpg" alt="Book_Club-Mobile_View" width="450">
            <figcaption>Book Club - Mobile View</figcaption>
        </figure>
        <figure style="margin-bottom: 2rem;">
            <img src="bookclub-readme-assets/Book_Club-Mobile_Resposiveness.GIF" alt="Book_Club-Mobile_Responsiveness" width="450">
            <figcaption>Book Club - User Authentication Demo</figcaption>
        </figure>
    </div>
    <figure style="margin-bottom: 2rem;">
        <img src="bookclub-readme-assets/Book_Club-Validations.GIF" alt="Book_Club-Validations" width="450">
        <figcaption>Validations triggered upon invalid submission.</figcaption>
    </figure>
    <figure style="margin-bottom: 2rem;">
        <img src="bookclub-readme-assets/Book_Club-First_Use.GIF" alt="Book_Club-First_Use" width="450">
        <figcaption>Entering the Book Club app for the first time.</figcaption>
    </figure>
    <figure style="margin-bottom: 2rem;">
        <img src="bookclub-readme-assets/Book_Club-Update_and_Delete-Demo.GIF" alt="Book_Club-Update_and_Delete-Demo" width="450">
        <figcaption>Updating and Deleting Book Entries.</figcaption>
    </figure>
    <figure style="margin-bottom: 2rem;">
        <img src="bookclub-readme-assets/Book_Club-View-User_Entries-Demo.GIF" alt="Book_Club-View-User_Entries-Demo" width="450">
        <figcaption>Accessing own book entries vs. other users' book entries.</figcaption>
    </figure>
</div> -->