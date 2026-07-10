# Abstract Factory Design Pattern

This project demonstrates the Abstract Factory Design Pattern using a database abstraction example.

The goal of the Abstract Factory pattern is to create families of related objects without exposing their concrete implementations to the client code.

In this example, each database provider supplies its own set of related components such as a connection object and a query executor.

---

## Problem Statement

Suppose an application needs to support multiple database systems such as:

- MySQL
- PostgreSQL

Each database requires its own implementation of:

- Database Connection
- Query Execution

A straightforward implementation would involve creating these objects directly inside the application logic.

For example:

```java
Connection connection = new MySQLConnection();
QueryExecutor executor = new MySQLQueryExecutor();
```

While this works initially, it creates strong dependencies on concrete implementations.

If the application later needs to switch to PostgreSQL, multiple parts of the application may require modification.

---

## The Solution

The Abstract Factory pattern groups related objects into families and delegates object creation to factory classes.

Instead of creating objects directly, the application requests them from a factory.

For example:

```java
DatabaseFactory factory = new MySQLFactory();

Connection connection = factory.createConnection();
QueryExecutor executor = factory.createQueryExecutor();
```

The client code does not know whether it is working with MySQL or PostgreSQL objects.

---

## Product Families

### MySQL Family

- MySQLConnection
- MySQLQueryExecutor

### PostgreSQL Family

- PostgreSQLConnection
- PostgreSQLQueryExecutor

Each factory creates objects that belong to the same family.

---

## Components

### DatabaseConnection

Defines operations related to establishing a database connection.

### QueryExecutor

Defines operations related to query execution.

### DatabaseFactory

An interface responsible for creating related database objects.

### Concrete Factories

- `MySQLFactory`
- `PostgreSQLFactory`

These factories create objects that belong to their respective database family.

---

## Execution Flow

1. The client selects a database factory.
2. The factory creates the required objects.
3. The application interacts only with interfaces.
4. Database-specific implementations remain hidden from the client.

---

## Advantages

- Reduces dependency on concrete classes.
- Ensures compatible objects are used together.
- Makes the system easier to extend.
- Improves maintainability.
- Supports dependency inversion.

---

## Disadvantages

- Introduces additional interfaces and classes.
- Can become verbose for very small applications.
- Adding a new product type requires updating all factories.

---

## Example Output

### MySQL

```text
Connecting to MySQL Database
Executing query using MySQL Engine
```

### PostgreSQL

```text
Connecting to PostgreSQL Database
Executing query using PostgreSQL Engine
```

---

## When to Use Abstract Factory

Abstract Factory is useful when:

- Multiple related objects need to be created together.
- Different implementations must remain interchangeable.
- Client code should not depend on concrete classes.
- Consistency between related objects must be maintained.

---

## Author

Kishore Kumar J