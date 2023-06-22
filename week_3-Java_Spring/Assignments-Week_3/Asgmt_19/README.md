# Hello Human

This Spring application demonstrates the usage of query parameters in routing. The purpose of this project is to learn how to handle query parameters in a Spring Controller and provide different responses based on the parameters provided in the URL.

## `MainController`

The `MainController` class is the main controller of the application. It is annotated with @RestController and handles the incoming HTTP requests for the `/hello rout`e.


## **Query Parameters**

Query parameters are key-value pairs added to the end of a URL after a question mark (`?`). In this project, query parameters are used to pass additional information to the server and customize the response. Query parameters are optional and can be included or excluded in the URL.


## Routes and Descriptions

### 1. Route: `/hello`

- Description: This route handles the default greeting when no name is provided as a query parameter.
- Usage: [localhost:8080/hello](#)
- Response: Displays "Hello Human" if no name is provided. If a name is provided as a query parameter (`?name=<name>`), it will display "Hello `<name>`".

### 2. Route: `/hello/fullname`

- Description: This route handles displaying a full name based on the provided first name and last name as query parameters.
- Usage: [localhost:8080/hello/fullname?first_name=`<first_name>`&last_name=`<last_name>`](#)
- Response: Displays "Hello `<first_name>` `<last_name>`" if both first name and last name are provided. If only the first name is provided, it will display "Hello `<first_name>`". If no name is provided, it will display "Hello Human".

### 3. Route: `/hello/repeat`

- Description: This route handles repeating the greeting message a specified number of times based on the times query parameter.
- Usage: [localhost:8080/hello/repeat?fName=`<first_name>`&lName=`<last_name>`&times=`<times>`](#)
- Response: Displays the greeting message repeated <times> number of times. If both first name and last name are provided, it will display "Hello `<first_name>` `<last_name>`" repeated `<times>` times. If only the first name is provided, it will display "Hello `<first_name>`" repeated `<times>` times. If no name is provided, it will display "Hello Human" repeated `<times>` times.

Disclaimer: While it was not necessary, different variations of the code were written to demonstrate different aspects and variations of query parameters in Spring applications.