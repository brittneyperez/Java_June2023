## **Week 4** - D12 |  ２０２３年０６月２９日（木）

### Recap
- **Java Spring MVC**
    - JSTL Forms
    - `@ModelAttribute`
    - Data Binding
    - `@Valid`
    - BindingResult
    - Rendering `findById() + .jsp`
    - Rendering `findAll() + .jsp`

## Topics to Cover
- **Java Spring MVC** (continued...)
    - `@ModelAttribute`
    - Data Binding
    - Hidden Inputs
    - Update
    - `@PutMapping`
    - Delete
    - `@DeleteMapping`
    - Full Stack MVC Single Object CRUD Review

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

### Controller: **TweetController.java**

The TweetController.java file is the controller class responsible for handling HTTP requests related to tweets in the TweetDemo project. It maps and handles different URL endpoints for tweet-related operations. The controller class is annotated with @Controller to mark it as a Spring MVC controller. It has a dependency on the TweetService class, which is autowired using the @Autowired annotation. The controller includes methods such as index(), createTweet(), editTweet(), and destroyMeAlternate() to handle operations like displaying all tweets, creating a new tweet, editing a tweet, and deleting a tweet, respectively.

These files and concepts work together to implement the **TweetDemo** project's functionality. The Tweet.java model class defines the structure and properties of a tweet. The TweetRepo.java repository interface provides the methods to interact with the database and perform CRUD operations on tweets. The TweetService.java service class encapsulates the business logic for working with tweets, and the TweetController.java controller class handles incoming requests, interacts with the service layer, and renders appropriate views to display tweet-related information.

## View
Certainly! Here's how the `index.jsp` and `update.jsp` files relate to rendering the data in the TweetDemo project:

### **index.jsp:**

The `index.jsp` file is responsible for rendering the home page of the TweetDemo application. It displays a form to create new tweets and a table to show all existing tweets. The form is defined using the `<form:form>` tag from the Spring Form tag library. It is bound to the `tweet` model attribute, which represents a new tweet. The form has inputs for the tweet content and an imaginary integer attribute. Validation errors are displayed using the `<form:errors>` tag. Upon submission, the form is posted to the `/tweets/post` endpoint in the `TweetController` for tweet creation. The table in the `index.jsp` file is populated using the `<c:forEach>` tag, which iterates over the list of tweets (`${tweets}`). It displays the tweet ID, content, creation and update dates, and the imaginary integer attribute. Each tweet in the table has links to edit and delete the tweet, which are handled by the `TweetController`.

### **update.jsp:**

The `update.jsp` file is responsible for rendering the form to edit a specific tweet in the TweetDemo application. It displays the edit form with pre-filled values of the tweet to be edited. The form is defined using the `<form:form>` tag, similar to the one in `index.jsp`. The form is bound to the `tweetToEdit` model attribute, which represents the tweet being edited. The form is posted to the `/tweets/${tweetToEdit.id}/update` endpoint in the `TweetController` for tweet update. It includes a hidden input field with the `_method` parameter set to "put" to simulate a `PUT` request. The form has inputs for modifying the tweet content and the imaginary integer attribute. Validation errors, if any, are displayed using the `<form:errors>` tag.

In summary, `index.jsp` renders the home page with a form to create new tweets and a table displaying existing tweets. It interacts with the `TweetController` to handle tweet creation, deletion, and editing. `update.jsp` is responsible for rendering the form to edit a specific tweet, pre-populating the form fields with the existing tweet data. It also interacts with the `TweetController` to handle the tweet update.