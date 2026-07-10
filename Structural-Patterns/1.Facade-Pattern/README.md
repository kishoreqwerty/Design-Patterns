# Facade Design Pattern

This project demonstrates the Facade Design Pattern using a computer startup example.

Starting a computer involves multiple components working together such as the CPU, memory, storage device, and operating system.

Instead of forcing the client to interact with each subsystem individually, the Facade Pattern provides a single entry point that manages the entire startup sequence.

---

## Problem Statement

Suppose a user wants to start a computer.

Without a facade, the client would need to manually perform several operations:

- Initialize the CPU
- Load memory
- Read boot files from storage
- Start the operating system
- Begin instruction processing

Example:

```java
CPU cpu = new CPU();
Memory memory = new Memory();
HardDrive hardDrive = new HardDrive();
OperatingSystem os = new OperatingSystem();

cpu.initialize();
memory.loadMemory();
hardDrive.readBootFiles();
os.startOS();
cpu.startProcessing();
```

Although this works, the client becomes responsible for understanding the complete startup sequence.

As the system grows, this approach becomes difficult to maintain.

---

## The Solution

The Facade Pattern hides subsystem complexity behind a single interface.

Instead of interacting with multiple components, the client simply calls:

```java
computer.startComputer();
```

The facade coordinates all subsystem operations internally.

---

## Components

### CPU

Responsible for processor initialization and instruction execution.

### Memory

Loads required data into memory during startup.

### HardDrive

Reads boot files required for operating system initialization.

### OperatingSystem

Starts and prepares the operating system environment.

### ComputerStartupFacade

Acts as a single entry point for the startup process.

It coordinates all subsystem interactions and hides implementation details from the client.

---

## Execution Flow

1. CPU initialization begins.
2. Memory is loaded.
3. Boot files are read from storage.
4. Operating system starts.
5. CPU begins processing instructions.
6. Startup completes successfully.

---

## Advantages

- Simplifies client interaction.
- Hides subsystem complexity.
- Reduces coupling between components.
- Centralizes workflow management.
- Improves maintainability.

---

## Disadvantages

- The facade can become too large if too many responsibilities are added.
- Clients requiring fine-grained control may still need direct subsystem access.

---

## How to Run

Compile and run the program:

```bash
javac ComputerStartupFacade.java
java ComputerStartupFacade
```

---

## Sample Output

```text
Initializing CPU...
Loading data into memory...
Reading boot files from hard drive...
Starting operating system...
CPU started processing instructions.
Computer startup completed successfully.
```

---

## Author

Kishore Kumar J