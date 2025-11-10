# CSE 2102 - Lab 7 Thymeleaf Quiz

In this lab assignment we are creating a quiz website using Thymeleaf, where it should follow these properties:
 - Should work for several independent quiz takers
 - This must use thymeleaf with Spring-boot


## Features

- True/False questions about astronomy and planets
- Multi-user support: Each user gets their own independent quiz session
- Session-based progress tracking
- Thymeleaf templates for dynamic HTML rendering
- JUnit tests for model classes and question logic


## Running the Application


### Build and Run

Clean and install dependencies:
```
./mvn clean install
```

Run the application:
```
./mvn spring-boot:run
```

After starting, visit http://localhost:8080 in your browser to access the quiz.

### Running Tests

```
./mvn test
```
