# Spring CRUD Application with API
Welcome to the Spring CRUD Application with API repository! This project is designed to demonstrate a simple yet robust CRUD (Create, Read, Update, Delete) application using Spring Boot. The application exposes a RESTful API to manage a basic entity, providing endpoints to create, retrieve, update, and delete records.

## Features
- CRUD Operations: Basic operations to create, read, update, and delete entities.
- RESTful API: Exposes endpoints to interact with the application.
- Spring Boot: Utilizes the powerful features of Spring Boot for rapid application development.
- H2 Database: In-memory database for development and testing purposes.
- Spring Data JPA: Simplifies database interactions.
- Exception Handling: Graceful handling of application errors.
- Getting Started
- Prerequisites
- Before you begin, ensure you have the following installed on your machine:

## JDK 11+
Maven
Installation
Clone the repository:

git clone https://github.com/Umwe/SpringCrudApplication-with-API.git
cd SpringCrudApplication-with-API
Build the project:

mvn clean install
Run the application:

mvn spring-boot:run
The application will start on http://localhost:8080.

## Usage
API Endpoints
Create a new entity

POST /api/entities
Body: JSON representation of the entity
Response: Created entity
Retrieve all entities

GET /api/entities
Response: List of entities
Retrieve a specific entity by ID

GET /api/entities/{id}
Response: Entity with the specified ID
Update an existing entity

PUT /api/entities/{id}
Body: JSON representation of the updated entity
Response: Updated entity
Delete an entity

DELETE /api/entities/{id}
Response: Success message
Example Requests
Create an entity:

curl -X POST http://localhost:8080/api/entities -H "Content-Type: application/json" -d '{"name":"Example Entity","value":"123"}'
Get all entities:


curl -X GET http://localhost:8080/api/entities
Get an entity by ID:


curl -X GET http://localhost:8080/api/entities/1
Update an entity:


curl -X PUT http://localhost:8080/api/entities/1 -H "Content-Type: application/json" -d '{"name":"Updated Entity","value":"456"}'
Delete an entity:


curl -X DELETE http://localhost:8080/api/entities/1
Project Structure


SpringCrudApplication-with-API
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── example
│   │   │           └── crud
│   │   │               ├── controller
│   │   │               ├── entity
│   │   │               ├── repository
│   │   │               └── service
│   │   └── resources
│   │       └── application.properties
├── .gitignore
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md
Contributing
Contributions are welcome! Please feel free to submit a Pull Request.

## License
This project is licensed under the MIT License. See the LICENSE file for more details.
