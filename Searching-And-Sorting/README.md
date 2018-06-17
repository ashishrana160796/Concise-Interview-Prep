# Sorting And Searching

## Sorting

* Data Sorting Definitions to start with are Internal(_data being sorted, stored in main memory_), External(_data being sorted, stored in external slow memory_),
In-Place(_extra space required is constant with input size_).
* Stable vs Unstable : In stable sort relative positions remain same for same values but not in case of unstable sorting algorithm.

---
* Bubble Sort : Biggest/Smallest element bubble out of array. Stable & In-Place sort. Less swaps for nearly sorted data.
Slow alogirthm for reverse sorted data.  
  Improvements to this are check for number of swaps in between iterations, Cocktail sort : every alterate run in opposite direction.
  Sample Questions : Calculate the number of swaps, iterations and different variations of this sorting algorithm.

* Selection Sort : O(n^2) (best,worst,average), stable & in-place sort, swap operations less & independent of initial ordering of elements.
  Used for heavy files when data movements are less like in music or video files. 
  Algorithm :
  ```
  selection-sort(int[] a, int n)
  for i<-0 to n-1 
    do smallest <- i
      for j <-i+1 to n-1
        do if a[j] < a[smallest]
          then smallest <-j
      swap a[j] <-> a[smallest]    
        
  ```
  Variations of Selection Sort Algorithm : [Here, select() method sorts with maximum elements selected to the end.](https://practice.geeksforgeeks.org/problems/selection-sort/1/?track=Placement)
  
* Insertion Sort : O(n^2) (average,worst), O(n) (best case-nearly sorted). Stable & In-place sort. Insertion process is costly as lot of movement for elements.
  Good for small list of numbers, & when value keeps on getting added to list. Out performs bubble & selection sort.

  ```
  insertion-sort(int[] a, int n) // it keeps on sorting elements from the left hand side
  for i<- 1 to n-1
   do key <- a[i]  // a[i] will be inserted in a[0 ... i-1]
     j <- i-1
     while j>0 && a[j] > key
       do a[j+1] <- a[j]
       j--
     a[j+1] <- key        
  ```
   
* Shell Sort : Better then all above sorts mentioned. Not a stable sort. Worst case complexities are O(n*log2n) or O(n^3/2) depending on gap sequence.
  Distance b/w successive elements is called gap. Each segment is sorted with insertion sort till gap = 1.
  ```
  for(gap = n/2; gap >0 ; gap/=2)
  {
    for(p = gap ;p<N;p++)
    {
      temp = a[p];
      for(j=p;j>=gap && temp<a[j-gap] ;j-=gap)
        a[j] = a[j-gap];
      a[j] = temp;
    }
  }
  ```
  
* Counting Sort : O(n+k), stable sort. Not a comparison sort but assumes that range of numbers is upto a number __k__. 
  Auxillary storage O(k( for auxillary count array)+n (for final storage array)). 
  ```
  countSort(A,B,k)
    for j=0 to n-1
      C[A[j]] +=1
    
    for i=1 to k
      c[i] += c[i-1]
    
    for j = n-1 to 0
      B[C[A[j]]] = A[j]
      C[A[j]] -= 1
      
  ```
  
* Radix Sort : O(d*(n+k)), Fast & generic in nature & stable sort. 
  ```
  radixSort(a,d)
  for i  to d
    count-sort of digit i
  ```
  
---
__Note__
* Algorithms implementation will be added soon. 
* Merge, Quick and Heap Sort pending with fibonacci heap analysis.
