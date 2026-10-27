# Student Management System — Spring Boot

A RESTful backend application built using **Java, Spring Boot, Spring Data JPA, Hibernate, and MySQL**.

This project provides APIs to manage student information and demonstrates backend development concepts such as CRUD operations, database integration, soft deletion, searching, and filtering.

## Tech Stack

- **Language:** Java
- **Framework:** Spring Boot
- **ORM:** Spring Data JPA / Hibernate
- **Database:** MySQL
- **Build Tool:** Maven
- **API Testing:** Postman
- **IDE:** IntelliJ IDEA

## Features

- Create new student records
- Retrieve student details by ID
- Retrieve all active students
- Update existing student information
- Permanently delete student records
- Soft delete student records
- Search students by name (case-insensitive)
- Filter students by age
- Filter students by subject
- Filter students by age and subject

## REST API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/students/create` | Create a student |
| GET | `/api/students/get?id=1` | Get student by ID |
| GET | `/api/students/getAll` | Get all active students |
| PUT | `/api/students/update?id=1` | Update a student |
| DELETE | `/api/students/delete?id=1` | Permanently delete a student |
| PATCH | `/api/students/delete-soft?id=1` | Soft delete a student |
| GET | `/api/students/search?name=Rahul` | Search by name |
| GET | `/api/students/filter/age?age=22` | Filter by age |
| GET | `/api/students/filter/subject?subject=Java` | Filter by subject |
| GET | `/api/students/filter/both?age=22&subject=Java` | Filter by age and subject |

## Example Request

**POST** `/api/students/create`

```json
{
  "name": "Rahul",
  "age": 22,
  "email": "rahul@example.com",
  "rollNo": 101,
  "subject": "Java"
}
```

## Database Configuration

The application uses environment variables to configure MySQL connectivity.

```properties
spring.datasource.url=${DB_URL}
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}
```

Configure these environment variables before running the application.

Example database URL:

```text
jdbc:mysql://localhost:3306/student_crud_db
```

## How to Run

1. Clone the repository.
2. Open the project in IntelliJ IDEA or another Java IDE.
3. Configure a MySQL database.
4. Set the `DB_URL`, `DB_USERNAME`, and `DB_PASSWORD` environment variables.
5. Run `src/main/java/com/example/crudSpringBootDemo/CrudSpringBootDemoApplication.java`.
6. Test the APIs using Postman at `http://localhost:8080`.

## Project Status

**Under development.** Core CRUD, search, and filtering functionality has been implemented. Local environment configuration and final API verification are in progress.

## Future Enhancements

- Pagination and sorting
- Input validation
- Global exception handling
- Restore soft-deleted students
- DTO implementation
- Spring Security and JWT authentication
- Unit and integration testing

## Learning Objectives

This project was developed to gain practical experience in:

- Building REST APIs with Spring Boot
- Using Controller, Service, and Repository layers
- Working with Spring Data JPA
- Integrating MySQL with Java applications
- Implementing CRUD and soft-delete operations
- Designing and testing backend endpoints
