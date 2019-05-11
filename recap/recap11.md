1. Hash Function _h(k)_
 - Consists of two parts
   * **Hash code** maps a key to an integer
   * **Compression function** maps the hash code to an integer within a range of indices [0, N − 1]

2. Stacks
 - _last in first out_
 - Applications:
   * Internet Web browsers
   * _undo_ in Text editors
 - Implementations of the Stack interface
   * Array
     * `java.util.Stack`
     * It relies on a fixed-capacity array, which limits the ultimate size of the stack
     * Waste space, _O(N)_
   * Singly LinkedList
     * Flixible length
     * `insertFront()`
 - Sample applications
   * Matching Parentheses
     ```java
     public static boolean isMatched(String expression) {
      final String OPENING = "({[";
      final String CLOSING = ")}]";
      Stack<Character> buffer = new Stack<>();
      for (char c: expression.toCharArray()) {
        if (OPENING.indexOf(c) != -1) buffer.push(c);
        else if (CLOSING.indexOf(c) != -1) {
          if (buffer.isEmpty()) return false;
          if (CLOSING.indexOf(c) != OPENING.indexOf(buffer.pop())) {
            return false;
          }
        }
      }
      return buffer.isEmpty();
     }
     ```
     
3. Queues
 - FIFO
 - Implementations
   * Circular Array 
     ```java
     /**
      * f index of the front element
      * sz current number of elements
      */
     public void enqueue(E e) throws IllegalStateException {
       if (sz == data.length) throw new IllegalStateException("Queue is full");
       int avail = (f + sz) % data.length; // use modular arithmetic
       data[avail] = e;
       sz++;
     }
     
     public E dequeue( ) {
       if (isEmpty()) return null;
       E answer = data[f];
       f = (f + 1) % data.length;
       sz−−;
       return answer;
     }
     ```
