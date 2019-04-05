1. jvm vs complier
complier runs `javac` to convert source codes to bytecodes, then jvm runs `.class` file(bytecodes).

2.  Initialize instance varaibles
Instance varaible always get a default value, e.g. String null, int 0, float 0.0, boolean false.

```java
class PoorDog {
    private int size;
    private String name;
    
    public int getSize() {
        return size;
    }
    
    public String getName() {
        return name;
    }
}
```

```java
public class PoorDogTest {
    public static void main(String[] args) {
        PoorDog one = new PoorDog();
        System.out.println(one.getSize());
        System.out.println(one.getName());
    }
}
```

output:

```java
0
null
```
