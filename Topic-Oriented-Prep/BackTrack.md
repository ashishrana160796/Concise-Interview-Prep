# BackTracking

Mainly Solutions in Java, all common backtracking problems are written here. General backtracking approach as follow.
It is used for basically constraint satisfaction problem. Backtracking is more of like DFS traversal, in pruning tree fashion.  
__General DFS Code__

```
6 things that a domain specific code must handle

root(P): return the partial candidate at the root of the search tree.
reject(P,c): return true only if the partial candidate c is not worth completing.
accept(P,c): return true if c is a solution of P, and false otherwise.
first(P,c): generate the first extension of candidate c.
next(P,s): generate the next alternative extension of a candidate, after the extension s.
output(P,c): use the solution c of P, as appropriate to the application.

procedure bt(c)
  if reject(P,c) then return
  if accept(P,c) then output(P,c)
  s ← first(P,c)
  while s ≠ Λ do
    bt(s)
    s ← next(P,s)

Reference: Wikipedia, Backtracking.
```

On the basis of above pseudocode. All other codes are mentioned below, follow these properties.

* __N-Queen Problem, All solutions print__
```
import java.util.*;
class NQueen {
  static boolean chk = false;
  // print function
  static void print(int[][] board,int n) {
    chk=true;
    int i=0,j=0;
    System.out.print("[");
    //(j,i) - pair , printing ith column
    while(j<n)
    {
        i=0;
        while(i<n)
        {
          if(board[i][j]==1)
            System.out.print(i+1+" ");
          i++;
        }
        j++;
    }
    System.out.print("] ");
  }
  static boolean safe(int[][] board,int col,int row,int n) {
    if(board[row][col]==1)
      return false;
    int i,j;
    for(i=0;i<col;i++)
      if(board[row][i]==1)
        return false;
    // upper diagonal check
    for(i=row,j=col;i>=0&&j>=0;i--,j--)
      if(board[i][j]==1)
        return false;
    // lower diagonal check
    for(i=row,j=col;i<n&&j>=0;i++,j--)
      if(board[i][j]==1)
        return false;
    return true;
  }
  static void solve(int[][] board,int col,int n) {
    if(col>=n)
    {
        print(board,n);
        return;
    }
    for(int i=0;i<n;i++)
    {
        if(safe(board,col,i,n))
        {
            board[i][col]=1;
            solve(board,col+1,n);
            board[i][col]=0;
        }
    }
  }
  public static void main (String[] args) {
	   Scanner s = new Scanner(System.in);
	   int T = s.nextInt();
	   int[][] b = new int[10][10];
  	 for(int x=0;x<T;x++)
	   {
	      int n = s.nextInt();
	      if(n==2 || n==3) {
	       System.out.println("-1");
	     }
	     else{     
	      solve(b,0,n);
	      System.out.println();
	      if(chk==false)
	          System.out.println("-1");
	     }
     }
   }
}
```
