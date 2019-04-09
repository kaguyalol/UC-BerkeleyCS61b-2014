1. Singly-LinkedList
  - Easy to insert/delete at front of list
  - Hard to insert/delete end of list
  - Insert node to the front of SLinkedList
    ```java
    public class SLink{
      public void removeTail(){
        
      }
    }
    ```

2. Doubly-LinkedList
  - Easy to insert/delete end of list
  - Remove tail from DLinkedList(_should consider special cases_)
    ```java
    tail.prev.next = null;
    tail = tail.prev;
    ```
  - Sentinel
    * To reduce one node or no node special cases, and no tail, head points to continel
    * Remove back(no tail now)
      ```java
      public void removeBack() {
        if (head.prev != head) {
          head.prev = head.prev.prev;
          head.prev.next = head;
          size--;
        } 
      }
      ```
  
