# Student Management API

A RESTful API built with Spring Boot and MySQL.

## Technologies Used
- Java 21
- Spring Boot 3.4.3
- MySQL
- Hibernate/JPA
- Lombok
- ModelMapper
- Spring Validation

## API Endpoints
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | /students | Get all students |
| GET | /students/{id} | Get student by ID |
| POST | /students | Create student |
| PUT | /students/{id} | Full update |
| PATCH | /students/{id} | Partial update |
| DELETE | /students/{id} | Delete student |

## Setup
1. Clone the project
2. Create MySQL database named `studentdb`
3. Create `.env` file:
DB_USERNAME=your_username
DB_PASSWORD=your_password
4. Run the project
5. Test with Postman on `localhost:8080`
