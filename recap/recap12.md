1. Tree
  - Computing Depth and Height
    * Depth
      ```java
      public int depth(Position<E> p) {
        if (isRoot(p)) return 0;
        return 1 + depth(parent(p));
      }
      ```
    * Height
      ```java
      public int height(Position<E> p) {
        int h = 0;
        for (Position<E> c: child(p)) {
          h = Math.max(h, 1 + height(c));
        }
        return h;
      }
      ```
