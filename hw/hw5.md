1. `Comparable`
  - Key point of hw5
  - Since every element inserted into the set is Integer, which implemented `Comparable`, then in the later methods such as `union()`, casting items to Comparable can call `compareTo()` method
  - Other classes that implements `Comparable` can also pass to the insert method
  - Interface is also a type, which can used to cast
