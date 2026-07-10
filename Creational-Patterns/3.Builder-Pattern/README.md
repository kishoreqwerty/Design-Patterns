# Builder Design Pattern

The Builder Pattern is a creational design pattern used to create complex objects step by step.

Instead of passing every value to a constructor at once, the object is built gradually by setting only the required information and then adding optional details when needed.

In simple terms, Builder helps create objects in a readable and flexible way.

---

## Real-Life Analogy: Building a Resume

Imagine creating a resume.

Every resume must contain some basic information such as:

- Full Name
- Email Address

Apart from that, there are many optional sections:

- Phone Number
- Professional Summary
- Education
- Skills
- Projects
- Certifications
- Experience

Not every resume contains all these sections.

For example:

- A student resume may not contain work experience.
- An experienced developer may include projects, certifications, and skills.
- A fresher may only include education and technical skills.

Builder Pattern allows us to create these different versions of a resume without writing multiple constructors.

---

# The Problem

Suppose we try to create a resume using a constructor.

```java
Resume resume = new Resume(
    "Kishore Kumar J",
    "kishore@example.com",
    "+1 812-555-1234",
    "Software Engineer",
    "Indiana University",
    skills,
    projects
);
```

This approach works initially but introduces several problems:

## Difficult to Read

As the number of parameters increases, understanding what each value represents becomes harder.

```java
new Resume(
    "Kishore Kumar J",
    "kishore@example.com",
    null,
    null,
    "Indiana University",
    null,
    projects
);
```

It becomes difficult to identify which value belongs to which field.

---

## Too Many Optional Parameters

Many resume fields are optional.

If we don't want to include them, we are forced to pass `null` values.

This makes object creation messy and difficult to maintain.

---

## Constructor Explosion

To avoid null values, we may end up creating multiple constructors:

```java
Resume(String name, String email)

Resume(String name, String email, String phone)

Resume(String name, String email, String phone, String education)

Resume(String name, String email, String phone,
       String education, List<String> skills)
```

As more fields are added, the number of constructors keeps increasing.

This problem is commonly known as the **Telescoping Constructor Problem**.

---

# The Solution

The Builder Pattern solves this problem by separating object construction from object representation.

Required fields are provided first.

Optional fields can then be added only if they are needed.

Finally, the object is created using the `build()` method.

Example:

```java
Resume resume = new Resume.Builder(
        "Kishore Kumar J",
        "kishore@example.com")
        .withPhone("+1 812-555-1234")
        .withEducation("Indiana University Bloomington")
        .addSkill("Java")
        .addSkill("C++")
        .addProject("AI Compliance Monitoring System")
        .build();
```

This approach is easier to read and much more flexible.

---

# Understanding the Code

## Private Constructor

The constructor of `Resume` is private.

This prevents users from creating objects directly using `new Resume()`.

The only way to create an object is through the Builder.

---

## Nested Builder Class

The `Builder` class stores all the information required to create the resume.

It contains both required fields and optional fields.

---

## Required Fields

Some information is mandatory for every resume.

In this example:

- Full Name
- Email Address

These values are provided when creating the Builder object.

```java
new Resume.Builder(
    "Kishore Kumar J",
    "kishore@example.com"
)
```

---

## Optional Fields

Additional information can be added only if needed.

Examples include:

- Phone Number
- Education
- Skills
- Projects

```java
.withPhone("+1 812-555-1234")
.addSkill("Java")
.addProject("Distributed Trading System")
```

---

## Method Chaining

Each builder method returns the builder object itself.

This allows multiple methods to be chained together.

```java
.withPhone(...)
.withEducation(...)
.addSkill(...)
.build();
```

This style makes object creation more readable.

---

## build()

The `build()` method creates the final `Resume` object and returns it to the user.

```java
Resume resume = builder.build();
```

After this point, object construction is complete.

---

# Why Builder Is Better

| Constructor Approach | Builder Pattern |
|---------------------|----------------|
| Long parameter lists | Readable object creation |
| Multiple overloaded constructors | Single builder class |
| Requires null values for optional fields | Configure only required fields |
| Difficult to maintain | Easy to extend |

---

# When to Use Builder Pattern

Builder Pattern is useful when:

- A class contains many optional fields.
- Object creation involves multiple configuration steps.
- Readability is important.
- Immutable objects are preferred.

---

# When to Avoid Builder Pattern

Builder Pattern may not be necessary when:

- The class contains only one or two fields.
- Object creation is simple.
- There are very few configuration options.

---

# Advantages

- Improves readability.
- Eliminates large constructors.
- Supports method chaining.
- Handles optional fields cleanly.
- Makes complex object creation easier.

---

# Disadvantages

- Requires additional builder code.
- Introduces extra classes and methods.
- May be unnecessary for simple objects.

---

# Example Output

```text
Name: Kishore Kumar J
Email: kishore@example.com
Phone: +1 812-555-1234
Education: Indiana University Bloomington
Skills: Java, C++, Python
Projects:
- AI Compliance Monitoring System
- Distributed Trading System
```

---

## Author

Kishore Kumar J