# Base Conversion and Floating Point Representation

> Name: {name}             
> GitHub Account: {account}

## Problems:


### Scientific Notation Representation
Represent each number in Scientific Notation:
  1. 2# - 10010.11001
     >                                                   <!-- response -->

  1. 8#  0.00034237
     >                                                   <!-- response -->

  1. 16#  4E1.212
     >                                                   <!-- response -->

### Converting from Scientific Notation
Represent each number in normal form:

1. -1.010010010  x 2^ 101
   >                                                     <!-- response -->

1. 4.34 x 8^ -3
   >                                                     <!-- response -->

1. 1.ABC2 x 16^ 3
   >                                                     <!-- response -->
 

### Base Conversion of Real Numbers
Represent each of the following numbers as a binary real.  <br>
(Yes, it is really that simple!)

  1. 8# 0.00434  
     >                                                    <!-- response -->

  1. 16#  1ABC.2 
     >                                                    <!-- response -->
  

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
     *                                                    <!-- response -->
 
  1. Scientific Notation: 
     *                                                    <!-- response -->

  1. IEEE Binary16:
     * | x | x xxxx | xxxx xxxx xx |                     
     *                                                    <!-- response -->
     *                                                    <!-- response -->

  1. IEEE Binary32:
     * | x | xxxx xxxx | xxxx xxxx xxxx xxxx xxxx xxx |
     *                                                    <!-- response -->
     *                                                    <!-- response -->

### 16#  1AB.C2 
  1. Base 2: 
     *                                                    <!-- response -->
 
  1. Scientific Notation: 
     *                                                    <!-- response -->

  1. IEEE Binary16:
     * | x | x xxxx | xxxx xxxx xx |                     
     *                                                    <!-- response -->
     *                                                    <!-- response -->

  1. IEEE Binary32:
     * | x | xxxx xxxx | xxxx xxxx xxxx xxxx xxxx xxx |
     *                                                    <!-- response -->
     *                                                    <!-- response -->


### 16#  - 242.324345
  1. Base 2: 
     *                                                    <!-- response -->
 
  1. Scientific Notation:             
     *                                                    <!-- response -->

  1. IEEE Binary16:
     * | x | x xxxx | xxxx xxxx xx |                     
     *                                                    <!-- response -->
     *                                                    <!-- response -->

  1. IEEE Binary32:
     * | x | xxxx xxxx | xxxx xxxx xxxx xxxx xxxx xxx |
     *                                                    <!-- response -->
     *

### 8#  - 342.324345674 

  1. Base 2: 
     *                                                    <!-- response -->
 
  1. Scientific Notation: 
     *                                                    <!-- response -->

  1. IEEE Binary16:
     * | x | x xxxx | xxxx xxxx xx |                     
     *                                                    <!-- response -->
     *                                                    <!-- response -->

  1. IEEE Binary32:
     * | x | xxxx xxxx | xxxx xxxx xxxx xxxx xxxx xxx |
     *                                                    <!-- response -->
     *                                                    <!-- response -->

## Resources: 
   * [Encoding to Float](encode_float.md)

