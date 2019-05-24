```
Inserting 1A, 6V, 3K, 2Z, 5L, 9L:
The tree is:  1A(((2Z)3K(5L))6V(9L))
Size:  6

Testing find() ...
Calling find() on 1
  returned A.
Calling find() on 9
  returned L.
Calling find() on 5
  returned L.
Calling find() on 4
  returned null.
Calling find() on 6
  returned V.
Calling find() on 3
  returned K.

Testing remove() (for nodes with < 2 children) ...
After remove(5):  1A(((2Z)3K)6V(9L))
After remove(3):  1A((2Z)6V(9L))
After remove(1):  (2Z)6V(9L)
After inserting 7S, 8X, 10B:  (2Z)6V((7S(8X))9L(10B))
Size:  6

Testing remove() (for nodes with 2 children) ...
After remove(6):  (2Z)7S((8X)9L(10B))
After remove(9):  (2Z)7S((8X)10B)
Size:  4

```
