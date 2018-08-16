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
```
* Cloudsim is extensible cloud simulation toolkit for simulation of Cloud Environments. It's important features are,
  * Allows creation of one or more nodes of Data centers, jobs & their mappings to VMs.
  * Simulation on multiple data centers to enable study on federation.
  * automatic scaling of applications.  

---

## Containers, Blobs, Buckets

* The main issue with a VM is that each VM owns a resource, & there is no leveling of that resource.
* Containers are “isolated, resource controlled, and portable operating environment”.
  * Linux containers are self-contained execution environments with their own, isolated CPU, memory, block I/O, and network resources that share the kernel of the host operating system.
  * Result is like a VM but sheds all weight over to guest OS. In large scale systems VMs behave like running duplicate instances of same volume.
  * Container is a linux process that thinks it the only process running. It is assigned it's own IP, which can be mapped to IP address of host, accessible by public. Resource sharing is managed by container manager. Boots quickly, isolation & encapsulation of a VM, w/o drawback of dedicated resources. OS virtualization by docker, container manager.
  * Container component or container image is called a layer. To change a runtime dependency here, only configuration file is needed to be changed.
  * __Containers are built in images__ : image represents a template of a container that your computer needs to work in. Image is stored in registry & registries are live in network. Complete process of this,
    * Configuration file is needed to be constructed. After running the host, container manager will read the configuration file to get the container images needed from the cloud.
    * Add images in container, container manager will get them & layer them in also. Container mananger copies files to required container.
    *  provisioning service will deploy to a cloud provider.
  * Cluster of container, behind a load balancer container(top-layer) to achieve high performance, high availability computing. Discovery technology for availablity of balancers, so it can route traffic to new node.
  * LXC is driving development behind for above tech based on CGroups & Name spaces.
    * CGroups : resource management for process or process groups.
    * Name Spaces : Process groups isolation from each other. Restriction & visibility issues can be added.
  * Container for Windows, these are hosted on Windows server. They have their own NFS & resources.   
* __Blob storage__ allows Microsoft Azure to store arbitrarily large amounts of unstructured data and serve them to users over HTTP and HTTPS.
  * Microsoft's use cases include serving streaming video, files, text and images to remote users. Azure allows users to store blobs in containers. A blob might be dedicated solely to video while another might store image files.
  * Microsoft defines three types of blobs: block blobs, append blobs and page blobs. Block blobs support up to 50,000 blocks up to 4 megabytes, with up to 195 gigabytes in total. Block blobs are intended for text and other binary files. Append blobs support appending operations and are designed for log files. Page blobs are designed for frequent read/write operations. Blobs are created and accessed with .NET code.
* A __bucket__ is a logical unit of storage in Amazon Web Services (AWS) object storage service, Simple Storage Solution S3. Buckets are used to store objects, which consist of data and metadata that describes the data.
  * An S3 customer must create a bucket before he can store data in Amazon's public cloud and specify access privileges for the bucket by using the AWS Policy Generator. Although customers are not charged for creating buckets, they are charged for storing objects in a bucket and for transferring objects in and out of buckets.
  * There is no limit to the number of objects a customer can store in a bucket, but each AWS account can only have 100 buckets at one time.

---

## Computing Performance

* __Cloud Bursting,__ additional resources given at peak resource consumption time. From load balancers to app servers, few are moved to public ones for more resources. Master & Slave DBs remains the same. Major concern is speed issues while moving complete application to public servers.
  * A service oriented approach with loosely coupled architecture can help, running each service on different clouds. While cloud bursting otherwise challenges related to interfaces are faced, perfomance issues etc.
* Parallel, Distributed, Grid & Cluster computing,
  * Parallel computations with multiple cores on a single machine with one memory unit.
  * Distributed computations each machine with its own core & memory unit for processing.
  * Highly distributed architecture, computer resources from multiple domains are taken to achieve common goals.
  * Cluster computing, cluster is a tightly coupled system and have centralized job management and scheduling system. Types of clusters,
    * High Availability, failover clusters to improve available time, one-way or two-way.
    * Load Balancing, multiple computers to divide the workload on the system.
    * HPC Cluster, it increases peformance by splitting tasks onto different nodes, all nodes represented as one.

---

## MapReduce-Important

* Programming model designed for processing large volumes of data in parallel by dividing the work into a set of independent tasks. All elements in mapreduce are immutable, can't be updated. If a key-value pair gets changed it doesn't reflected back in input files. Input list -> reducing function -> Output Value.
```
mapper.py

import sys
for line in sys.stdin:
  line=line.strip()
  words=line.split()
for word in words:
  print '%s\t%s' % (word, "1")

reducer.py

import sys
w2c = {}
for line in sys.stdin:
  line=line.strip()
  word, count=line.split('\t',1)
  try:
    count=int(count)
  except ValueError:
    continue
  
  try:
    w2c[word]=w2c[word]+count
  except:
    w2c[word]=count
  
for word in w2c.keys():
  print '%s\t%s' % (word, w2c[word])

command used : cat mapper.py | ./mapper.py | sort | ./reducer.py
```
* All of the values with the same key are presented to a single reducer together.
* First mapping process happens(with intermediate data for mappers from different nodes), intermediate values are exchanged b/w machines to send all key values to same key to single reducer, only communication process. Individual Map and Reduce tasks are not aware of other's existence. User never explicitly marshals information from one machine to another; all data transfer is handled by the Hadoop.
* Some hadoop related information, Nodes in a cluster fail task must be able to restart.
  * mapred.min.split.size parameter in hadoop-site.xml configuration file, by default divides files into size of 64MB. Overidding the parameter in the JobConf object.
  * On-node parallelism is controlled by the mapred.tasktracker.map.tasks.maximum parameter.
* RecordReader class actually loads the data from its source and converts it into (key, value) pairs suitable
for reading by the Mapper. Each invocation of the RecordReader leads to another
call to the map() method of the Mapper.
* map() method receives,
  * key-value pair.
  * OutputCollector object with collect() method for K-V pair to reduce phase of job.
  * Reporter object provides current information about the current task.
* Process of moving map outputs to the reducers is known as __shuffling__. All values for the same key are always
reduced together.
* __Partitioner__ class determines which partition a given (key, value) pair will go to. Default partitioner computes a hash value for the key and assigns the partition based on this result.
* K-V pair are sorted before reducer function, sharing same key are sent to same reducer. After a key, if new key appears, the previous key will never appear again.
* __Reducer__ : Reducer instance is created for each reduce task, reduce() method is called once only. Value associated with each key are returned by iterator in undefined order. OutputCollector & Reported objects are received by reducer in similar way like map().
* __Combiner__ runs after the Mapper and before the Reducer. Combiner will receive as input all data emitted by
the Mapper instances on a given node. Output from the Combiner is then sent to the Reducers, instead of the output from the Mappers. Basically it increases/adds the count like explained earlier in reducer.py file.
* __Speculative Execution__, few slow nodes limits the execution speed. When most of task are coming to close hadoop sends redundant copies to vacant nodes. When task is completed it is announced to JobTracker. Whichever task finished becomes definitive copy. 
  * If other copies were __executing speculatively__, Hadoop tells the TaskTrackers to abandon the tasks and discard their outputs.
  * Disable this option by :
    * – mapred.map.tasks.speculative.execution
    * – mapred.reduce.tasks.speculative.execution

---

## Virtualization

* A hypervisor is a software, firmware or hardware that creates and runs virtual machines.
* Share HW among users, sandbox applications & decouple application & hardware for HW upgrades.
* Virtualization is process which allows multiple OS configuration & executions. 
* Hypervisor provides support for running multiple operating systems concurrently in virtual servers created within a physical server.
  * Type-1: OS-independent VMM, limited set of hardware by vendor.; Type-2: OS-dependent VMM. Relies on OS for resource management.
* __Full virtualization:__ direct execution & binary translation techniques are used for this. Privileged operations & I/O instructions, are the main issue. 
* __Binary Translation:__ The hypervisor translates all operating system instructions on the fly and
caches the results for future use. 
* __Para Virtualization:__ Involves explicitly modifying guest operating system so that it is aware of being virtualized to allow near native performance.
  * Paravirtualization involves modifying the OS kernel to replace non-virtualizable instructions with hypercalls that communicate directly with the virtualization layer hypervisor.
* Hardware assisted virtualization: OS requests traps to VMM without binary translation or paravirtualization. 
* __Server Consolidation__ : Running multiple virtualized server on one physical server. Different types,
  * Centralised Consolidation: all servers are centralized.
  * Physical Consolidation: reducing number of servers by merging into few servers.
  * Operational Consolidation: partitioning and virtualisation to run many “virtual servers” on a single machine.
* Types of Virtualizations :
  * Desktop Virtualisation
  * Server Virtualisation
  * Storage Virtualisation
  * Network Virtualisation
* Sandbox: a virtual space in which new or untested software or coding can be run securely.
* Types of different virtualization softwares,
  * VMWare: Full virtualization. Virtualization solutions for virtual data centers and cloud infrastructures.
  * Citrix Xen Server: Offers both HVM & PV. Xen loads an initial OS which runs as a privileged guest called “domain 0”.
    * The domain 0 OS, typically a Linux or UNIX variant, can talk directly to the system hardware (whereas the other guests cannot) and also talk directly to the hypervisor itself. It allocates and maps hardware resources for other guest domains.
  * Ubuntu KVM: Kernel based virtual machine (Kernel Based VM) is a virtualization infrastructure for the Linux kernel that turns it into a hypervisor.  
  
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
