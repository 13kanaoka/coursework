# My First Programming Assignment in COMP122

For each and every programming assignment, you are responsible for developing a MIPS program, that contains one or more subroutines.  To write MIPS code, especially as a beginner, is a daunting task due to the large number of details that you need to manage.

To aid you in this endeavor, a particular process has been developed to ease you into the task of writing each assigned MIPS subroutines.  It is expected that each student follows this process in total, which will result in a set of four major deliverables.   These four deliverables include:

  1. A set of STH test-cases (STH: Simple Test Harness):  
     - These test cases can be freely shared with members of the class.
     - Increasing the number of test cases will help you to detect and to fix programming errors more quickly.

  1. A set of Java methods:
     - These methods are to be written in a straight-forward manner.
     - Your focus is placed on:
       - understanding the underlying algorithm/s associated with the assignment, and
       - developing code in Java.

  1. A set of Java methods written in the style of Java TAC:
     - These methods will be created via a transformation process provided by the Professor.
     - Your focus is placed on understanding:
       * the semantics of individual Java statements, and
       * the transformation process (which foreshadows the material in COMP 310 and COMP 430).

  1. A set of MIPS subroutines:
     - These subroutines will be a direct equivalent of your JAVA TAC methods
     - Your focus is placed on understanding:
       * the details of the MIPS Instruction Set Architecture (ISA), and
       * the transliteration process.

The process you will undergo for each and every programming assignment is a follows:

  1. Review the Programming Specification
  1. Develop a Set of STH test cases
  1. Implement your Java methods
  1. Implement your Java-TAC methods
  1. Implement your MIPS subroutines
  1. Validate your assignment, and Confirm your submission.


Throughout the course, you are expected to follow the iterative software-development process, and you will utilize a specific workflow to keep you on track. See [Programming workflow](programming_workflow.md) for more detailed information. 

In this participatory assignment, the Professor will walk you through the process to develop your set of deliverables. You will need to submit your deliverables for appropriate credit.

### Java: Equation.j    
  1. Write a Java Method to compute ``answer = 2*b + (a + b)/2``
     - Create a file called equation.j in the java subdirectory
     - Use the following template for your method
       ```java
   
       public static int equation(int a, int b) {
         int answer;
   
         // Insert your statement to compute `answer = 2*b + (a + b)/2`

         return answer;
        }
        ```
     - Add and commit your file to the repository: `git add equation.j; git commit -m "message"`
     - Implement your equation method
     - Add and commit your updated file to the repository: `git add equation.j; git commit -m "message"`
     - Test your equation method: ``answer = 2*b + (a + b)/2``
       * Where a=5, b=7
         - Hand compute the value of answer:
         - Validate the results: `java_subroutine equation 5 7`
       * Where a=2, b=5
         - Hand compute the value of answer:
         - Validate the results: `java_subroutine equation 2 5`

     - Commit your changes: `git commit -m "{message}" .`
     - Push your changes to the remote: `git push`
     - Tag your code to indicated this is your submission:  `git tag --force java_tac_submitted`
     - Push your tag to the remote:  `git push --force --tags`


### Java TAC: equation.j
  1. Write Java TAC Method to compute ``answer = 2*b + (a + b)/2``
     - Copy your equation.j file into the java_tac subdirectory
     - Add and commit your file to the repository: `git add equation.j; git commit -m "message"`
     - Transform your single linear equation into a series of Java TAC statements
     - Add and commit your updated file to the repository: `git add equation.j; git commit -m "message"`
     - Test your equation method: ``answer = 2*b + (a + b)/2``
       * Where a=5, b=7
         - Hand compute the value of answer:
         - Validate the results: `java_subroutine equation 5 7`
       * Where a=2, b=5
         - Hand compute the value of answer:
         - Validate the results: `java_subroutine equation 2 5`
       * Where a=4, b=3
         - Hand compute the value of answer:
         - Validate the results: `java_subroutine equation 4 3`
       * Where a=20, b=16
         - Hand compute the value of answer:
         - Validate the results: `java_subroutine equation 20 16`

     - Commit your changes: `git commit -m "{message}" .`
     - Push your changes to the remote: `git push`
     - Tag your code to indicated this is your submission:  `git tag --force java_tac_submitted`
     - Push your tag to the remote:  `git push --force --tags`

### Test Cases via STH

  1. Create a number of additional test cases to cover the following table.

     |  a    |  b   | answer  |
     |-------|------|---------|
     |   5   |  7   |    xxx  |   `java_subroutine equation 5 7`
     |   2   |  5   |    xxx  |   `java_subroutine equation 2 5`
     |   4   |  3   |    xxx  |   `java_subroutine equation 4 3`
     |  20   | 16   |    xxx  |   `java_subroutine equation 20 16`

  1. Note that such test cases should NOT be created at the end of the development process!
     - Instead, test cases should be developed through the entire development process.

  1. Use `make`:
     - to test: uses the simple testing harness (sth) to test the code within a directory
     - to validate: checks the administrative requirements of the assignment against the local
     - to confirm: checks the administrative requirements of the assignment against the remote


### MIPS: equation.s
   1. Review the code provide as a first introduction to MIPS programing

