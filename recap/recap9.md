1. Exceptions
  - Is a class 
  - Can be catched to prevent program terminating and printing error message
  - If `try` code throws an exception, it will jump to the first `catch` that **match** the exception(same or subclasses)
  - If an exception propagates all the way out of main() without being caught, the JVM prints an error message and halts
  - Multiple `catch` block must be ordered from smallest to biggest
    * Since superclass catch the exception, then subclasses will never run
  - `throws` exceptions in the signature
    * If exception happens, method will pop off the stack down to the `main()`
    * If no one deal with such exception, JVM will shuts down

2. Throwable
  - Superclass of Exception and Error
  - Checked and Unchecked
    * Whether need to declare them in the signature
  - `throws` 
    * One method throws exception and another deal with the exception(`try` and `catch`)

3. `finally`
  - Must run regardless of an exception
  - If try or catch block has return statement, `finally` still runs
    * Flow jumps to the `finally` and back to the reture
  - If try block causes other exceptions, `finally` still runs, but the exception is not caught, then down to the stack
  - If an exception happens in catch block, `finally` still runs

4. Generics
  - Safe from a ClassCastException
  - Don't work with primitive types

5. Field Shadowing
  - Static methods _can’t_ use dynamic method lookup or overriding, so they use shadowing instead
  - The choice of methods is dictated by the _dynamic_type_ of an object
  - The choice of fields is dictated by the _static_type_ of a variable or object
    ```java
    class Super {
      int x = 2;
      int f() {
        return 2;
      }
    }
    ```
    ```java
    class Sub extends Super {
      int x = 4; // shadow Super.x
      int f() {  // override Super.f()
        return 4;
      }
    }
    ```
    * Every objects of Sub has _two_ fields called x
    ```java
    Sub sub = new Sub();
    Super supe = sub;
    int i;
    ```
    ```java
    i = supe.x; // 2
    i = sub.x; // 4
    i = ((Super) sub).x; // 2
    i = ((Sub) supe).x; // 4
    ```
    ```java
    i = supe.f(); // 4
    i = sub.f(); // 4
    i = ((Super) sub).f(); // 4
    i = ((Sub) supe).f(); // 4
    ```
    * Shadow `this`
    ```java
    class Sub extends Super {
      int x = 4;  // shadows Super.x
      void g() {
    
        i = this.x;  // 4
        i = ((Super) this).x; // 2
        i = super.x;  // 2    
    ```

6. `final`
  - A method can be declared "final" to prevent subclasses from overriding it
  - A class can be declared "final" to prevent it from being extended
  - `final` is to improve the speed of a program

7. Prevent Subclasses
  - Default accessor 
  - `final`
  - Private constructors
    
    

  
      
