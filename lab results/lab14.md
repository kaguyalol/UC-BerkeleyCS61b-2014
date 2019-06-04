```shell
PART I:  Testing zigZig()

Inserting 1G, 3O, 2O, 5J, 4D, 7B, 6O into Tree 1.
Tree 1 is:  (((((1G)2O)3O)4D)5J)6O(7B)
Skipping the rest of Part I.

PART II:  Testing splayNode()

Calling splayNode() on the unbalanced tree:

Inserting 10A, 9B, 8C, 7D, 6E, 5F, 4G, 3H, 2I, 1J
tree is:  1J(2I(3H(4G(5F(6E(7D(8C(9B(10A)))))))))
Calling find(10)
  returned A.
The tree should be better balanced now: (1J((2I)3H((4G)5F((6E)7D((8C)9B)))))10A

Some find() operations on a new tree to test splayNode():

Inserting 3A, 7B, 4C, 2D, 9E, 1F
Tree 2 is:  1F((2D(3A((4C)7B)))9E)
Calling find(7)
  returned B.
Tree 2 is:  (1F((2D)3A(4C)))7B(9E)
Calling find(4)
  returned C.
Tree 2 is:  ((1F(2D))3A)4C(7B(9E))
```
