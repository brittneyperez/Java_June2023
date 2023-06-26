# Hopper's Receipt

### Synopsis
Grace Hopper is giving a talk at MIT. But first she needs to order some thin metal wires to represent nanoseconds to help her audience understand the speed of signals. As it happens, Market2, a new third-party purchasing app has all her needs covered, as well as anyone else who needs to order from a small local business.


### **`application.properties`**

```
spring.mvc.view.prefix=/WEB-INF/
```

The above line of code in `application.properties` is needed to configure the Spring MVC view prefix. It sets the prefix for the location of the web application's view files. In this case, the prefix is set to `/WEB-INF/`, which means that the view files will be located in the `WEB-INF` directory.

### Dependencies

The following dependencies are required for the project to work:

```xml
<dependencies>
...
	<dependency>
		<groupId>org.apache.tomcat.embed</groupId>
		<artifactId>tomcat-embed-jasper</artifactId>
	</dependency>
	<dependency>
		<groupId>jakarta.servlet.jsp.jstl</groupId>
		<artifactId>jakarta.servlet.jsp.jstl-api</artifactId>
	</dependency>
	<dependency>
		<groupId>org.glassfish.web</groupId>
		<artifactId>jakarta.servlet.jsp.jstl</artifactId>
	</dependency>
</dependencies>
```

- `tomcat-embed-jasper`: This dependency allows the embedded Tomcat server to support JSP rendering. It provides the necessary components to compile and render JSP files.

- `jakarta.servlet.jsp.jstl-api` and `jakarta.servlet.jsp.jstl`: These dependencies provide the JavaServer Pages Standard Tag Library (JSTL) implementation. JSTL is a collection of custom tags that simplify the development of JSP pages by providing common functionality, such as loops and conditional statements.


## **`HopperController`**

The `HopperController` is a Spring MVC controller that handles requests related to the receipt. It is annotated with `@Controller`, indicating that it is a Spring bean responsible for handling web requests.

The controller has a single method, `index()`, annotated with `@RequestMapping`. This method handles requests to the `/receipt` URL. It prepares the data required for the receipt by setting various attributes in the `Model` object.

The attributes include the customer name, item name, price, description, and vendor. These values are hardcoded in the method for demonstration purposes. The method returns the name of the JSP file, `index.jsp`, which will be used to render the receipt.


## **`index.jsp`**

`index.jsp` is the JSP file responsible for rendering the receipt. It starts with the standard JSP directives and imports. The JSTL core taglib is also imported to provide support for JSTL tags.

The JSP file contains HTML markup and JSP tags. The customer name, item name, price, description, and vendor are retrieved from the model using JSP expression language `${...}` and displayed in the appropriate HTML elements.

Inline styling is applied using the `style` attribute to control the color of some text elements. The receipt details are enclosed in a `<div>` with the class `item_details` for styling purposes.

Overall, the `HopperController` and `index.jsp` work together to handle requests to the `/receipt` URL and display the receipt information in the browser. The controller sets the necessary data in the model, and the JSP file uses that data to render the receipt HTML.