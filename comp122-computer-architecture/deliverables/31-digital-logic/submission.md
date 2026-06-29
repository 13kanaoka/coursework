# Digital Logic 
> A practice exercise to prepare for the the Digital Logic Section's quiz.  


## Name: Matthew Rohde
## GitHub Account: thiccgin

### Boolean Algebra
1. Given the following circuit, provide the equivalent Boolean expression:
   * S = A ⊕ B, C = A * B                      <!-- response -->
   ![circuit](circuit.png)

 
1. Given the following truth table, provide the equivalent Boolean expression:
   * A'B'C + A'BC' + AB'C' + AB'C + ABC'       <!-- response -->
   * B ⊕ C + AB'C' (simplified)                <!-- response -->


   | A  | B  | C | Output |
   |----|----|---|------- |
   | 0  | 0  | 0 | 0      |
   | 0  | 0  | 1 | 1      |
   | 0  | 1  | 0 | 1      |
   | 0  | 1  | 1 | 0      |
   | 1  | 0  | 0 | 1      |
   | 1  | 0  | 1 | 1      |
   | 1  | 1  | 0 | 1      |
   | 1  | 1  | 1 | 0      |

1. Convert the following truth table into a Karnaugh map.<br>
   (Make sure you update all of the x-s in the answer template.)
   
   | A  | B  | C | Output |
   |----|----|---|--------|
   | 0  | 0  | 0 |   0    |
   | 0  | 0  | 1 |   1    |
   | 0  | 1  | 0 |   1    |
   | 0  | 1  | 1 |   0    |
   | 1  | 0  | 0 |   1    |
   | 1  | 0  | 1 |   1    |
   | 1  | 1  | 0 |   1    |
   | 1  | 1  | 1 |   1    |

   <!-- Updated the table below to provide your answer -->

   |   |   | BC | BC | BC | BC | 
   |   |   | 00 | 01 | 11 | 10 | 
   |---|---| -- | -- | -- | -- | 
   | A | 0 | 0  | 1  | 0  | 1  | 
   | A | 1 | 1  | 1  | 1  | 1  | 


1. Simplify the following Boolean expressions:<br>
   1. ``A * ( B + C) + A' * ( B + C) ``
      * B + C                     <!-- response -->

   1. ``AB' + A'B + AB``
      * A + A'B                   <!-- response -->

   1. ``(AB' + A'B + AB)'``
      * A'B'                      <!-- response -->


1. You are provided with a truth table. By what method can you use to determine the equivalent Boolean algebra expression. (Your answer needs to be provided by a simple sentence.)
   ```
   Find which outputs == 1 and plug the preceding inputs into the Sum of Products property  <!-- response -->
   ```

<!-- For the next two questions, you need not include the response tags -->
1. Update the following Karnaugh map by replacing the x's to provide the missing labeling information.

   |   |   | BC <br> 00 | BC <br> 01 | BC <br> 11 | BC <br> 10 |   
   |---|---| -----------|------------|------------|------------|   
   | A | 0 |         1  |         0  |         0  |         1  |   
   | A | 1 |         1  |         0  |         1  |         1  |   


1. For the Karnaugh map in the previous question, provide the equivalent truth table.
   
   | A | B | C | Output |
   |---|---|---|--------|
   | 0 | 0 | 0 |   1    |
   | 0 | 0 | 1 |   0    |
   | 0 | 1 | 0 |   1    |
   | 0 | 1 | 1 |   0    |
   | 1 | 0 | 0 |   1    |
   | 1 | 0 | 1 |   0    |
   | 1 | 1 | 0 |   1    |
   | 1 | 1 | 1 |   1    |

1. Using the above Karnaugh map, provide the equivalent Boolean expressions.
   * B'C' + BC' + ABC                             <!-- response -->
   * C' + ABC         (simplified)                <!-- response -->

1. Using the above truth table, provide the equivalent Boolean expression. Do NOT take steps to simplify the resulting Boolean expression.
   * A'B'C' + AB'C + A'BC + A'B'C + A'B'C'        <!-- response -->


1. Provide an example for each of the following Boolean algebra properties.

   *  associative property:  
      - `(A + B) + C == A + (B + C)`              <!-- response -->
   *  idempotent:
      - `A + A == A`                              <!-- response -->
   *  absorption property:  
      - A + AB == A                               <!-- response -->
   *  commutative property:  
      - A + B == B + A                            <!-- response -->
   *  distributive property:  
      - (A + B)(A + C) = A + BC                   <!-- response -->
   *  identity property:
      - A + 0 == A                                <!-- response -->
   *  definition of XOR:
      - A'B + AB' == A ⊕ B                        <!-- response -->
   *  annulment:
      - A + 1 == 1                                <!-- response -->
   *  complement:
      - A + A' == 1                               <!-- response -->



1. Show the steps to show that `C'(B'C + ABC') + A(BC' + 1)` is equivalent to `A`.
   *  C'(B'C + ABC') + A(BC' + 1)  : given        <!-- response -->
   *  C'(B'C + ABC') + A                          <!-- response -->
   *  (C'B'C + C'ABC') + A                        <!-- response -->
   *  (0 + C'ABC') + A                            <!-- response -->
   *  C'ABC' + A                                  <!-- response -->
   *  A(C'BC' + 1)                                <!-- response -->
   *  A * 1                                       <!-- response -->
   *  A                                           <!-- response -->
   <!-- Add or Delete response lines above as necessary -->



### Circuits

1. You are given a SR latch that is storing the value of 1. You then provide the following values for inputs:  E=1, S=1, and R=1.  What is the final value for Q(t+1) and for Q(t+1)' ?
   * Q(t+1) :  invalid                            <!-- response -->
   * Q(t+1)':  invalid                            <!-- response -->


![RS Latch](RS_latch.png)

1. You are asked to build a register bank. Identify which of the following digital components you need. (To answer this question, simply remove the digital components your don't need.)
   * Encoder                                      <!-- response -->
   * Decoder                                      <!-- response -->
   * ALU                                          <!-- response -->
   * Multiplexer                                  <!-- response -->
   * Latch                                        <!-- response -->
   * FlipFlop                                     <!-- response -->

       
1. Can all programs be computed via a combinational circuit, yes or no?
   * No                                           <!-- response -->
   * Explain your answer:<br>
     ```response
     A combinational circuit is the lowest power form of computer, written in boolean algebra. A turing machine, the most powerful, can compute anything computable.                                                    <!-- response -->
     ```

1. What is the difference between a control line and a data line?   <!-- response -->
   * They are similar in that they both are just wires carrying     <!-- response -->
   * electricity. The values they carry differ slightly as control  <!-- response -->
   * lines hold onto the clock and control while data lines hold    <!-- response -->
   * instructions.                                                  <!-- response -->

1. You have been asked to produce a combinational circuit that can select exactly 1 output from 16 different possible inputs.
   1. What basic combinational circuit should be used?
      * Multiplexer                               <!-- response -->
   1. How many selector lines will this circuit have?
      * 4                                         <!-- response -->

1. You have a CPU that has 120 registers. (Yes, 120 registers!)
   1. How many selector lines are included in this circuit
      * 7                                         <!-- response -->

1. Consider the following circuit

   ![what is it?](whatisit.png)

   1. What is the type of this circuit?
      * 2 to 4 line decoder                      <!-- response -->

1. You are provided with a 5-32 Decoder.
   1. What is the role of the "E"nable line?
      * The enable lines decides if the decoder  <!-- response -->
      * runs (1) or becomes inactive (0)         <!-- response -->

   3. What is the total number of inputs to this circuit?
      * 6                                        <!-- response -->

   5. What is the total number of outputs from this circuit?
      * 32                                       <!-- response -->


1. Explain the primary difference between a combinational and a sequential circuit.
   * combinational has no memory but is fase, sequential <!-- response -->
   * has memory (remembers past inputs) but is slower    <!-- response -->

2. What is the primary difference between a SR-latch and a D-latch?
   * SR-latch has S and R inputs that cause an invalid   <!-- response -->
   * state when both are 1. D latch has only one input.  <!-- response -->

### Microarchitecture

1. A CPU is an example of a sequential circuit, where different parts of the circuit is executed in well defined steps.  Answer the following questions related to such a sequential circuit.
   1. For the MIPS microarchitcture, enumerate and describe briefly what each of these steps does:
      1. Fetch: PC is incremented by 4, and the next instruction is read from main memory.  <!-- response -->
      1. Decode: fetched instruction is decoded, registers/values are read                  <!-- response -->
      1. Execute: The ALU completes the specified operation                                 <!-- response -->
      1. Memory: Load or store instructions are read and completed                          <!-- response -->
      1. Write-back: the result of the operation is written to registers                    <!-- response -->

      <!-- Feel free to add or remove additional response lines as needed. -->
 
   1. anWhat type of digital component is used between each of these steps?
      *                                          <!-- response -->
 
   1. Why is the value of the PC incremented by 4 in each "fetch" stage?  
      * MIPS instructions are 32 bits long and so each                                      <!-- response -->
      * increment is pointing to the next location in memory                                <!-- response -->

1. What are the five (5) elements that are defined by an ISA?<br>
   1.                                             <!-- response -->

   <!-- Add additional response lines as needed -->


1. In the MIPS micro-architecture, the PC is incremented for each instruction, during the "Instruction Fetch" stage.  The value of the PC may also be updated later within the "Memory Access" phase.

   * If the value of the PC is: 0x0000 2F1C, what is the value of the PC after you complete the execution of the instruction:  ``addi $t0, $s0, $ra``?
      *                                           <!-- response -->

1. The MIPS I-format includes a 16-bit field, which is used to encode an immediate value.  During the "Instruction Decode" phase this 16-bit value is transformed into a 32-bit value.  For each of the following values, provide 16-bit value that is stored in the instruction and the 32-bit value that is passed to the ALU.
   * 0x7FF7:  
     * 16-bit value:                              <!-- response -->
     * 32-bit value:                              <!-- response -->
   * 0xAAAA:  
     * 16-bit value:                              <!-- response -->
     * 32-bit value:                              <!-- response -->
   * -2:                
     * 16-bit value:                              <!-- response -->
     * 32-bit value:                              <!-- response -->
   * 7:                   
     * 16-bit value:                              <!-- response -->
     * 32-bit value:                              <!-- response -->




