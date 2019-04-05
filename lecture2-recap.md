1. Objects and Constructors

```java
String s = new String();
```

composes 3 steps, 
  - chunk a memory for `s` to store `String`
  - construct a new object from `String`
  - s point/reference to the new object
  
```java
s = "wow";
String s2 = s;
```

`s` and `s2` point to same object.

```java
String s2 = new String(s);
```

`s` and `s2` point to different object, although they're identical.

