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

---
