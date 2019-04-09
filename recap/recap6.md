1. Singly-LinkedList
    ```java
    public class SListNode {
      private Object item;
      private SListNode next;
    }
    ```
  - Easy to insert/delete at front of list
  - Hard to insert/delete end of list
  - Insert node to the front of SLinkedList
    ```java
    public class SLink{
      private SListNode head;
      private int size;
      
      public SLink(){
        head = null;
        size = 0;
      }
      
      public void insertFront(Object item){
        /*
        * create new SListNode storing a reference to Object item
        * set new SListNode.next points to old head node
        * new head points to new SListNode
        */
        head = new SListNode(item, head);
        size++;
      }
    }
    ```
  - Keep reference to tail, add new node to last
    ```java
    // asign refrence from tail node to newLast before removing tail reference
    public void addLast(Object item) {
      SListNode newLast = new SListNode(item, null);
      tail.next = newLast;
      tail = newLast;
    }
    ```

2. Doubly-LinkedList
    ```java
    public class DListNode {
      private Object item;
      private DListNode prev;
      private DListNode next;   
    }
    ```
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
  
