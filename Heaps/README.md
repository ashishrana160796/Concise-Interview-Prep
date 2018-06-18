# Heaps Implementation

## Min/Max-Heap, Binomial Heap, Fibonacci Heap

Deep Exploration of Heap Data-Structure in details with implementations of Binomial Heap and Fibonacci Heap.  

---

* Binary Heap basics : Complete tree(all levels except last are full, and last is full from left to right), suitable for storing in an array. Representation of binary heap is in a level-order manner in an array of numbers.  
  A[0] : root  
  A[(i-1)/2] : parent node  
  A[2*i+1] : left node  
  A[2*i+2] : right node  
  Elements greater then A(floor(n/2)+1 ... n) are leaves  

* Methods/Functions implemented on Heaps  
  Max-Heapify :  O(logn)  
  Build-Max-Heap: O(n), establishing a tight upper bound T(n)=Sigma(n*h) => Sigma(2^i*(h-i)) => O(n)  
  HeapSort : O(n*logn)   
  Max-Heap-Insert :  O(logn)   
  Heap-Extract-Max : O(logn)  
  Heap-Increase-Key : O(logn)     
  Heap-Maximum : O(1)  
  
  Implemented code in [BinaryHeap.java](Heap-Algorithms/BinaryHeap.java).  
  
* Applications Questions related to  Heaps  
  * Priority Queue Implementation, Dijkastra & Prim uses Heap data structure.
  * K-ary Heaps
  * Kth largest & smallest element in an array.
  * Connect n-ropes with minimum cost.
  * Binary Heap vs BST for priority queue.
  * min-Heap to max-Heap and vice-versa.
  
---

* Binomial Heap explanation : It provides faster merge operations as compared to binary heaps. It is collection of Binomial Tree.  
  
  Binomial Tree :  
  
  A Binomial Tree of order 0 has 1 node. A Binomial Tree of order k can be constructed by taking two binomial trees of order k-1 and making one as leftmost child or other.  
  * It has exactly 2k nodes.  
  * It has depth as k.  
  * There are exactly kCi nodes at depth i for i = 0, 1, . . . , k.  
  * The root has degree k and children of root are themselves Binomial Trees with order k-1, k-2,.. 0 from left to right.  
  
  #### Binary Representation : 
  
  A Binomial Heap with n nodes has the number of Binomial Trees equal to the number of set bits in the Binary representation of n. For example let n be 13, there 3 set bits in the binary representation of n (00001101), hence 3 Binomial Trees. We can also relate the degree of these Binomial Trees with positions of set bits. With this relation, we can conclude that there are O(Logn) Binomial Trees in a Binomial Heap with ‘n’ nodes.  

  Implemented merging code in [BinaryHeap.java](Heap-Algorithms/BinomialHeap.java).  
  Except merge other operations have same time complexity as binary heap.  
  
---

* Finonacci Heap : In fibonacci heap trees can have any shape, even single node shape for all trees. Each tree is having min/max heap properties  
  * Find-Min(O(1)), Delete-Min(O(logn)) same as in binary & binomial heap.  
  * Insert : Θ(1) [Θ(Log n) in Binary and Θ(1) in Binomial]  
  * Decrease-Key : Θ(1) [Θ(Log n) in both Binary and Binomial]  
  * Merge : Θ(1) [Θ(m Log n) or Θ(m+n) in Binary and Θ(Log n) in Binomial] 
  * Extract minimum is a complicated operation, others use lazy approach & simply add/merge to rest structure without any alteration.
  
  Implemented merging code in [BinaryHeap.java](Heap-Algorithms/FibonacciHeap.java).  

  It maintains a pointer to min element. All roots are connected with double linked list.  
---

#### References  

* [Binomial Heap](https://www.geeksforgeeks.org/binomial-heap-2/)  
* [Fibonacci Heap](https://www.geeksforgeeks.org/fibonacci-heap-set-1-introduction/)  
