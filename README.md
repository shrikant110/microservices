# Microservices Project

## Overview
This repository contains a set of Kotlin-based microservices that work together to provide a robust and scalable application. The architecture follows best practices in microservices design and enables easy scaling, deployment, and maintenance.

## Architecture
The project's architecture is designed around microservices principles:
- **Service Independence**: Each service can be deployed independently.
- **Decentralized Data Management**: Each service manages its own database.
- **API Gateway**: An API gateway routes requests to the appropriate microservice.

### Diagram
![Architecture Diagram](link_to_architecture_diagram)

## Setup
To set up the project locally, follow these steps:

### Prerequisites
- **Java**: Ensure you have Java JDK 11 or higher installed.
- **Kotlin**: You can use the Kotlin command-line tools or IntelliJ IDEA.
- **Docker**: For running containerized services.
- **Gradle**: Build tool used in the project.

### Steps
1. **Clone the repository**:
   ```bash
   git clone https://github.com/shrikant110/microservices.git
   cd microservices
   ```
2. **Build the project**:
   ```bash
   ./gradlew build
   ```
3. **Run the services**:
   You can run the microservices either individually or together using Docker:
   ```bash
   docker-compose up
   ```

## Services
The following microservices are included in this project:
- **User Service**: Manages user accounts and authentication.
- **Order Service**: Handles order processing and management.
- **Product Service**: Manages product details and inventory.

### User Service
- **Tech Stack**: Spring Boot, Kotlin, PostgreSQL
- **Endpoints**:
  - `POST /users`: Create a new user
  - `GET /users/{id}`: Retrieve user details

### Order Service
- **Tech Stack**: Spring Boot, Kotlin, MySQL
- **Endpoints**:
  - `POST /orders`: Create a new order
  - `GET /orders/{id}`: Retrieve order details

### Product Service
- **Tech Stack**: Spring Boot, Kotlin, MongoDB
- **Endpoints**:
  - `POST /products`: Add a new product
  - `GET /products/{id}`: Retrieve product details

## Contributing
Please read the [CONTRIBUTING.md](CONTRIBUTING.md) for information on how to contribute to this project.

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgments
Thanks to everyone who contributed to this project, including the open-source community for their libraries and tools that made this possible.