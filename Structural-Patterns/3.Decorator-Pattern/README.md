# Decorator Design Pattern

This project demonstrates the Decorator Design Pattern using a notification delivery system.

The objective is to add additional notification channels dynamically without modifying the original notification implementation.

---

## Problem Statement

Suppose an application initially supports only email notifications.

Later, new requirements arrive:

- Send Email + SMS
- Send Email + Push Notification
- Send Email + SMS + Slack
- Send Email + SMS + Push + Slack

Using inheritance, we may end up creating classes such as:

```text
EmailNotification
EmailSMSNotification
EmailPushNotification
EmailSMSPushNotification
EmailSMSPushSlackNotification
```

As the number of combinations grows, maintaining these classes becomes difficult.

---

## Solution

The Decorator Pattern solves this problem by allowing new functionality to be attached to an existing object dynamically.

Instead of creating new subclasses for every combination, notification channels are added as decorators around an existing notification object.

Example:

```java
Notification notification =
        new EmailNotification();

notification =
        new SMSNotification(notification);

notification =
        new PushNotification(notification);

notification =
        new SlackNotification(notification);
```

Each decorator adds its own behavior while preserving the original interface.

---

## Components

### Notification

Defines the common interface shared by all notifications.

### EmailNotification

Represents the base notification implementation.

### NotificationDecorator

Acts as the parent class for all decorators.

It stores a reference to an existing notification object.

### SMSNotification

Adds SMS delivery support.

### PushNotification

Adds push notification support.

### SlackNotification

Adds Slack notification support.

---

## Execution Flow

1. Create a base notification object.
2. Wrap the object using decorators.
3. Each decorator adds additional functionality.
4. The final object contains all selected features.

---

## Advantages

- Adds functionality at runtime.
- Avoids creating numerous subclasses.
- Supports flexible feature combinations.
- Encourages composition over inheritance.
- Makes the system easier to extend.

---

## Disadvantages

- Introduces additional classes.
- Multiple decorators can make debugging harder.
- Excessive decoration can increase complexity.

---

## When to Use Decorator Pattern

Decorator Pattern is useful when:

- Features need to be added dynamically.
- Multiple combinations of functionality exist.
- Inheritance would create too many subclasses.
- Functionality should remain modular and reusable.

---

## How to Run

Compile and run the program:

```bash
javac NotificationDecorator.java
java Main
```

---

## Sample Output

```text
Notification Channels:
Email Notification + SMS Notification + Push Notification + Slack Notification

Total Cost: $5.0
```

---

## Author

Kishore Kumar J