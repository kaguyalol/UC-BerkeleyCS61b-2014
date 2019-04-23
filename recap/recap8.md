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
  - Array of type(abstract)
    ```java
    Animal[] animals = new Animal[4]; // Animal is an abstract type, it's not make a new object of Animal type
    ```
2. Object
  - Every class in Java extends class **Object**
  - Methods
    * `equals(Object o)`
    * `getClass()`return the class that object instantiated from
      ```java
      Cat c = new Cat();
      System.out.println(c.getClass());
      ```
      ```
      class Cat
      ```
    * `hashCode()` return the hashcode for object
      ```java
      System.out.println(c.hashCode());
      ```
      ```
      8202111
      ```
    * `toString()` return a String with the name of class
      ```java
      System.out.println(c.toString());
      ```
      ```
      Cat@7d277f
      ```
  - The complier decides whether you can call a method based on the reference type, not the actual object type
      
  
3. Interface
  - Can inherits multiple interfaces

4. Iterator
  - In Java.util there is a standard interface for iterator
    ```java
    public interface Iterator {
      boolean hasNext();
      Object next();
      void remove();
    }
    ```

5. Building Packages
  - Put a `package` statement in all source files in the same directory
    * It must be in the first line
    ```java
    package list; // all classes are put in directory list/
    
    public class SList {
      SListNode head;
      int size;
    }
    ```
