# Counter

### Overview

Counter is a simple Java Spring project that implements a visit counter web application. It keeps track of the number of times a user visits a specific URL and provides basic functionality such as incrementing the counter, resetting it, and displaying a welcome message based on the visit count.

## Configuration

To properly configure the project, make sure to include the following line in the `application.properties` file:

```
spring.mvc.view.prefix=/WEB-INF/
```

This configuration specifies the prefix for the Spring MVC view resolver, which indicates the location of the JSP files.

### Dependencies

The project relies on the following dependencies defined in the `pom.xml` file:

- `tomcat-embed-jasper`: Provides JSP rendering capabilities within the embedded Tomcat server.
- `jakarta.servlet.jsp.jstl-api` and `jakarta.servlet.jsp.jstl`: Implement the JSTL (JavaServer Pages Standard Tag Library) tags, which facilitate the display logic in JSP files.
- `webjars-locator` and `bootstrap`: Allow the usage of Bootstrap framework in the web application for styling purposes.

## **CounterApplication**

The `CounterApplication` class is the entry point of the application. It is annotated with _`@SpringBootApplication`_ to enable Spring Boot auto-configuration and component scanning. The class also includes a request mapping for the root URL `("/")`, which redirects to the "`/my_server`" URL, where the counter functionality is located.

## **CounterController**

The `CounterController` class is a Spring MVC controller responsible for handling the HTTP requests related to the visit counter functionality. It contains the following methods:

- `index`: Handles the root URL request ("`/my_server`") and displays the welcome message. It retrieves the visit count from the session and passes it to the `welcome.jsp` view.
- `displayCounter`: Increments the visit counter by 1 and displays the updated count in the `counter.jsp` view.
- `displayCounter2`: Increments the visit counter by 2 and displays the updated count in the `counter.jsp` view.
- `resetCounter`: Resets the visit counter by removing the count attribute from the session and redirects to the `welcome.jsp` view.

## **JSP Files** & **JSTL Tags**

- `welcome.jsp`: This JSP file displays a welcome message based on the visit count. It uses the JSTL `<c:choose>`, `<c:when>`, and `<c:otherwise>` tags to perform the conditional logic. If the visit count is null or less than 1, it displays "Welcome User!" message; otherwise, it displays "Welcome back, User!" message. The file also includes links to navigate to the counter pages and reset the counter.
- `counter.jsp`: This JSP file displays the current visit count. It retrieves the count value from the model passed by the controller and displays it using the JSTL `<c:out>` tag. It also provides a link to test another visit.

These JSP files, along with the use of JSTL tags, enable dynamic content generation and conditional rendering based on the visit count.