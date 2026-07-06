# Singleton Pattern Implementations in Java

This folder contains different Java implementations of the Singleton design pattern.  
Each file shows a separate way to create and access only one object of a class.

## Files

```text
1.Singleton/
├── EagerLoading.java
├── LazyLoading.java
├── SynchronizedMethod.java
├── DoubleCheckedLocking.java
└── BillPugh.java
```

## About Singleton Pattern

Singleton is a creational design pattern used when a class should have only one object throughout the program.

Instead of creating objects using `new` from different places, the class controls its own object creation and provides a common method such as `getInstance()` to return the same object every time.

## Implementations

### 1. Eager Loading

File: `EagerLoading.java`

In this approach, the object is created when the class is loaded.

This is simple and thread-safe, but the object is created even if it is not used.

### 2. Lazy Loading

File: `LazyLoading.java`

In this approach, the object is created only when `getInstance()` is called for the first time.

This saves memory, but it is not safe in a multi-threaded environment.

### 3. Synchronized Method

File: `SynchronizedMethod.java`

This approach makes the `getInstance()` method synchronized.

It solves the thread-safety issue, but synchronization happens every time the method is called, which may reduce performance.

### 4. Double Checked Locking

File: `DoubleCheckedLocking.java`

This approach checks whether the object is already created before entering the synchronized block.

It improves performance compared to synchronizing the whole method. The `volatile` keyword is used to make sure changes are visible across threads.

### 5. Bill Pugh Singleton

File: `BillPugh.java`

This approach uses a static inner class to hold the singleton object.

The object is created only when `getInstance()` is called. It is thread-safe and does not require explicit synchronization.

## Comparison

| Implementation | Lazy Creation | Thread Safe | Notes |
|---|---|---|---|
| Eager Loading | No | Yes | Simple, but creates object early |
| Lazy Loading | Yes | No | Good for single-threaded programs |
| Synchronized Method | Yes | Yes | Safe, but slower due to synchronization |
| Double Checked Locking | Yes | Yes | Better performance with thread safety |
| Bill Pugh | Yes | Yes | Clean and efficient approach |

## How to Run

Compile any one Java file:

```bash
javac BillPugh.java
java Main
```

Example for another file:

```bash
javac DoubleCheckedLocking.java
java Main
```

## Expected Output

The program prints two object references.

Example:

```text
BillPugh@7344699f
BillPugh@7344699f
```

Both references are the same, which shows that both variables are pointing to the same object.

## Key Points

- Constructor is private.
- Instance variable is static.
- `getInstance()` returns the same object.
- Different implementations handle object creation and thread safety differently.

## Author

Kishore Kumar J