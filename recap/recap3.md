1. static method
static method does not pass an object as a parameter, it does not pass `this`.
e.g. Methods in `Math` class don't use any _instance variables_, methods in  `Math` class are all _static_.

```java
Math mathObject = new Math();
```
Complie Error will occurs, since constructor of `Math` is _private_.

```java
int x = Math.round(42.2);
```
  - static method don't need instances
  - only need the _class_
  - no need to instantiate
  - use the class name, rather than reference variable name. _NO OBJECTS_
  - static methods can't use non-static variables/methods
  - static variables have default values as like instance variables

```java
Human.printHumans();
```

It has nothing to do with specific object, but the class itself.

2. instance variables vs local variables
  - instance variables are declared within a class; local variables are declared inside a method
  - instance variables have default value, do not need to initialize; local variables have no default value, need initialize, if not, will invoke complie error.
  
3. constructors are _NOT_ inherited. 


