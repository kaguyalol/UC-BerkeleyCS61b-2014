1. Singly-LinkedList
  - Remove tail from SLinkedList
    ```java
    ```

2. Doubly-LinkedList
  - Remove tail from DLinkedList(_should consider special cases_)
    ```java
    tail.prev.next = null;
    tail = tail.prev;
    ```
  - Sentinel
    * To reduce one node or no node special cases, and no tail, head points to continel
    * Remove back(no tail now)
      ```java
      public void removeBack {
        if (head.prev != head) {
          head.prev = head.prev.prev;
          head.prev.next = head;
          size--;
        } 
      }
      ```
  
