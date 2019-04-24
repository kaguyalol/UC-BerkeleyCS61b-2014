## HW 4

1. `protected`
  - Classes in the same package can access methods or fields of each other even not subclass
  - Subclass can access methods or fields even outside the package

2. Casting
 - Superclass cannot cast to subclass only if dynamic type is subclass
  ```java
  List myList = new SList();
  ((SList) myList).head =...;
  ```
  
