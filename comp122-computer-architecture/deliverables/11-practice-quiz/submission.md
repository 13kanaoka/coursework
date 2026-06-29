# Practice Assignment for Models of Communication and Computation
---
> Name: Matthew Rohde               
> GitHub Account: thiccgin  

### Analogies
Provide an analogy that helps describe the purpose of the four layers in TCP/IP model.
   1. The four layers of TCP/IP are the physical,  <-- response -->
   2. data link, network, and transport layers.    <-- response -->
   3. The first layer is the interface, like       <-- response -->
   4. writing an email or a letter. The data link  <-- response -->
   5. is getting that letter to the post office.   <-- response -->
   6. The network layer is the post office,        <-- response -->
   7. determining the route for your letter.       <-- response -->
   8. The fourth layer is the actual transport,    <-- response -->
   9. like a delivery truck.                       <-- response -->

<!-- You may must add additional lines as needed; remember to add response tags.  -->

### Finite State Machine (FSM)
We can use a Finite State Machine (FSM) to model the interaction between the OS and your program.

On a piece of paper, 
   - draw the Process Status Diagram (PSD) on a piece of paper
   - label both it states and edges
   - take a picture your drawing
   - upload your picture to your computer
   - export your picture in PNG format with the name "PSD.png"
   - copy your "PSD.png" to this directory.<br>

  ![Process Status Diagram](PSD.png)

### ISA
An ISA is an abstraction for a physical computer.  This abstraction includes a defined set of characteristics.  Enumerate these defined characteristics.
   1. Instructions                                        <!-- response -->
   1. Data Types                                          <!-- response -->
   1. Registers                                           <!-- response -->
   1. Memory organization                                 <!-- response -->
   1. OS Interface                                        <!-- response -->

<!-- You may add additional lines as needed; remember to add response tags.  -->


### Computational Models
There are four theoretical machines that are built on top of combinational logic.  Enumerate each of these theoretical machines in the order of increasing computational power.  
   1. Finite State Machine                                <!-- response -->
   1. Pushdown Automaton                                  <!-- response -->
   1. Linear Bounded Automaton                            <!-- response -->
   1. Turing Machine                                      <!-- response -->

### Communication Models
The OSI/ISO and TCP/IP models are closely aligned, where the OSI/ISO model is more theoretical and TCP/IP is a practical implementation of a subset of the OSI/ISO model.  These two models help us to better understand how messages can be effectively sent between to computers.  Answer the following questions:

   1. At which layer is the `http` protocol associated?
      * The Application Layer - 7                         <!-- response -->

   1. At which layer is a MAC address used to name a communication end-point?
      * Data Link Layer - 2                               <!-- response -->

   1. What layer is only concerned with the mechanism to send symbols (e.g., electric impulses) over some medium.
      * Physical Layer - 1                                <!-- response -->

   1. What layer is used to support the communication that performed by a USB hub?
      * Data Link Layer - 2                               <!-- response -->

   1. What layer is used to ensure that a message that is sent is actually received by the intended receiver.
      * Transport Layer - 4                               <!-- response -->

1. What type of digit circuit introduces the notion of state?  Stated another way, what type of digit circuit is necessary to store a data value that is either a 0 or a 1?
   - Sequential Circuit                                   <!-- response -->

### Terms
Define the following terms:
   1. memory
      -                                                   <!-- response -->
   1. interrupt
      - Police car stopping you on the freeway            <!-- response -->
   1. trap
      -                                                   <!-- response -->
   1. lval
      - New value of a variable that is on the left side  <!-- response -->
      - of the equals sign.                               <!-- response -->
   1. rval
      - Value of a variable on the right side of the      <!-- response -->
      - equals sign                                       <!-- response -->
   1. kernel
      - Most important part of the OS and remains in      <!-- response -->
      - memory                                            <!-- response -->
   1. RISC
      - reduced instruction set computer                  <!-- response -->
   1. CISC
      - complex instruction set computer                  <!-- response -->

### MIPS Instrucitons
Provide the MIPS instruction that is equivalent to the following Java statements (which are written in TAC style).
   * $v0 = $v0 + $a0;          
     - value in $v0 is added to value in $a0 and replaces <!-- response -->
     - $v0                                                <!-- response -->
   * $v0 = $v0 + 4;
     - Value in $v0 is added to 4 and replaces $v0 value  <!-- response -->
   * $t0 = 1;
     - stores value 1 in the $t0 register                 <!-- response -->
   * $t8 = $s2
     - The value being held by saved register $s2 is      <!-- response -->
     - loaded into temporary register $t8                 <!-- response -->

### Abstract Model
Explain why the MIPS microarchitecture is a physical implementation of the Harvard abstract model as opposed to the von Neumann abstract model.
  > MIPS uses separate memory spaces for its instructions <!-- response -->
  > and data, and they can be accessed simultaneously.    <!-- response -->
  <!-- You many use as many of lines as you want.  Make sure each line has the response tag at the end. -->


### Sequential Circuit versus Combinational Circuit
Briefly describe the difference between a Sequential circuit and a Combinational Circuit.

   ```response
   Sequential Circuits depend on clock cycles and depends on both current and past inputs. Combinational circuits do not depend on clock cycles
   and do not use past inputs.
   ```
   <!-- You may add additional lines within the code block above, without the need to add additional response tag. -->


### Universal Computer
A 'Universal Computer' is an abstract machine based upon the Turing Machine.  This computer has a standardized control program to manage the underlying finite state machine. (This control program is akin to the computer firmware).  

Two other programs are placed on the tape.  What are these two other programs:
  1. Input Program                                        <!-- response -->
  1. Transition Function                                  <!-- response -->


### PDA
A Pushdown Automata (PDA) has more computational power than a Finite State Machine (FSM). What is the difference between the PDA and and FSM that provides the PDA with this additional power?
   1. As stated in the name, FSM has a finite number of   <!-- response -->
   1. states and can't hold much information. The PDA can,<!-- response -->
   1. however, due to it having access to a stack.        <!-- response -->


### Memory
Memory can be modeled as an array of bytes.  A register on the MIPS architecture contains 32 bits.  What role does endiance play when we execute an instruction to load a register with values stored within memory.
   ```response
   It makes sure that the values are read properly and loaded in proper order and accurately.         
   ```

### Memory Access
Given the following configuration of memory, answer the following questions:
   1. What is the value stored in memory at location `0x0100 0002`: 
      - 54                                                <!-- response -->
   1. What is the label associated with location `0x0100 0009` in memory
      - D                                                 <!-- response -->
   1. What is the lval associated with `B`:  
      - 3                                                 <!-- response -->
   1. What is the rval associated with `B`:
      - 3                                                 <!-- response -->
   1. What is the rval associated with `C[3]`:
      - 5                                                 <!-- response -->
   1. What is the lval associated with `C[3]`:
      - 5                                                 <!-- response -->

|     | mem |              |
|-----|-----|--------------|
|     | 253 |  0x0100 000A |
| D:  |  42 |  0x0100 0009 |
|     |   0 |  0x0100 0008 |
|     |   1 |  0x0100 0007 |
|     |   2 |  0x0100 0006 |
| C:  |   3 |  0x0100 0005 |
|     |  77 |  0x0100 0004 |
| B:  | 202 |  0x0100 0003 |
|     |  54 |  0x0100 0002 |
| A:  | 123 |  0x0100 0001 |



