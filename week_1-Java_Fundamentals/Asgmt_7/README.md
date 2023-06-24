# List of Exceptions

This Java project, **List of Exceptions**, demonstrates the use of exception handling. It focuses on handling the **`ClassCastException`** that occurs when trying to cast incompatible types in an ArrayList.

The code creates an `ArrayList` called myList and adds various elements, including strings and an integer, to it. Then, it uses a for loop to iterate over each element in the list. Within the loop, an attempt is made to cast each element to an Integer.

However, since the list contains elements of mixed types, including strings, casting a string element to an `Integer` throws a `ClassCastException`. To handle these exceptions, a `try/catch` block is used.

The commented code snippets illustrate the attempted casting and its resulting exceptions. For example, uncommenting the line:
```java
Integer castedValue = (Integer) myList.get(i);
```
... will trigger a `ClassCastException` when trying to cast a string element to an Integer. The exception is then caught by the catch block, which prints the corresponding error message.

To see the specific elements causing the exceptions, you can uncomment the line:
```java
System.out.println(myList.get(i));
```
...within the catch block.

After catching the exception, the program continues executing and prints "Finished!" to mark the end of each iteration.

This project serves as a learning exercise to understand the importance of exception handling in Java and how to handle `ClassCastException` gracefully using try/catch blocks. By examining the exceptions and their causes, developers can gain insights into debugging and handling incompatible type errors effectively.