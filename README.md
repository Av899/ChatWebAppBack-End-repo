# Chat Application Backend

Spring Boot backend service for real-time chat application with MongoDB integration.

## Features

- Real-time messaging using Spring WebSocket
- MongoDB data persistence
- Spring Boot Actuator for monitoring
- Development tools (Lombok, Spring DevTools)
- Maven build system

## Tech Stack

- **Java 17**
- **Spring Boot 3.4.2**
- Spring WebSocket
- Spring Data MongoDB
- Lombok
- Spring Boot Actuator
- Maven

## Getting Started

### Prerequisites
- Java 17 JDK
- Maven 3.9+
- MongoDB instance

### Installation

1. Clone the repository:
   git clone https://github.com/Av899/ChatWebAppBack-End-repo.git
   cd chat-app-backend

2. Build the project:
   mvn clean install

3. Run the application:
   mvn spring-boot:run

## Configuration

Create `application.properties` in `src/main/resources`:


# MongoDB Configuration
spring.data.mongodb.host=localhost
spring.data.mongodb.port=27017
spring.data.mongodb.database=chatdb

## Actuator Endpoints
management.endpoints.web.exposure.include=health,info,metrics

## API Endpoints

| Endpoint              | Description                          |
|-----------------------|--------------------------------------|
| `/ws`                 | WebSocket endpoint                   |
| `/actuator/health`    | Application health check             |
| `/actuator/metrics`   | Application metrics                  |


## Dependencies

Key dependencies from `pom.xml`:
- `spring-boot-starter-web`
- `spring-boot-starter-websocket`
- `spring-boot-starter-data-mongodb`
- `spring-boot-starter-actuator`
- `lombok`
- `spring-boot-devtools`

## License

[MIT License](LICENSE)
