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
