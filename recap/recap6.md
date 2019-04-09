1. Singly-LinkedList
    ```java
    public class SListNode {
      public Object item;
      public SListNode next;
    }
    ```
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
  - Delete at the front
    ```java
    public void deleteFront(Object item) {
        if (head != null) {
            head = head.next;
            size--;
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
        size++;
    }
    ```
  - Hard to delete end of list(even with tail pointer)
    * Need to access the second last node, but no pointer from last one to second last one
    * Or from head to tail, need _Doubly-LinkedList_

2. Circularly Singly-LinkedList
    |-|
    
3. Doubly-LinkedList
    ```java
    public class DListNode {
      public Object item;
      public DListNode prev;
      public DListNode next;   
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
  
