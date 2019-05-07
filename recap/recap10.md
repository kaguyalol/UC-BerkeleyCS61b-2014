1. Experimental Studies
  - Record running time
    ```java
    long startTime = System.currentTimeMillis();
    /*run algorithm*/
    long endTime = System.currentTimeMillis();
    long elapsed = endTime - startTime;
    ```
  - StringBuilder
    ```java
    /*O(n^2)*/
    public static String repeat1(char c, int n) {
      String answer = "";
      for (int j = 0; j < n; j++) {
        answer += c;
      }
      return answer;
    }
    /*O(n)*/
    public static String repeat2(char c, int n) {
      StringBuilder answer = new StringBuilder();
      for (int j = 0; j < n; j++) {
        answer.append(c);
      }
      return answer.toString();
    }
    ```

2. Analyzing Algorithms
  - Counting Primitive Operations
    * Primitive operations
      * Assigning a value to a variable
      * Following an object reference
      * Performing an arithmetic operation
      * Comparing two numbers
      * Accessing a single element of an array by index
      * Calling a method
      * Returning from a method
    * Running time
      * Counting the number _t_ of primitive operations 
  - Measuring Operations as a Function of Input Size
    * _f(n)_ characterizes the number of primitive operations that are performed as a function of the **input size _n_**
  - Functions
    * Logarithm
      * log4 n = (logn)/log4 = (logn)/2
      
      
3. Asymptotic Analysis
  - Big-Oh   
  - Big-Omega
    * Greater than or equal to
    * 3nlogn − 2n is Omega(nlogn)
  - Big-Theta
    * Grows at the same rate
    * c'g(n) <= f (n) <= c''g(n)

