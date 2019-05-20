1. Binary Search Tree
  - TreeSearch(p, k) results in the **position** at which the key is found
  - TreeInsert(k, v)
    * pseudocode
      ```
      input:key k, value v
      p = TreeSearch(root(), k)
      if k == key(p) then
        change p's value to v
      else 
        expandExternal(p, (k,v))
      ```
  
