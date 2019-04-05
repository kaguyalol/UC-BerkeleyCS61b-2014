1. Objects and Constructors

```java
String s = new String();
```

composes 3 steps:
  - chunk a memory for `s`, a reference variable(_not object itself_)
  - construct a new object for new `String` object on the heap
  - s points/refers to the new object
  
```java
s = "wow";
String s2 = s;
```

`s` and `s2` point to same object.

```java
String s2 = new String(s);
```

`s` and `s2` point to different object, although they're _identical_.


2. Methods

```java
s.toUpperCase();
```

`s` points to new object, `.toUpperCase` is not _inplace_.


3. I/O Classes

read from keyboard:
3 steps:
  - `BufferedReader`
  - `InputStreamReader`
  - `System.in`

*System.in(raw data) -> InputStreamReader(characters) -> BufferedReader(line)*

```java
import java.io.*;

class SimpleIO {
    public static void main(String[] args) throws Exception{
        BufferedReader keybd = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(keybd.readLine());
    }
}
```

4. Garbage Collection

`null` is a value; _garbage collection_: an object has only one reference, and the reference is broke, then it is eligible for garbage collection.

```java
Book b = new Book();
Book c = new Book();
```
b -> object 1\
c -> object 2

active references: 2\
reachable objects:2

```java
b = c;
```

active references:2\
reachable objects:1\
abondaned objects:1

*object 1 is in garbage collection*

```java
c = null;
```

active references:1\
null reference:1\
reachable objects:1\
abondaned objects:1


5. String(Immutable)

```java
String s = "0";
for (int i = 0; i < 10; i++) {
    s = s + i;
}
```

JVM will creates _10_ objects in _string pool_, but garbage collector will not go there, which will waste memory.


6. Wrappers(Immutable)

```java
Integer iWrapper = new Integer(42);
```

If refer iWrapper to other obejcts, then there are _two_ objects.
