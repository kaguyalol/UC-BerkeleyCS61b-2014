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

5. Final variable can be shadowed by parameter in methods
  ```java
  class Foo5 { 
    static final int x = 12;
    public void go(final int x) { 
        System.out.println(x);  
    } 
  }
  class Foo5 { 
    static final int x = 12;
    public void go(int y) { 
        System.out.println(x);  
    } 
  }
  class Foo5 { 
    static final int x = 12;
    public void go(int x) { 
        System.out.println(x);  
    } 
}
  ```
  ```java
  Foo5 foo5 = new Foo5();
  foo5.go(4);
  ```
  output:
  ```java
  4
  12
  4
  ```
  

