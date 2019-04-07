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
  if (a == b) { // false }
  if (a == c) { // true } 
  if (b == c) { // false }
  ```

3. wrapping a primitive

  `Integer`,`Boolean`...

  ```java
  \\ wrapping a value
  int x = 3;
  Integer iWrap = Integer(3);
  ```
  ```java
  \\ unwrap a value
  int unWrapped = iWrap.intValue();
  ```

4. Bit manipulation
  - Bitwise NOT operation
    ```java
    // flip all the bits
    int x = 10; // bits are 00001010
    x = ~x; // bits are now 11110101
    ```
  - Bitwise AND OR XOR operations
    ```java
    int x = 10; // bits are 00001010
    int y = 6; // bits are 00000110

    // AND
    int a = x & y; // bits are 00000010
    // OR
    int a = x | y; // bits are 00001110
    // XOR
    int a = x ^ y; // bits are 00001100
    ```
  
  - Shift operator
    ```java
    int x = -11; // bits are 11110101
    ```
    * _sign bit_ : negative(1), positive(0);
    * Shift _left_ means multiplies a number by a power of two, e.g. `x << 3` -> 10*(2^3);
    * Shift _right_ means devides a number by a power of two, e.g. `x >> 3` -> 10/(2^3);
    
    ```java
    \\ right shift: shift all of the number's bits right by a certain number
    \\ fill the left side with original bits, so the sign does _NOT_ change
    int y = x >> 2; // bits are 11111101
    ```
    ```java
    \\ unsigned right shift: similar as right shif, but fill the left side with _zeros_
    int y = x >>> 2; // bits are 00111101
    ```
    ```java
    \\ left shift: similar to right shift, but in opposite direction
    \\ fill the right side with _zeros_, sign might change
    int y = x << 2; // bits are 11010100
    ```

5. Objects in array

  ```java
  Dog[] myDog = new Dog[3];
  myDog[0] = new Dog();
  myDog[0].name = "Fido";
  myDog[0].bark();
  ```
  `myDog[0]` as a reference varaible name.
  
6. Pre/Post operator
  ```java
  int x = 0;
  int z = ++x; // z = 1, x = 1
  int z = x++; // z = 0, x = 1
  ```
  
7. Turn primitive to String
```java
double d = 42.5;
String doubleString = "" + d;

String doubleString = Double.toString(d);
```

8. The format specifier

  *%*[argument number][flags][width][.precision]*type*
  ```java
  String.format("%6.1f", 42.00);
  ```
  output:
  `  42.0`
    

