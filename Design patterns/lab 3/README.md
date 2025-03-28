## Overview

This project demonstrates the Observer Design Pattern in Java. The Observer pattern allows objects (Observers) to automatically receive updates when the state of another object (Subject) changes.

### Key Components

1.  Subject (Publisher):

- Maintains a list of observers.
- Notifies all observers when the state changes.

2.  Observer (Subscriber):

- Defines an interface for receiving updates.
- Updates when notified by the Subject.

3.  Concrete Observers :

- `BinaryObserver` → Converts state to binary.
- `OctalObserver` → Converts state to octal.
- `HexaObserver` → Converts state to hexadecimal.

---

## How It Works

1. Observers subscribe to the `Subject`.
2. When the `Subject`'s state changes, all Observers are notified.
3. Each Observer updates and displays the state in its respective format.

---

## Code Explanation

### 🔹 Subject.java

- Maintains a list of observers.
- Calls `notifyAllObservers()` whenever the state changes.

### 🔹 Observer.java

- Abstract class defining the `update()` method.

### 🔹 Concrete Observers

- `BinaryObserver` → Converts the state to binary .
- `OctalObserver` → Converts the state to octal .
- `HexaObserver` → Converts the state to hexadecimal .

### 🔹 ObserverPatternDemoN.java (Main Class)

- Creates a `Subject` instance.
- Attaches three observers.
- Changes the state of `Subject` to trigger notifications.

---

## Usage

### Run the Program

1. Compile the Java files:
   ```sh
   javac ObserverPatternDemoN.java
   ```
2. Run the program:
   ```sh
   java ObserverPatternDemoN
   ```

### Expected Output

```
First state change: 15
Hex String: F
Octal String: 17
Binary String: 1111
Second state change: 10
Hex String: A
Octal String: 12
Binary String: 1010
```

---

## Key Benefits of the Observer Pattern

✔️ Loose Coupling → Subject and Observers are independent.
✔️ Automatic Updates → Observers react instantly to state changes.
✔️ Extensibility → New observers can be added without modifying existing code.

---
