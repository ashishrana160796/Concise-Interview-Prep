# Puzzles

## Logical Puzzles

### Problems

* [21-wire puzzle, How many trips required to figure mapping b/w 21 wires & its labels](https://github.com/sharkdp/great-puzzles/blob/master/puzzles/21-wires/puzzle.md)
* [Two Pills Each Day Puzzle](https://www.interviewbit.com/problems/two-pills-each-day/)
* [Good Processor Problem](https://www.interviewbit.com/problems/good-processor/)
* [Genie & Magical Hats Problem](https://www.interviewbit.com/problems/genie-and-hats/)
* [Two Numbers Sum & Product Problem](https://www.interviewbit.com/problems/two-numbers/)
* [The Tribe Problem](https://www.interviewbit.com/problems/the-tribe/)
* [Daughters ages](https://www.interviewbit.com/problems/daughters-ages/)
* [Jelly Bean Jars](https://www.interviewbit.com/problems/jelly-beans-jars/)

### Solution

* [Well, Explained Solution](https://github.com/sharkdp/great-puzzles/blob/master/puzzles/21-wires/solution.md)
* Add one more pill of type A, & then cut 4 pills to 8 halfs and consume one-half today, than other half tommorow.
* [Well qurated solution](https://everything2.com/title/Good+and+bad+processors+solution)
* C days. As for c=1, person will see no one has the hat. Hence, he is having one.
  c=2, first night no one will go. Then they will realize 1 hat on other guy & one is with him. And so on for other days.
* First Statment: sum>2, Second Statement: number is not prime (Inferences by individual analysis).
  When combined minimum combination of (2,2) comes as (1,q) are eliminated by P.
* First Person(Truth Tribe) -> 2nd person, will say Lie Tribe -> 3rd person is truthful
  Second Person(Lie Tribe, will say truth tribe) ->  2nd person, will say Lie Tribe -> 3rd person is again truthful.
* Consider following equations first, 3 * 3 * 8 = 72 then summation,  
  2 + 6 + 6 = 14
  3 + 3 + 8 = 14, rest of the sums are unique for all possible combinations. Hence, second one as only oldest girl is there only.
* Trick is every jar is mislabelled. Hence, pick the one with label mixed on it as that jar will contain some kind of jelly in pure amount. From, that jelly type in mind combined with information of mislabelled jars. All jars can be found out about. Hence, one jelly from mixed jar labelled is needed to be picked.

Referenced Site : First 8 Problems & Solutions are taken from [interviewbit](https://www.interviewbit.com/puzzles/) from where these puzzles can be solved.

---

## Geometry

### Problems

* Consider a rectangular cake with a rectangular section (of any size or orientation) removed from it. Is it possible to divide the cake exactly in half with only one cut ?
* Break a cholocate into single pieces which are integration of nxm pieces.
* With 3 toothpicks a equilateral triangle can be created. Need to add three more equilateral triangles, same size.
* Disk is painted half black & white. Rotated with constant speed, determining the direction of rotation. Minimum numbers of camera required ?
* Six different colors that you can paint each side of the cube. How many different cubes can you make? Different rotated alignments doesn't count.
* 3 Ants at 3 corners, What is the probability that they don't collide ?
* 12 balls, 1-defective ball, two way balance. How many turns required to find which one is defective ?
* 8 balls, 1-defective ball, two way balance. How many turns required to find which one is defective ?
* 4 cats at 4 corners, each chasing one another in such a way that they keep on changing direction towards another cat. Speed is constant, at what time they will catch one another ? 
* You’ve got someone working for you for seven days and a gold bar to pay him. The gold bar is segmented into seven connected pieces. You must give them a piece of gold at the end of every day. What are the fewest number of cuts to the bar of gold that will allow you to pay him 1/7th each day?

### Solutions

* Line cutting a rectangle in half passes through its center. A line passing through the center of two rectangles will divide the rectangle in two different parts.
* n*m-1 (Sufficient number of pieces).
* A pyramid structure like tetrahedron is the solution.
* Take one camera, rotate it with disk. If color of strips will change in both direction. But, in while in rotating in opposite direction to disk it will happen way faster.
* Fix top & bottom color-5 options. 4 sides left, (4-1)!=6, circular arragement. Hence, 5*6=30.
* Each ant can go in 2 directions. Therefore, 2^3 possibilites. Hence, 2(all clock or anti-clockwise)/8 not colliding.
* 3 turns, first divide into two->heavior side have the defective ball. this six ball group divided into two->heavior side with defective ball. Weigh two balls if equal then third one kept out is heavior one. Otherwise, any of the two is heavior one.
* 2 turns. Divide into groups of 3,3,2 & than compare groups of 3,3. Rest of steps are simple.
* Each dog moves perpendicular to another dog. Realtive speed of the dog1 (v1), w.r.t dog 2, it changes perpendicularly. T = l(side)/v(dog).
* Make 2 cuts such that bar is divided into 1/7, 2/7 & 3/7 as pieces. Analysis for complete week can be done. Like, Day 3: You: 4, Worker: 1 and 2 &  Day 5: You: 2, Worker: 1 and 4.

Referenced Site : First 10 Problems & Solutions are taken from [interviewbit](https://www.interviewbit.com/puzzles/) from where these puzzles can be solved.

---

## Games

### Problems

* Two player game, takes turn placing coin on a table having unspecified diameter. Which Player has stratergy to win ?
* 3-switches in OFF position are there. When upstairs, you cannot access the switches. What is the minimum number of times you need to go upstairs to determine the switch for each bulb?
* Alice & Bob in seperate island with Alice having medicine and Bob needing them. Eve can only transport it via a boat but will steal anything that is inside the chest when open. Alice & Bob have locks & keys. Minimum number of trips needed for delivering. boat going from Alice to Bob or Bob to Alice counts as 1 trip.  
* N number of times fliping is allowed. Can these be divided into 2 piles coins with equal number of heads up.

### Solutions

* Player 1, as except placing coin at center, every coin placed is having counter point in table for a given chance.
* Switch One bulb on for quite some time. Then turn it off, & then switch another one ON. The 'ON' bulb is for switch 2, for switch 1 'OFF' & warm bulb & for switch 2 'OFF' & cold bulb is there.
* Multiple locks can be added to chest(Hint).  
  Trip 1: medicine in chest & lock it, Alice. Trip 2: Locked by Bob, sent to Alice. Trip 3: lock removed by Alice, & sent to Bob. 
* Divide into two groups first. Keep on tossing one group until it becomes equal to second one.

Referenced Site : First Four Problems & Solutions are taken from [interviewbit](https://www.interviewbit.com/puzzles/) from where these puzzles can be solved.

---

## Physics Section 

In this section top 10 Martin Gardner Physics Stumper are asked & Solved in the end in reference to following [link](http://www.martin-gardner.org/Top10MGPhysics.html).  
This page contains only questions. These problems can be tried all at once in start time. This Section contain solution approaches to it.

---
### Solutions

* Reflection in the mirror flip horizontally because we flip it horizontally & than analyze the situation.
  Like when reading a word, we are looking onto it. But, when reading from mirror we are from reflection of image which is flipped.
  Mirror flips in __z direction, i.e. forward becomes backword.__

* Metal with expand in all direction in volume basis, hole size will decrease. (Delta)V/V = (Gamma)*(Delta)T.

* Colliding missile problem, convert speed into minutes per hour after adding their speeds. As, two missiles approaching each other can equally be treated like going away from one another.

* Magnet Testing Problem: Take, let say bar A & put it in b/w center of bar B. Magnetic Force is minimum at center & maximum at poles. If, bar get's lifted than bar A is magnet, strongest force or vice-versa scenario.

* Water level stays same. As, ice-cube is expanded with crystalization process, after melting the volume of cube remains the same.

* Water level goes down. As boat rises with falling cargo the volume displacement of water by this boat goes down & it water level goes down. Shape of boat places a vital role in displacement of water.

* No, not in a air tight container. As, these birds would push down the container with same Gravitational Force as before while flying.

* Helium is lighter than atmospheric air. Hence, it will move forward when breaks applied & will move in the direction of curve i.e. in inwards direction.

* Hollow Moon: For bodies near the edge of shell, will gets pulled towards the shell. Take small mass _dm_ & calculated force exerted by it on the object, after that integrate it for all mass components. This will lead to a resultant force directing towards the shell's mass instead of center.

* Simple center of mass problem. Let the can be filled upto an height 'y' < h/2 & create a function equation from center of mass equation, than calculate derivative to evaluate the result.
