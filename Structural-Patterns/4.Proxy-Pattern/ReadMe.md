# Proxy Design Pattern

This project demonstrates the Proxy Design Pattern using a secure document access system.

Instead of allowing every user to access a confidential document directly, a proxy object sits between the client and the real document. The proxy checks whether the user has permission before forwarding the request.

---

## Project Structure

```text
ProxyPattern/
├── SecureDocumentProxy.java
└── README.md
```

---

## Problem

Imagine an application that stores confidential company documents.

Not every user should be allowed to open these documents. If the client accesses the document directly, permission checks may end up being repeated throughout the application.

This makes the code harder to maintain and increases the risk of unauthorized access.

---

## Solution

The Proxy Pattern introduces an intermediate object that controls access to the real document.

Instead of interacting with the document directly, the client communicates with the proxy.

The proxy is responsible for:

- Verifying user permissions
- Allowing authorized users to continue
- Blocking unauthorized requests
- Creating the real document only when it is needed

The client doesn't need to know how these checks are performed.

---

## Components

### Document

Defines the common interface shared by both the proxy and the real document.

```java
void viewDocument(String userRole);
```

---

### ConfidentialDocument

Represents the actual document.

This class only focuses on displaying the document once permission has already been granted.

---

### DocumentAccessProxy

Acts as the intermediary between the client and the confidential document.

Before forwarding the request, it verifies whether the user has the required access level.

If the request is valid, the proxy creates the real document (if necessary) and forwards the request.

Otherwise, access is denied.

---

### SecureDocumentProxy

Contains the `main()` method and demonstrates how different users interact with the proxy.

---

## Execution Flow

1. The client requests access to a document.
2. The request reaches `DocumentAccessProxy`.
3. The proxy checks the user's role.
4. Unauthorized users receive an access denied message.
5. Authorized users are allowed to continue.
6. The proxy forwards the request to the real document.

---

## Why Use a Proxy?

Without a proxy, every part of the application would need to perform its own permission checks.

Using a proxy keeps this logic in one place, making the system easier to maintain and reducing duplicate code.

It also prevents the client from communicating directly with the confidential document.

---

## Advantages

- Controls access to sensitive resources.
- Keeps security checks separate from business logic.
- Supports lazy object creation.
- Makes the system easier to maintain.
- Reduces duplicate permission-checking code.

---

## Limitations

- Introduces an additional layer between the client and the real object.
- More classes are required.
- The proxy may become complex if too many responsibilities are added.

---

## When to Use Proxy Pattern

The Proxy Pattern is useful when:

- Access to an object needs to be restricted.
- Expensive objects should be created only when required.
- Logging or monitoring is needed before accessing an object.
- Additional processing should happen before forwarding a request.

---

## How to Run

Compile the program:

```bash
javac SecureDocumentProxy.java
```

Run the program:

```bash
java SecureDocumentProxy
```

---

## Sample Output

```text
Employee Login
Access denied for EMPLOYEE.

Manager Login
Access granted for MANAGER.
Opening document: Employee Records
Displaying confidential information.

Admin Login
Access granted for ADMIN.
Opening document: Employee Records
Displaying confidential information.
```

---

## Pattern Summary

The Proxy Pattern places an intermediate object between the client and the real object.

The client interacts with the proxy exactly as it would with the real object, while the proxy decides whether the request should be forwarded.

In this example, the proxy is responsible for enforcing access control, allowing only authorized users to open the confidential document.

---

## Author

Kishore Kumar J