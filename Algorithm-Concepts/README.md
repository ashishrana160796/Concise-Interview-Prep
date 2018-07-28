# Algorithm Concepts

---

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



---
