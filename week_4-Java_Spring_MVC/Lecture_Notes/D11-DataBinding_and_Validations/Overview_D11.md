## **Week 4** - D11 |  ２０２３年０６月２８日（水）

### Recap
- **Java Spring MVC**
    - MVC Design
    - Spring Data JPA
    - Connecting MySQL to Spring
    - Domain Models
    - Validations
    - Repositories
    - Services

## Topics to Cover
- **Java Spring MVC** (continued...)
    - JSTL Forms
    - `@ModelAttribute`
    - Data Binding
    - `@Valid`
    - BindingResult
    - Rendering `findById()` + `.jsp`
    - Rendering `findAll()` + `.jsp`

---

# TwitterDemo (continued...)

### Database Configuration
Each line in your `application.properties` file for the **TweetDemo** project:

1. `spring.datasource.url`: Sets the URL for connecting to the MySQL database on localhost with the specified schema name.

2. `spring.datasource.username`: Specifies the username for accessing the database.

3. `spring.datasource.password`: Sets the password for accessing the database.

4. `spring.jpa.hibernate.ddl-auto`: Configures Hibernate to update the database schema based on the entity classes.

5. `spring.mvc.view.prefix`: Specifies the prefix for the views/templates used in Spring MVC.

6. `spring.mvc.hiddenmethod.filter.enabled`: Enables the hidden method filter for handling hidden form inputs and HTTP methods in Spring MVC.

These configurations control the database connection, schema management, view template resolution, and form handling in your TweetDemo project.

## Models, Repositories, and Service

### Model: **Tweet.java**

The `Tweet.java` file represents the model class for a tweet in the TweetDemo project. It is annotated with `@Entity` to indicate that it is an entity class to be mapped to a database table. The class contains attributes such as `id`, `createdAt`, `updatedAt`, `tweetContent`, and `imaginaryIntAtt` representing various properties of a tweet. It also includes annotations for validation and lifecycle callbacks. The class provides constructors, getters, and setters for accessing and manipulating tweet data.

### Repository Interface: **TweetRepo.java**

The `TweetRepo.java` file is the repository interface for managing tweet data in the TweetDemo project. It extends the `CrudRepository` interface, which provides basic CRUD (Create, Read, Update, Delete) operations for the `Tweet` entity. The interface declares additional methods, such as `findAll()`, to retrieve tweets from the database. The repository interface is annotated with `@Repository` to indicate that it is a Spring-managed repository.

### Service: **TweetService.java**

The `TweetService.java` file represents the service class responsible for handling business logic related to tweets in the TweetDemo project. It is annotated with `@Service` to indicate that it is a Spring-managed service. The class is dependent on the `TweetRepository` interface, which is injected using the `@Autowired` annotation. The service class provides methods for creating, reading, updating, and deleting tweets. For example, it includes `create()` to save a new tweet, `getAll()` to retrieve all tweets, and `getById()` to retrieve a specific tweet by its ID.

### **RestController: TweetApiController.java**

The `TweetController.java` file is the controller class that handles HTTP requests and manages the flow of data between the user interface and the TweetDemo application. It is annotated with `@Controller` to mark it as a Spring MVC controller. The controller includes various request mapping methods such as `index()` and `createTweet()`, which correspond to specific URL endpoints. The controller interacts with the `TweetService` to perform actions such as retrieving all tweets, creating a new tweet, and displaying the tweets in the user interface. It uses model attributes to pass data to the views and validates tweet data using `@Valid` and `BindingResult`.

These files represent the core components of the TweetDemo project, including the data model (`Tweet.java`), the repository for data access (`TweetRepo.java`), the service layer for business logic (`TweetService.java`), and the controller for handling user requests and managing the application flow (`TweetController.java`). Together, they enable the functionality to create, retrieve, update, and delete tweets in the TweetDemo application.

## View
In the TweetDemo project, the `index.jsp` file is responsible for rendering the data and presenting it to the user interface. Here's how it relates to the other files and concepts:

The `index()` method in the `TweetController.java` class is mapped to the URL endpoint specified as `"/tweets"`. When a user accesses this endpoint, the `index()` method is invoked. Inside the method, it retrieves all tweets from the `TweetService` using the `getAll()` method and adds them as a model attribute named "tweets". It also adds a new `Tweet` object as a model attribute named "tweet".

The `index.jsp` file receives these model attributes from the `index()` method. It can access the list of tweets by referencing `${tweets}` and the new tweet object by referencing `${tweet}`. By using JSP expression language and JSP tags, the `index.jsp` file can iterate over the list of tweets and display their content and other attributes. It can also display form inputs to allow users to create new tweets.

When a user submits the form to create a new tweet, the `createTweet()` method in the `TweetController.java` class is invoked. It is mapped to the URL endpoint `"/tweets/post/tweet"`. This method receives the `@Valid` annotated `Tweet` object as a parameter, along with `BindingResult` to handle validation errors. If there are validation errors, the `index.jsp` file is rendered again, displaying the errors. Otherwise, the `TweetService`'s `create()` method is called to save the new tweet to the database.

In summary, the `index.jsp` file interacts with the `TweetController.java` class to display a list of tweets, allow users to create new tweets, and handle the submission of the new tweet form. It relies on the model attributes provided by the controller to access and display the tweet data.