# File Util

[![](https://jitpack.io/v/hidirektor/file-util.svg)](https://jitpack.io/#hidirektor/file-util)

File Util is a Java-based utility library for performing file and directory operations.

## Features
- File operations: reading, writing, copying, moving, and deleting.
- Directory operations: creation, deletion, listing contents, and size calculation.
- File compression and extraction.

## Installation

### Maven
```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>

<dependency>
    <groupId>com.github.hidirektor</groupId>
    <artifactId>file-util</artifactId>
    <version>v1.0.0</version>
</dependency>
```

### Gradle
```groovy
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    implementation 'com.github.hidirektor:file-util:v1.0.0'
}
```

## Usage

### File Operations

#### Reading a File
```java
String content = FileUtil.readFile("/path/to/file.txt");
System.out.println(content);
```

#### Writing to a File
```java
FileUtil.writeFile("/path/to/file.txt", "Hello, World!", false);
```

#### Checking File Existence
```java
boolean exists = FileUtil.fileExists("/path/to/file.txt");
System.out.println("Exists: " + exists);
```

#### Copying a File
```java
FileUtil.copyFile("/path/source.txt", "/path/destination.txt");
```

#### Moving a File
```java
FileUtil.moveFile("/path/source.txt", "/path/destination.txt");
```

### Directory Operations

#### Creating a Directory
```java
DirectoryUtil.createDirectory("/path/to/newdir");
```

#### Checking if a Directory is Empty
```java
boolean isEmpty = DirectoryUtil.isDirectoryEmpty("/path/to/dir");
System.out.println("Is Empty: " + isEmpty);
```

#### Listing Files in a Directory
```java
List<String> files = DirectoryUtil.listFiles("/path/to/dir");
files.forEach(System.out::println);
```

#### Calculating Directory Size
```java
long size = DirectoryUtil.getDirectorySize("/path/to/dir");
System.out.println("Size: " + size);
```

## License
This project is licensed under the [MIT License](LICENSE).

