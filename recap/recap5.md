1. `final` static variable
  - two initializing ways
    ```java
    public class Foo {
      public static final int FOO_X = 25;
    }
    ```
    ```java
    public class Foo {
      public static final int FOO_X;
      
      static {
      FOO_X = 25;
      }
    }
    ```
  - MUST initialize or _complier error_

2. A final class means you can't extend the class

3. Mark class final, then all methods in the class are final

4. Assigning a value to a final instance variable must be either at the time it is declared, or in the constructor

5. Final variable can be shadowed by parameter in methods
  ```java
  class Foo5 { 
    static final int x = 12;
    public void go(final int x) { 
        System.out.println(x);  
    } 
  }
  ```
  ```java
  class Foo5 { 
    static final int x = 12;
    public void go(int y) { 
        System.out.println(x);  
    } 
  }
  ```
  ```java
  class Foo5 { 
    static final int x = 12;
    public void go(int x) { 
        System.out.println(x);  
    } 
  }
  ```
  ```java
  Foo5 foo5 = new Foo5();
  foo5.go(4);
  ```
  output:
  ```java
  4
  12
  4
  ```

6. Insert item to a full array
  - Allocate a new array with longer length
  - Shift items to teh right
  ```java
  
  public class AList {
    int a[];
    int lastItem;

    public AList() {
        a = new int[10]; // empty array, so need to insert items till full
        lastItem = -1; // from -1 since index is from 0
    }

    public void insertItem(int newItem, int location) {
        int i;
        // since lastItem starts from -1, need to add 1 to equal to a.length
        if (lastItem + 1 == a.length) {
            int b[] = new int[2 * a.length];
            for (i = 0; i <= lastItem; i++) {
                b[i] = a[i];
            }
            a = b;
         }
         // when i--, if initial state less than final condition, loop will not start
         for (i = lastItem; i >= location; i--) {
             a[i + 1] = a[i];
         }
         System.out.println(lastItem);
         a[location] = newItem;
         lastItem++;
     }
  }
  ```
  - _*when i--, if initial state less than final condition, loop will not start*_
  

  

  

