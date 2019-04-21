1. Abstract Class
  ```java
  public abstract class List{}
  ```
  - To prevent some from saying **new** on that type
  - Don't allow creating an object directly
  - Can declare a type
    ```java
    List myList; \\ good
    myList = new List(); \\ Compile-time error
    ```
  - A non-abstract class may never contain a abstract method, nor inherit one without inplementation
  - Abstract Method
    * Implementation is like override a method, with same method signature and compatible return type

2. Interface
  - Can inherits multiple interfaces
