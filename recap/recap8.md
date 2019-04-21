1. Abstract Class
  ```java
  public abstract class List{}
  ```
  - Don't allow creating an object directly
  - Can declare a type
    ```java
    List myList; \\ good
    myList = new List(); \\ Compile-time error
    ```
  - A non-abstract class may never contain a abstract method, nor inherit one without inplementation

2. Interface
  - Can inherits multiple interfaces
