## Important Java Concepts

* __Variable Basics__

```
Variable reserves a place to store a particular data. Basic data types determine what kind of variable can be stored in it.  
Two Types of data types are there:
* Basic/Primitive(8 types: 4+2+1+1): byte, short, int, long | float, double | char | boolean 
* Referential: arrays types | Object of classes.

A literal is a source code representation of a fixed value. like 'A', 26 they can be assigned to variables.

Difference b/w \u0000 & NULL i.e. null character v/s liternal null.

\u0000 is a null character. The null type has one value, the null reference, represented by the literal null, which is formed from ASCII characters. A null literal is always of the null type.  
Also, programmer can ignore the null type and just pretend that null is merely a special literal that can be of any reference type.  
As, null type has no name, it is impossible to declare a variable of the null type or to cast to the null type.  

Static variables an interesting concept, only one copy per class. Static variables are rarely used other than as constants.  
Static variables can be accessed by calling with the class name ClassName.VariableName. Like, System.out etc.
```

* __Modifiers__

```
Access Control Modifiers
The four access levels are:
    Visible to the package, the default. No modifiers are needed.
    Visible to the class only (private).
    Visible to the world (public).
      can be accessed from any class belonging to the Java Universe. 
    Visible to the package and all subclasses (protected).
      can be accessed only by the subclasses in other package or any class within package of protected members' class.

Non Access Modifiers
    The static modifier for creating class methods and variables. Exist w/o instance, accessed with ClassName.Variable . 
    The final modifier for finalizing the implementations of classes, methods, and variables. A reference variable declared final can't be changed.
      However, content within it can be changed. Final methods can't be overidden. Final Classes can't be subclassed.
    The abstract modifier for creating abstract classes and methods. Abstract class can contain abstract methods & non-abstract methods.
      A class extending abstract class must implement all its abstract methods.
    The synchronized and volatile modifiers, which are used for threads.
      synchronized states that method can be accessed one at time.
      transient keyword in Java is used to indicate that a field should not be serialized i.e. not part of the persistent state of an object.
      Volatile variable accessing thread must merge it's own copy with the master copy.
        It synchronizes all the cached copied of the variables in the main memory.
        
```

* __Arrays__

```
java.util.Arrays, few important methods

public static int binarySearch(Object[] a, Object key), before calling it sort the array. Returns the index value of key or -(key+1)
public static boolean equals(long[] a, long[] a2), same method for int, short, byte etc. is also there.
public static void fill(int[] a, int val), same method short, long & byte etc. available.
public static void sort(Object[] a), for other data types also available.
```

* __Inner Classes__

```
                  Nested Classes
    Inner Classes                 Static Classes
    
    Inner Classes
    Method Local Classes, local within a method i.e. it's scope is within that method only.
    Anonymous Inner Classes, Class declared w/o a name. Ex:
      AnonymousInner an_inner = new AnonymousInner() { public void my_method() {} };
 
Private modifiers are only added to inner classes. Member of inner classes can be accessed by containing class.  
If a method accepts an object of an interface, an abstract class, or a concrete class, then we can implement
the interface, extend the abstract class, and pass the object to the method. If it is a class, then we can
directly pass it to the method.

A static inner class is a nested class which is a static member of the outer class.
It can be accessed without instantiating the outer class, using other static members.
```

* __Checked Exceptions__

```
Types of Exceptions
  Checked Exceptions: Occurs at compile time. Can't be ignored at compile time.
  Unchecked Exceptions: Occurs at run time, executing the code.
  Errors: beyond the control of programmer, stack overflow for example. Can't do anything about it.
    Examples: IllegalArgumentException, IllegalStateException.
  
Exception Hierarchy:
All exception classes are subtypes of the java.lang.Exception class.
The exception class is a subclass of the Throwable class.
Other than the exception class there is another subclass called Error which is derived from the Throwable class.

* getMessage(), printStackTrace(), Throwable getClause() can be used to get messages about the class.
* Concept of multiple catch blocks & their linear order of execution until the first one is matched.
    Catching multiple exceptions with concatenate operand can also be done.
* If a method does not handle a checked exception, the method must declare it using the throws keyword. The throws keyword appears at the end of a method's signature. Mutiple exception throws can be declared in the method signature also.
* Finally block always executes it can be used for performing clean ups.
* try-with-resources, automatically closes resources, is an example of automatic resource management. In case of multiple resources seperate them with semi-colons.
  AutoClosable interface is needed to be implemented. Resources within this try block are implicitly final & closes in reverse order.
 * All exception throwing classes must be child of Throwable. Hence, they must extend Exception.
```

* __Packages__

```
Package statement is first line in code. & only one package name should be there. Upon no decleration it placed in current
default package.

-d argument compilation of javac creates a package folder in specified destination.
javac -d Destination file.java
java packageName.ClassName, can be used to compile the classes.
```
---

## Java OOPS Concept

* __Inheritance__

```
* A subclass inherits all the members (fields, methods, and nested classes) from superclass.
  Constructors are not members, but the constructor of the superclass can be invoked from subclass.

* super keyword differentiate members of superclass & invoke superclass constructors.
  
* Generally inheritance relation is IS-A relation type but other types are also there.
    Association: Relation b/w two classes. Can be one-to-one, one-to-many, many-to-one, many-to-many.
      Composition: PART-OF relation, depedency amongst each other, no individual existance.
      Aggregation: HAS-A relation, unidirectional relation & both entries survive individually.
* No, multiple inheritance to avoid any virtual function type analysis like C++. Multiple interfaces can be implemented.
```

* __Overriding__

```
Example:

  Animal a = new Animal();
  Animal b = new Lion();
  a.print();   
  b.print();   
  
Output:
  Animals
  Lion

In compile time, the check is made on the reference type.
However, in the runtime, JVM figures out the object type and would run the method that belongs to that particular object.
Reference type of superclass won't be able to access methods from subclass.
  Also, access level of subclass can't be more restrictive. 
  Final method can't be overridden. Static methods also but can be re-declared.
  Overidding method must also throw narrow scope exceptions as compared to superclass.
```

* __Polymorphism__

```
The way to access is of reference type, once declared can't be changed. Multiple IS-A test passing instances will
show polymorphism.

Virtual method invocation: 
An overridden method is invoked at run time, no matter what data type the reference is that was used
in the source code at compile time.
```
