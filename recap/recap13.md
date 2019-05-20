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
      * expandExternal(p, (k,v)) Stores entry e at the external position p, and expands p to be internal, **having two new leaves as children**
      
  - 
  
