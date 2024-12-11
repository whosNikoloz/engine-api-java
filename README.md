# engine-api-java

## About the API

An API for branches and product management. This project is built with Java, Spring Boot, and Spring Framework.
The API main URL `/products` , `/branches`.

## Features

This API provides HTTP endpoint's and tools for the following:

- Create a branch: `POST/branches`
- Update a branch: `PUT/branch/{id}`
- Delete a branch (by id): `DELETE/branch/{id}`
- Find a unique branch by id: `GET/branch/{id}`
- Get all branch: `GET/branch`

- Create a product: `POST/products/{branch_id}`
- Update a product: `PUT/products/{id}`
- Delete a product (by id): `DELETE/products/{id}`
- Find a unique product by id: `GET/products/{id}`
- Find a products by branch: `GET/products/{branch_id}`
- Get all products: `GET/products`

### Technologies used

This project was developed with:

- Java 23
- Spring Boot 2.5.2
- Maven
- JUnit 5
- H2
- Swagger 3.0.0
- Model Mapper 2.3.9

### Compile and Package

The API also was developed to run with an `jar`. In order to generate this `jar`, you should run:

```bash
mvn package
```

This command will clean, compile and generate a `jar` at target directory, e.g. `engine-api-1.0.0-SNAPSHOT.jar`

### Execution

This project uses **My Sql**.

Below are the table creation scripts for setting up the database schema.

```sql
CREATE TABLE Branch (
    branch_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    branch_name_ka VARCHAR(255) NOT NULL, -- Georgian name
    branch_name_en VARCHAR(255) NOT NULL, -- English name
    description_ka TEXT,                -- Georgian description
    description_en TEXT                 -- English description
);

CREATE TABLE Product (
    product_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    product_name_ka VARCHAR(255) NOT NULL,  -- Georgian name
    product_Name_en VARCHAR(255) NOT NULL,  -- English name
    price DECIMAL(10, 2) NOT NULL,        -- Price with precision
    description VARCHAR(255) NOT NULL,                     -- Product description
    product_logo VARCHAR(255),             -- Path to product logo
    branch_id BIGINT,                     -- Foreign key to Branch
    CONSTRAINT fk_branch FOREIGN KEY (branch_id) REFERENCES Branch(branch_id) ON DELETE CASCADE
);
```

### Test

- For unit test phase, you can run:

```bash
mvn test
```

### Run

In order to run the API, run the jar as following:

```bash
java -jar engine-api-1.0.0-SNAPSHOT.jar --spring.profiles.active=dev
```

or

```bash
mvn spring-boot:run -Dspring.profiles.active=dev
```

By default, the API will be available at [http://localhost:9999](http://localhost:9999)

### Documentation

- Swagger (development environment): [http://localhost:9999/swagger-ui/index.html](http://localhost:9999/swagger-ui/index.html)
