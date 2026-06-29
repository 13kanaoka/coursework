# Quiz: Models of Communication and Computation
Released: at  6:00 pm on Sept 27 (Friday)
Closed:   at 11:59 pm on Sept 29 (Sunday)

Timelimit: 60 minutes
  - time starts when you accepted the assignment
  - you are responsible for timing yourself.


Notes: 
  1. This is an open resource quiz.  That is to see you may review your notes, my notes, and the slides associated with COMP122.

  1. You *MUST* follow the process associated with an MD assignment. This process is explained in  the README.md file.


---
> Name: {name}               
> GitHub Account: {account}  


## Universal Computer
What are the $N$ characteristics of a Universal Computer that differentiates it from a Turing machine

   1.                                                                      <!-- response -->
   1.                                                                      <!-- response -->

## FA
The Process Status Diagram (PSD) is a specific Finite State Machine that models the execute flow of a process.  During it's lifetime a process goes through a number of states. Enumerate the names of each of these states and briefly describe something purpose of the state.

   1. New: the process is created, and waits to be added to the system.     <!-- response -->
   1.                                                                       <!-- response -->


## PDA

A Pushdown Automata (PDA) has more computational power than a Finite State Machine (FSM). What is the difference between the PDA and and FSM that provides the PDA with this additional power?

  ```response

  ```

## User Memory
   The memory of a physical machine can be organized in many ways. For the MIPS architecture, the ISA defines this organization. More specifically, the user space is divided into 4 segments. 

   Briefly, name and describe the purpose of these 4 segments.

   1.                                                                       <!-- response -->


## Registers
   The ISA for the MIPS architecture defines the number, size and purpose of its registers.
   For each of the following MIPS registers indicate their purpose:

   1.  `$v0`:                                                  <!-- response -->
   1.  `$sp`:                                                  <!-- response -->
   1.  `$zero`:                                                <!-- response -->
   1.  `$a2`:                                                  <!-- response -->
   1.  `$t4`:                                                  <!-- response -->



### Memory Access
At the physical layer, memory is an index array of bytes. At the ISA layer, however, memory can be views as an associative array of byte.  Given the following configuration of memory, answer the following questions:

   1. What is the value stored in memory at location `0x0100 000A`: 
      -                                                   <!-- response -->
   1. What is the label associated with location `0x0100 0005` in memory
      -                                                   <!-- response -->
   1. What is the lval associated with `B`:  
      -                                                   <!-- response -->
   1. What is the rval associated with `B`:
      -                                                   <!-- response -->
   1. What is the rval associated with `D[0]`:
      -                                                   <!-- response -->
   1. What is the rval associated with `A[3]`:
      -                                                   <!-- response -->
   1. What is the lval associated with `A[-3]`:
      -                                                   <!-- response -->

|     | mem |              |
|-----|-----|--------------|
|     | 253 |  0x0100 000A |
| C:  |  42 |  0x0100 0009 |
|     |   0 |  0x0100 0008 |
| A:  |   1 |  0x0100 0007 |
|     |   2 |  0x0100 0006 |
| D:  |   3 |  0x0100 0005 |
|     |  77 |  0x0100 0004 |
| B:  | 202 |  0x0100 0003 |
|     |  54 |  0x0100 0002 |
|     | 123 |  0x0100 0001 |



