# Quiz #3: Digital Logic 
> Released: Dec 6 17:00 PST
> Time limit: 2 hours
> Due: Dec 8 23:59 PST
> This an open notes quiz

---

### Name: {name}  
### GitHub Account: {account}

### Five Elements of an ISA
* What are the five (5) elements that are defined by an ISA?<br>
   1.                                             <!-- response -->
   2.                                             <!-- response -->
   3.                                             <!-- response -->
   4.                                             <!-- response -->
   5.                                             <!-- response -->



### Pipeline Architecture Stages
* The MIPS MicroArchitecture is an example of a pipeline architecture that executes each instruction via a series of stages.  Enumerate and describe briefly what each of these stages do:
   1.                                                                    <!-- response -->
   1.                                                                    <!-- response -->
   <!-- Feel free to add or remove additional response lines as needed. -->
 


### Signed Extension
* The MIPS I-format includes a 16-bit field, which is used to encode an immediate value.  During the "Instruction Decode" cycle this 16-bit value is transformed into a 32-bit value.  For each of the following values, provide 16-bit value that is stored in the instruction and the 32-bit value that is passed to the ALU.
   1. 0x4E0F:  
      * 16-bit value: 2#                     xxxx xxxx xxxx xxxx      <!-- response -->
      * 32-bit value: 2# xxxx xxxx xxxx xxxx xxxx xxxx xxxx xxxx      <!-- response -->
   1. 0xA0AA:  
      * 16-bit value: 2#                     xxxx xxxx xxxx xxxx      <!-- response -->
      * 32-bit value: 2# xxxx xxxx xxxx xxxx xxxx xxxx xxxx xxxx      <!-- response -->
   1. -8:                
      * 16-bit value: 2#                     xxxx xxxx xxxx xxxx      <!-- response -->
      * 32-bit value: 2# xxxx xxxx xxxx xxxx xxxx xxxx xxxx xxxx      <!-- response -->
   1. 5:                   
      * 16-bit value: 2#                     xxxx xxxx xxxx xxxx      <!-- response -->
      * 32-bit value: 2# xxxx xxxx xxxx xxxx xxxx xxxx xxxx xxxx      <!-- response -->


### Combinational versus Sequential Circuit
* Explain the primary difference between a combinational and a sequential circuit.
  ```response 


  ```


### Boolean Expressions
* Given the following truth table, provide the equivalent Boolean expression:
   *                                              <!-- response -->

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
   |   |   | BC <br> xx | BC <br> xx | BC <br> xx | BC <br> xx | 
   |---|---| -----------| ---------- | ---------- | ---------- | 
   | x | x |     x      |     x      |     x      |     x      | 
   | x | x |     x      |     x      |     x      |     x      | 


### Algebraic Simplification
* Proved the steps to show that `C'(B'C + 1) + A(BC' + ABC')` is equivalent to `C'`.
  ```response  C'(B'C + 1) + A(BC' + ABC') == C'
  C'(B'C + 1) + A(BC' + ABC')     : given        
  C'(1)  + A(BC' + ABC')          : annulment

  ```


### Models of Computation
There are a number of different types of machines, each with a different level of computational power. The Turning machine is equivalent to a Recursively Enumerable Language.  Complete the following statements:

* The most power machine is the {machine}.        <!-- response -->
* Any function can be evaluated using {language}. <!-- response -->
* We can model a process via the PSD, which is an example of a {machine}.   <!-- response -->



