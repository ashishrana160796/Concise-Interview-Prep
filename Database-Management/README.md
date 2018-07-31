# Information Management

This is preperation repository for topics like database basics, SQL, basic PL/SQL, Cloud basics and other information
management related concepts to be discussed in detail with practical applications.

---
## Introduction & Basics

* Information is collection of data which is business specific and helps in making decisions. Data is not business specific but is atomic level of information.
* File bases Systems vs Database Systems :
  * Limitations of File based systems :
      * Repetition of data.
      * File format issues.
      * duplicate data & data dependence.
      * seperated & isolated data.
  * Advantages of DBMS :
    * Controlling Redundancy, Integrity. Inconsistency can be avoided.
    * backup & recovery.
    * Standard enforcement, solving unauthorized access.
    * Enterprise level solutions provide.
  * Disadvantages like size, performance, complexity, Cost of DBMS & Conversion cost is also there.
* Components of DBMS environment Hardware, Software, Data, Users & Procedures.
* CODASYL made two levels : schema & subschema, Schema is the blue print of the database and subschema is the application programmer's view of the database. Schema is called intension of database & instance is called extension of database.
* ANSI made three levels : Internal( physical representation, data storage in database ), Conceptual( relationships, entities, attributes, constraints, security & integrity of information ) and External( user-view ) level of schema. 
* Mapping between views :
  * External Mapping : Correspondance between records & relationships of the external and conceptual views.
  * Internal Mapping : actual record in physical schema can be found with this in conceptual view.
* Data independence achievement :
  * Logical data independence : Conceptual schema doesn't depend on external schemas.
  * Physical data independence : storage structures can be changed w/o affecting conceptual schema.
* Metadata or Data Dictionary : It is the data about the data. Active data dictionary is managed automatically dbms & passive one is used for documentation purposes.
* Data Models : They are the concept collection for describing, manipulating and defining relationships between data & constraints.
* Categories of data models :
  * Object based models : external & conceptual level. entity, attributes & relationships are used in this. 
  * Physical data models : internal levels describe data-models. unifying model, example.
  * Record data models : external & conceptual level. Hierarchical( oldest, example: IMS ), network & relational model.
    * Additional, removal, updation, retrieval, single relation with parent & vice-versa, reveral of hierachy causes general problem in handling such cases.
    * Network model handles many-to-many relations well. Above mentioned problems don't occur but complexity is more. Relational model works with records proposed by E.F. Codd.
* Database Design Approach :
  * Top-Down Approach : E-R Modeling
  * Bottom-Up Approach : Normalize
* Entity is an object independent, distinguishable from other objects. Entity set is a set of entities of the same type that share the same properties.
* Types of values simple vs composite, single vs multivalued, stored vs derived. Keep in mind different conventions to represent different attributes.
* Connectivity describes the type of mapping of associated entity in the relationship. Cardinality is the actual number of related instances. Cardinality also tells about the lower & upper limit.
* Direction line orignation shows parent entity, otherwise  child entity. Direction line is used to indicate one occurance & undirected line, many occurance. Other symbols for entities, relationships and attributes are important.
* Total vs Partial Participation : every entity participates in at least one relationship in relationship set. Some entities participates in the relationship set.
* Strong & Weak entity sets, loan-payment relation where payment number won't exist w/o loan. Entity set doesn't have sufficient attribute to form a primary key is called weak entity set.
* Generalization( bottom-up ) vs specification( top-down ), entities sharing common attributes can be generalized into on higher supertype. Sub-types are dependent. It is denoted with triangle 'IS A' attribute. In specification from higher subsets lower ones are formed in top-down manner.
  * Constraints on these can be user-defined or attribute defined.
* Aggregation : One limitaion is cannot define relation amongst relation. Aggregating one relation with entities with another relation and entities. example : Loan officer for customer loan pair.
* __E-R Diagram to table__ : A generic approach that is applicable.
  * Unique row attribute becomes primary key.
  * Composite attributes are flattened out.
  * EM, E is entity set & M is multivalue attribute. So, primary key & M will have seperate table and same goes for remaining entity set plus their table.
  * Weak entity set becomes seperate table & involves primary key of identifying strong entity set.
  * In many-to-many relation represent it with a primary keys of both the entity sets in a seperate table.
  * Many-to-one relation instead of creating new table, add primary key of many branch to one side. example, in account branch relation copy branch to account side.
  * In specification involve primay keys from higher level onto lower levels of tables.
  * Consider a case of account generalized from saving & current accounts. There are two cases either maintain three tables of account, saving account, current account or maintain the later two. But, in first one balance attribute joining is required for two tables, but in second approach a redundant balance field is required for both tables.
  * To represent a aggregated relation, create a table of aggregated relation's primary key and primary key of associated entity.
* __Keys :__ Different types of keys in relation.
  * Super Key : uniqueness property is there.
  * Candidate Key : uniqueness & irreducibility.
  * Primary Key : key chosen for unique identification of records. Can't contain null. 
  * Alternate Key : are candidate keys not chosen as primary keys.
  * Artificial Key : created by DBA to increase efficiency by combining multiple columns create new unique key.
  * Foreign Key : attribute that refer to primary of another table. target table is the one containing reference to target tuple. Matter of integrity of foreign keys is referred to as Referential Integrity.
* Number of tuples = cardinality of a relation. And number of attributes are degree of relation.
* Domain is set of all possible valid values. Also, body of a relation consist of unordered set of zero or more tuples.

---
## Normalization

* A process of series of tests that a relation must pass in order to be in normal form. If test is not passed then individual sets are broken, to meet desired tests. Objective of normalization.
  * Formalization framework develop & relational retrieval algorithm develop.
  * Reduce restructing of relations with new data types & avoid free relations.
* Basic types of normal form :
  * 1st NF: Eliminate Repeating Groups.
  * 2nd NF: Non-key attribute fully dependent functionally on PK.
  * 3rd NF: Eliminate Transitive dependence on PK.
  * 4th NF: Remove multi-value dependency.
  * 5th NF: Projection Join dependency.
* Detailed Analysis of Normalization:
  * FD, X->Y, means with X (determinant) can determine Y's value. FFD, Y is determined by X only not on it's proper subset X.
  * Relation is __1NF__ if all underlying domains contains single values, i.e. all repeated unfilled entries are removed, by flattening the table.
    * Flattening with filling non-repeated entries is the first approach, 
    * Second approach is decomposition, for this one table consist of all non-repeating and other repeating attributes with containing table identifier. __Anomalies__ related to insertion, updation and deletion exists thats why needs 2NF.
    * __2NF__ iff it is in 1NF & every non-functional attribute is dependent upon primary key. Drawing a FD diagram is also a good approach. Because of transitive dependence, anomalies can still exist with insertion, updation & deletion.
    * __3NF__ iff in 2NF & no nonprime attribute determine a nonprime attribute, remove dependencies. If A->B->C non-symmetric relation is there, can be broken down into A->B & B->C.
    * __BCNF__ makes no reference to 1NF & 2NF, but states that every determinant single or composite is a candidate key. A relation in 3NF is always in BCNF but not the opposite. __Overlapping candidate keys are main problem__ tha BCNF handles.
    * __4NF__, If already in 3NF or BCNF & no Multi value dependency. In MVD an attribute can have multivalued fact about another. A relation R having A,B, and C, as attributes can be non loss- decomposed into two projections R1(A,B) and R2(A,C) if and only ifthe MVD A->->B|C hold in R.
    * __5NF__, Already in 4NF and it cannot be non-loss decomposed. A table T is in 5NF if every join dependency(lossless reconstruction) in T is a consequence only of the candidate  keys in T.
* Denormalization : helps in increasing the efficiency of data by keeping redundant data to avoid extra join overload.
  * One way, Logical design is kept normalized, but keep redundant views to optimize the query like Indexed or materialized views. View represent information & queries are optimized. Denormalized databases need to be synchronized.
  * denormalization of data should be done after certain level of normalization. Denormalization is not equivalent to non-normalized data.
  * OLTP prefers normalized databases for consistency & OLAP prefers denormalized ones.
* __Codd Rules:__ Codd rules were proposed by E.F. Codd which should be satisfied by relational model.
  * Information Rule: Data stored in Relational model must be a value of some cell of a table.
  * Guaranteed Access Rule: Every data element must be accessible by table name, its primary key and name of attribute whose value is to be determined.
  * Systematic Treatment of NULL values: NULL value in database must only correspond to missing, unknown or not applicable values.
  * Active Online Catalog: Structure of database must be stored in an online catalog which can be queried by authorized users.
  * Comprehensive Data Sub-language Rule: A database should be accessible by a language supported for definition, manipulation and transaction management operation.
  * View Updating Rule: Different views created for various purposes should be automatically updatable by the system.
  * High level insert, update and delete rule: Relational Model should support insert, delete, update etc. operations at each level of relations. Also, set operations like Union, Intersection and minus should be supported.
  * Physical data independence: Any modification in the physical location of a table should not enforce modification at application level.
  * Logical data independence: Any modification in logical or conceptual schema of a table should not enforce modification at application level. For example, merging of two tables into one should not affect application accessing it which is difficult to achieve.
  * Integrity Independence: Integrity constraints modified at database level should not enforce modification at application level.
  * Distribution Independence: Distribution of data over various locations should not be visible to end-users.
  * Non-Subversion Rule: Low level access to data should not be able to bypass integrity rule to change data.

---
## Relational Algebra

* Relational Algebra is procedural query language, which takes Relation as input and generate relation as output. Relational algebra mainly provides theoretical foundation for relational databases and SQL.
* Operations in Relational Algebra :
  * Projection (π) : Projection is used to project required column data from a relation.
  ```
      R              
  (A  B  C)    
  ----------
   1  2  4
   2  2  3
   3  2  3
   4  3  4
   
   π (BC) 
    B  C
    -----
    2  4
    2  3
    3  4
  ```
  * Selection (σ) : Selection is used to select required tuples of the relations. For the above relation, σ (c>3)R will select the tuples which have c more than 3. To display above result we need projection also.
  ```
  π (σ (c>3)R ) will show following tuples.
  A  B  C
  -------
  1  2  4
  4  3  4
  ```
  * Union (U) : Union operation in relational algebra is same as union operation in set theory, only constraint is for union of two relation both relation must have same set of Attributes.
  * Set Difference (-) : Set Difference in relational algebra is same set difference operation as in set theory with the constraint that both relation should have same set of attributes.
  * Rename (ρ) : Rename is a unary operation used for renaming attributes of a relation. ρ (a/b)R will rename the attribute ‘b’ of relation by ‘a’.
  * Cross Product (X) : Cross product between two relations let say A and B, so cross product between A X B will results all the attributes of A followed by each attribute of B. Each record of A will pairs with every record of B.
  * Natural Join (⋈) : Natural join is a binary operator. Natural join between two or more relations will result set of all combination of tuples where they have equal common attribute.
  * Conditional Join : Conditional join works similar to natural join. In natural join, by default condition is equal between common attribute while in conditional join we can specify the any condition such as greater than, less than, not equal
 
---

## SQL Basics

* __Create table commands__ :
  * Table names are note case-sensitive, characters in it are A-Z, a-z, 0-9, _(underscore),$ and #. Numbers of columns in a table can range from 1 to 1000. 
  * Create table command. Also, varchar is variable length character & char is fixed length command.
  ```
  Create table student
  (Name varchar(20),
  Class varchar(15),
  Roll_no number(4),  -- NUMBER(p,s), where p is precision & s is scalability
  Address varchar(30));
  ```
  * Constraints column level & table level constraints of primary key can also be added. Names to constraints can also be assigned. 
  ```
  Create table student
  (Name varchar (20) CONSTRAINT NN_NAME NOT NULL,
  Roll_no number (5) NOT NULL,
  Address varchar (40),
  phone_no varchar (10));
  /*
  NOT NULL, UNIQUE, PRIMARY KEY( Syntantically it can also be added in seperate line, PRIMARY KEY (name, class) ),  
  CHECK (salary > 5000) or CHECK (deptname in (‘general’,’accounts’)), DEFAULT value */
  
  --FOREIGN KEY ANALYSIS
  --Deleting parent record might give error message if referenced by child, otherwise use ON DELETE CASCADE, RESTRICT, DEFAULT or ON UPDATE CASCADE etc. option.
  --Another example of it as follow, deptno NUMBER(2) REFERENCES dept(deptno) on delete set null);
  --Seperate line sytax, Foreign key (deptno,dname) references dept(deptno,dname)) ;
  --Referential Integrity, parent-child relation b/w primary & foreign keys are preserved.
  
  ```
  * __user_constraints table__, __user_cons_columns__ : Named user_constraints are present in it, few queries associated with it.
  ```
  Select owner, constraint_name,constraint_type, r_owner, r_constraint_name from user_constraints where table_name = ‘EMP_DETAIL’;
  Select * from user_constraints;
  SELECT * FROM USER_CONS_COLUMNS;
  ```
  * Create table from rows & columns of another table with SELECT & AS keywords.
  ```
  CREATE TABLE emp2 AS SELECT empno, ename, mgr, sal FROM emp WHERE deptno in (10,20);
  ```
* __Altering Tables__ : Syntaxes & Few cases are discussed at bottom for this ALTER option.
```
ALTER TABLE < table_name >
[ADD < columnname > | <constraints >.......]
[MODIFY <columnname>......]
[DROP <options >];

--Let's say for renaming, ALTER TABLE exampletable RENAME TO new_table_name;
--Let's say adding a new column
ALTER TABLE <table_name>
[ADD <column_name datatype (size) | <constraints>
,..........];
```
* __Truncate Table__ : Delete all rows from a table, TRUNCATE TABLE Customer or DELETE FROM Customer
```
Difference between TRUNCATE & DELETE :
With Truncate data can't ne recovered. Truncate is DDL, DELETE is DML. Truncate releases the memory but DELETE doesn't.
```

---

## Views, Sequences & Index

* Views are tables which doesn't contain any data, data is taken from other tables. Content of original table can be manipulated fro these views. Once, a view is created it can be treated like any table. These can have security, abstraction advantages.
```
CREATE OR REPLACE VIEW clerk AS
SELECT empno, ename, job, dname from emp,dept
WHERE emp.deptno=dept.deptno;
```
* Sequence in database object is used to generate numbers for rows in a table.
```
CREATE SEQUENCE <Sequence_name>
[INCREMENT BY <integervalue>] --default is 1
[START WITH <integervalue>] --default 1 for asc, -1 for dsc
[MINVALUE <integervalue>/NOMINVALUE]
[MAXVALUE <integervalue>/NOMAXVALUE]
[CYCLE/ NOCYCLE];

--Example of a sequence as follow,
CREATE SEQUENCE Empcode Increment By 2 Start With 100;
SELECT EmpCode.Nextval From Dual; --CURRVAL for last value returned by NEXTVAL
```
* Indexes, way to store & search records in table. Records are retrieved in two ways either by ROWID or full table scan. Maintain uniqueness in database, boosts searching performance.
* Address field of a index is called ROWID. Internally generated & maintained in binary values. Format of row id, BBBBBBB.RRRR.FFFF
  * BBBBBBB(7): block number on which the record isstored.
  * RRRR: unique record number in each data block.
  * FFFF: unique number given by oracle engine to each data file.
* Duplicate vs Unique indexes, unique doesn't allow duplicate values for indexed columns. Simple & Composite Indexes exist
```
--Index created on single col but duplicate values can be there
CREATE INDEX index_name  --UNIQUE INDEX, for unique index
Types of Indexes
ON table_name(column_name1 |, column_name2);
--Dropping an index
DROP INDEX index_name;
```
* Too many indexes slows down the DML queries. Index only 10-15% of data. Index cols involved in multi-table join.
* A comparison b/w bitmap & b-tree index. Also, paritioned index is used to partition table.  

| B-tree Index | Bitmap Index, single index entry uses bitmap to point at rows |
| --- | --- |
| Good for high cardinality data | low cardinality |
| Good for OLTP databases | Good for data warehousing applications |
| Large amount of space | Little space |
| Easy update | difficult |

* How good a index is ? selectivity, = unique index values / total number of records.

---
__Note:__
* Reference are from book Simplified approach to dbms : Parteek Bhatia Sir
* Interview Preperation Section will soon be added.
