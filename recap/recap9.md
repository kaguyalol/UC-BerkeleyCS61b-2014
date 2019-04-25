1. Exceptions
  - Is a class 
  - Can be catched to prevent program terminating and printing error message
  - If `try` code throws an exception, it will jump to the first `catch` that **match** the exception(same or subclasses)
  - If an exception propagates all the way out of main() without being caught, the JVM prints an error message and halts
  - Multiple `catch` block must be ordered from smallest to biggest
    * Since superclass catch the exception, then subclasses will never run
  - `throws` exceptions in the signature
    * If exception happens, method will pop off the stack down to the `main()`
    * If no one deal with such exception, JVM will shuts down

2. Throwable
  - Superclass of Exception and Error
  - Checked and Unchecked
    * Whether need to declare them in the signature
  - `throws` 
    * One method throws exception and another deal with the exception(`try` and `catch`)

3. `finally`
  - Must run regardless of an exception
  - If try or catch block has return statement, `finally` still run
    * Flow jumps to the `finally` and back to the return

  
      
