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
    * 

--- 
#### References
* Dietel OS book.
* Operating Systems Concepts - Dinosaur Book.
  * Why Dinosaurs ?
    In 1985 when first edition was written 'OS wars' was going on. Every OS was fighting for its existance but the fittest & most adaptable ones survived. Similarly, OS needed to adapt with technology & time, a stagnant technology will lead to extinction.
---
#### Note :
* Topics related to OS will be added soon, within a week.
