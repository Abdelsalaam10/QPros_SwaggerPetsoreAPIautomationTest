# API Automated Project README

## Overview

This project focuses on automating tests for the Swagger Petstore API, specifically targeting the CRUD operations on the USER endpoint. The goal is to provide a comprehensive set of automated tests for creating, retrieving, updating, and deleting users through a test automation framework.

## Prerequisites

1. Java Development Kit (JDK) installed
2. A testing framework (e.g., TestNG, JUnit)
3. REST-assured library for API testing
4. Maven or another build tool for managing dependencies

## Project Structure

The project is organized with a modular structure to enhance maintainability and readability.

```
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── framework
│   │   │   │   ├── APIConfig.java
│   │   │   │   ├── APITestBase.java
│   │   ├── test
│   │   │   ├── java
│   │   │   │   ├── tests
│   │   │   │   │   ├── CreateUserTest.java
│   │   │   │   │   ├── DeleteUserTest.java
│   │   │   │   │   ├── GetUserTest.java
│   │   │   │   │   ├── UpdateUserTest.java
│   ├── testng.xml
├── pom.xml
├── README.md
```

## Test Cases

### 1. **Create User Test:**
   - **Description:** Tests the creation of a new user through the `createUser` endpoint.
   - **Steps:**
     - Send a POST request to create a new user.
     - Verify the response status code and relevant information.
     - Ensure the user is created successfully.

### 2. **Delete User Test:**
   - **Description:** Tests the deletion of an existing user through the `deleteUser` endpoint.
   - **Steps:**
     - Send a DELETE request to delete an existing user.
     - Verify the response status code and relevant information.
     - Ensure the user is deleted successfully.

### 3. **Get User Test:**
   - **Description:** Tests retrieving user information through the `getUser` endpoint.
   - **Steps:**
     - Send a GET request to retrieve user information.
     - Verify the response status code and relevant information.
     - Ensure the correct user details are retrieved.

### 4. **Update User Test:**
   - **Description:** Tests updating user information through the `updateUser` endpoint.
   - **Steps:**
     - Send a PUT request to update user information.
     - Verify the response status code and relevant information.
     - Ensure the user information is updated successfully.

## Framework Components

### 1. **APIConfig:**
   - Manages API configuration settings such as base URL, authentication, etc.

### 2. **APITestBase:**
   - Acts as the base class for all API test classes, providing common setup and teardown operations.

## Execution

1. **Clone the Repository:**
   ```
   git clone https://github.com/yourusername/api-automation-project.git
   ```

2. **Navigate to the Project Directory:**
   ```
   cd api-automation-project
   ```

3. **Run the Tests:**
   ```
   mvn test
   ```

## Note

- Ensure that the Swagger Petstore API is accessible and available during test execution.
- Customize the `APIConfig` class with the appropriate API base URL, authentication, or any other configuration settings.
- This project uses Maven as a build tool. Adjust dependencies and plugins accordingly if using a different build tool.
- Test results and logs can be found in the `target` directory after running the tests.

Feel free to extend and modify the test cases or framework components as needed for your specific testing requirements.