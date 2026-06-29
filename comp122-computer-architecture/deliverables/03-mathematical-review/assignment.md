# Mathematical Review: Base 10
> Name:  {name}
> GitHub Account: {account}
---

## Overview
  * The human hand has ten digits, which are also known as fingers.
  * There are ten digits in the Base 10 numbering system.
  * We have all learned to count in Base 10.
  * As humans, we are comfortable in performing mathematical operations in Base 10.

In COMP122, we will be learning about computer architecture and assembly languages. A key component in using these systems is knowing various numbering systems and data representations. For example, we will be learning about Base 2, Base 8, Base 16, and Base 64 within this class.

On a computer system, we need to perform basic mathematical operations. The operations are not performed in Base 10, but in Base 2. That is to say that a computer system uses binary numbers in all of its computations. Moreover, we are limited in the size of the numbers that can be used within our calculations.

In this assignment, you are to perform a number of simple mathematical operations in Base 10. The purpose of this assignment is to have you review the fundamentals of these operations and to prepare you to perform the same types of operations using binary numbers (that is to say, using Base 2 computations).

While completing this exercise, pay attention to the algorithm or process you use to solve each problem. Show all of your work in the space provided. Notice that you are limited to numbers in the range of 0 .. 9,999. Perhaps, there might be a problem or two in which you will not be able to solve given the provided <b>space</b>. When such an <b>exception</b> occurs, simply denote you were not able to solve that problem.


#### Section 1: Addition of Whole Numbers
   1. Perform the following additions.
   1. Show your work by replacing each 'x' with the appropriate character (digit).
   1. Every 'x' needs to be replace with the appropriate character (digit).

   * 13 + 5
   ```response
         xxx0  
         xxxx  
       + xxxx  
       ------
         xxxx  

   Final Answer: xxxx 
   ```
 
   * 13 + 8
   ```response
         xxx0  
         xxxx  
       + xxxx  
       ------
         xxxx  
         
   Final Answer: xxxx 
   ```
 
   * 1345 + 655
   ```response
         xxx0  
         xxxx  
       + xxxx  
       ------
         xxxx  
         
   Final Answer: xxxx 
   ```
 
   * 5676 + 4334
   ```response
         xxx0  
         xxxx  
       + xxxx  
       ------
         xxxx  
         
   Final Answer: xxxx 
   ```
 
#### Section 2: Addition of Fix Point Numbers
   1. Perform the following additions.
   1. Show your work by replacing each 'x' with the appropriate character (digit).
   1. Every 'x' needs to be replace with the appropriate character (digit).

   * 13.5 + 5.0
   ```response
        xxxx.xx
        xxxx.xx
      + xxxx.xx
      ---------
        xxxx.xx
         
   Final Answer: xxxx.xx  
   ```
 
   * 45.67 + 0.8
   ```response
        xxxx.xx
        xxxx.xx
      + xxxx.xx
      ---------
        xxxx.xx
         
   Final Answer: xxxx.xx  
   ```
 
   * 134.5 + 0.655
   ```response
        xxxx.xx
        xxxx.xx
      + xxxx.xx
      ---------
        xxxx.xx
         
   Final Answer: xxxx.xx  
   ```
 
   * 566.76 + 4334.0
   ```response
        xxxx.xx
        xxxx.xx
      + xxxx.xx
      ---------
        xxxx.xx
         
   Final Answer: xxxx.xx 
   ```

#### Section 3: Ten's Complement[^1]
[^1]: Also known as a radix complement for Base 10.

> Complement: a thing that completes or brings to perfection

In mathematics, two numbers are said to be complements if by adding them together you obtain a number that is a power of ten: 0, 10, 100, 100, etc. For example, the ten's complement of 25 with respect to 100 is 75 (25 + 75 = 100).

  1. Calculate the complement of the following numbers _with respect to_ 10:
     * 3:                                            <!-- response -->
     * 5:                                            <!-- response -->
     * 6:                                            <!-- response -->
     * 9:                                            <!-- response -->
  
  1. Calculate the complement of the following numbers _with respect to_ 100:
     * 33:                                           <!-- response -->
     * 65:                                           <!-- response -->
     * 82:                                           <!-- response -->
     * 3:                                            <!-- response -->
  
  1. Calculate the complement of the following numbers:
     * 23:                                           <!-- response -->
     * 345:                                          <!-- response -->
     * 3453:                                         <!-- response -->
     * 5638:                                         <!-- response -->
  
  When we are not given the sum of the two numbers, it is defined to be the smallest power of 10 larger than both the complements.  For example, when providing the complement of 654, we presume that this is _with respect to_ 1000.

#### Section 4: Nine's Complement[^2]
[^2]: Also know as the diminished radix complement for Base 10.

The nine's complement of a decimal digit is the number that must be added to produce 9.  Whereas the nine's complement of a three digit number is that number that must be added to it to produce 999.

  1. Provide the 9's complement of the following numbers:
     * 3:                                            <!-- response -->
     * 5:                                            <!-- response -->
     * 6:                                            <!-- response -->
     * 9:                                            <!-- response -->
  
  1. Provide the 9's complement of the following numbers:
     * 33:                                           <!-- response -->
     * 65:                                           <!-- response -->
     * 82:                                           <!-- response -->
     * 3:                                            <!-- response -->
  
  1. Provide the 9's complement of the following numbers:
     * 23:                                           <!-- response -->
     * 345:                                          <!-- response -->
     * 3453:                                         <!-- response -->
     * 5638:                                         <!-- response -->
  


#### Section 5: Scientific Notation
Large and small numbers can be more consciously written using Scientific Notation. For example, the value of ``pi`` can be represented as:

>  3.14159  x 10^ 0

This number represented in this form can be broken down into the following components
  1. the sign: +                   # which is implicitly provided
  1. the whole part: 3
  1. the radix: .                  # also known as the decimal point
  1. the mantissa part: 14159
  1. the scientific-base: x 10^
  1. the sign of the exponent: +   # which is also implicitly provided
  1. the exponent: 0

The general pattern for writing this number out in textual form is as follows:

> s w.mmmmm x 10^ s eee

Represent the following numbers using scientific notation using the pattern provided. That is to say, replace the pattern character (s, w, m, and e) with appropriate character.  Every pattern character must be replaced, and you can't add additional pattern characters.

   * 45.67
     > + 4.56700 x 10^ + 001                         <!-- response -->

   * 92,955,807  # Average distance between the Sun and the Earth in miles.
     > s w.mmmmm x 10^ s eee                         <!-- response -->

   * 602,221,407,600,000,000,000,000    # Avogadro constant
     > s w.mmmmm x 10^ s eee                         <!-- response -->
   
   * 0.000,000,000,000,000,000,000,001,673,557,5 # Mass of an hydrogen atom 
     > s w.mmmmm x 10^ s eee                         <!-- response -->


### Section 6: Questions
1. Did you read the overview of this assignment? 
   *                                                 <!-- response -->

1. Why was this exercise assigned to you by your Professor?
   *                                                 <!-- response -->

1. What is a natural number?
   *                                                 <!-- response -->

1. What is a whole number?  
   *                                                 <!-- response -->

1. What is an integer?
   *                                                 <!-- response -->

1. What is a real number? 
   *                                                 <!-- response -->

1. What is a complement?
   *                                                 <!-- response -->

1. What is a carry?
   *                                                 <!-- response -->

1. What is overflow?
   *                                                 <!-- response -->

1. When using scientific notation, with a particular pattern, is there the potential for a loss information or precision in the number?
   *                                                 <!-- response -->

1. What is an exception?
   *                                                 <!-- response -->



---
### Appendix:
* Example additions of 961 + 921 and 7236 + 4216 are provided as a template
* Note that it is not possible to add 7236 and 4216 together with the space provided.

#### Addition of 961 + 921 
* Template:
   ```
     xxx0  (Carry Row)
     xxxx  (Augend Row)
   + xxxx  (Addend Row)
   ------
     xxxx  (Sum Row)

   Final Answer: xxxx
   ```
* response:
   ```
     1000
     0961
   + 0921
   ------
     1882 

   Final Answer: 1882
   ```

#### Addition of 7236 + 4216 
* Template:
   ```
     xxx0 (Carry Row)
     xxxx (Augend Row)
   + xxxx (Addend Row)
   ------ 
     xxxx (Sum Row)

   Final Answer: 1882
   ```
* response:
   ```
     0010
     7236
   + 4216
   ------
     1452 

   Final Answer: overflow 
   # Note I was unable to solve this problem in the space provided.  The sum is 11,452.
   ```


 
