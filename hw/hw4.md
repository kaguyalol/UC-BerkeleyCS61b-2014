## HW 4

1. `protected`
  - Classes in the same package can access methods or fields of each other even not subclass
  - Subclass can access methods or fields even outside the package
    * It is the key point of PartII, to corrupt the program, we can inherits the fields or static method, then **shaodows** them.

2. Casting
 - Superclass cannot cast to subclass only if dynamic type is subclass
  ```java
  List myList = new SList();
  ((SList) myList).head =...;
  ```
- The key point of partIII of hw4 is that **override newNode()** in *LockDList*, since every methods inherit from *DList* will invoke method newNode(), if override it, then everytime we insert a new node, the dynamic type is *LockDListNode*, then it can be casted to *LockDListNode*

- Override a method can return same type or **compatible** type 

- Second key point is that we should know cast can change object itself
  ```java
  public void lockNode(DListNode node) { 
    ((LockDListNode) node).isLocked = true;
  }
  ```
  
