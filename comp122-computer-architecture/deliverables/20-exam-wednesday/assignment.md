# Exam #2: Formats and Encodings
Date: Nov 20 & Nov 21, 2024
Time:
  - Monday: 10:00 - 11:15
  - Tuesday: 10:00 - 11:15

Version: VHVlc2RheTogMTI6MDAK

---
### Name: {name}
### GitHub Account: {account}

Directions:
You have already copied this file (assignment.md) to a file called "submission.md".  Take steps to commit and push your work regularly. (You never know when a technical issue might arise that prevents you from doing so.)

Note that the bias for binary32 is 127 (2# 0111 1111).

You should also take care to format all you answers so that they are easy to understand, etc.  Add appropriate spacing, use appropriate punctuation for clarity, remove or add response lines as needed. Note that the curtly brace notation (e.g., {answer}) have been placed in text to highlight where your answers should be placed. That is to say, you need to replace these notations with your response.

Your final submission MUST be professionally presentable when viewed via the Sublime Text editor and a markdown viewer. 

Remember to follow the process, i.e., the md assignment workflow. 


#### Conversion between Powers of 2

  - Convert the following numbers to the identified associated base: 
    1. 8# 2556   == {hex}                                 <!-- response -->
    1. 16# FADE  == {octal}                               <!-- response -->
    1. 4# 3333   == {binary}                              <!-- response -->


#### Convert the `10# 0.2025` into a binary number that contains at most 5 binary digits. 
  - Show your work--you will not get credit otherwise!

  ```response
  number =  
  max    =  


  answer:  2#  
  ```

#### Convert  `10# 123` into a binary number. 
  - Show your work--you will not get credit otherwise!

  ```response
  number =  


  answer: 2# 
  ```

#### Floating Point
The following binary string purports to represent a floating point number encoded as a binary32.

  ```text
  1100 0100 0011 1011 0110 1110 1010 1111 
  ```

  1. How many fields are there in the binary32 encoding?
     * number: {value}                                  <!-- response -->

  1. Enumerate the names of these fields from left to right
     * {field-name}                                     <!-- response -->
     * {field-name}                                     <!-- response -->
     * {field-name}                                     <!-- response -->
     * {field-name}                                     <!-- response -->
     * {field-name}                                     <!-- response -->

  1. Use the following template to identify the number of bits in each field within the binary32 format.
     * | xxxxx | xxx | xxxxxxxx | xx | xxxxx | xx |   <!-- response -->

     Yes, you need to modify the template above to provide your answer.


  1. Decode each of the individual fields.
     * {field-name}: {value}                           <!-- response -->
     * {field-name}: {value}                           <!-- response -->


  1. Present the decoded value in Scientific Notation in base 2
     * scientific-notation: {value}                   <!-- response -->



#### UTF-8 Format
The following is a two byte UTF-8 value.  
   ```
   1100100010101010
   ```

  1. Modify the following bit sequence to identify just the framing bits. Simply replace each framing bit with the letter 'f'.
     - framing bits: | 1100 1000 | 1010 1010 |          <!-- response -->

  1. Modify the following bit sequence to identify just the data bits. Simply replace each data bit with the letter 'd':
     - data bits:    | 1100 1000 | 1010 1010 |          <!-- response -->


  1. Copy the data bits to form a binary number, and then convert the binary number to a hexadecimal number:
     - 2# {answer}                                      <!-- response -->
     - 16# {answer}                                     <!-- response -->

  1. What is the UTF-8 index for the given two byte sequence
     - U+ {answer}                                      <!-- response -->

  
#### Whole Number Encodings
Provide the 8-bit encoding for each following numbers and associated encodings

  1.  123: {answer}  : unsigned integer                  <!-- response -->
  1.  123: {answer}  : 1's complement                    <!-- response -->
  1.  123: {answer}  : 2's complement                    <!-- response -->
  1. -123: {answer}  : unsigned integer                  <!-- response -->
  1. -123: {answer}  : 1's complement                    <!-- response -->
  1. -123: {answer}  : 2's complement                    <!-- response -->
  1.  127: {answer}  : unsigned integer                  <!-- response -->
  1. -127: {answer}  : 1's complement                    <!-- response -->
  1. -127: {answer}  : 2's complement                    <!-- response -->   


#### Binary Addition/Subtraction
Solve the following addition/subtraction problems using 8-bit binary arithmetic. Show your work by modifying the template provided.

  1. 123 + 127 = 2# {answer}                           <!-- response --> 
     ```response
     x xxxx  xxxx 
       xxxx  xxxx 
     + xxxx  xxxx 
     ------  ---- 
     y yyyy  yyyy 
     ```
  
  1. -123 - 127 = 2# {answer}                           <!-- response --> 
     ```response
     x xxxx  xxxx 
       xxxx  xxxx 
     + xxxx  xxxx 
     ------  ---- 
     y yyyy  yyyy 
     ```

#### Base64
When converting a binary string to base64, each 24-bit sequence (which is 3 bytes in length) is converted into 4 6-bit values.  Then each 6-bit value is mapped onto an ASCII character.

For this problem you need to isolate the third 6-bit sequence (from left-to-right).  

The following steps are used to achieve the desired results:

  * Let $t0 hold the desired 3-byte sequence: 0x32F3AA.
  * Let $t1 hold an appropriate value to isolate the third 6-bit sequence.
  * Perform the following operation:  and $t2, $t0, $t1
  * Perform the following operation:  srl $t3, $t2, X
    - note that you need to determine the appropriate value of X

Modifying the register templates below to reflect the value in each of these registers.

Then provide the answers related to $t1, X, and $t3.

  1. $t0: xxxx xxxx xxxx xxxx xxxx xxxx xxxx xxxx       <!-- response -->
  1. $t1: xxxx xxxx xxxx xxxx xxxx xxxx xxxx xxxx       <!-- response -->
  1. $t2: xxxx xxxx xxxx xxxx xxxx xxxx xxxx xxxx       <!-- response -->
  1. $t3: xxxx xxxx xxxx xxxx xxxx xxxx xxxx xxxx       <!-- response -->

  1. hexadecimal value of $t1: {answer}                 <!-- response -->
  1. hexadecimal value of $t3: {answer}                 <!-- response -->
  1. decimal value of X: {answer}                       <!-- response -->

