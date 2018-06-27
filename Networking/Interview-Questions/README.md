# Interview Questions

## Answers/Hints also in the end Of Questions

Q1 : Coding, Remove leading zeros from IP-address ?  
Q2 : Advantages & Disadvantages of OSI model ?  
Q3 : [What are MAC layer protocols ?](https://practice.geeksforgeeks.org/problems/mac-layer-protocols)  
Q4 : [Number of Subnets ?](https://practice.geeksforgeeks.org/problems/find-the-number-of-subnets)  
Q5 : [What happens when google.com is typed on web-browsers](https://practice.geeksforgeeks.org/problems/what-happens-when-anyone-type-googlecom-in-browser)  

---

```
* Only look at Answers after brainstorming a possible answer.
* Must compare quality of your answer to the ideal one.
* Have a better answer replace it with it your with a PR.
* Make flashcards of it accordingly.
```

---

## Answers/Hints for Interview Problemms

A1 : 
```
Java Way of Coding :

  String str = s.nextLine();
	String[] str1 = str.split("\\.");
	str = "";
	for(int i=0;i<str1.length;i++){
	  Integer Z = Integer.parseInt(str1[i]);
	  str1[i] = Z.toString();
	  str +=str1[i];
	  if(i!=str1.length-1)
	    str +=".";
	}
	System.out.println(str);
	 
```
A2 : Generic Model, connection-oriented & connectionless, More secure and adaptable. Disadvatage is it is not defined
for any particular protocol, duplication of layers, it having interdependence among layers( Vertical in  nature ).






