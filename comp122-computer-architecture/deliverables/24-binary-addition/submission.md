# Binary Addition & Subraction:
### Name: Matthew Rohde
### GitHub Account: thiccgin


## Questions

### Complements
Provide the 1's complement and 2 complement encodings for the following numbers.
(You can limit your answer to 8-bit encodings.)

1. -5
   - 1's: 0101                <!-- response -->
   - 2's: 1101                <!-- response -->

1. -22
   - 1's: 0001 0010           <!-- response -->
   - 2's: 1110 1110           <!-- response -->

1. 123
   - 1's: 0101 0011           <!-- response -->
   - 2's: 1010 1101           <!-- response -->

1. -2
   - 1's: 0010                <!-- response -->
   - 2's: 1110                <!-- response -->

1. -105
   - 1's: 0100 0101           <!-- response -->
   - 2's: 1011 1011           <!-- response -->


1. -122
   - 1's: 0101 0010           <!-- response -->
   - 2's: 1010 1110           <!-- response -->


### Binary Addition
Solve the following addition problems using binary arithmetic. Show your work by modifying the template provided.

1. 7 + 8:  
   ```response
   0 0000 0000  
     0000 0111  
   + 0000 1000  
   ------ ----  
   0 0000 1111  
   ```

1. 113 + 127: 
   ```response
   0 0000  0000
     0100  1011 
   + 0101  0111 
   ------  ---- 
   0 1010  0010 
   ```

1. 112 - 12: 
   ```response
   0 0000  0000
     0100  1010 
   + 1111  0110 
   ------  ---- 
   0 0100  0000
   ```

1. -22 + 22: 
   ```response
   0 0000  0000 
     0001  0010 
   + 1110  1110 
   ------  ---- 
   0 0000  0000 
   ```


### Status Bits:
Provide the values of the CPU's status bits after the each of the following additions.  (Note you calulate these additions in the previous section:

1. 113 + 127 
  - C: 1         <!-- response -->
  - V: 0         <!-- response -->
  - S: 0         <!-- response -->
  - Z: 0         <!-- response -->

1. -22 + 22
  - C: 1         <!-- response -->
  - V: 0         <!-- response -->
  - S: 0         <!-- response -->
  - Z: 1         <!-- response -->


### Conversion from Base 16, 8, 2 -> Decimal
1. Convert the following numbers to their base10 equivalent, using the left-to-right method.
Make sure you format your answers well!<br>
(Don't worry about the missing &lt;!-- response: --&gt; tags)

   1. 2# 1010 1101 

   | v      | = | v    | * base + |  digit |  glyph  | 
   |--------|---|----- |----------|--------|---------| 
   | 1      | = | 1    | * 2^ 7 + |   128  |   128   |    
   | 0      | = | 0    | * 2^ 6 + |   64   |         |    
   | 1      | = | 1    | * 2^ 5 + |   32   |   32    |    
   | 0      | = | 0    | * 2^ 4 + |   16   |         |    
   | 1      | = | 1    | * 2^ 3 + |   8    |   8     |    
   | 1      | = | 1    | * 2^ 2 + |   4    |   4     |  
   | 0      | = | 0    | * 2^ 1 + |   2    |         | 
   | 1      | = | 1    | * 2^ 0 + |   1    |   1     | = 173  
                                           
   1. 8# 12131          
  
   | v      | = | v    | * base + |  digit |  glyph  | 
   |--------|---|----- |----------|--------|---------| 
   |   1    | = |  1   | * 8^ 4 + |  4096  |  4096   | 
   |   2    | = |  2   | * 8^ 3 + |  512   |  1024   | 
   |   1    | = |  1   | * 8^ 2 + |  64    |  64     | 
   |   3    | = |  3   | * 8^ 1 + |  8     |  24     | 
   |   1    | = |  1   | * 8^ 0 + |  1     |  1      | = 5209

   1. 16# 28B1    

   | v      | = | v    | * base + |  digit |  glyph  | 
   |--------|---|----- |----------|--------|---------| 
   |   2    | = |  2   | * 16^3 + |  4096  |  8192   | 
   |   8    | = |  8   | * 16^2 + |  256   |  2048   | 
   |   B    | = |  11  | * 16^1 + |  16    |  176    | 
   |   1    | = |  1   | * 16^0 + |  1     |  16     | = 10,432


### Conversion from Decimal -> base N
 1. Convert 10# 43.5187 -> 2# 
    <br>Only provide a maximum of 16 digits in total
    ```
    number = 43                              <!-- response -->
                                             <!-- response -->
    answer: 101011                           <!-- response -->
    ```
    ```
    number =   5187                          <!-- response -->
    max    =   10                            <!-- response -->
                                             <!-- response -->
    answer:    1000010011                    <!-- response -->
    ```

 1. Convert 10# - 324.324 -> 2# 
    <br>Only provide a maximum of 16 digits in total
    ```
    number = -324                            <!-- response -->
                                             <!-- response -->
    answer:  1010111011                      <!-- response -->
    ```
    ```
    number = -324                            <!-- response -->
    max    = 7                               <!-- response -->
                                             <!-- response -->
    answer:  1010111                         <!-- response -->
    ```


### Binary32

  1. Provide the Binary Scientific Notation for: 10# 43.5187
     -  2# 1.010111000010011 x 2^ 5                        <!-- response -->

  1. Provide the Binary Scientific Notation for: 10# - 324.324
     -  2# -1.010001000101001 x 2^ 8                       <!-- response -->

  1. Provide the binary16 encoding pattern and then provide the encoding for: 10# 43.5187
     * | s | eeeee | mmmm mmmm mm |                        <!-- response -->
     * | 0 | 10111 | 0101 1100 00 |                        <!-- response -->

  1. Provide the binary32 encoding pattern and then provide the encoding for: 10# - 324.324
     * | s | eeee eeee | mmmm mmmm mmmm mmmm mmmm mmm |    <!-- response -->
     * | 1 | 1000 0111 | 0100 0100 0101 0010 0000 000 |    <!-- response -->


 

