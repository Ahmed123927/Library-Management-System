# Library Management System API

This is a RESTful API for a Library Management System built using Spring Boot. It provides endpoints to manage books and patrons in a library, as well as functionalities for book borrowing and returning.

## Setup and Installation

1. **Setup Environment**:
   - Ensure you have Java installed on your system. You can download and install it from the [official website](https://www.java.com/en/download/).
   - Set up your development environment with your preferred IDE, such as IntelliJ IDEA, Eclipse, or Visual Studio Code.

2. **Clone the Repository**:
   - Clone the repository containing the Library Management System codebase to your local machine.

3. **Build the Application**:
   - Navigate to the root directory of the project where the `pom.xml` file is located.
   - Open a terminal or command prompt in that directory.
   - Run the following Maven command to build the application:
     ```
     mvn clean install
     ```

4. **Run the Application**:
   - After the build is successful, you can run the application.
   - You can run it directly from your IDE or by executing the generated JAR file in the `target` directory.

## Interacting with API Endpoints

Once the application is running, you can interact with its API endpoints using HTTP requests. Below are the available endpoints along with their descriptions:

- **Add Book**:
  - URL: POST `/api/books`
  - Description: Adds a new book to the library management system.

- **Get Book by ID**:
  - URL: GET `/api/books/{id}`
  - Description: Retrieves a book from the library management system by its ID.

- **Update Book**:
  - URL: PUT `/api/books/{id}`
  - Description: Updates the details of an existing book in the library management system.

- **Delete Book**:
  - URL: DELETE `/api/books/{id}`
  - Description: Deletes a book from the library management system.

- **Get All Books**:
  - URL: GET `/api/books`
  - Description: Retrieves the list of all books from the library management system.

- **Add Patron**:
  - URL: POST `/api/patrons`
  - Description: Adds a new patron to the library management system.

- **Get Patron by ID**:
  - URL: GET `/api/patrons/{id}`
  - Description: Retrieves a patron from the library management system by their ID.

- **Update Patron**:
  - URL: PUT `/api/patrons/{id}`
  - Description: Updates the details of an existing patron in the library management system.

- **Delete Patron**:
  - URL: DELETE `/api/patrons/{id}`
  - Description: Deletes a patron from the library management system.

- **Patron Borrow Book**:
  - URL: POST `/api/borrow/{bookId}/patron/{patronId}`
  - Description: Allows a patron to borrow a book from the library.

- **Return Book**:
  - URL: PUT `/api/return/{bookId}/patron/{patronId}`
  - Description: Handles the return of a borrowed book by a patron.

## Authentication

If authentication is implemented, you need to provide appropriate credentials (e.g., API key, JWT token) in the request headers according to the authentication mechanism used.

## Error Handling

The API endpoints handle errors gracefully and return appropriate HTTP status codes along with error messages in case of failures.
