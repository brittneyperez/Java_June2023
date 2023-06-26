# Display Date & Time

The **Display Date & Time** project is a Java Spring application that allows users to view the current date and time. It consists of several Java files, JSP files, and a JavaScript file. Let's go over the different components and their functionalities:

### `application.properties`

The line of code `spring.mvc.view.prefix=/WEB-INF/` in the application.properties file is needed to configure the view prefix for Spring MVC. It specifies the location where the JSP files are stored. In this case, the JSP files are located in the "/WEB-INF/" directory.

### Dependencies

The project requires several dependencies specified in the pom.xml file. These dependencies are necessary for the project to work correctly. Here are the main dependencies and their purposes:

- **`tomcat-embed-jasper`**: This dependency provides support for JSP rendering within the embedded Tomcat server.
- **`jakarta.servlet.jsp.jstl-api`**: This dependency contains the JSP Standard Tag Library (JSTL) API classes.
- **`jakarta.servlet.jsp.jstl`**: This dependency provides the JSTL implementation.
- **`webjars-locator`**: This dependency is used to locate web resources packaged as WebJars.
- **`bootstrap`**: This dependency includes the Bootstrap framework, which is used for styling the web pages.

## **DateTimeController**

The `DateTimeController` class is a Spring MVC controller responsible for handling requests related to displaying the date and time. It contains three request mappings:

- **`index()`**: This mapping handles the root ("/") request and redirects it to the "`/home`" endpoint.
- **`displayDate()`**: This mapping handles the "`/home/date`" request. It retrieves the current date, formats it using `SimpleDateFormat`, and adds it to the model. The **date.jsp** file is then rendered to display the current date.
- **`displayTime()`**: This mapping handles the "`/home/time`" request. Similar to `displayDate()`, it retrieves the current time, formats it, and adds it to the model. The time.jsp file is then rendered to display the current time.

## JSP Files

- **home.jsp**: This file serves as the main page for the application. It displays the project title, assignment information, and provides links to navigate to the date and time pages.
- **date.jsp**: This file displays the current date. It retrieves the date value from the model and renders it.
- **time.jsp**: This file displays the current time. Similar to date.jsp, it retrieves the time value from the model and renders it.

## template.js

The **template.js** file contains JavaScript code that determines the current page URL and displays an alert accordingly. If the URL contains "`/home/date`", an alert saying "This is the date template" is displayed. Similarly, if the URL contains "`/home/time`", an alert saying "This is the time template" is displayed. Otherwise, if it's a different template, an alert saying "This is a different template" is shown.
