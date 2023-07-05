# Save Travels

### Overview

**Save Travels Expense Tracker** is a Java Spring project designed to help users track their expenses. The project follows the MVC (Model-View-Controller) architecture to manage and display expense data through JSP (JavaServer Pages) for the view layer.

## Configuration

The `application.properties` file contains the configuration settings for the project. In this case, it specifies the database connection details (URL, username, and password) and sets the Hibernate DDL mode to "update," which means that the database schema will be automatically updated based on the entity classes. The line `spring.mvc.view.prefix=/WEB-INF/` sets the prefix for the JSP view files. And finally, `spring.mvc.hiddenmethod.filter.enabled=true` enables the hidden method filter in Spring MVC. This filter allows the use of hidden input fields in forms to send HTTP requests with non-GET methods (such as PUT, DELETE, etc.), which is useful for RESTful APIs.

### Dependencies

The project includes several dependencies in the `pom.xml` file that are necessary for its proper functioning:

1. **`tomcat-embed-jasper`**: This dependency allows the use of JSP (JavaServer Pages) for rendering dynamic web pages.
2. **`spring-boot-starter-validation`**: It provides support for validation annotations used in the model classes to enforce data constraints.
3. **`jakarta.servlet.jsp.jstl-api`** and **`jakarta.servlet.jsp.jstl`**: These dependencies enable the use of JSTL (JavaServer Pages Standard Tag Library) tags in JSP files.
4. **`webjars-locator`** and **`bootstrap`**: These dependencies allow the usage of Bootstrap, a popular CSS framework, in the project.


## Models, Repository and Service

### Model

The `Expense` class represents the model for a expense entry. It defines the structure and properties of a Expense object, such as its expenseName, vendor, amount, description, and timestamps for creation and update. It also includes annotations for database mapping and validation constraints. The Expense class provides getters and setters for accessing and modifying the expense's attributes.

### Repository

The `ExpenseRepository` interface extends the `CrudRepository` interface from Spring Data JPA. It serves as the interface between your application and the database, allowing you to perform CRUD (Create, Read, Update, Delete) operations on the Expense objects. The ExpenseRepository provides methods for retrieving all expenses from the database and is responsible for interacting with the underlying database implementation.

### Service

The `ExpenseService` class acts as an intermediary between the controller and the repository. It acts as an intermediary between the controller and the repository, encapsulating the logic for handling CRUD operations on expenses. The `ExpenseService` class defines methods for retrieving all expenses, creating a new expense, finding a specific expense by its ID, updating an expense, and deleting an expense. It uses the ExpenseRepository to interact with the database and performs any necessary data manipulation or validation before delegating the operations to the repository.

These three files work together to implement the **Save Travels Expense Tracker** application's functionality. The Expense model defines the structure of the expense objects, the `ExpenseRepository` handles the database operations, and the `ExpenseService` encapsulates the business logic for working with expenses.

## Controller

The **`ExpenseController`** class serves as the controller in your **Save Travels** project. It handles the incoming HTTP requests related to expense and interacts with the `ExpenseService` to perform the necessary operations. The controller includes various methods annotated with `@GetMapping`, `@PostMapping`, `@RequestMapping`, and `@DeleteMapping` to map the corresponding HTTP methods and endpoints. The `index` method retrieves all expenses, `create` creates a new expense, `showExpense` retrieves a specific expense by ID, `editExpense` retrieves an expense for editing, `update` updates an existing expense, and `delete` deletes an expense. The **ExpenseController** acts as the bridge between the user's actions and the underlying service layer, allowing the application to handle HTTP requests and manage expense-related operations.

## View

- **`index.jsp`**: retrieves a list of expenses from the Controller using the `${expenses}` expression, which corresponds to the expense model attribute returned by the Controller's index method.It iterates over the expenses using the `<c:forEach>` tag, displaying the expense details within the table rows. 

    The Edit and Delete actions are formed as links and forms, respectively, allowing the user to update or delete a specific expense. These actions utilize the endpoints provided by the Controller (`/expenses/${expense.id}/edit` and `/expenses/${expense.id}`).

- **`read-one.jsp`**: displays the details of a specific expense. It accesses the expense details using the `${expense}` expression, which corresponds to the expense model attribute returned by the Controller's `showExpense()` method.
The expense details, such as name, notes, restaurant, and rating, are displayed using the `<c:out>` tag.

- **`update-form.jsp`**: renders a form that allows the user to edit an expense. The form is pre-populated with the existing expense details by accessing the `${expense}` expression, which corresponds to the expense model attribute returned by the Controller's `editExpense` method. The form's action attribute is set to `/expenses/${expense.id}`, and the `_method` input field is populated with the value "put", which indicates that the form submission should be treated as an HTTP PUT request. The user can update the expense's name, vendor, amount, and description using the form fields.

### Summary

<!-- In summary, the **Save Travels** project utilizes models to define the structure of expense objects, a repository interface for database operations, a service to handle the business logic, and a controller to handle HTTP requests and manage the flow of data between the view and the service layer. The JSP files provide the user interface for displaying and adding expense information. -->
