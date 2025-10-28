# User Authentication API

Simple user registration and login API built with Spring Boot. In-memory storage with email validation and HTTP status codes.

## Description

RESTful API for user authentication demonstrating registration, login, and user listing with proper HTTP status responses and DTO pattern.

## Technologies

Java 17+ | Spring Boot | REST API | DTO Pattern | In-Memory Storage

## Project Structure

    src/main/java/com/ResponseEntity/Prueba/
    ├── PruebaApplication.java (Main class)
    ├── config/
    │   └── database.java (In-memory storage)
    ├── controller/
    │   └── UsuarioController.java (REST endpoints)
    ├── model/
    │   └── Usuario.java (User entity)
    └── dto/
        └── RequestLoginDTO.java (Login data transfer)

## Installation

### Prerequisites

- Java JDK 17+
- Maven 3.6+

### Run Application

    mvn spring-boot:run

Runs on: `http://localhost:8080`

## API Endpoints

### Base URL

    http://localhost:8080/api/usuario

### List All Users

    GET /api/usuario

Response (200):

    [
        {
            "id": 1,
            "username": "john_doe",
            "email": "john@example.com",
            "contraseña": "pass123"
        }
    ]

### Register User

    POST /api/usuario
    Content-Type: application/json

Body:

    {
        "username": "john_doe",
        "email": "john@example.com",
        "contraseña": "pass123"
    }

**Success Response (201):**

    "Usuario registrado correctamente"

**Error Response (409):**

    "El usuario con ese correo ya existe"

### Login

    POST /api/usuario/login
    Content-Type: application/json

Body:

    {
        "email": "john@example.com",
        "contraseña": "pass123"
    }

**Success Response (200):**

    "Login exitoso"

**Error Response (401):**

    "Credenciales no validas"

## Data Models

### Usuario

    {
        "id": Long (auto-generated),
        "username": String,
        "email": String (unique),
        "contraseña": String
    }

### RequestLoginDTO

    {
        "email": String,
        "contraseña": String
    }

## Features

- User registration with email uniqueness validation
- User login with credential verification
- List all registered users
- Auto-increment user IDs
- In-memory database (ArrayList)
- DTO pattern for login requests
- HTTP status codes (200, 201, 401, 409)
- Case-insensitive email comparison

## HTTP Status Codes

| Code | Description                    |
|------|--------------------------------|
| 200  | OK - Login successful          |
| 201  | Created - User registered      |
| 401  | Unauthorized - Invalid login   |
| 409  | Conflict - Email already exists|

## Architecture

    Client Request
         ↓
    UsuarioController
         ↓
    database (ArrayList)
         ↓
    Response with Status Code

## Testing with cURL

### Register User

    curl -X POST http://localhost:8080/api/usuario \
      -H "Content-Type: application/json" \
      -d '{"username":"john","email":"john@test.com","contraseña":"123"}'

### Login

    curl -X POST http://localhost:8080/api/usuario/login \
      -H "Content-Type: application/json" \
      -d '{"email":"john@test.com","contraseña":"123"}'

### List Users

    curl http://localhost:8080/api/usuario

## Key Concepts

- **DTO Pattern**: Separate data transfer object for login
- **ResponseEntity<?>**: Flexible response types with status codes
- **In-Memory Storage**: Static ArrayList for temporary data
- **Email Validation**: Prevents duplicate registrations
- **Auto-Increment IDs**: Static counter for unique identifiers

## Validations

- Email uniqueness check on registration
- Case-insensitive email and password comparison on login
- Proper HTTP status codes for different scenarios

## Limitations

- No password encryption
- Data lost on application restart
- No authentication tokens
- Basic validation only
- No user update/delete operations

## Future Improvements

- Password hashing (BCrypt)
- JWT token authentication
- Database persistence (MySQL/PostgreSQL)
- User CRUD operations (Update, Delete)
- Input validation with Bean Validation
- Password strength requirements
- Email format validation
- Rate limiting for login attempts
- Forgot password functionality
- User roles and permissions

## Developer Information

Name: SebitasDown
GitHub: @SebitasDown
Project: User Authentication API

## License

Educational project - Open source for learning

---

Built with Spring Boot
