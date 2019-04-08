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

