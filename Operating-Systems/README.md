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
#### References
* Dietel OS book.
* Operating Systems Concepts - Dinosaur Book.
  * Why Dinosaurs ?
    In 1985 when first edition was written 'OS wars' was going on. Every OS was fighting for its existance but the fittest & most adaptable ones survived. Similarly, OS needed to adapt with technology & time, a stagnant technology will lead to extinction.
---
#### Note :
* Topics related to OS will be added soon, within a week.
