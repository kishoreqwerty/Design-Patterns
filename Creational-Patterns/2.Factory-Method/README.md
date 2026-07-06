# Factory Design Pattern in Java

This project demonstrates the Factory Design Pattern using a simple payment processing example.

Instead of creating payment objects directly, the application delegates object creation to a factory class. This keeps the client code independent of concrete implementations and makes the application easier to extend when new payment methods are introduced.

## Project Structure

```text
FactoryPattern/
└── PaymentFactory.java
```

## Overview

The Factory Pattern is a creational design pattern that centralizes object creation.

The client requests an object from the factory without knowing which concrete class is being instantiated. The factory decides which implementation to return based on the provided input.

In this project, different payment methods are represented by separate classes, while the factory is responsible for creating the appropriate payment object.

## Components

### PaymentMethod

An interface that defines the common operation for all payment types.

```java
void pay();
```

### Concrete Implementations

The following classes implement the `PaymentMethod` interface:

- `CreditCardPayment`
- `DebitCardPayment`
- `UpiPayment`

Each class provides its own implementation of the `pay()` method.

### PaymentFactory

The factory class contains the object creation logic.

Based on the payment method requested by the client, it returns the corresponding implementation.

### PaymentService

The service class contains the business logic.

Instead of creating payment objects directly, it requests them from `PaymentFactory` and executes the payment operation.

## Execution Flow

1. The client requests a payment using a payment type.
2. `PaymentService` forwards the request to `PaymentFactory`.
3. `PaymentFactory` creates the appropriate payment object.
4. The created object is returned to the service.
5. The service invokes the `pay()` method.

## Benefits

- Separates object creation from business logic.
- Reduces dependency on concrete classes.
- Makes it easy to add new payment methods.
- Improves readability and maintainability.
- Encourages programming against interfaces.

## Limitations

- Adds an additional factory class.
- May introduce unnecessary abstraction for very small applications.
- The factory needs to be updated when supporting new object types.

## How to Run

Compile the Java file.

```bash
javac PaymentFactory.java
java Main
```

## Sample Output

```text
Processing payment using Credit Card
Processing payment using Debit Card
Processing payment using UPI
```

## Future Enhancements

New payment methods such as the following can be added with minimal changes:

- Net Banking
- Wallet
- PayPal
- Apple Pay
- Google Pay
- Cryptocurrency

Only a new implementation of `PaymentMethod` and a corresponding factory condition are required.

## Author

Kishore Kumar J