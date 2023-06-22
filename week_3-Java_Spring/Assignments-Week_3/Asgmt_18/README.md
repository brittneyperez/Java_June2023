# Daily Text Routes

### Synopsis

This project demonstrates the usage of Spring Framework's `@RequestMapping` annotation to create a website that delivers daily Bible texts based on the URL path entered in the browser.

## **Controller**

The **DailyTextController** class is a REST controller responsible for handling incoming HTTP requests and returning the appropriate responses.


## Routes

### Welcome Route

- **Path**: [/dailytext](#)
- **Method**: `GET`
- **Description**: This route is the default route that welcomes the user.
- **Response**: "Welcome!"


### Today's Text Route

- **Path**: [/dailytext/today](#)
- **Method**: `GET`
- **Description**: This route returns the daily Bible text for the current day.
- **Response**: "So never be anxious about the next day, for the next day will have its own anxieties. Each day has enough of its own troubles".—Matthew 6:34


### Tomorrow's Text Route

- **Path**: [/dailytext/tomorrow](#)
- **Method**: `GET`
- **Description**: This route returns the Bible text for the following day.
- **Response**: ""And he will wipe out every tear from their eyes, and death will be no more, neither will mourning nor outcry nor pain be anymore. The former things have passed away."—Revelation 21:4"


## Running the Application

To run the application, follow these steps:

1. Clone the repository to your local machine.
2. Open the project in Spring Tool Suite or any Java IDE.
3. Build and run the project.
4. Access the routes using the appropriate URL paths in your browser.

<!-- Feel free to explore the project code and learn more about Spring Framework's `@RequestMapping` annotation and routing in the context of web applications. -->