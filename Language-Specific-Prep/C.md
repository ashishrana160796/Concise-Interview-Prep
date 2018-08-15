## C Important Concepts

* __Storage Classes:__ Define scope & life-time of a variable.  
  * auto: default type.
  * register: A variable might be stored in register. '&' can't be applied to it, as it doesn't have memory location.
  * static: Variable is in scope for lifetime of the program.
  * extern: give a reference of a global variable/member that is visible to ALL the program files.

* Functions, Call by value(actual parameters not changed, formal ones are) where as in Call by reference with '&' operator
actual value is changed *(indifference operator) is used for this.  
* Global variable are initialized to default values, local ones are not.
* Pointer to an array upon increment iterates over the elements of an array.  
  For passing an array, either usual or star syntax can be used. Example: function(int *par){, or (int par[]) or size can also be specified in last decleration  
  Return statement can also be specfied, int * function(){ ...  
* __Strings in C__: Char Arrays with '\0' character in end. Basic methods are strcpy, strcat, strlen, strcmp, strchr, strstr.  
* __Typedef & TypeCasting__: In typecasting explicitely a type is changed into specific one. Also, implicitely compiler
promote type of different data types known as integer promoting. _typedef_ is used for giving yout type a new name.
  * typedef is different from 3define, typedef is compilers interpretation & #define is pre-processor's interpretation.
* __Structure v/s Union:__
  * In Structure each variable gets different space. In union largest one is only gets counted.
  * In union error while accessing a variable is thrown. Only, the most recent stored member can be accessed.
  * Several members can be initialized in struct. In union only first member can be initialized.
* __Pointers:__ 

```
Pointer Increment moves the pointer to next memory location. Pointer comparison can be done if they are member of same array, relation is needed.
ptr1 <= &arr[3]  // ptr1 = arr; 
Pointer array syntax: int *ptr[n];
Pointer to a Pointer syntax: int **ptr;
Syntax of pointer return: int * function() { ...
```
