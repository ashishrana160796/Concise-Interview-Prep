## SQL Queries

* SELECT statements are used to fetch data from a database. Every query will begin with SELECT.  
  Generic: SELECT column_name/s FROM table_name

* Using Column Aliases:  
  SELECT last_name AS name, commission_pct comm FROM employees;  -- AS keyword
  SELECT last_name "Name", salary*12 "Annual Salary" FROM employees;  -- Double quotes format

* Concatenation Operator(||):  
  SELECT last_name||job_id AS "Employees" FROM employees;  
  Using Literals:  
  SELECT last_name ||' is a '||job_id AS "Employee Details" FROM employees;  

* DISTINCT keyword: unique values are returned,  
  SELECT DISTINCT column_name FROM table_name;
  
* DESCRIBE:Describe table structure,  
  DESCRIBE tablename  
  
* WHERE: It indicates you want to filter the result set to include only rows where the following condition is true.  
  SELECT employee_id, last_name, job_id, department_id FROM employees WHERE department_id = 90 ;  
  SELECT last_name, job_id, department_id FROM employees WHERE last_name = 'Whalen';  

* OPERATORS and their meaning :  
```
Operator  Meaning

=           Equal to
>           Greater than
>=          Greater than or equal to
<           Less than
<=          Less than or equal to
<>          Not equal to
BETWEEN     Between two values (inclusive),
IN(set)     Match any of a list of values
LIKE        Match a character pattern
IS NULL     Is a null value
AND         Returns TRUE if both component conditions are true
OR          Returns TRUE if either component condition is true
NOT         Returns TRUE if the following condition is false
```
  Examples :  
  SELECT last_name, salary FROM employees WHERE salary BETWEEN 2500 AND 3500;  
  SELECT employee_id, last_name, salary, manager_id FROM employees WHERE manager_id IN (100, 101, 201);  

* __LIKE__: LIKE condition to perform wildcard searches of valid search string values. Search conditions can contain either literal characters or numbers:  
  – % denotes zero or many characters.  
  – _ denotes one character.  
  Examples :  
  SELECT first_name FROM employees WHERE first_name LIKE 'S%';  
  SELECT last_name FROM employees WHERE last_name LIKE '_o%';  
  
* __IS NULL__: Example, SELECT last_name, manager_id FROM employees WHERE manager_id IS NULL;

* Rules of Precedence, Order Evaluation for Operators  
``` 
 1 Arithmetic operators
 2 Concatenation operator
 3 Comparison conditions
 4 IS [NOT] NULL, LIKE, [NOT] IN
 5 [NOT] BETWEEN
 6 NOT logical condition
 7 AND logical condition
 8 OR logical condition
```

* ORDER BY: Sort rows with the ORDER BY clause. The ORDER BY clause comes last in the SELECT statement.  
  – ASC: ascending order, default  
  – DESC: descending order  
  Example: SELECT last_name, job_id, department_id, hire_date FROM employees ORDER BY hire_date ;  
  (Column ALias) SELECT employee_id, last_name, salary*12 annsal FROM employees ORDER BY annsal;   
  (Multiple Columns) SELECT last_name, department_id, salary FROM employees ORDER BY department_id, salary DESC;  

* Different SQL Functions & their results: 
```
Function               Result

LOWER('SQL Course')          sql course
UPPER('SQL Course')          SQL COURSE
INITCAP('SQL Course')        Sql Course
CONCAT('Hello', 'World')     HelloWorld
SUBSTR('HelloWorld',1,5)     Hello  -- inclusive integers
LENGTH('HelloWorld')         10
INSTR('HelloWorld', 'W')     6
LPAD(salary,10,'*')          *****24000
RPAD(salary, 10, '*')        24000*****
TRIM('H' FROM 'HelloWorld')  elloWorld
```
  Example : SELECT employee_id, CONCAT(first_name, last_name) NAME, job_id, LENGTH (last_name), INSTR(last_name, 'a') "Contains 'a'?"
FROM employees WHERE SUBSTR(job_id, 4) = 'REP';  

* ROUND: Rounds value to specified decimal -> ROUND(45.926, 2) 45.93  
  TRUNC: Truncates value to specified decimal -> TRUNC(45.926, 2) 45.92  
  MOD: Returns remainder of division -> MOD(1600, 300) 100  
  Example: SELECT ROUND(45.923,2), ROUND(45.923,0),ROUND(45.923,-1) FROM DUAL; --(Remember DUAL)System  
           SELECT last_name, salary, MOD(salary, 5000) FROM employees WHERE job_id = 'SA_REP';  
           
* SYSDATE is a function that returns: The SYSDATE function records the current date and time.  
  • Date  
  • Time  
  Example : SELECT last_name, (SYSDATE-hire_date)/7 AS WEEKS FROM employees WHERE department_id = 90;  
```
Function           Description

MONTHS_BETWEEN     Number of months between two dates
ADD_MONTHS         Add calendar months to date
NEXT_DAY           Next day of the date specified
LAST_DAY           Last day of the month
ROUND              Round date
TRUNC              Truncate date
• MONTHS_BETWEEN ('01-SEP-95','11-JAN-94') -> 19.6774194
• ADD_MONTHS ('11-JAN-94',6) -> '11-JUL-94'
• NEXT_DAY ('01-SEP-95','FRIDAY') -> '08-SEP-95'
• LAST_DAY('01-FEB-95') -> '28-FEB-95'


Assume SYSDATE = '25-JUL-95':

• ROUND(SYSDATE,'MONTH') -> 01-AUG-95
• ROUND(SYSDATE ,'YEAR') -> 01-JAN-96
• TRUNC(SYSDATE ,'MONTH') -> 01-JUL-95
• TRUNC(SYSDATE ,'YEAR') -> 01-JAN-95
```
  TO_CHAR('date','format_model')  
  SELECT last_name,TO_CHAR(hire_date, 'fmDD Month YYYY') AS HIREDATE FROM employees; --Embedded extra spaces are removed, not aligned basically.  
  SELECT last_name, TO_CHAR(hire_date, 'DD-Mon-YYYY') FROM employees WHERE hire_date < TO_DATE('01-Jan-90', 'DD-Mon-RR');  
  
  to_date('19781212','YYYYMMDD')  
  
* NVL functions of SQL explained,
```
NVL (expr1, expr2)
expr1 is the source value or expression that may contain a null.
expr2 is the target value for converting the null.

NVL2 (expr1, expr2, expr3)
expr1 is the source value or expression that may contain null
expr2 is the value returned if expr1 is not null
expr3 is the value returned if expr1 is null

DECODE(col|expression, search1, result1 -- Like if-else
 [, search2, result2,...,][, default])  -- If the default value is omitted, a null value is returned 
 
COALESCE (expr_1, expr_2, ... expr_n) --First non-null is matched

NULLIF (expr_1, expr_2)  --The NULLIF function compares two expressions. If they are equal, the function returns null

```

* GROUP BY & HAVING Clause : Having clause was added because WHERE can't aggregate functions.  
  SELECT COUNT(CustomerID), Country  
  FROM Customers  
  GROUP BY Country  
  HAVING COUNT(CustomerID) > 5;  

* __Different Types of Joins__: The following are different types of joins:  
  * Cross joins
  * Natural joins
  * Using clause
  * Full or two sided outer joins
  * Arbitrary join conditions for outer joins

```
SELECT table1.column, table2.column
FROM table1, table2
WHERE table1.column1 = table2.column2;

SELECT employees.employee_id, employees.last_name,employees.department_id, departments.department_id, departments.location_id
FROM employees, departments 
WHERE employees.department_id = departments.department_id;

SELECT e.employee_id, e.last_name, e.department_id,
d.department_id, d.location_id
FROM employees e , departments d
WHERE e.department_id = d.department_id;

To join n tables together, you need a minimum of
n-1 join conditions. For example, to join three
tables, a minimum of two joins is required.

SELECT e.last_name, e.salary, j.grade_level
FROM employees e, job_grades j
WHERE e.salary
BETWEEN j.lowest_sal AND j.highest_sal;

The Outer join operator is the plus sign (+).

SELECT table1.column, table2.column
FROM table1, table2
WHERE table1.column(+) = table2.column;

SELECT table1.column, table2.column
FROM table1, table2
WHERE table1.column = table2.column(+);

SELECT e.last_name, e.department_id, d.department_name
FROM employees e, departments d
WHERE e.department_id(+) = d.department_id ;  --for right join + is on left side & vice-versa


OWN JOIN:
SELECT worker.last_name || ' works for '
|| manager.last_name
FROM employees worker, employees manager
WHERE worker.manager_id = manager.employee_id ;

CROSS JOIN: The CROSS JOIN clause produces the cross-product of two tables.
SELECT last_name, department_name
FROM employees
CROSS JOIN departments ;


NATURAL JOIN clause is based on all columns in the two tables that have the same name.
It selects rows from the two tables that have equal values in all matched columns.
If the columns having the same names have different data types, an error is returned.

SELECT department_id, department_name, location_id, city FROM departments NATURAL JOIN locations ;


New Syntax Oracle:
USING keyword:
SELECT e.employee_id, e.last_name, d.location_id
FROM employees e JOIN departments d USING (department_id) ;

ON keyword:
SELECT e.employee_id, e.last_name, e.department_id,
d.department_id, d.location_id
FROM employees e JOIN departments d
ON (e.department_id = d.department_id);

LEFT & RIGHT JOINS:

SELECT e.last_name, e.department_id, d.department_name
FROM employees e LEFT OUTER JOIN departments d          --unmatched left rows & inner join returned
ON (e.department_id = d.department_id) ;

SELECT e.last_name, e.department_id, d.department_name
FROM employees e RIGHT OUTER JOIN departments d         --unmatched right rows & inner join returned
ON (e.department_id = d.department_id) ;

FULL OUTER JOIN:

SELECT e.last_name, e.department_id, d.department_name
FROM employees e
FULL OUTER JOIN departments d
ON (e.department_id = d.department_id) ;

```

* Aggregator Functions of SQL Queries: 
```
SELECT AVG(salary), MAX(salary),
MIN(salary), SUM(salary)
FROM employees
WHERE job_id LIKE '%REP%';

--COUNT(expr) returns the number of rows with non-null values for the expr.
SELECT COUNT(DISTINCT department_id) FROM employees;

GROUP BY CLAUSE:

SELECT department_id, AVG(salary) FROM employees
GROUP BY department_id;

SELECT department_id, MAX(salary) FROM employees
GROUP BY department_id HAVING MAX(salary)>10000 ;

SELECT job_id, SUM(salary) PAYROLL
FROM employees
WHERE job_id NOT LIKE '%REP%'
GROUP BY job_id
HAVING SUM(salary) > 13000
ORDER BY SUM(salary);
```

* __Nested Queries__: Query within a query, when aggregator function analysis is too complex.
```
SELECT last_name FROM employees WHERE salary > (SELECT salary
FROM employees WHERE last_name = 'Abel');

SELECT last_name, job_id, salary FROM employees
WHERE job_id = (SELECT job_id FROM employees WHERE employee_id = 141)
AND salary > (SELECT salary FROM employees WHERE employee_id = 143);

Operator   Meaning
IN         Equal to any member in the list
ANY        Compare value to each value returned by the subquery
ALL        Compare value to every value returned by the subquery
```

* INSERT: Add new rows to a table by using the INSERT statement.  
  INSERT INTO table [(column [, column...])] VALUES (value [, value...]);  
```
INSERT INTO sales_reps(id, name, salary, commission_pct) 
SELECT employee_id, last_name, salary, commission_pct
FROM employees WHERE job_id LIKE '%REP%'
--Do not use the VALUES clause here. Alternative
```

* UPDATE: Modify existing rows with the UPDATE statement. Update more than one row at a time, if required.  
```
UPDATE table
SET column = value [, column = value, ...]
[WHERE condition];

UPDATE employees SET department_id = 70 WHERE employee_id = 113;
```
