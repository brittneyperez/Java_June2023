## **Week 4** - D10 |  ２０２３年０６月２７日（火）

### Recap
- **Java Spring** (finished)
    - Spring w/View
    - Form Submission
    - `GET` & `POST`
    - Session
    - Redirecting
    - Flash
    - Dependency Injection

## Topics to Cover
- **Java Spring MVC**
    - MVC Design
    - Spring Data JPA
    - Connecting MySQL to Spring
    - Domain Models
    - Validations
    - Repositories
    - Services

---

# TwitterDemo

## Database Configuration
Sure! Here's a summary explanation of each line in your `application.properties` file for the TweetDemo project:

1. `spring.datasource.url=jdbc:mysql://localhost:3306/java-twitter-lecturedemo?createDatabaseIfNotExist=true`: 
   - This line specifies the URL for connecting to the database. It indicates that the project will be using MySQL and connecting to the local database server running on `localhost` with port `3306`. The `java-twitter-lecturedemo` is the name of the database schema, and `createDatabaseIfNotExist=true` ensures that the schema will be created if it doesn't already exist.

2. `spring.datasource.username=root`
   - This line sets the username for accessing the database. In this case, the username is set to `root`.

3. `spring.datasource.password=rootroot`
   - This line sets the password for accessing the database. The password is set to `rootroot` in this example.

4. `spring.jpa.hibernate.ddl-auto=update`
   - This line configures the behavior of Hibernate's schema generation tool. Setting it to `update` means that Hibernate will automatically update the database schema based on the entity classes defined in your application. It will add any missing tables or columns and update the existing schema if necessary.

5. `spring.mvc.view.prefix=/WEB-INF/`
   - This line specifies the prefix for the views (templates) used in the Spring MVC framework. The `/WEB-INF/` prefix indicates that the views are located in the `WEB-INF` directory of your project.

6. `spring.mvc.hiddenmethod.filter.enabled=true`
   - This line enables the hidden method filter in Spring MVC. The hidden method filter allows you to use hidden form inputs in your HTML forms to simulate HTTP methods like PUT, DELETE, etc. This feature is useful when working with RESTful APIs that expect different HTTP methods for different actions.

These configurations provide settings for your database connection, database schema management, view template resolution, and form handling in your Spring MVC application.

## Models, Repositories, and Service

### Model: **Tweet.java**

The `Tweet` class represents a tweet object in the TweetDemo application. It is annotated with `@Entity` to indicate that it is a persistent entity in a database. The class defines attributes such as `id`, `createdAt`, `updatedAt`, `tweetContent`, and `imaginaryIntAtt`. It also includes JPA annotations for database mapping and validation annotations for input validation. This class provides constructors, getters, and setters for accessing and manipulating tweet data.

### Repository Interface: **TweetRepo.java**

The `TweetRepository` interface extends `CrudRepository` to access CRUD (Create, Read, Update, Delete) functionality for the `Tweet` entity. It defines a method `findAll()` to retrieve all tweets from the database. The repository is annotated with `@Repository` to indicate it as a Spring component responsible for data access.

### Service: **TweetService.java**

The `TweetService` class acts as an intermediary between the repository and the controller. It is annotated with `@Service` to mark it as a Spring service component. The service class uses the `TweetRepository` by autowiring it as a dependency. It provides methods for creating and retrieving tweets from the repository. The `create()` method saves a new tweet to the database, while the `getAll()` method retrieves all tweets from the database. It also includes a method `getById()` to retrieve a specific tweet by its ID.

### **RestController: TweetApiController.java**

The `TweetApiController` class is a RESTful controller that handles HTTP requests related to tweets. It is annotated with `@RestController` to indicate that it handles REST API endpoints. The controller communicates with the `TweetService` by autowiring it as a dependency. The controller defines several endpoints: 
- `createTweet()`: a `POST` endpoint that receives tweet content and an imaginary integer attribute as request parameters. It creates a new `Tweet` object and saves it using the `TweetService`.
- `index()`: a `GET` endpoint that retrieves all tweets from the `TweetService`.
- `showOneTweet()`: a `GET` endpoint that retrieves a specific tweet by its ID from the `TweetService`.

These components work together to create, read, update, and delete tweet data in the TweetDemo application. The model represents the tweet object, the repository provides data access methods, the service handles business logic, and the controller exposes RESTful endpoints for interacting with tweets.