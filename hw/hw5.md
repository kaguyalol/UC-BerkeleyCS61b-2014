1. `Comparable`
  - Key point of hw5
  - Since every element inserted into the set is Integer, which implemented `Comparable`, then in the later methods such as `union()`, casting items to Comparable can call `compareTo()` method
  - Other classes that implements `Comparable` can also pass to the insert method
  - Interface is also a type, which can used to cast
  - **If you define a reference variable whose type is an interface, any object you assign to it must be an instance of a class that implements the interface**
  ```java
  public void union(Set s) {
    // Your solution here.
    try {
      if (set.isEmpty()) {
        ListNode dummy = s.set.front();
        while (dummy.isValidNode()){
          set.insertBack(dummy.item());
          dummy = dummy.next();
        }
      } else {
        ListNode p1 = set.front(), p2 = s.set.front();

        while (p2.isValidNode()) {
          while (((Comparable) p2.item()).compareTo(p1.item()) > 0) {
            if (p1.next().isValidNode()) {
              p1 = p1.next();
            } else {
              break;
            }
          }

          if (((Comparable) p1.item()).compareTo(p2.item()) == 0) {
            p2 = p2.next();
          }

          p1.insertAfter(p2.item());
          p2 = p2.next();
          if (p1.next().isValidNode()) p1 = p1.next().next();
        }
      }
    } catch (InvalidNodeException e) {

    }
  }
  ```
