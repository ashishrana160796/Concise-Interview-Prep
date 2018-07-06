# Operating-Systems

## Important Topics List 

Kernels, User to Kernel translation, Process/Storage Management generic, Processes/IPC, Process/CPU Scheduling,
Resource Sharing/Deadlocks , Threads/Concurrent Programming Implementation of Semaphores & resource sharing algorithms
( Dietel Book Oriented ), Disk Management Algorithms, Virtual Memory Organization & Numericals related to it, 
File Systems, Token Ring and some basic networking, Linux vs Windows - Basic froms OS point of View.

---

### Introduction to OS

* Application base : Combination of hardware & OS used to develop applications.
* VMs : Software abstractions of a OS, often executes on top of a OS.
* Multiprogrammed environment, kernel messages executes processes. Program components that executes independently but use single space & share data are called threads.
* I/O device & process must issue system call. It is handled by device driver, software components that interact with hardware. Device-specific commands it contain.
* Monolithic OS with all components in one place, which can directly communicate with one another. Highly efficient, determining source of errors is a problem.
* Layer Architecture : verticals of layers interacting with one another through many layers before completion. 
* Micro-kernel architecture - increase level of intermodule communication, small number of services, high modularity.
* Timesharing is logical extension of job switches, so user can interact with each job while it is running. Also, regain control to avoid program exceeds alotted time.
* By changing the mode bit( =0, kernel : =1, user) & making system calls user mode to kernel mode is shifted. This call happens via system call interface. 
* Kernel loads itself first, remains in main memory. Kernel32.dll is the 32-bit Dynamic Link Library found in the Windows OS Kernel. It handles memory management, I/O operations, & interrupts, grant access via system calls.
* __P2P Computing__ is all nodes are peers, register itself with central lookup service & broadcase request for service & respond request for service via discovery protocol.
* Typically stored at ROM or EEPROM, generally a firmware. BOOTSTRAP program is loaded at power-up/reboot initialize drivers, loads OS & starts execution.

---

### Process

* Batch system, user of batch system doesn't interact directly they prepare jobs & send them for processing. Time
shared systems, for executing user programs & tasks.
* Process includes program counter, stack, data section.
* Program is a passive entity & process is an active one. A program becomes a process when executable file is loaded is  loaded into memory.
  * Content value associated with process :
    * Current value of Program Counter
    * Content of Process Registers
    * Value of variables
    * Process Stack( SP ) typically contains temporary data like subroutine parameters, return address, & temporary data.
    * Data section for global variables.
* States of a process :
  * New State: The Process being created.
  * Ready State: The Process is waiting to be assigned to a Processor. Schedule dispatcher will release it.
  * Running State: A Process is said to be running if it has the CPU.
  * Blocked (or Waiting) State: A Process is said to be blocked if it is waiting for some event to happen.
  * Terminated State: The Process has finished Execution

* Queues Of different kind :
  * Job Queue – Set of all processes in the system
  * Ready Queue – Set of all processes residing in main memory, ready and waiting to execute
  * Device Queues – Set of processes waiting for an I/O device

* Process Control Block (PCB, also called Task Controlling Block, Entry of the Process Table, Task Struct, or Switchframe) is a data structure in the operating system kernel containing the information needed to manage the scheduling of a particular process.

* Context Switch : system switches to another process and have the state of previous process & saves the state of new process via a context switch. Context of a process represented in PCB. Context-switch is a overhead. Time dependent of hardware support.

* Different type of scheduler in processes : 
  * Long-Term Scheduler (or Job scheduler) – Selects which Processes should be brought into the Ready queue.
  * Short-Term Scheduler (or CPU scheduler) – Selects which Process should be executed next and allocates CPU.
  * Medium-Term Scheduler – Intermediate Level of Scheduling. Limit the Multiprogramming and executes Swapping.

* Parent & children processes, with forking it creates tree of processes. PId uniquely idenifies a process :
  * Resource Sharing
    * Parent and Children share all Resources
    * Children share subset of parent’s Resources
    * Parent and child share no Resources
  * Execution
    * Parent and Children execute Concurrently
    * Parent waits until children Terminate

* Two models for IPC. As, cooperating process needs IPC :
  * Shared Messaging : Common variable & data.
  * Message Passing : Communication between two processes.
    * send(P, message), receive(Q, message) : Link establishment happens automatically, b/w each pair there is only one pair.

* UNIX style system calls & their functionalities :

| System call | Description |
| --- | --- |
| fork | spawns child process & allocate parent's resources. |
| exec | load's process data & instructions into address space. |
| wait | causes the calling block to block resources until child process is terminated. |
| signal | specifies signal handler a particular signal. |
| exit | terminates calling process. |
| nice |  modifies process's scheduling priority. |

---

### Threads & Programing Analysis

* Threads are LW( Light weight )P, instructions/control, global info/shared address space. Also, register, stack, ,thread specific data and single masks are local to a thread. 
* Threading models as follow :
  * User-level threads : created by runtime libraries & cannot access kernel directly.
    * Many to one mapping, single execution context threads are mapped to.
    * Synchronization performed outside kernel, avoid context switches. Kernel views multithreaded  as single thread of control, cannot be used on mutliple processor at once.
  * Kernel-level threads : maps each thread to its own context. Overhead is reduced by context switching but not optimal solution.
  * Worker Threads( kernel threads that are persistent ) : New thread executed with worker thread. Improves performance where are created/destroyed oftenly.
  * Synchronous : Occurs as a direct result of program execution. Where as, asynchronous event typically unrelated to current instruction.
  * Multiple threads share same address space. Therefore, thread termination can cause serious problems.
  * POSIX & PThreads : POSIX states that processor registers, stack and signal mask are maintained individually for each thread. POSIX API specifies how OS should signal Pthreads & in addition to specifying thread-cancellation modes.
  * XP threads can creates fibres,  that creates it rather than scheduler. In XP process exist with thread pool, with number of worker threads, in which kernel threads execute function specified by user thread.

#### Java Multithreading 
```
Created by class Thread( java.lang.Thread ). Execute code is specified in Runnable( java.lang.Runnable )'s object run method.

public interface Runnable {
  void run();
}

With Runnable's object : Create class which implements, Runnable object. Create object of thread & pass runnable object & start it. 

RunnableThreadImplementor inst = new RunnableThreadImplementor();
Thread th = new Thread();
th.start();

With Thread class : A class extends thread class, override run() method. 
TheadExtender inst = new ThreadExtender();
inst.start();

Runnable's implementation is better as, java doesn't allow multiple inheritance. Class implementing Runnable interface will be able to extend another class. Thread class overload is excessive.
```
* __synchronized__ : keyword in java restricts multiple threads from executing the code simultaneously on the same object( i.e. same reference ).
* __Static synchronized Methods__ : two threads (same class, diff. references) above cannot simultaneously execute synchronized static method on same class, even one is calling foo & other is calling bar.
* __Synchronized Block__ : only one thread per instance can execute a synchronized block.
* __Locks(java.util.concurrent.Lock)__ : Lock can be used to synchronize access to resource by associating the resource with the lock. with lock & unlock methods every problem can be handled simply.

* Deadlock detection, when each thread is waiting for other to release resources :
  * Mutual Exclusion : Only one process can access a resource at given time.
  * Hold & Wait : Process holding a resource can request resources.
  * No Preemption : No removal of processes.
  * Circular Wait : Two processes comes into circular usage of resources.
  
---

### Disk Scheduling Algorithm & RAIDs

* Multiple I/O request comes one is served rest waits, this scheduling is done with Disk Scheduling Algorithms as hard drives are slowest . 

```
Disk Access Time = Seek Time( Time taken to locate disk arm where data is to be written/read) +
                   Rotational Latency( time taken by desired sector to reach read/write heads ) +
                   Transfer time( time taken to transfer data. depends on rotational speed of disk & bytes transferred ).
                   
Disk Response Time( average waiting time spent by a process while getting scheduled after a I/O operation ) = DAT + Disk Queuing Delay.
```

* Disk Scheduling Algorithms :
  * FCFS : Requests are served in order they arrive in. Easy to implement & involves unnecessary seek distance.
  * SSTF : Service request with shortest seek time from current position. May starve some requests & good algorithm for small list of requests.
  * Scan Algorithm : Disk start from one end & moves towards other end. It services request as it moves on & reverses its direction when hits the other end. Good for heavy loads & more fair.
    * High throughput, low variance in scheduling.
    * long waiting time.
  * Circular Scan : Similar to Scan algorithm but head reaches the other end w/o any servicing carrying out in between. Cylinders treated as circular. Waiting time more uniform near the edge of disk.
  * Look : It is enchancement to Scan with no movement towards the end of tracks. To avoid unnecessary disk operations.
  * C-Look : Look + C-Scan. Lower variance response time, but lower throughput than Look also.
  * FSCAN : freeze the queue & service only those requests at the queue at that time.
  * N-Step SCAN : Service only first 'n' requests in the queue at time.
    * Both reduces indefinent postponement.
    * Variance in response time is reduced as compared to SCAN.
  * Rotational optimacy :
    * SLTF : shortest latency( time taken by desired sector to reach read/write head ) is served first.
    * SPTF : least positioning time( seek time + rotational latency ).
    * SATF : Shortest Access time first( transfer time + position time ).
  * Cache Buffer, Disk Fragmentation, Compression, Multiple copies of frequent data, record blocking & disk arm anticipation can be used as way to decrease at I/O access operations.

__Note :__ Must Practice numericals of Disk Scheduling Algorithms.

* __Redundant Arrays of Independent Disks__, developed to avoid pending 'I/O' crisis.
    * Additional drivers used to improve data integrity, Parallel/muliple accesses. Decreases MTTF, but more disks increases more point of failure. 
* data is stored as strips which upon collection becomes stripes.    
* Description of Different RAIDs levels :

| RAID level | Description | Read Concurrency | Write Concurrency | Redundancy | Striping Level |
| --- | --- | --- | --- | --- | --- |
| 0 | Includes stripes, but no redundancy | Yes | Yes | None | Block |
| 1 | each drive mirror of another, half data is unique only | Yes | No | Mirror | None |
| 2 | Striped at bit level, Hamming ECC for integrity. Mutilple parity disks | No | No | Hamming ECC | Bit |
| 3 | Striped at bit level, XOR ECC memory. Single parity disks | No | No | XOR ECC parity | Bit/Byte |
| 4 | Stores block level parity, single write/but multiple read | Yes | No | XOR ECC parity | Block |
| 5 | Parity block distributed, removes bottleneck of level 4 | Yes | No | Distributed XOR ECC parity | Block |

* Important raid level concepts :
  * RAID level 0 + 1 : striped disks copied/mirroed to another disks.
  * RAID level 1 + 0 : set of mirrored data striped accross disks.

---

### Memory Management
* Input Queue : collection of processes on disk that are waiting to be brought into memory to run the program.
* Bindings of instructions & Data to memory in three ways :
  * Compile time : Memory location is known priori, absolute code can be generated. If modified, recompile it. Example : compiler, assembler.
  * Load time : Generate __relocatable code__ if memory location is not known at compile time. Example : linker, loaders
  * Execution time : binding delayed until runtime, address maps with base & limit registers are needed. Example : dynamic linking
* Logical Address & Physical Address : generated by CPU, virtual v/s address seen by memory unit. These addesses differ in Execution time schema.
* Memory management unit ( MMU ) : user programs deals with logical addresses it never sees, the real physical address. MMU is hardware device that maps virtual address to physical address. Relocation register is used to evaluate effective physical address.
* Dynamic Loading & Linking : In DLoading routine is not loaded until it is called by program design. In DLinking it is postponed until execution time. Stub gets replaced with actual routine with OS's help to check routine in processes memory address.
* Swapping : Process getting swapped to backing store ( large disk space ). Roll out, roll in on priority basis.
* OS related processes are kept at lower address with interrupt vector & user related at higher address. base & limit register define address partition space. Relocation scheme & register protects processes from changing each other's data.
* __Contigous Allocation__ : Hole is block of memory that is available for use by the process. Process of hole allocation involves :
  * First fit of hole that is big enough.
  * Best fit searches all the holes & minimum difference hole is selected.
  * Worst fit allocate largest hole
* __Fragmentation__ : external vs internal : total memory size is there, but not contigous vs  allocated size larger then requested, size difference is internal to partition, but not being used.
  * External fragmentation by compaction( convert to one single block ) use, only possible when relocation is dynamic & done at execution time.
 
---
 
### Paging

* Paging is a memory management scheme that eliminates the need for contiguous allocation of physical memory. This scheme permits the physical address space of a process to be non–contiguous.
    
  * Logical Address or Virtual Address (represented in bits): An address generated by the CPU
  * Logical Address Space or Virtual Address Space( represented in words or bytes): The set of all logical addresses generated by a program
  * Physical Address (represented in bits): An address actually available on memory unit
  * Physical Address Space (represented in words or bytes): The set of all physical addresses corresponding to the logical addresses
  * Divided physical space of equal size is known as frames. Size is of power of 2.
  * Logical memory blocks of same size called pages.
  * Run a program of n pages, need n free frames & load program. page table is setup for such translation.


Example:

  * If Logical Address = 31 bit, then Logical Address Space = 2^31 words = 2 G words (1 G = 2^30)
  * If Logical Address Space = 128 M words = 2^7 * 2^20 words, then Logical Address = log2(2^27) = 27 bits
  * If Physical Address = 22 bit, then Physical Address Space = 2^22 words = 4 M words (1 M = 220)
  * If Physical Address Space = 16 M words = 2^4 * 2^20 words, then Physical Address = log2(224) = 24 bits

* The mapping from virtual to physical address is done by the memory management unit (MMU) which is a hardware device and this mapping is known as paging technique.

   * The Physical Address Space is conceptually divided into a number of fixed-size blocks, called frames.
   * The Logical address Space is also splitted into fixed-size blocks, called pages.
   * Page Size = Frame Size

---

### CPU Scheduling Theory

#### Note : Must practice numericals from CPU scheduling.

* Based on multipgramming OS. CPU execution & I/O wait exist in Process Execution.
* Different definitions related to time-scheduling :
  * dispatch latency : time taken by dispatcher to stop one process & start another.
  * Throughput : number of processes executed per unit time.
  * Turnaround Time : time taken to execute a particular process.
  * Waiting Time : The time for which the process is waiting in ready queue. Take average of all processes waiting to evaluate average waiting time of an algorithm.
  * Response Time : Amount of time till which request was submitted & not single response has happened.
* Scheduling algorithms :
  * FCFS : First arrival time is served first. Average time of wait comes to be higher if shorter processes are behing long processes known as convoy effect.
  * SJF( optimal, gives minimum average waiting time ) : Burst times are used to schedule the process, with minimum burst time scheduled first & updation of burst after execution also happens.
    * Preemptive ( complete CPU burst is executed ) vs Non-Preemptive ( SRTF priority ).
  * Priority Scheduling : Smaller integer, highest priority. Can be preemptive & non-preemtive. Priority Scheduling  lead to starvation & Aging.
  * Round Robin : After each time quantam is preempted & a kept at the end of ready queue( all the processes that have arrived ). Large value of 'q' FIFO, 'q' small : must be large with respect to context switch otherwise overhead is too high. Complex numerical will have different arrival time.

---

### Real Time Operating Systems

* Terms & Definitions :
  * Release Time : Instant at which task is ready for execution.
  * Schedule Time : Time instant when task is scheduled.
  * Completion Time : Task completes an execution.
  * Deadline : time instant before which the task should get completed.
  * Runtime : after release time, time taken for completion.
  * tardiness : the time by which task misses deadline. Completion Time - Deadline.
  * Laxity : Amount of time task can wait still meat deadlines. Deadline - Computation Time.
  * Aperiodic tasks : they have irregular arrival times and either soft or hard deadlines.
  * Sporadic tasks  : two successive requests must be separated in time by at least p “time units.”
  * Offline scheduling ( future order is known ) v/s Online scheduling ( future order is not known )
  * Static Priority & Dynamic Priority :
    * Static Priority :
      * Non-preemptive
      * Preemptive
    * Dynamic Priority :
      * Planned System
      * Best Effort Algorithm
* RMA : As period increase priority decreases. __Summation(Ci/Pi) <= n(2^(1/n)-1)__ , if condition satisfied then schedulable process. 
  * Schedule in such a manner that after certain periodicity, the process does get finished beforehand. And at period start newer instance of process can get started. Schedule it process of largest period gets schedules with this algorithm.
  * In condition value is <= 1 then either process is schedulable or we cannot say anything. Summation greater than 1, inschedulable process.
* EDF( Earliest Deadline First Algorithm ) : The task for which deadline approaches near gets the highest priority as compared to the normal one.

---

### Virtual Memory

* Seperate logical space from physical memory. Logical address can be much larger > physical address. Part of process is needed to be in logical space. Allows efficient process creation. Implemented via demand paging & demand segmentation. It is mapped to physical memory via a memory map.
* Page is needed, make reference to it. If invalid reference -> abort otherwise not in memory -> bring to memory.
* Transfer of page memory upon demands happen with swap in/out of Contigous Disk Space. When some pages in demand are not in main memory i.e. blocking store is having all the pages. 
* Valid/Invalid Bit : With each page table entry valid/invalid is associated, during page-translation if this bit is 0 -> page fault.  
* Page Fault logic : first reference to such page is trapped and page fault has happened. Then valid or invalid page reference is checked. Time to get an empty frame & swap page in with it, validation bit set to 1.
```
EAT for page fault swapping with probability( p ) : (1-p)xmemory access + p*(page fault overhead + swap page out + swap page in + restart overhead )
```
* Copy On Write : both child & parent processes can initially share same pages in memory. If any of them modifies a page then only it is copied.
* Number faults becomes constant even if number of frames goes to infinity. It converges to a value.
* Page replacement algorithms discussion :
```
Initial filling of frames is also counted as page faults.

FIFO Algorithm : In FIFO replacement more frames can give more faults Belady's anomaly. Algorithm
is simply first in page will go out first.

Optimal Algorithm : Replace the page that will not be used for longest period of time. If no such
thing applicable in the end part of reference then just do FIFO.

LRU Algorithm : Maintain a stack like data structure/ or a counter with for evaluating which page
was least earlier on and replace the oldest of the pages. Stack size will be equivalent to number of
frames.

Approximation Algorithms for LRU :

Reference bit :
The page which is reference make modificaiton/referece bit as 1, & replace pages with reference bit as 0. & Follow a circular queue of pages.

Second Chance Algorithm : Associate reference bit to frames, whenever page is reference twice make reference bit as 1, this bit will be made zero when this page was supposed to get replaced because it was least recently used one but now it will get second chance, for now other least recently used page will be replaced with reference bit 0. Second chance can be given to multiple pages if more then one frames are set to 1 -> they are all set to 0. 

LFU : Replace page with minimum count in refernce string.
MFU : Replace page with maximum count in refernce string. page brought in just to be used which is having least count.So, don't replace it.

```
* Frames allocation to processes happen either in fixed manner or proportional to size of process. Global vs local replacement : process replace from all frames possible v/s selects only from allocated frmaes.
* __Thrashing :__ Not enough pages to carry out swapping, processor gets busy in swapping process. CPU utilization goes low when degree of multiprogramming decreases, thrashing starts at this point.
  * Demand paging works because of locality model. Process migrates from one locality to another.
  * Sigma ( size of locality ) > total memory size.
* Working Set Model : Delta = working-set windows. a fixed number of page references.
  * Delta value should be ideally to encompass entire locality only not process or program.
  * D = Sigma(Deltas) = total demand frames.
  * if D > m => Thrashing. Policy, is to suspend one process.

---

### Networking Basics

* Token Ring : Operate on a ring network. Employs token to gain access to transmission medium. A token controls access to transmission medium is an empty frame circulated between over a network having logical ring topology.
  * When machine owns a token, it generates data, places it in a frame & sends it to its neighbour.
  * Token ring protocol token is releases by the node, & via hops it gets delivered to end node.
* FDDI( Fiber Distributed Data Interface ) : Supports transfer at higher speeds & larger distance. Built on two token rings & second is usually reserved for backup.
* Tier Architectures :
  * Two tiers :
    * UI is on client side.
    * data resides on server side.
    * application logic lies on both these side.
  * Three tiers :
    * logic layer resides on its own layer.

---

### File System Interface


* Data needed to manage & open files :
  * File Pointer : pointer to last read/write location, per process that has open file.
  * File-open count : Counts number of times a file is open. allows removal of data from open-file table when last process closes it.
  * Disk location in file : cache of data access information.
  * Access Rights : per-process access mode information.
* File types & possible extensions :  

| file type | usual extensions | function |
| --- | --- | --- |
| executable | exe, com, bin, or none | ready-to-run machine language program |
| object | obj, o | compiled, machine language, not linked |
| source code | c, cc, java, pas, asm, a | compiled, machine language, not linked |
| batch | bat, sh | commands to command interpreter |
| text | txt, doc | text data, documents |
| word processor | wp, tex, rtf, doc | various word-processor format |
| library | lib, a, so, dll | libraries of routines for programs |
| print | ps, pdf, jpg | ASCII or binary format |
| archive | arc, zip, tar | files grouped into one |
| multimedia | mpeg, mp3, mp4 | binary files containing audio or A/V information |

* Sequential Access v/s Direct Access, read & write next are post increment in nature.
```
Sequential Access :
  read access
  write access
  reset
  no read after last write ( rewrite )

Direct Access : n = relative block number
  read n
  write n
  position to n
      read next
      write next
  rewrite n

```

* Index & Relative Files : In index file a map with logical record will exist & this number will point to actual location of the relative file which is the actual one.
* Directory is collection of nodes containing all information about all files. Tree structure being most efficient implementation.
* make, delete a file & delete a directory :
  * rm <file-name>, rm -r <dr-name>
  * mkdir <dr-name>
*  Acyclic-graph directories :
  * backpointers, using daisy chain( one stem & other branches points to files ) organizations of directories.
* General Graph Directory :
  * Allow link to files only not sub-directories.
  * Garbage Collection.
* Mounting & Unmounting of files depending upon the mount point of file systems.
* Network File Sharing system is a common distributed file sharing system.
  * User IDs, Group IDs : permissions & access rights.
  * Distributed Information Systems like DNS, LDAP( light-weight directory access ) is distributed directory system over IP, it modfied data for SPs like Active Directory.
* Access List & groups:  
  * Three classes of access OGP(Owner, Group, Public) : Example : chmod 777 FileName
  * Value for each group is specified by RWX.
  * Remember __OGP__ & __RWX__ .

--- 
#### References
* Dietel OS book.
* Operating Systems Concepts - Dinosaur Book.
  * Why Dinosaurs ?
    In 1985 when first edition was written 'OS wars' was going on. Every OS was fighting for its existance but the fittest & most adaptable ones survived. Similarly, OS needed to adapt with technology & time, a stagnant technology will lead to extinction.
---
#### Note :
* Topics related to OS will be added soon, within a week.
