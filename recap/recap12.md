1. Tree
  - Computing Depth and Height
    * Depth
      ```java
      public int depth(Position<E> p) {
        if (isRoot(p)) return 0;
        return 1 + depth(parent(p));
      }
      ```
