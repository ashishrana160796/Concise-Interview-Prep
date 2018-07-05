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
* Merge Sort : Worst & Average Case Complexity O(nlogn), in-place & out-place both implementations exist, divide & conquer algorithm and can be parallelized, stable sorting algorithm.  
  
  Complexity Analysis T(n):  
  Divide : O(1)  
  Conquer : 2*T(n/2), into two sub-problems.  
  Combine : O(n), merging elements.  
  T(n) = 2T(n/2) + O(n) if n > 1  
  Using Master Th. Case 2.  
  T(n) = O(nlogn)  
  
  Algorithm :  
  ```
  mergeSort(A,p,r)  // like in dfs it goes in-depth
  if p < r
    then q <- floor((p+r)/2)
      mergeSort(A,p,q)
      mergeSort(A,q+1,r)
      merge(A,p,q,r)
  
  merge(A,p,q,r)
  n1 <- q-p+1
  n2 <- r-q
  
  int L[] = new int[n1];
  int R[] = new int[n2];
  
  for(int i=0;i<n1;i++)
    L[i] = a[p+i];
  
  for(int i=0;i<n2;i++)
    R[i] = a[r+1+i];
  
  i,j <- 0
  
  // Initial index of merged subarry array
  
  int k = l; // Important assignment - k must be lowe limit of array initiated
  while (i < n1 && j < n2)
    if (L[i] <= R[j])
      arr[k] = L[i];
      i++;
    else
      arr[k] = R[j];
      j++;
    k++;
 
   /* Copy remaining elements of L[] if any */
   while (i < n1)
    arr[k] = L[i];
    i++;
    k++;
    
   /* Copy remaining elements of R[] if any */
   while (j < n2)
    arr[k] = R[j];
    j++;
    k++;
    
  ```

* Quick Sort : Not a stable sort but in-place sort, Naive implmentation average case O(nlogn) & worst case(n^2). 
  Partition method : rearranges the array such that a[left] <= a[right] and return pivot index element.  
  
  Complexity Analysis :  
  Worst Case : T(n) = T(n-1) + O(n) => T(n) = O(n^2)  
  Best Case : T(n) = 2*T(n/2) + O(n) => T(n) = O(n*logn)  
  
  Two Solution to avoid worst case :  
  * Randomize input array.  
  * Pick random pivot element.  
  
  Algorithm :
  ```
  quickSort(A,p,r)
    if(p<r)
      q = parition(A,p,r)
      quickSort(A,p,q)
      quickSort(A,q+1,r)
  
  
  parition(A,p,r)
  x <- A[r]
  i <- p-1
  for j<-p to r-1
    if A[j] <= A[x]
      i++
      swap A[i] <=> A[j]
  swap A[i] <=> A[r]
  return i+1
  ```
  
---
Heap Sort: Not a stable sort. Complexity O(nlogn)(Best and Worst both)

1. Build a max heap from the input data.
2. At this point, the largest item is stored at the root of the heap. Replace it with the last item of the heap followed by reducing the size of heap by 1. Finally, heapify the root of tree.
3. Repeat above steps while size of heap is greater than 1.

```
void heapify(int A[], int n, int i)
{
    int largest = i;  
    int l = 2*i + 1;  // left child
    int r = 2*i + 2;  // right child
    
    if (l < n && A[l] > arr[largest])
        largest = l;
 
    if (r < n && A[r] > arr[largest])
        largest = r;
        
    if (largest != i)
    {
        swap(A[i], A[largest]);
 
        // Recursively heapify the affected sub-tree
        heapify(arr, n, largest);
    }
}
void heapSort(int A[], int n)
{
    for (int i = n / 2 - 1; i >= 0; i--)
        heapify(A, n, i);
    for (int i=n-1; i>=0; i--)
    {
        swap(A[0], A[i]);
        heapify(A, i, 0);
    }
}
```
## Implemented Sorting Codes

* [Cocktail Sort](Sorting-Algorithms/CocktailSort.java)
