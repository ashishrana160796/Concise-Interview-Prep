## Introduction: Big Data

* With increase in data size a new technology handling huge data efficiently is required, different from current servers storing data in limited space with okay speed.
* Big Data is the data that is too large & difficult to process by DBMS tools. All data analytics challenges are inherited to it also.
* __Big Data Characteristics:__
```
Huge Volume
Velocity
Variety
Veracity: Ambiguity & Uncertainity, one of the most important components
Value, some quantified output must be there.
```
* __Types of Big Data__
```
Structured: RDBMS & SQL, PL/SQL is often used for this kind of data.
Semi-Structured: XML, JSON etc. can be used to structure it.
Unstructured: Unknown form of data.
```
* __Challenges Of Big Data__
```
Data Quality
Discovery
Storage
Analytics
Security
```
---
* __Hadoop: __ Apache's Java-based programming framework, storage & processing large datasets in distributed computing environment.
```
Problems: Even more processing units won't help as memory resource will get bottleneck.
         Even with parallel seperate units(for processing/memory) problem of overloading might happen.

Solution: Hadoop works in a distributed manner for fault tolerance & for parallel processing first data is
processed by slave nodes & then an intermediate result is sent to master node.
---
Issues of Big Data solved by Hadoop: Large amount of hetergenous data, processing speed.
Solution:
    HDFS: Hadoop distributed file system, stores data in distributed fashion.
        NameNode, a master server that manages the file system namespace and regulates access to files by clients.
        Internally, a file is split into one or more blocks and these blocks are stored in a set of DataNodes.
    YARN: for reducing the processing time drastically. YARN is in between HDFS & processing engine.
        Yet Another Resource Negotiator, it dynamically allocate resources to applications as needed.
```

* __Solution, Hadoop: __ 

```
Solutions to Earlier mentioned Problems:

Volume: Hadoop follows horizontal scaling, divides data into horizontal nodes.
Variety: HDFS stores all kind of data. No pre-dumping schema validation needed. Write once, read many problem.
Processing: Processing Unit Logic is sent to data, rather than opposite. All intermediary nodes are merged for result. 
```

* __Features:__ Reliable(In-built fault tolerance mechanism), Economical, Scalable.

* __Core Components:__
```
HDFS(storage): Scalable storage unit.
YARN(processing): process data, in distributed & parallel fashion.

HDFS,
  NameNode: master daemon maintains and manages the DataNodes (slave nodes). Records all changes in file system metadata.
  Keeps record of all HDFS & DataNodes.
  DataNode: slave daemon which run on each slave machine. Create, Delete & Replicate block upon decision by NameNode.
YARN,
  ResourceManager: Cluster Level Component, operates on master machine.
      Scheduler: responsible for allocating different resources to various applications.
      ApplicationManager:  accepts job submissions & negotiates the first container for executing the application
  NodeManager: managing containers and monitoring resource utilization in each container. 
```

* __Hadoop Ecosystem:__
```
 MapReduce:                  | HIVE & DRILL:    | Mayout &         | PIG: Scripting | HBASE:         |
 Processing, Diff. Languages | Analytical, SQL  | SPARK MLib       | SOLR & Lucene: | NoSQL Database |
                                                  Machine Learning | Searching &    | OOZIE:         |
Spark: In-Memory,  | KAFKA & STORM:  |                               Indexing       | Scheduling     |
Data Flow Engined  | Streaming       |
    ------------------------------------------------------------| ZooKeeper &  | 
    Resource Management: YARN                                   |   AMBARI     |
    ------------------------------------------------------------|              |
    Storage: HDFS                                               | Mangement &  |
    ------------------------------------------------------------| Coordination |
            Flume                             Sqoop
        Unstructured Data                 Structured Data
      /Semi-Structured Data
```
