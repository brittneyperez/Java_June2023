## **Week 5** - D13 |  ２０２３年０７月０５日（火）

### Recap
- **Java Spring MVC** (continued...)
    - `@ModelAttribute`
    - Data Binding
    - Hidden Inputs
    - Update
    - `@PutMapping`
    - Delete
    - `@DeleteMapping`
    - Full Stack MVC Single Object CRUD Review

## Topics to Cover
- **Database Relationships**
    - Relationships
    - `@OneToOne`
    - `@OneToMany`
    - `@ManyToOne`
    - More Data Binding

---

# TwitterDemo

The changes made to the TwitterDemo project were necessary to implement a one-to-many relationship between the `User` and `Tweet` models. The addition of the `User` model, along with the `@OneToMany` annotation in the `User` class and the `@ManyToOne` annotation in the `Tweet` class, establishes the relationship between users and tweets. The `UserRepository` and `UserService` were created to provide the necessary database operations for users. However, it's important to note that for the tweets to be posted under a specific user, the `user_id` needs to be provided and stored in the session attribute of the controller, simulating a logged-in user. This disclaimer is important to ensure that tweets are associated with the correct user in the one-to-many relationship.

To add a one-to-many relationship between the `User` and `Tweet` models in the TwitterDemo project, you made the following changes:

1. **Added User Model:**
In the `com.javalecture.twitterdemo.models` package, a new Java class called `User` was created. It is annotated with `@Entity` and `@Table(name="users")` to indicate that it represents a database entity and corresponds to the "users" table in the database. The class includes attributes such as `firstName`, `lastName`, `email`, and `password` representing user details. It also includes a **one-to-many** relationship with the `Tweet` model using the `@OneToMany` annotation, specifying that one user can have multiple tweets.

2. **Updated Tweet Model:**
In the existing `Tweet` model class, a `creator` attribute of type `User` was added to establish the **many-to-one** relationship. This relationship is specified using the `@ManyToOne` annotation, indicating that many tweets can be created by one user. It is mapped to the "`user_id`" column in the tweets table using `@JoinColumn(name="user_id")`.

3. **Added UserRepository:**
In the `com.javalecture.twitterdemo.repositories` package, a `UserRepository` interface is created by extending the `CrudRepository` interface. This interface provides the basic CRUD operations (create, read, update, delete) for the `User` entity. It includes a method `findAll()` to retrieve all users from the database.

4. **Added UserService:**
In the `com.javalecture.twitterdemo.services` package, a `UserService` class is created. Annotated with `@Service`, it indicates that it provides business logic related to users. The class includes methods to interact with the `UserRepository` for creating, reading, updating, and deleting users.

5. **Updated TweetController:**
In the `com.javalecture.twitterdemo.controllers` package, the following changes were made to `TweetController` class: The `UserService` is injected into the controller using `@Autowired` and a private field `uService` is created to access user-related operations.

- `index` method: In the `index` method, the `loggedInUser` session attribute is used to simulate a logged-in user. It sets a pseudo user ID (3 in this case) to the session attribute. This user ID is used when creating a new tweet to set the creator of the tweet.

- `createTweet` method: In the `createTweet` method, the creator of the new tweet is set using `newTweet.setCreator()` and and it retrieves the user from the session attribute using `uService.getUserById()`. This establishes the relationship between the tweet and the user.

The methods `editTweet()`, `updateTweet()`, and `deleteTweet()` were left unaltered.

These changes enable the one-to-many relationship between users and tweets in the TwitterDemo project. The `User` entity can have multiple associated tweets, and the `Tweet` entity is linked to its creator through the `creator` attribute.

6. **Updated index.jsp**

The changes made to the `index.jsp` file in the TwitterDemo project are primarily related to displaying and interacting with tweets in the context of the one-to-many relationship. The form section allows users to create new tweets by submitting the form data to the `/tweets/post` endpoint. The tweets are displayed in a table using a `<c:forEach>` loop, where each tweet's content, creation date, and creator's information are shown. Additionally, the edit and delete links/buttons are provided to allow users to modify or remove specific tweets. It's important to note that the `loggedInUser` value, representing the current user's `user_id`, needs to be stored in the session attribute for proper association of tweets with users in the one-to-many relationship.

[Click here to see the original TwitterDemo.](https://github.com/brittneyperez/Java_June2023/tree/f14550c67da3c34465ba809551b79542cc9e0ecb/week_4-Java_Spring_MVC/Lecture_Notes/D12-Update_and_Delete)