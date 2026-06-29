

# Exam #2: Formats and Encodings

### Name:

### GitHub Account:

#### Conversion between Powers of 2
    1. 8# 175316 == {hex}                                 
    1. 16# FACE  == {octal}                               
    1. 4# 1000   == {binary}                              

#### Convert the `10# 0.4004` into a binary number that contains at most 5 digits. 
  ```response
  number =  
  max    =  


  answer:  2#  
  ```

#### Convert  `10# 106` into a binary number. 
  ```response
  number =  


  answer: 2# 
  ```

#### Floating Point
     * number: {value}                                  
     * {field-name}                                     
     * {field-name}                                     
     * {field-name}                                     
     * {field-name}                                     
     * {field-name}                                     
     * | xxxxx | xxx | xxxxxxxx | xx | xxxxx | xx |   
     * {field-name}: {value}                           
     * {field-name}: {value}                           
     * scientific-notation: {2# value}                

#### UTF-8 Format
     - framing bits: | 1100 1000 | 1010 1010 |          
     - data bits:    | 1100 1000 | 1010 1010 |          
     - 2#  {answer}                                     
     - 16# {answer}                                     
     - U+ {answer}                                      

#### Whole Number Encodings
  1.  106: {answer}  : unsigned integer                  
  1.  106: {answer}  : 1's complement                    
  1.  106: {answer}  : 2's complement                    
  1. -106: {answer}  : unsigned integer                  
  1. -106: {answer}  : 1's complement                    
  1. -106: {answer}  : 2's complement                    
  1.  127: {answer}  : unsigned integer                  
  1. -127: {answer}  : 1's complement                    
  1. -127: {answer}  : 2's complement                    

#### Binary Addition/Subtraction
  1. 106 + 127 = 2# {answer}                           
     ```response
     x xxxx  xxxx 
       xxxx  xxxx 
     + xxxx  xxxx 
     ------  ---- 
     y yyyy  yyyy 
     ```
  1. -106 - 127 = 2# {answer}                           
     ```response
     x xxxx  xxxx 
       xxxx  xxxx 
     + xxxx  xxxx 
     ------  ---- 
     y yyyy  yyyy 
     ```

#### Base64
  1. $t0: xxxx xxxx xxxx xxxx xxxx xxxx xxxx xxxx       
  1. $t1: xxxx xxxx xxxx xxxx xxxx xxxx xxxx xxxx       
  1. $t2: xxxx xxxx xxxx xxxx xxxx xxxx xxxx xxxx       
  1. $t3: xxxx xxxx xxxx xxxx xxxx xxxx xxxx xxxx       
  1. hexadecimal value of $t1: {answer}                 
  1. hexadecimal value of $t3: {answer}                 
  1. decimal value of X: {answer} 
