# Algorithm Concepts & Data Structures

Algorithmically important concepts & questions related to it, plus the variations which will be beneficial to remember. Keep such concepts in cache of your brain to solve questions at high speed. As almost all the questions in the company interviews are repeated.  

---

### Recursion

* __All permutations of a string__ print , also lexicographically sort them.
  ```
  //    Sort the characters of string with ASCII value & then print All permutations
  
  // Recursive Implementation
     
  //   perm(str,0,n-1);
     
  private void permute(String str, int l, int r){
        if (l == r)
            System.out.println(str);
        else
        {
            for (int i = l; i <= r; i++)
            {
                str = swap(str,l,i);
                permute(str, l+1, r);
                str = swap(str,l,i);
            }
        }
    }
     
  // Iterative Implementation
     
     public static void perm(String par){
     	permHelp(par);
     }
  
     public static void permH(String app, String wor){
         if(wor.length()==0)
             System.out.println(app+wor);
         else{
             for(int i=0;i<wor.length;i++){
                 permH(app+wor.charAt(i), wor.substring(0, i)+wor.substring(i+1, wor.length()));
             }
         }    
     }
  
  ```

* __Maximum Path Sum in Matrix__ with variation of recursive/dp, with obstacle also.
  ```
  // Recursive implementation
  public static int computePaths(int n){
    return recursive(n, 0, 0);
  }
  public static int recursive(int n, int i, int j){
    if( i == n-1 || j == n-1 ){
        //reach either border, only one path
        return 1;
    }
    return recursive(n, i + 1, j) + recursive(n, i, j + 1);
  }
  
  // Mathematically it is (M+N)__C__(N) OR (M+N)__C__(M).
  
  // Dp w/o obstacles
  
  static int numberOfPaths(int m, int n)
    {
        int count[][] = new int[m][n];
        for (int i = 0; i < m; i++)
            count[i][0] = 1;
        for (int j = 0; j < n; j++)
            count[0][j] = 1;
  
        for (int i = 1; i < m; i++)
        {
            for (int j = 1; j < n; j++)
                count[i][j] = count[i-1][j] + count[i][j-1]; //+ count[i-1][j-1]; if diagonals are also there.
        }
        return count[m-1][n-1];
    }
  
  // Blocked digits are also there, present.
  // for first row and first column there is only one way 
  // to reach the current cell i.e from previous cell
  for(i=1;i<n;i++)
      if(!blocked[i][0])
          path[i][0]=path[i-1][0];
  for(i=1;i<m;i++)
      if(!blocked[0][i])
          path[0][i]=path[0][i-1];
    
  //for all other cells there are two ways to reach the 
  //current cell
  for(i=1;i<n;i++)
      for(j=1;j<m;j++)
          if(!blocked[i][j])
              path[i][j] = (path[i-1][j]+path[i][j-1]);
  print path[n-1][m-1]
  
  ```

* __Josephus Problem__
  
  ```
  // n-people are there, kth person-getting killed. Pick a safe position & stay the last one alive.
  josephus(n, k)
      if (n == 1)
          return 1;
      return (josephus(n - 1, k) + k-1) % n + 1;
  ```

* __Recursive Adjacent Duplicates__
  ```
    // Schemial Painter's Algorithm
    public static void check(String str)
     {
         if(str.length()<=1)   // length related check
         {
             System.out.println(str);
             return;
         }
         String n="";
         int count=0;
         for(int i=0;i<str.length();i++)
         {
             while(i<str.length()-1 && str.charAt(i)==str.charAt(i+1))
             {
                 if(i<str.length()-2 &&str.charAt(i)!=str.charAt(i+2))    // double skip & single skip condition
                 i+=2;
                 else
                 i++;
                 count++;
             }
             // append conditions -- to this problem
             if(i!=str.length()-1)
             n=n+str.charAt(i);
             else
             {if(i==str.length()-1 && str.charAt(i)!=str.charAt(i-1))
                 n=n+str.charAt(i);
             }
         }
         if(count>0)
         check(n);
         else
         System.out.println(n);
     }
  ```

---

## HashMap

* __Get maximum value out of a HasMap's value with key in lexicographically sorted order__
```
int maxValueInMap = 0;
        String winner = "";
        Map.Entry<String,Integer> entry;  // don't declare a direct HashMap object
        for (entry : map.entrySet())
        {
            String key  = entry.getKey();
            Integer val = entry.getValue();
            if (val > maxValueInMap)
            {
                maxValueInMap = val;
                winner = key;
            }
 
            // If there is a tie, pick lexicographically
            // smaller. 
            else if (val == maxValueInMap &&
                winner.compareTo(key) > 0) // winner > key, lexicographically
                winner = key;
        }
```

* __Largest Sub-Array With Sum 0__

```
// iterate over all sub-arrays, for (i=0 to n-1){ for (j=i to n-1){ sum == 0 check} }
// HashMap approach : O(n) approach
// Create prefix array sum, if prefix sum repeats or becomes zero, sub-array with zero sum exists.
static int maxLen(int arr[]) {
        HashMap<Integer, Integer> hM = new HashMap<Integer, Integer>();
        int sum = 0;      // Initialize sum of elements
        int max_len = 0;  // Initialize result
        for (int i = 0; i < arr.length; i++)
        {
            sum += arr[i];
            if (arr[i] == 0 && max_len == 0)
                max_len = 1;
            if (sum == 0)
                max_len = i+1;
 
            // Look this sum in hash table
            Integer prev_i = hM.get(sum);
 
            // If this sum is seen before, then update max_len
            // if required
            if (prev_i != null)
               max_len = Math.max(max_len, i-prev_i);
            else  // Else put this sum in hash table
               hM.put(sum, i);
        }
 
        return max_len;
    }


```

* __Number of pairs of substrings of the string which are anagrams of each other.__

```
  int tcount = 0;
  HashMap<String, Integer> hm = new HashMap<>();
  for(int i=0;i<s.length();i++){ 
    for(int j=i+1;j<=s.length();j++){
      String str = s.substring(i,j);
      char[] ch = str.toCharArray();
      Arrays.sort(ch);
      str = String.valueOf(ch);
      if(hm.containsKey(str)) 
        {
          int value = hm.get(str);
          tcount=tcount+value;
          hm.put(str, value+1);
        } 
      else 
        hm.put(str, 1);
    }
  }
  return tcount;
```

* __Check if one sentance can be constructed with words of another-case sensitivity handle__

```
// add words in respective hashmap's with increment of count policy upon duplicacy.
boolean b = false;
  for (Map.Entry<String, Integer> entry : noteMap.entrySet())
  {
    if(magazineMap.containsKey(entry.getKey()))
      {
         String s = entry.getKey();
         if(magazineMap.get(s)>=entry.getValue())
           b = true;
           else
           {
             b = false;
             break;
           }
      }
return b;
```

* __Count Geometric triplets in an array, part i<j<k__

```
long cnt = 0;
        // map1 is for keeping count of numbers encountered
        Map<Long, Long> map = new HashMap<>();
        // map2 is for keeping track of previous encountered numbers,
        //previous triplet count associated
        Map<Long, Long> rMap = new HashMap<>();
        for (long n : arr) {
            if (n % r == 0) {
                long pre = n / r;
                Long cnt2 = rMap.get(pre);
                // previous value recalled & added
                if (cnt2 != null) cnt += cnt2;
                // privous g.m recalled & stored
                Long cnt1 = map.get(pre);
                if (cnt1 != null) rMap.put(n, rMap.getOrDefault(n, 0L) + cnt1);
            }
            map.put(n, map.getOrDefault(n, 0L) + 1);
        }
        return cnt;
```

---

## Arrays, String & Search

* __Kadane's Algorithm__:

```
Initialize:
    max_so_far = 0
    max_ending_here = 0
Loop for each element of the array
  (a) max_ending_here = max_ending_here + a[i]
  (b) if(max_so_far < max_ending_here)
            max_so_far = max_ending_here
  (c) if(max_ending_here < 0)
            max_ending_here = 0
return max_so_far

DP Solution:

int max_so_far = a[0];
int curr_max = a[0];
for (int i = 1; i < size; i++)
  {
     curr_max = Math.max(a[i], curr_max+a[i]);
     max_so_far = Math.max(max_so_far, curr_max);
  }
return max_so_far;
```

* __Minimum Swaps to Sort Array in ascending order, unique elements__

```
int count = 0;
for (int i = 0; i < arr.length;) {
  if (arr[i] == (i + 1) || arr[i] >= arr.length) {
      i++;
      continue;
  }
  int tmp = arr[i];
  arr[i] = arr[tmp - 1];
  arr[tmp - 1] = tmp;
  count++;
}    
return count;
```

* __Left & Right Rotation In An Array__

```
for(int i=0;i<n;i++)  // b, be new rotated array
  b[i] = a[((i+n-k)%n)]; // right rotation

for(int i=0;i<n;i++)  // b, be new rotated array
  b[i] = a[((i+n-k)%n)]; // right rotation
```

* __Array Manipulation, (a,b,k): add k b/w these indices(included)__

```
//"difference array": The entry arr[i]=k indicates that arr[i] is exactly k units larger than arr[i-1]
long[] arr = new long[n];

int lower;
int upper;
long sum;
for(int i=0;i<m;i++){
    lower=scan.nextInt();
    upper=scan.nextInt();
    sum=scan.nextInt();
    arr[lower-1]+=sum;
    if(upper<n) arr[upper]-=sum; 
}
        
long max=0;
long temp=0;
// Basically, slope like structures are created, upon summation.
for(int i=0;i<n;i++){
    temp += arr[i];
    if(temp> max) max=temp;
}
```

* __Number of Palindromic Substrings__

```
// initialize counter to n because each character is a
// palindromic string
int counter = n;
// to count consecutive characters that are the same
int consec = 1;
// the middle index of a 3-character symmetry,
// assigned only once detected
int midIndex = -1;
// compare with previous character so start with i=1
for (int i = 1; i < n; i++) {
  if (s.charAt(i) == s.charAt(i-1)) {
  // Condition 1: All of the characters are the same
  // For n consecutive characters that are the same,
  // we have this formula:
  // Number of palindromic strings =
  //     (n-1) + (n-2) + ... + (n-(n-1))
  counter += consec;
  consec++;
  // Condition 2: All characters except the middle one
  // are the same
    if (midIndex > 0) {
    // check for symmetry on both sides
    // of the midIndex
    if ((midIndex-consec) >= 0 && s.charAt(midIndex-consec) == s.charAt(i)) {
      counter++;
    } else {
      // no more possibility of palindromic string
      // with this midIndex
      midIndex = -1; 
      }
    }
  } else {
  // reset consecutive chars counter to 1
   consec = 1;
   // check for a 3-character symmetry
   if (((i-2) >= 0) && s.charAt(i-2) == s.charAt(i)) {
     counter++; // 3-char symmetry is detected
     // to check if the next characters are the same
     // and symmetrical along the midIndex
     midIndex = i-1;
   } else {
      midIndex = -1;
   }
 }
}
return counter;
```

---

## Bit Manipulation

* __Few instant java functons for string manipulation__
```
Integer.toBinaryString(i) // to convert to binary string
Integer.bitCount(i) // count number of ones in Binary String
Integer.parseInt("1001", 2); // binary, hex, oct string can be converted into base-10 int value
```

* __Find first set bit from right__
```
// Normal way 
while ((n & m) == 0)
    {
 
        // left shift
        m = m << 1;
        position++;
    }
    return position

// Ninja Way
return (int)((Math.log10(n & -n)) / Math.log10(2)) + 1; // take two's complement, take log2 & add 1 to get the position
```

* __Total number of set bits in a number__
```
// Counting Approach O(log(n))
while (n > 0)
        {
            count += n & 1;
            n >>= 1;
        }
        return count

// Sofisticated Algorithm,
while (n > 0)
        {
            n &= (n - 1) ;
            count++;
        }
        return count

// C++, gcc direct count with lookup table it can be done: __builtin_popcount (4)
```

* __Count total numbers of bits__
```
// Complexity of best solution is O(k*n), k = 64 bits
int i=0;
int ans=0;
while((1<<i)<=n){  // 2^i less than equal to n
  boolean k = false; // flip counter
  int chng = 1<<i;  // 2^i flips to 1
  for(int j=0;j<n;j++){
    if(k==true)
      ans++;
    if (change == 1) {
      // When change = 1 flip the bit
      k = !k; 
      // again set change to 2^i
      change = 1 << i; 
    }
    else {
      change--;
    }
  }
  // increment the position
  i++;
}
return ans;
```

* __Toggle bits in given range__
```
num = (((1<<r)-1)^((1<<(l-1))-1))
n=n^num
```

* __Kth bit is set or not__
```
--> (n & (1 << (k - 1))) >= 1  // left shift approach
--> (n >> (k - 1)) & 1 // right shift approach
```

* __Right-Most different bit b/w two numbers m & n__
```
--> (int)(Math.log10((m^n)&-(m^n))/Math.log10(2))+1
```

* __Sparse number, with two consecutive ones counted as non-sparse__
```
---> (n & (n>>1)) >=1 then return 0, else return 1
```

* __Missing numbers in an array:__ ` XOR sum of all numbers till n & XOR sum of all in missing array, then XOR the resultant `

---

## Dynamic Programming Problems

* __0/1 Knapsack Problem, Main Logic:__
```
if(j<w[i])
{
  T[i][j]=T[i-1][j]
}
else
{
  T[i][j]=Max(val[i]+T[i-1][j-w[i]], T[i-1][j])
}
```

* __Longest common subsequence problem:__
```
int lcs( char[] X, char[] Y, int m, int n )
  {
    if (m == 0 || n == 0)
      return 0;
    if (X[m-1] == Y[n-1])
      return 1 + lcs(X, Y, m-1, n-1);
    else
      return max(lcs(X, Y, m, n-1), lcs(X, Y, m-1, n));
  }

// dp solution algorithm logic

if(m[i]==n[j])
  T[i][j]=T[i-1][j-1]+1
else
  T[i][j]= max(T[i-1][j], T[i][j-1])
```

* __Matrix Multiplication Maximization:__
```
// Construction of maximum matrix multiplication, bottom up
// Upper triangular matrix
T[i][j]=min{T[i][k]+T[k+1][j]+(val[i]first * val[k]second * val[j]second )}
```

* __Subset Sum Problem__
```
// Main Algorithmic Logic
if(j<num[i])
  T[i][j]=T[i-1][j]
else
  T[i][j]=T[i-1][j] || T[i-1][j-input[i]]
```

---

## Maths & Puzzles

* __Sieve Of Eratosthenes: Find primes upto 'n' number__

```
boolean[] numPrime(int max){
  int[] flag = new int[max+1];
  int count=0;
  init(flag)  // set all flags either to 0 or 1
  int prime = 2;
  
  while(prime<=Math.sqrt(max)){
    crossOff(flag, prime);
    nextPrime(flag, prime);
    count++;  // for counting the number of primes
  }
  return flag;
}

void crossOff(boolean[] flag, int prime){
  // prime number, mulipliers are crossed off.
  for(int i=prime*prime;i<flag.length;i+=prime)
    flag[i] = false;
}

int nextPrime(boolean[] flag, int prime){
  int next=prime+1;
  while(next<flag.length && !flag[next])
    next++;
  return next;
}

// Optimize it with using only odd numbers in this array-space.
```

__Greedy Algorithms__

* __Huffman Coding: Print Coding Values__

```
class HuffmanNode{
  int data;
  char c;  // type of node, internal or regular
  HuffmanNode l;
  HuffmanNode r;
}
// Comparator interface implementation, for data comparison
class MyComparator implements Comparator<HuffmanNode> {
    public int compare(HuffmanNode x, HuffmanNode y)
    {
 
        return x.data - y.data;  // ascending order comparison
    }
}
public class Huffman{
public static void printCode(HuffmanNode root, String s) {
 // leaf node, to be printed only, not the internal ones
   if (root.left == null && root.right == null && Character.isLetter(root.c)) {
     // c is the character in the node
     System.out.println(root.c + ":" + s);
     return;
   }
   printCode(root.left, s + "0");
   printCode(root.right, s + "1");
 }
// main function
public static void main(String[] args) {
   Scanner s = new Scanner(System.in);
   int n = 6;
   char[] charArray = { 'a', 'b', 'c', 'd', 'e', 'f' };
   int[] charfreq = { 5, 9, 12, 13, 16, 45 };
   // makes a min-priority queue(min-heap).
   PriorityQueue<HuffmanNode> q = new PriorityQueue<HuffmanNode>(n, new MyComparator());
   for (int i = 0; i < n; i++) {
     // creating a huffman node object
     // and adding it to the priority-queue.
     HuffmanNode hn = new HuffmanNode();
     hn.c = charArray[i];
     hn.data = charfreq[i];
     hn.left = null;
     hn.right = null;
     // the huffman node to the queue added.
     q.add(hn);
   }
   // create a root node
   HuffmanNode root = null;
   // Here we will extract the two minimum value
   // from the heap each time until
   // its size reduces to 1, extract until
   // all the nodes are extracted.
    while (q.size() > 1) {
      // first min extract.
      HuffmanNode x = q.peek();
      q.poll();
      // second min extarct.
      HuffmanNode y = q.peek();
      q.poll();
      // new node f which is equal
      HuffmanNode f = new HuffmanNode();
      // to the sum of the frequency of the two nodes
      // assigning values to the f node.
      f.data = x.data + y.data;
      f.c = '-';
      // first extracted node as left child.
      f.left = x;
      // second extracted node as the right child.
      f.right = y;
      // marking the f node as the root node.
      root = f;
      // add this node to the priority-queue.
      q.add(f);
   }
   // print the codes by traversing the tree
   printCode(root, "");
  }
}
```

* __Activity Selection Problem__

```
greedySelector(int s[], int f[], int n)  // Sorted according to earliest finishing time in activities.
{
    int i, j;
    // The first activity always gets selected
    i = 0;
    System.out.print(i+" ");
    // Consider rest of the activities
    for (j = 1; j < n; j++)
    {
         // If this activity has start time greater than or
         // equal to the finish time of previously selected
         // activity, then select it
         if (s[j] >= f[i])
         {
              System.out.print(j+" ");
              i = j;
          }
     }
    }
```

* __Fractional Knapsack__

```
// Summation(x) <= W
// Summation(b(x/w)), maximize
for each item i E S do
  xi <- 0
  vi <- bi/wi // value per unit
w<-0
while w<W do
  a<-min(wi, W-wi) // W-wi, might cause an overflow
  xi<-a
  w<-w+a
```
