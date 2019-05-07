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
    public static String repeat1(char c, int n) {
    String answer = "";
    for (int j = 0; j < n; j++) {
      answer += c;
    }
    return answer;
    }

    public static String repeat2(char c, int n) {
      StringBuilder answer = new StringBuilder();
      for (int j = 0; j < n; j++) {
        answer.append(c);
      }
      return answer.toString();
    }
    ```
  
  
2. Asymptotic Analysis
  - Big-Omega
    * Greater than or equal to
  - Big-Theta
    * Grows at the same rate

