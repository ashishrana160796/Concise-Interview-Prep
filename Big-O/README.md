# Big-O Analysis

#### Big-O is equivalent to Big-Theta in general interview terms


---

* Firstly, study upper-bound(Big-O), lower-bound(Big-Omega) & Intersection Concept( Big-Theta).
* Time Complexity Order : O(x^x) > O(2^x*x!) > O(x!) > O(2^x) > O(x^2) > O(xlogx) > O(x) > O(logx).
* Amortized Analysis : total expense per operation evaluated for sequence of steps.
* Ignore constants & non-dominant terms.
* Binary Search performs better then ternary search (O(log2n) vs O(log3n)).
* Recursive Runtimes : This can be solved with general formula, branches^depth. 

---

#### Solving way : Perform algorithm stepwise, count number of iterations for each step. Become the "compiler", generalize pattern for complexity evaluation.

#### Note : loop - O(n), nested loop - O(n^|nested loop|), log vs divide complexity, branch^depth. These are good for easy small generalizations only. Avoid them standalone complexity numericals.

---

### Concepts & Questions


#### Concepts

* O(N+M) : If no relation between them is given then no term can be ignored.
* Avoid shallow analysis with crammed complexity for various flows in programming. Iterative calculation approach is best for solution.

#### Questions

* Tree Basics : Complexity calculation, see how much work is done by this recursive function.
```
int sum(Node n){
  if(node == null)
    return 0;
  return sum(n.left) + n.value + sum(n.right);  
}
```

* Permutations of a String 
```
void perm(String s){
  perm(s,"");
}

void perm(String s, String pre){
  if(s.length() == 0)
    System.out.println(pre);
  else{
    for(int i=0;i<s.length();i++){
      String rem = s.substring(0,i)+s.substring(i+1);
      perm(rem, pre+s.charAt(i));
    }   
  }
}
```

* Count the digits
```
int digCount(int n){
  int count = 0;
  while(n>0){
    count++;
    n/=10;
  }
  return count;
}
```

---
#### Hints

* Each node is touched only once. With total of n nodes present.
* Total Complexity : Total Permutations * Time to print one * Time for iterative loop.

---

#### Online Practice links

* Nested Loops : [Calculate the exact iterations](https://www.interviewbit.com/problems/nestedcmpl2/)
* Nested Loops : [Iterative Analysis Needed](https://www.interviewbit.com/problems/nestedcmpl3/)
* Loop Comparisons : [Multiplicative Iteration Analysis](https://www.interviewbit.com/problems/loopcmpl2/)
* Euclids GCD : [Swap & Subtract Logic Complexity](https://www.interviewbit.com/problems/loopcmpl2/)
* Find Minimum Path : [Non-DP approach](https://www.interviewbit.com/problems/reccmpl2/)
* Find Minimum Path : [DP approach](https://www.interviewbit.com/problems/reccmpl3/)
* Amortized Analysis : [Multiple Case Scenario](https://www.interviewbit.com/problems/amortized1/)
