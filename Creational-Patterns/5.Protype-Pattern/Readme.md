# Prototype Design Pattern - Game Character Example

This project demonstrates the Prototype Design Pattern using a game character cloning system.

Instead of creating every character from scratch, the application creates new characters by cloning an existing character and modifying only the required attributes.

## Project Structure

```text
PrototypePattern/
└── GameCharacterPrototype.java
```

## Problem Statement

In many games, characters often share most of their properties.

For example, multiple warrior characters may have:

- Similar health values
- Similar attack power
- Similar defense levels
- Similar abilities

Creating every character manually by repeating the same initialization code can become inefficient and difficult to maintain.

## Solution

The Prototype Pattern solves this problem by creating new objects through cloning existing objects.

Instead of constructing a new character every time, an already configured character can be copied and customized according to the requirements.

This reduces repetitive initialization logic and improves object creation performance.

## Components

### CharacterPrototype

Defines the cloning operation that all prototypes must support.

```java
CharacterPrototype cloneCharacter();
```

### GameCharacterPrototype

Represents the actual game character object.

The class contains properties such as:

- Character Class
- Health
- Attack
- Defense
- Abilities

It also implements the cloning functionality.

### cloneCharacter()

Creates and returns a copy of the existing object.

The cloned object can then be modified independently without affecting the original object.

## Execution Flow

1. Create a base character object.
2. Clone the existing character.
3. Modify the cloned object as needed.
4. Use both objects independently.

## Example

```java
GameCharacterPrototype warrior =
        new GameCharacterPrototype(
                "Warrior",
                100,
                25,
                20,
                abilities
        );

GameCharacterPrototype eliteWarrior =
        warrior.cloneCharacter();

eliteWarrior.setAttack(40);
eliteWarrior.addAbility("Berserk");
```

The cloned character starts with the same configuration as the original character but can be customized separately.

## Deep Copy vs Shallow Copy

This implementation performs a deep copy for mutable fields such as lists.

Without deep copying, modifications made to the cloned object's abilities could also affect the original object.

Deep copying ensures that both objects remain completely independent.

## Advantages

- Reduces expensive object initialization.
- Eliminates repetitive setup code.
- Allows runtime customization of cloned objects.
- Improves performance when creating similar objects.
- Keeps object creation logic simple.

## Disadvantages

- Deep cloning can require additional implementation effort.
- Objects with circular references can be difficult to clone correctly.
- Incorrect cloning logic may lead to unexpected side effects.

## When to Use Prototype Pattern

The Prototype Pattern is useful when:

- Object creation is expensive.
- Multiple objects share similar configurations.
- Objects require only small modifications after creation.
- Object creation logic should remain independent of concrete classes.

## How to Run

Compile and run the program:

```bash
javac GameCharacterPrototype.java
java Main
```

## Sample Output

```text
Base Character
Class: Warrior
Health: 100
Attack: 25
Defense: 20
Abilities: [Slash, Shield Block]

Cloned Character
Class: Warrior
Health: 100
Attack: 40
Defense: 20
Abilities: [Slash, Shield Block, Berserk]
```

The output demonstrates that the cloned object is independent of the original object and can be modified without affecting it.

## Author

Kishore Kumar J