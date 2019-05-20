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
      
  - TreeDelete()
  - Implementation
    ```java
    public class TreeMap<K,V> extends AbstractSortedMap<K,V> {
      protected BalanceableBinaryTree<K,V> tree = new BalanceableBinaryTree<>();
      
      pulic TreeMap() {
        super();
        tree.addRoot(null);  // create a sentinel leaf as root
      }
      
      pulic TreeMap(Comparator<K> comp) {
        super(comp);
        tree.addRoot(null);  
      }
      
      public int size() {
        return (tree.size() - 1) / 2;
      }
      
      private void expandExternal(Position<Entry<K, V>> p, Entry<K, V> entry) {
        tree.set(p, entry);
        tree.addLeft(p, null);
        tree.addRight(p, null);
      }
      
      protected Position<Entry<K,V>> root( ) { return tree.root( ); }
      
      private Position<Entry<K,V>> treeSearch(Position<Entry<K,V>> p, K key) {
        if (isExternal(p))
          return p;
        int comp = compare(key, p.getElement( ));
        if (comp == 0)
          return p;
        else if (comp < 0)
          return treeSearch(left(p), key); 
        else
          return treeSearch(right(p), key);
      }
      
      public V get(K key) throws IllegalArgumentException {
        checkKey(key);
        Position<Entry<K,V>> p = treeSearch(root(), key);
        rebalanceAccess(p);
        if (isExternal(p)) return null;
        return p.getElement().getValue();
      }
      
      public V put(K key, V value) throws IllegalArgumentException {
        checkKey(key);
        Entry<K,V> newEntry = new MapEntry<>(key, value);
        Position<Entry<K,V>> p = treeSearch(root(), key);
        if (isExternal(p)) {
          expandExternal(p, newEntry);
          rebalanceInsert(p);
          return null;
        } else {
          V old = p.getElement().getValue();
          set(p, newEntry);
          rebalanceAccess(p);
          return old;
        }
      }
      
      public V remove(K key) throws IllegalArgumentException {
        checkKey(key);
        Position<Entry<K,V>> p = treeSearch(root(), key);
        if (isExternal(p)) {
          rebalanceAccess(p);
          return null;
        } else {
          V old = p.getElement().getValue();
          if (isInternal(left(p)) && isInternal(right(p))) {  // both children are internal
            Position<Entry<K,V>> replacement = treeMax(left(p));
            set(p, replacement.getElement());
            p = replacement;
          }
          Position<Entry<K,V>> leaf = (isExternal(left(p)) ? left(p) : right(p));
          Position<Entry<K,V>> sib = sibling(leaf);
          Position<Entry<K,V>> sib = sibling(leaf);
          remove(leaf);
          remove(p);
          rebalanceDelete(sib);
          return old;
        }
      }
    }
    ```
  
