## Cloud Computing & Scaling

* Cloud computing is on-demand network access for shared pool of computing resources which are managed efficiently.

```
Layers of cloud architecture

Clients

SaaS : SaaS is delivered over the web and is primarily designed for the end user, may be on a subscription basis. 
DaaS : virtual desktop and the provider provides all back-end services that would have usually been provided by
application software.
PaaS : Rather than offering software that is delivered over the web,
PaaS offers a platform for the creation of software delivered over the web. For multiple development team across different regions.
IaaS : It is delivering cloud computing infrastructure as an on demand service.

Hardware
```
* Cloudsim is extensible cloud simulation toolkit for simulation of CLoud Environments. It's important features are,
  * Allows creation of one or more nodes of Data centers, jobs & their mappings to VMs.
  * Simulation on multiple data centers to enable study on federation.
  * automatic scaling of applications.  

---

## NoSQL Databases

* Not Only SQL, refers to a set of data stores that do not use SQL or a relational model to store data.
* It doesn't use SQL queries, requires fixed table schema, join operations support, ACID(Atomicity, Consistency, Isolation, Durability) operations.
* It does Scale horizontally, eventual consistency, support shared nothing architecture.
* Limitations of relational databases vertical scaling(not horizontal), single point of failure, poor handling of semi-structured data, expensive joins & normalization.
* No complexity, high throughput, horizontal scalability, reduce DBA workload.
```
Classification of NoSQL DBs
Key/Value          Column        Graph     Document
Amazon DynamoDB    Cassandra     Neo4j     MongoDB
```
* Key-value data store, Data is organized as an associative array of entries Key based storage, updation and retrieval Allow the application developer to store schema-less data. Fast reterieval & storage but integrity constraints & limited data analytics capability. Use-cases
Content providing applications, Object Caching, Session management, Storing user profiles and shopping cart etc.
* Document data store, Stores, retrieves and manages semi-structured data
Support multiple types of documents and nested documents too. Each document is identified by a unique key.
Provides API that allow retrieving documents based on their contents. Different documents may have different fields.
Use-cases: Blogging systems, Content Management Systems, Real-
time analytics, Mobile applications, Inventory management, Shopping
cart and Logging events etc.
  * Pros: Powerful indexing, Good at handling complex data structures, In-built support for Map-Reduce, Schema-less, Scalable, Fast writes, High availability, Sharding Lesser workload on DBA and Suitable for agile development.
  * Cons: Not good at handling data containing relationships, Data duplication, No transactional capabilities, Searching and Not good at performing complex transactions.
* Colum Oriented Datastore, Also called extensible record stores.
Data is stored column wise instead row wise.Group of columns is called column family and is analogous to table in
relational database. Columns of a table are distributed over multiple nodes by using column groups. Example, google's Bigtable.
  * Use-cases: Analytical querying, Blogging websites, Event logging, Content Management Systems, Maintaining counters.
  * Pros: Flexible, Scalable, Efficiently handles random read operation, Supports Map-Reduce, Provides high write throughput.
  * Cons: Integrity constraints at application level, Not good at handling relationships, Ad-hoc querying needs revamping of column-family design.
* Graph based Datastore, Employ nodes (like entities), properties (attributes), and edges (relationships). Faster for associative data sets. Can scale to large data sets without joins
. Every element contains a direct pointer to its adjacent element. Traverse graph to find the data. Efficient for representing social networks and storing sparse data.
* NoSQL disadvantages are, lack of support & standardization, requires redesigning, Enterprise reluctance to adopt non-ACID database.
* __New SQL Databases__ : New SQL Databases = SQL+NoSQL Databases, traditional ACID notion for transactions, Offer scale-out, shared-nothing architecture, capable of running on a
large number of nodes without bottle-necking.
* Best suitable database for each use-case,
```
Redis for user sessions: Rapid access for reads and writes
RDBMS for financial data: Transactional updates and reporting
Riak for shopping cart: High availability across multiple locations
Neo4J for recommendations: Rapidly traverse links between friends, product purchases and ratings
MongoDB for product catalog: Lots of reads, infrequent writes
Cassandra for analytics and user activity logs: High volume of writes on multiple node
```
* Case-study of adhar database,
```
(All enrolled records/documents-selected documents only) : Solr cluster, low latency indexed search & random search(Documents per sec)
(All enrolled records/documents-selected documents + photos) : MongoDB cluster, low latency indexed read & high latency random search(Documents per sec)
(All UID records-demographics only, enrollment status) : MySQL cluster, low latency indexed read & high latency random search(Documents per sec)
(All biometric templates) : HBase, High read throughput, low-to-medium latency read
(All raw packets) : HDFS(Hadoop distributed file system), High read throughput, high latency read
(All archived raw packets) : NFS(Network File System), Moderate read throughput, High latency read
```

---
__Note:__
* Amazon AWS, GAE, Azure cloud related information is in TODO list.
* References taken from multiple sources for this one.
