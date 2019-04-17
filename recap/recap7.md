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
    
    
