1. `Comparable`
  - Key point of hw5
  - Since every element inserted into the set is Integer, which implemented `Comparable`, then in the later methods such as `union()`, casting items to Comparable can call `compareTo()` method
  - Other classes that implements `Comparable` can also pass to the insert method
  - Interface is also a type, which can used to cast
  - If you define a reference variable whose type is an interface, any object you assign to it must be an instance of a class that implements the interface
