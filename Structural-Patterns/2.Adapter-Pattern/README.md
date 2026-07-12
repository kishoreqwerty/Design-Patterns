# Adapter Design Pattern

This project demonstrates the Adapter Design Pattern using a media player example.

The main idea behind the Adapter Pattern is to allow two classes with incompatible interfaces to work together without modifying their existing implementation.

## Problem Statement

Suppose an application supports playing MP3 files through a standard `MediaPlayer` interface.

```java
mediaPlayer.play("song.mp3");
```

Now assume we want to integrate a third-party VLC player library.

The problem is that the VLC library exposes a different method:

```java
playVLC("movie.vlc");
```

Because the method names and interfaces are different, the existing application cannot use the VLC player directly.

## Solution

The Adapter Pattern solves this problem by introducing an intermediate class called an adapter.

The adapter receives requests using the expected interface and internally translates them into calls understood by the existing implementation.

In this project, `VLCAdapter` converts:

```java
play(fileName)
```

into

```java
playVLC(fileName)
```

This allows the application to use both implementations through the same interface.

## Components

### MediaPlayer

Defines the interface expected by the client.

```java
void play(String fileName);
```

### MP3Player

A class that already follows the expected interface.

### VLCPlayer

An existing class with an incompatible interface.

### VLCAdapter

Acts as a bridge between `MediaPlayer` and `VLCPlayer`.

It converts requests from the expected interface into a format understood by the VLC implementation.

### AudioPlayer

Represents the client application that interacts only with the `MediaPlayer` interface.

The client never needs to know whether it is using an MP3 player or a VLC player.

## Execution Flow

1. The client requests media playback.
2. If the player supports the expected interface directly, the request is executed immediately.
3. If the implementation uses a different interface, the adapter converts the request.
4. The underlying implementation processes the request.

## Advantages

- Allows incompatible interfaces to work together.
- Encourages reuse of existing code.
- Reduces changes required in client code.
- Simplifies integration of external libraries and APIs.
- Improves flexibility and maintainability.

## Disadvantages

- Introduces additional classes.
- Excessive use of adapters can increase system complexity.
- Multiple adapters may make debugging more difficult.

## When to Use Adapter Pattern

The Adapter Pattern is useful when:

- Integrating third-party libraries.
- Working with legacy systems.
- Reusing existing code with incompatible interfaces.
- Standardizing interactions across multiple implementations.

## How to Run

Compile and execute the program:

```bash
javac MediaPlayerAdapter.java
java Main
```

## Sample Output

```text
Playing MP3 file: song.mp3

Playing VLC file: movie.vlc
```

## Author

Kishore Kumar J