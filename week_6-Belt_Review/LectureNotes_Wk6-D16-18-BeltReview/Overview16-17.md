## **Week 6** - D16-18 |  ２０２３年０７月１１日（火）ー　２０２３年０７月１３日（木）

### Recap

- **Database Relationships** (continued...)
    - Project Set Up Review
    - Creating a "Helper" Class
    - Updating User.java
    - Login & Reg `.jsp`
    - Data Binding multiple forms on one view
    - Password Security
    - Service Authentication/Validation Logic

## Topics to Cover
- **Belt Review**
    - Validations
    - MVC Review
    - `@ManyToMany` Table Relationships

# Project Manager Demo

<details>
    <summary>Database and View Configuration</summary>

1. `spring.datasource.url=jdbc:mysql://localhost:3306/java-belt-review?createDatabaseIfNotExist=true`: This line specifies the URL for connecting to the MySQL database. The URL indicates that the database is located on `localhost` at port `3306` and its name is `java-authentication-demo`. The `createDatabaseIfNotExist=true` parameter instructs the system to create the database if it doesn't already exist.

2. `spring.datasource.username=root`: This line specifies the username to be used when connecting to the database. In this case, it is set to `root`.

3. `spring.datasource.password=rootroot`: This line specifies the password associated with the username used to connect to the database. In this case, the password is set to `rootroot`.

4. `spring.jpa.hibernate.ddl-auto=update`: This line configures the behavior of Hibernate, the ORM (Object-Relational Mapping) framework used by Spring Data JPA. The `ddl-auto` property controls the automatic generation and update of database schema. In this case, it is set to `update`, which means that Hibernate will update the schema based on the entity classes defined in your project.

5. `spring.mvc.view.prefix=/WEB-INF/`: This line configures the prefix for resolving view templates in Spring MVC. It indicates that the view templates are located in the `/WEB-INF/` directory.

6. `spring.mvc.hiddenmethod.filter.enabled=true`: This line enables the hidden method filter in Spring MVC. This filter allows you to use the hidden input field technique for submitting forms with methods other than GET and POST, such as DELETE or PUT.

These configuration properties define various aspects of the Java Spring application, **AuthenticationDemo**, including the database connection, ORM behavior, and view resolution settings.
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

## Model, Repositories, Services, and Validators

### The Models: **`User.java`** & **`Project.java`**

1. `User.java`: The `User` class represents the user entity in the BeltReview application. It is an entity mapped to the "users" table in the database. The class contains member attributes for user information, such as first name, last name, email, username, password, and date of birth. The class also defines table relationship attributes to represent the association between users and projects. Specifically, it has a one-to-many relationship with `myProjects`, indicating that a user can create multiple projects. Additionally, it has a many-to-many relationship with `teamProjects`, indicating that a user can be a team member of multiple projects. These relationships are mapped through the "teams" join table in the database, connecting users to their created projects and projects they have joined as team members.

2. `Project.java`: The `Project` class represents the project entity in the BeltReview application. It is an entity mapped to the "projects" table in the database. The class contains member attributes for project details, such as title, description, and due date. The class also defines table relationship attributes to represent the association between projects and users. It has a many-to-one relationship with `creator`, indicating that a project can have a single user as its creator. Furthermore, it has a many-to-many relationship with `teamMembers`, signifying that a project can have multiple team members. These relationships are mapped through the "teams" join table in the database, connecting projects to their creators and team members.

Both `User.java` and `Project.java` classes utilize JPA annotations such as `@Entity`, `@Table`, `@Id`, `@OneToMany`, `@ManyToOne`, and `@ManyToMany` to define the table relationships and enable ORM (Object-Relational Mapping) for seamless data persistence and retrieval between the Java objects and the underlying database tables.

### The Validator: **LoginValidator.java**:

The `LoginUser` model is a simple class used for validating login credentials in the BeltReview application. It consists of two member variables, `loginCredential` and `password`, both annotated with `@NotEmpty` to ensure they are required and not empty.

Regarding the absence of a separate table for user login credentials in the database, BeltReview utilizes the `User` table to store login information. The `User` table already contains fields for email, username, and password, which are used to authenticate users during login. Therefore, there is no need for an additional table solely dedicated to login credentials. By utilizing the existing `User` table, the application saves resources and simplifies the authentication process, making it more efficient and straightforward.


### Repositories: **`UserRepository.java`** and **`ProjectRepository.java`**

1. `UserRepository.java`: The `UserRepository` interface is responsible for defining data access methods related to the `User` entity in the BeltReview application. It extends the `CrudRepository` interface, which provides basic CRUD (Create, Read, Update, Delete) operations. Additionally, the repository interface defines three custom methods to retrieve user data from the database. The `findAll` method retrieves all users from the database, returning a list of `User` objects. The `findByEmail` method allows the retrieval of a specific user by their email address, and it returns an `Optional` containing the matching user if found. Similarly, the `findByUsername` method enables retrieving a specific user by their username and returns an `Optional` containing the user if it exists.

2. `ProjectRepository.java`: The `ProjectRepository` interface is responsible for defining data access methods related to the `Project` entity in the BeltReview application. It also extends the `CrudRepository` interface, providing basic CRUD operations for the `Project` entity. Additionally, the repository interface defines two custom methods to retrieve project data from the database. The `findAll` method retrieves all projects from the database, returning a list of `Project` objects. The more specific method `findAllByTeamMembersNotContaining` is used to retrieve projects where the provided user is not a team member. This method takes a `User` object as an argument and returns a list of `Project` objects where the user is not part of the team, enabling the display of projects that are joinable by the current user.

### The Services: **`UserService.java`** and **`ProjectService.java`**

The repository interfaces (`UserRepository` and `ProjectRepository`) and the services (`UserService` and `ProjectService`) work together to provide the data access and business logic for the BeltReview application.

1. `UserService.java`: The `UserService` class contains methods related to user registration and authentication. It uses the `UserRepository` interface to interact with the database to perform CRUD operations related to the `User` entity. Specifically, the `findByUserById` method retrieves an existing user by their ID. The `registerUser` method takes care of registering a new user by performing various validations and saving the user to the database using the `save` method from the `UserRepository`. Similarly, the `loginUser` method is responsible for authenticating users during login by validating their credentials against the information stored in the database.

2. `ProjectService.java`: The `ProjectService` class handles project-related operations and team management. It uses the `ProjectRepository` interface to interact with the database for CRUD operations related to the `Project` entity. The `createProject` method allows the creation of a new project, assigning the current user as the team leader, and saving the project to the database using the `save` method from the `ProjectRepository`. The `getAllProjects` and `getProjectById` methods provide retrieval functionality for projects. The `updateProject` method allows updating an existing project, and the `deleteProjectById` method deletes a project by its ID.

Regarding team management, the `joinTeam` method allows a user to join a project's team, while the `leaveTeam` method enables a user to leave a project's team. These methods update the list of team members associated with a project and save the changes to the database using the `save` method from the `ProjectRepository`.

Overall, the repository interfaces provide the data access layer to interact with the database, while the services encapsulate business logic and use the repository interfaces to perform necessary operations on the entities (i.e., `User` and `Project`). The services serve as an intermediary between the controllers (which handle HTTP requests) and the database, providing a separation of concerns in the application architecture.


## Controllers

The `UserController.java` and `ProjectController.java` are responsible for handling HTTP requests related to users and projects, respectively. They interact with the corresponding service classes (`UserService` and `ProjectService`) to perform the necessary business logic and retrieve data from the database.

1. `UserController.java`:
This controller handles user-related operations, such as user registration, login, displaying user information, and logging out. The methods in this controller interact with the `UserService` to perform user-related actions. Here's an overview of the functionalities:
    - `index`: Displays the login/registration page (`index.jsp`) with an empty `User` and `LoginUser` object to handle the registration and login forms.
    - `register`: Handles the registration form submission, validates the user's input, and uses `UserService` to register the new user.
    - `login`: Handles the login form submission, validates the user's input, and uses `UserService` to authenticate the user.
    - `home`: Displays the dashboard page (`home.jsp`) after a successful login, showing all projects and allowing users to join/leave projects.
    - `aboutMe`: Displays the "About Me" page (`about-me.jsp`) for a specific user, showing user details, such as name, age, and date of birth.
    - `logout`: Logs out the user by invalidating the session and redirects to the login/registration page.

2. `ProjectController.java`: This controller handles project-related operations, such as creating projects, updating project details, displaying project information, and allowing users to join/leave projects. The methods in this controller interact with the `ProjectService` to perform project-related actions. Here's an overview of the functionalities:
    - `createProjectForm`: Displays the create project form (`create-project-form.jsp`) with an empty `Project` object to handle project creation.
    - `createProject`: Handles the project creation form submission, validates the user's input, and uses `ProjectService` to create the new project.
    - `showProject`: Displays the project details page (`show-project.jsp`) for a specific project, showing project details and allowing users to join/leave the project.
    - `editProjectForm`: Displays the edit project form (`update-project-form.jsp`) for a specific project, pre-filled with the project's current details.
    - `editProject`: Handles the project update form submission, validates the user's input, and uses `ProjectService` to update the project details.
    - `joinProjectTeam`: Allows users to join a project's team by updating the project's team members using `ProjectService`.
    - `leaveProjectTeam`: Allows users to leave a project's team by updating the project's team members using `ProjectService`.
    - `terminateProject`: Deletes a project by its ID using `ProjectService`.

Overall, both controllers play a crucial role in routing and handling HTTP requests for user and project-related actions. They use service classes to perform business logic and communicate with the database via repository interfaces. The separation of concerns between the controllers, services, and repositories helps maintain a clean and organized architecture for the BeltReview application.


## Views

1. **`index.jsp`**: This is the landing page of the application, which serves as both the registration and login forms for users. It includes HTML, Bootstrap CSS, and JSTL (JavaServer Pages Standard Tag Library) code. The page consists of two sections, one for user registration and the other for user login. The user can fill in the required information and submit the forms to register or log in to the application.

2. **`home.jsp`**: This is the dashboard page of the application, displayed to authenticated users upon successful login. It also uses HTML, Bootstrap CSS, and JSTL code. The page includes a welcome message for the logged-in user and displays two sections: "All Available Projects" and "My Projects." The "All Available Projects" section shows a table with a list of projects that the user can join. If there are no available projects, it prompts the user to create one. The "My Projects" section shows a table with the projects the user is already a part of, along with the option to edit or delete projects created by the user or leave projects joined by the user.

3. **`about-me.jsp`**: This JSP page displays the user's profile information. It includes HTML, Bootstrap CSS, and JSTL code. The page shows details about the currently logged-in user, such as their full name, email, username (with "@"), date of birth, and the date they joined the platform. The user's password is intentionally not shown for security reasons. The page also provides a link to log out and return to the home dashboard.

4. **`create-project-form.jsp`**: This JSP page contains a form to create a new project. It includes HTML, Bootstrap CSS, JSTL, and Spring form tags. The page allows the user to input a project title, description, and due date. When the user submits the form, it sends the project data to the server-side for processing and creation. The page also includes a link to return to the home dashboard.

5. **`show-project.jsp`**: This JSP page displays the details of a specific project. It includes HTML, Bootstrap CSS, and JSTL code. The page shows information about the project, such as its title, description, due date, creation date, and last update date (if applicable). It also shows actions that can be performed on the project. If the currently logged-in user is the creator of the project, they can see buttons to edit the project (linked to the edit page) and delete the project (disabled in this case). If the user is not the creator, these action buttons are not visible. The page also provides a link to return to the home dashboard.

6. **`edit-project.jsp`**: This JSP page allows the user to edit an existing project. It includes HTML, Bootstrap CSS, JSTL, and Spring form tags. The page displays the current project details in input fields, allowing the user to modify the project's title, description, and due date. When the user submits the form, the project data is sent to the server-side for updating. The page also includes a hidden field that carries the HTTP "PUT" method to support the update operation. The page provides a link to return to the home dashboard.
