# Quiz #3: Digital Logic 
> Released: Dec 6 17:00 PST
> Time limit: 2 hours
> Due: Dec 8 23:59 PST
> This an open notes quiz

---

### Name: Matthew Rohde 
### GitHub Account: thiccgin

### Five Elements of an ISA
* What are the five (5) elements that are defined by an ISA?<br>
   1. Instructions                                <!-- response -->
   2. Data Types                                  <!-- response -->
   3. Registers                                   <!-- response -->
   4. Memory Organization                         <!-- response -->
   5. OS Interface                                <!-- response -->



### Pipeline Architecture Stages
* The MIPS MicroArchitecture is an example of a pipeline architecture that executes each instruction via a series of stages.  Enumerate and describe briefly what each of these stages do:
   1. Stage 1: IF - Instruction Fetch:                                   <!-- response -->
      - fetches an instruction from memory                               <!-- response -->

   1. Stage 2: ID - Instruction Decode:                                  <!-- response -->
      - decodes fetched instruction for execution                        <!-- response -->

   1. Stage 3: EX - Execute:                                             <!-- response -->
      - instruction reaches ALU -> mathematical operations are performed <!-- response -->

   1. Stage 4: MEM - Memory access:                                      <!-- response -->
      - performs load and store instructions                             <!-- response -->

   1. Stage 5: WB - Write back:                                          <!-- response -->
      - Results are written to register                                  <!-- response -->
   <!-- Feel free to add or remove additional response lines as needed. -->
 


### Signed Extension
* The MIPS I-format includes a 16-bit field, which is used to encode an immediate value.  During the "Instruction Decode" cycle this 16-bit value is transformed into a 32-bit value.  For each of the following values, provide 16-bit value that is stored in the instruction and the 32-bit value that is passed to the ALU.
   1. 0x4E0F:  
      * 16-bit value: 2#                     0100 1110 0000 1111      <!-- response -->
      * 32-bit value: 2# 0000 0000 0000 0000 0100 1110 0000 1111      <!-- response -->
   1. 0xA0AA:  
      * 16-bit value: 2#                     1010 0000 1010 1010      <!-- response -->
      * 32-bit value: 2# 1111 1111 1111 1111 1010 0000 1010 1010      <!-- response -->
   1. -8:                
      * 16-bit value: 2#                     1111 1111 1111 1000      <!-- response -->
      * 32-bit value: 2# 1111 1111 1111 1111 1111 1111 1111 1000      <!-- response -->
   1. 5:                   
      * 16-bit value: 2#                     0000 0000 0000 0101      <!-- response -->
      * 32-bit value: 2# 0000 0000 0000 0000 0000 0000 0000 0101      <!-- response -->


### Combinational versus Sequential Circuit
* Explain the primary difference between a combinational and a sequential circuit.
  ```response 
  Combinational circuits have no memory and run solely on current inputs whereas sequential circuits have a memory component and store previous inputs and outputs.
  ```


### Boolean Expressions
* Given the following truth table, provide the equivalent Boolean expression:
   * A'B'C' + AB'C + ABC'                         <!-- response -->

   | A  | B  | C  | Output|
   |----|----|----|-------|
   | 0  | 0  | 0  |   1   |
   | 0  | 0  | 1  |   0   |
   | 0  | 1  | 0  |   0   |
   | 0  | 1  | 1  |   0   |
   | 1  | 0  | 0  |   0   |
   | 1  | 0  | 1  |   1   |
   | 1  | 1  | 0  |   1   |
   | 1  | 1  | 1  |   0   |

### Karnaugh map
* Convert the following truth table into a Karnaugh map.<br>
   (Make sure you update all of the x-s in the answer template.)
   
   | A  | B  | C  | Output |
   |----|----|----|--------|
   | 0  | 0  | 0  |   0    |
   | 0  | 0  | 1  |   0    |
   | 0  | 1  | 0  |   1    |
   | 0  | 1  | 1  |   0    |
   | 1  | 0  | 0  |   1    |
   | 1  | 0  | 1  |   1    |
   | 1  | 1  | 0  |   1    |
   | 1  | 1  | 1  |   1    |

   <!-- Updated the table below to provide your answer -->
   |   |   | BC <br> 00 | BC <br> 01 | BC <br> 11 | BC <br> 10 | 
   |---|---| -----------| ---------- | ---------- | ---------- | 
   | A | 0 |     0      |     0      |     0      |     1      | 
   | A | 1 |     1      |     1      |     1      |     1      | 


### Algebraic Simplification
* Proved the steps to show that `C'(B'C + 1) + A(BC' + ABC')` is equivalent to `C'`.
  ```response  C'(B'C + 1) + A(BC' + ABC') == C'
  C'(B'C + 1) + A(BC' + ABC')     : given        
  C'(1)  + A(BC' + ABC')          : annulment
  C' + A( BC' + ABC' )            : identity
  C' + A( BC'(1 + A) )            : factor
  C' + A( BC'(1) )                : annulment
  C' + A( BC' )                   : identity
  C' + ABC'                       : associative
  C'                              : absorption
  ```

### Models of Computation
There are a number of different types of machines, each with a different level of computational power. The Turning machine is equivalent to a Recursively Enumerable Language.  Complete the following statements:

* The most power machine is the Turing Machine.                                        <!-- response -->
* Any function can be evaluated using a Recursively Enumerable language.               <!-- response -->
* We can model a process via the PSD, which is an example of a Finite State Machine.   <!-- response -->



