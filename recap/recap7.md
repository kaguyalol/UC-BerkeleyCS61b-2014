1. The _heap_ stores all objects, including all arrays and all class variables(i.e. static variables)
  - Instance variables live in heap, inside the object they belong to

2. The _stack_ stores all local variables, including all parameters

3. Garbage Collection
  - Reference goes out of scope, permanently
  - Assign the reference to another object
  - Explicitly set the object to null

4. Inheritance
  - When call a method on an object refrence, you're calling the most specific version of the method for that object type
    * e.g. Invoking a method on a reference to Wolf object means the JVM starts looking first in the Wolf class. 
    * If the JVM does not find a version of the method in the Wolf class, it starts walking back up to the inheritance hierarchy until it finds a match.
    * The compiler does not care about which versions the method is on, only check for whether they have.
  - IS-A Test
    * If inheritance tree works well, subclass IS-A superclass.
    * e.g. tub is not bathroom, bathroom has tub, thus, no inheritance, but tub can be an instance variable of bathroom
  - can't have `this()` and `super()` in the same constructor
    * they must be the first statment
  - instanceof
    * This instanceof operation will return false if s is null or doesn’t reference a TailList.  
    * It returns true if s references a TailList object--even if it’s a __subclass__ of TailList.

5. Polymorphism
  - The reference and the object can be different
    ```java
    Animal myDog = new Dog();
    ```
  - The Rules of Overriding
    * Aruguments must be the same, return type should be the same type or subclass type
    * The method can't be less accessible( cannot from public to private)
    
6. `equals()`
  - Override `equals()`
    * Every class has an equals() method(inherit `Object.equals()`)
    * Signature must not change, pass `Object`, e.g. `equals(Object other)`
