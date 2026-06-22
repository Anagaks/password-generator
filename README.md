A simple REST API to generate passwords, built with Spring Boot.

1. Clone the repository
```bash
git clone <your-repo-url>
cd password_generator
```
2. Build
```bash
./mvnw clean install
```
3. Run
```bash
./mvnw spring-boot:run
```
App starts at http://localhost:8080

Key features
Generate random passwords via REST API
no group of 4 or more character should not be valid form dictionary api
length can be configurable by passing in params 

