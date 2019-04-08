1. `final` static variable
  - two initializing ways
    ```java
    public class Foo {
      public static final int FOO_X = 25;
    }
    ```
    ```java
    public class Foo {
      public static final int FOO_X;
      
      static {
      FOO_X = 25;
      }
    }
    ```
  - MUST initialize or _complier error_

2. A final class means you can't extend the class

3. Mark class final, then all methods in the class are final

4. Assigning a value to a final instance variable must be either at the time it is declared, or in the constructor

