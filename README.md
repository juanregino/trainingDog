# Training Dog

## Installation

Follow these steps to install and run the Training Dog project in your local development environment:

### Prerequisites

- Java 17
- Docker

1. Clone the repository:
    ```bash
   https://github.com/juanregino/trainingDog
    ```

2. Initialize Docker:
    ```bash
    docker-compose up --build
    ```

3. Run the project in development mode:
    ```bash
    mvn clean install
    ```

### Starting the Service

1. **Training Dog**:
    ```bash
    mvn spring-boot:run
    ```



## Open

**Local**
- TrainingDog: http://localhost:8080/api/v1




## Documentation

- The endPoint can be found in [Swagger](http://localhost:8080/api/v1/swagger-ui/index.html#/)
- The documentation can be found in the https://github.com/juanregino/trainingDog

## Deploy

- Training Dog : https://trainingdog.onrender.com
- Documentation : https://trainingdog.onrender.com/api/v1/swagger-ui/index.html
