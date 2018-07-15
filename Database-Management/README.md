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

---

__Note:__

* Interview Preperation Section will soon be added.
* Commits to complete this section will be made within 24 hours.
