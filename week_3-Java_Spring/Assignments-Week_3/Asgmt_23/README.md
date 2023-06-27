## Fruity Loops Project

**Fruity Loops** is a Java Spring project that showcases a simple web application for managing a fruit store inventory. It allows users to view a list of fruits along with their prices.

## Configuration

The `application.properties` file contains the following line of code:
```
spring.mvc.view.prefix=/WEB-INF/
```

This configuration is needed to specify the prefix for the view templates. In this case, it points to the `/WEB-INF/` directory, which is where the JSP files are located.

### Dependencies

The project has the following dependencies specified in the `pom.xml` file:

- `tomcat-embed-jasper`: This dependency allows the embedded Tomcat server to handle JSP rendering.

- `jakarta.servlet.jsp.jstl-api` and `jakarta.servlet.jsp.jstl`: These dependencies provide the JSTL (JavaServer Pages Standard Tag Library) API and implementation, which are required for using JSTL tags in the JSP files.

- `webjars-locator`: This dependency enables the use of WebJars, which are client-side web libraries packaged as JAR files.

- `bootstrap`: This dependency provides the Bootstrap CSS framework for styling the web application.

- `jstl`: This dependency includes the JSTL library, which is used for various JSP-related functionalities.


## Model: **Item**

The `Item` class represents a fruit item in the inventory. It has two member variables: `name` and `price`, along with their corresponding getters and setters. The class provides a constructor to initialize these variables when creating a new `Item` object.

## Controller: **ItemController**

The `ItemController` class is a Spring controller responsible for handling requests related to the fruit store inventory. The `index` method is annotated with `@RequestMapping("/")` to map the root URL of the application. Inside the method, a list of `Item` objects (fruitsBasket) is created and populated with sample fruit data. The list is then added to the model using `model.addAttribute("fruits", fruitsBasket)`, making it accessible in the corresponding JSP file.

## JSP File: **index.jsp**

The `index.jsp` file is the main view template of the web application. It displays a table of fruits along with their prices. The JSP file includes the necessary taglib declarations for using JSTL and the fmt (format) library.

The JSTL `<c:forEach>` tag is used to iterate over the list of fruits (`${fruits}`) in the model. Within the loop, each fruit's name is displayed in a table cell. Additionally, the `<c:choose>`, `<c:when>`, and `<c:otherwise>` tags are used to conditionally format the font color of fruits that start with the letter 'G' as orange.

The fmt `<fmt:formatNumber>` tag is used to format the fruit prices with proper decimal formatting.

## Conclusion

In conclusion, the Fruity Loops project demonstrates a simple web application using Java Spring, JSP, and JSTL. It allows users to view and interact with a fruit store inventory. The README.md provides an overview of the project's configuration, dependencies, model class, controller, and JSP file, giving users a clear understanding of the project's structure and functionality.