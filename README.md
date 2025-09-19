# Spring Cloud Gateway

API Gateway with routing and load balancing

## Overview

This service is part of the E-Commerce Microservices platform built with Spring Boot 3 and Spring Cloud.

## Technology Stack

- Java 17
- Spring Boot 3.2.2
- Spring Cloud 2023.0.0
- Maven
- Docker

## Running the Service

### Prerequisites
- JDK 17+
- Maven 3.8+
- Docker (optional)

### Local Development

1. **Start required infrastructure** (if running individually):
   ```bash
   # For services requiring databases, start them first
   docker-compose up -d postgres mongodb redis kafka zookeeper
   ```

2. **Run the service**:
   ```bash
   mvn spring-boot:run
   ```

### Docker

1. **Build the image**:
   ```bash
   docker build -t api-gateway .
   ```

2. **Run with Docker Compose** (recommended):
   ```bash
   # From root directory
   docker-compose up --build
   ```

## Configuration

Configuration is managed centrally via Spring Cloud Config Server. See `config-repo/api-gateway.yml` for service-specific configuration.

## Health Check

```bash
curl http://localhost:[PORT]/actuator/health
```

## API Documentation

When running, Swagger UI is available at:
```
http://localhost:[PORT]/swagger-ui.html
```

## Service Dependencies

- Config Server (port 8888)
- Discovery Server (port 8761)





## Development

To modify this service:

1. Update source code in `src/main/java/`
2. Modify configuration in `config-repo/api-gateway.yml`
3. Update dependencies in `pom.xml` if needed
4. Test changes: `mvn test`
5. Rebuild: `mvn clean package`

## Troubleshooting

- Check service logs: `docker logs ecommerce-api-gateway`
- Verify service registration: http://localhost:8761
- Check configuration: http://localhost:8888/api-gateway/default
