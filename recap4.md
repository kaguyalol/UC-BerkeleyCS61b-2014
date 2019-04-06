1. `System.out.print()` vs `System.out.println()`

  - `System.out.print()` keeps printing to the same line
  - `System.out.println()` insert a new line

2. `==` vs `equals()`

  - `==` uses for comparing two primitives or seeing if two references refer to the same object
  - `equals()` see if two different objects are equal(e.g. same string)
  
  ```java
  int a = 3;
  byte b = 3;
  if (a==b) {\\true}
  \\ the bit patterns are the same, so they are equal
  ```
```java
Foo a = new Foo();
Foo b = new Foo();
Foo c = a;
if (a == b) { // false } if (a == c) { // true } if (b == c) { // false }
```
