# Information Management

---

This is preperation repository for topics like database basics, SQL, basic PL/SQL, Cloud basics and other information
management related concepts to be discussed in detail with practical applications.

---
## Introduction & Basics

* Information is collection of data which is business specific and helps in making decisions. Data is not business specific but is atomic level of information.
* File bases Systems vs Database Systems :
  * Limitations of File based systems :
      * Repitition of data.
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
---
__Note:__

* Interview Preperation Section will soon be added.
