# Base Conversion and Floating Point Representation

> Name: Matthew Rohde             
> GitHub Account: thiccgin

## Problems:


### Scientific Notation Representation
Represent each number in Scientific Notation:
  1. 2# - 10010.11001
     > -1.001011001 x 2^ 100                              <!-- response -->

  1. 8#  0.00034237
     > 3.4237 x 8^ -100                                   <!-- response -->

  1. 16#  4E1.212
     > 4.E1212 x 16^ 0010                                 <!-- response -->

### Converting from Scientific Notation
Represent each number in normal form:

1. -1.010010010  x 2^ 101
   > 2# -101001.0010                                      <!-- response -->

1. 4.34 x 8^ -3
   > 8# 0.00434                                           <!-- response -->

1. 1.ABC2 x 16^ 3
   > 16# 1ABC.2                                           <!-- response -->
 

### Base Conversion of Real Numbers
Represent each of the following numbers as a binary real.  <br>
(Yes, it is really that simple!)

  1. 8# 0.00434  
     > 000 . 000 000 100 011 100                          <!-- response -->
         0     0   0   4   3   4                          <!-- response -->

  1. 16#  1ABC.2 
     > 0001 1010 1011 1100 . 0010                         <!-- response -->
          1    A    B    C      2                         <!-- response --> 

### Floating Point Representation
For each of the problem, perform the following steps:
  * Convert the number (as necessary) to a binary real
  * Represent the number in Scientific Notation (using base 2)
  * Represent the number in IEEE binary16 format
  * Represent the number in IEEE binary32 format

Note: you may use the following conversion calculator
  * https://www.csun.edu/~steve/classes/integers-conversion-encoding/integer-conversion.html


#### 8# 645.27  
For Example:

  1. Base 2: 
     * 110 100 101 . 010 111                              <!-- response --> 

  1. Scientific Notation: 
     * 2# 1.10 100 101 010 111 x 2^ 1000  // 8            <!-- response --> 

  1. IEEE Binary16: 
     * | x | x xxxx | xxxx xxxx xx |                     
     * | 0 | 1 0111 | 1010 0101 01 |                      <!-- response --> 
     * 8 + 15 = 23 -> 1 0111                              <!-- response -->

  1. IEEE Binary32:
     * | x | xxxx xxxx | xxxx xxxx xxxx xxxx xxxx xxx |
     * | 0 | 1000 0111 | 1010 0101 0101 1100 0000 000 |   <!-- response -->
     * 8 + 127 = 135 -> 1000 0111                         <!-- response -->


### 2#  - 0.000000101010  
  1. Base 2: 
     * - 0.000000101010                                   <!-- response -->
 
  1. Scientific Notation: 
     * - 1.01010 x 2^ -0111  // 7                         <!-- response -->

  1. IEEE Binary16:
     * | x | x xxxx | xxxx xxxx xx |                     
     * | 1 | 1 0010 | 0101 0000 00 |                      <!-- response -->
     * 7 + 15 = 22 --> 1 0010                             <!-- response -->

  1. IEEE Binary32:
     * | x | xxxx xxxx | xxxx xxxx xxxx xxxx xxxx xxx |
     * | 1 | 1000 0110 | 0101 0000 0000 0000 0000 000 |   <!-- response -->
     * 7 + 127 = 134 --> 1000 0110                        <!-- response -->

### 16#  1AB.C2 
  1. Base 2: 
     * 0001 1010 1011 . 1100 0010                         <!-- response -->
 
  1. Scientific Notation: 
     * 0.001 1010 1011 1100 0010 x 2^ ??  // 11           <!-- response -->

  1. IEEE Binary16:
     * | x | x xxxx | xxxx xxxx xx |                     
     * | 0 | 1 0110 | 0011 0101 01 |                      <!-- response -->
     * 11 + 15 = 26 --> 1 0110                            <!-- response -->

  1. IEEE Binary32:
     * | x | xxxx xxxx | xxxx xxxx xxxx xxxx xxxx xxx |
     * | 0 | 1000 1010 | 0011 0101 0111 1000 0100 000 |   <!-- response -->
     * 11 + 127 = 1000 1010                               <!-- response -->


### 16#  - 242.324345
  1. Base 2: 
     * - 0010 0100 0010 . 0011 0010 0100 0011 0100 0101   <!-- response -->
       1    2    4    2      3    2    4    3    4    5   <!-- response -->
 
  1. Scientific Notation:             
     * - 0.01001000010001100100100001101000101 x 2^ ? //11<!-- response -->

  1. IEEE Binary16:
     * | 1 | x xxxx | xxxx xxxx xx |                     
     * | 1 | 1 0110 | 0100 1000 01 |                      <!-- response -->
     * 11 + 15 = 26 --> 1 0110                            <!-- response -->

  1. IEEE Binary32:
     * | x | xxxx xxxx | xxxx xxxx xxxx xxxx xxxx xxx |
     * | 1 | 1000 1010 | 0100 1000 0100 0110 0100 100 |   <!-- response -->
     * 11 + 127 = 138 --> 1000 1010                       <!-- response -->

### 8#  - 342.324345674 

  1. Base 2: 
     * - 011 100 010 . 011 010 100 011 100 101 110 111 100<!-- response -->
           3   4   2 .   3   2   4   3   4   5   6   7   4<!-- response -->
 
  1. Scientific Notation: 
     * - 0.11100010011010100011100101110111100 x 2^ ? // 8<!-- response -->

  1. IEEE Binary16:
     * | x | x xxxx | xxxx xxxx xx |                     
     * | 1 | 1 0011 | 1110 0010 01 |                      <!-- response -->
     * 8 + 15 = 23 --> 1 0011                             <!-- response -->

  1. IEEE Binary32:
     * | x | xxxx xxxx | xxxx xxxx xxxx xxxx xxxx xxx |
     * | 1 | 1000 0111 | 1110 0010 0110 1010 0011 100 |   <!-- response -->
     * 8 + 127 = 135 --> 1000 0111                        <!-- response -->

## Resources: 
   * [Encoding to Float](encode_float.md)

