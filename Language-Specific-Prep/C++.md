## C++ Important Concepts

* __Pointers & References__

```
int  *ptr = NULL; // null pointer assign to non-initialized pointers
```

```
Reference is an alias, to already existing variable. Can't have NULL references.
After initialization reference can't be changed.
Reference is initialized at time of creation.
  // variables
   int    i;
   double d;
   // variables
   int&    ir = i;
   double& dr = d;
   
For references, data_type& should for passing variables as arguments or return type.   
```

---

* __Classes & Objects:__

```
For defining function outside class use scope operator '::'

Access by default is private in C++ members of class. Public means, available to all in scope of program.

The copy constructor is a constructor which creates an object by initializing it with an object of the
same class, which has been created previously.
classname (const classname &obj) {
}

Friend functions are not member functions. Right to access all private and protected members of the class.
Scope operator is not required for it while defining.

For small methods place a keyword 'inline' before the function & the code will get inlined to the value.

Pointer to an object of a class. -> is used for accessing the member functions.
Also, foo->bar() is the same as (*foo).bar(). In this brackets are required as '.' is having higher precidence than '*'.

Static Member Functions, becomes independent of class. Also, can access only static members of class or any other method outside the
class. They don't access to this pointer of the class.

```
