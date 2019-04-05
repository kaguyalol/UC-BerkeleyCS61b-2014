1. static method
static method does not pass an object as a parameter, it does not pass `this`.

```java
Human.printHumans();
```

It has nothing to do with specific object, but the class itself.

2. instance variables vs local variables
  - instance variables are declared within a class; local variables are declared inside a method
  - instance variables have default value, do not need to initialize; local variables have no default value, need initialize, if not, will invoke complie error.
  
3. constructors are _NOT_ inherited. 


