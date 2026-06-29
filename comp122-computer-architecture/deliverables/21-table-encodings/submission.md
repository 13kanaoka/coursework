# Table Encodings:
---
> Name: Matthew Rohde               
> GitHub Account: thiccgin  


## Questions

### Bit-Stream Separation

1. Consider the following bit sequence
 
   ```
   01011010 10101011 11010111 11110101 10110110 11010100
   ```

   Separate the bit sequence into appropriate sized chunks for each of the following domains. (You do NOT have to decode this bit sequence.)

   1. Octal String:
      * 010 110 101 010 101 111 010 111 111 101 011 011 011 011 010 100    <!-- response -->
   1. Hex String:                                                          
      * 0101 1010 1010 1011 1101 0111 1111 0101 1011 0110 1101 0010        <!-- response -->
   1. Base64 String:                                                       
      * 010110 101010 101111 010111 111101 011011 011011 010100            <!-- response -->


1. Before we send a message over the network, we send a string of binary digits to announce our intent.  This string is composed of 14 hexadecimal digits (7 octets), each with the value of "16# AA".  This string is then immediately followed by the Start of Frame (SOF) deliminator, which is a 8-bit value of "16# AB".  We then can proceed with sending our message.

   1. For each of the following question, provide the binary string...
      1. What is the binary bit pattern of the preamble?
         - 10101010        <!-- response -->
      1. What is the binary bit pattern of the SOF deliminator?
         - 10101011        <!-- response -->

### Encoding for Powers of 2
For each of the following number, encoding them into a binary string. 

  1. 16# AA AA AA AB 00 00  (Hexadecimal)
     - 2#  1010 1010 1010 1010 1010 1010 1010 1011 0000 0000 0000 0000

  1. 16# FACE (Hexadecimal)
     - 2# 1111 1010 1100 1110                     <!-- response -->
             F    A    C    E                     <!-- response -->

  1. 8# 5673 (Octal)
     - 2# 101 110 111 011                         <!-- response -->
            5   6   7   3                         <!-- response -->

  1. 16# 1011 (Hexidecimal)
     - 2# 0001 0000 0001 0001                     <!-- response -->
             1    0    1    1                     <!-- response -->

  1. 8# 10101011 (Octal)
     - 2# 001 000 001 000 001 000 001 001         <!-- response -->
            1   0   1   0   1   0   1   1         <!-- response -->
 
  1. 2# 10101110 11101010 01011101  (Binary)
     - 2# 10101110 11101010 01011101              <!-- response -->

  1. 4# 1010101 (Quaternary)
     - 2# 01 00 01 00 01 00 01                    <!-- response -->
           1  0  1  0  1  0  1                    <!-- response -->

  <!-- Did the Professor talk about base 4?  No, but you should be able to solve it anyways! -->

### Decoding into Powers of 2
For each of the following binary strings, decode them into the identified based number.

  1. 2# 00101110 10010101 01100010
     - 8#   1   3   5   1   2   5   4   2        <!-- response -->
          001 011 101 001 010 101 100 010        <!-- response -->

     - 16#   2    e    9    5    6    2          <!-- response -->
          0010 1110 1001 0101 0110 0010          <!-- response -->

  1. 2#  11011010 00110101 00000110
     - 8#   6   6   4   3   2   4   0   6        <!-- response -->
          110 110 100 011 010 100 000 110        <!-- response -->

     - 16#    d    a    3    5    0    6         <!-- response -->
           1101 1010 0011 0101 0000 0110         <!-- response -->

  1. 2#  00010010 10101001 01011011
     - 8#   0   4   5   2   4   5   3   3        <!-- response -->
          000 100 101 010 100 101 011 011        <!-- response -->

     - 16#    1    2    a    9    5    b         <!-- response -->
           0001 0010 1010 1001 0101 1011         <!-- response -->

     - 4#  0  1  0  2  2  2  2  1  1  1  2  3    <!-- response -->
          00 01 00 10 10 10 10 01 01 01 10 11    <!-- response -->

### ASCII Encodings
Use the ASCII table to encode the following character strings as a hexidecimal number.

  1. Example
     - 0x 45 78 61 6d 70 6c 65
  1. Hello
     - H  e  l  l  o                             <!-- response -->
      48 65 6c 6c 6f                             <!-- response -->
  1. Easy
     - E  a  s  y                                <!-- response -->
      45 61 73 79                                <!-- response -->
  1. Pie
     - P  i  e                                   <!-- response -->
      50 69 65                                   <!-- response -->

### ASCII Decodings
Use the ASCII table to decode the following binary string into a character string.

  1. 0x 4865 6c6c 6f20 576f 726c 6421 0a00
     -  H  e  l  l  o     W  o  r  l  d  !       <!-- response -->
       48 65 6c 6c 6f 20 57 6f 72 6c 64 21       <!-- response -->

###  MIPS encodings
Use the encoding tables associate with MIPS, complete the following problems.

  1. Provide the 5-bit encodings for the following registers:
     - $at : 0 0001          <!-- response -->
     - $a1 : 0 0101          <!-- response -->
     - $fp : 1 1110          <!-- response -->
     - $t0 : 0 1000          <!-- response -->
     - $13 : none            <!-- response -->

  1. Provide the 6-bit encodings for the following operations:
     - j :   000 010         <!-- response -->
     - jal : 000 011         <!-- response -->
     - beq : 000 100         <!-- response -->
     - lw :  100 011         <!-- response -->
     - addi :001 000         <!-- response -->
 
  1. Provide the 6-bit encoding for the following functions:
     - add :     100 000     <!-- response -->
     - and :     100 100     <!-- response -->
     - jalr :    001 001     <!-- response -->
     - sll :     000 000     <!-- response -->
     - syscall : 001 100     <!-- response -->
   

### Resources
  1. Fix Length Encodings: https://docs.google.com/spreadsheets/d/1eUNgDk746G9y_BstasdvrxU6iA7T5FdsiBWwvo0TH7M/edit#gid=0
  1. MIPS Encodings: https://docs.google.com/spreadsheets/d/1r9cj9x71JBVv3En-cOYanqRW4zSz53oSXLlScOparqY/edit#gid=0
  1. Keyboard Encodings: https://docs.google.com/spreadsheets/d/1eJCdUuydOccLiJcQDYv-PRZVd6jbiM67V7GPXYJYqAs/edit#gid=0
