        .text
        .globl equation

        # Include any supporting files, such as macros
        #.include ""

        .data
        # Insert an Static Data Declarations

        .text

equation: nop                           # public static int equation(int a, int b) {

        # Register Allocation Notes
        # $a0: a  
        # $a1: b  
        # $v0:                          #   int answer;
        # $t0:                          #   int t0;
        # $t1:                          #   int t1;
        # $t2:                          #   int t2;
        # $t3:                          #   int t3;
        # $t4:                          #   int t4;

                                        #   // Insert your statements to compute `answer = 2*b + (a + b)/2`
        li $t0, 2                       #   t0 = 2;
        mul $t1, $t0, $a1               #   t1 = t0 * b;
        add $t2, $a0, $a1               #   t2 = a + b;
        div $t3, $t2, $t0               #   t3 = t2 / t0;
        add $t4, $t1, $t3               #   t4 = t1 + t3;
        move $v0, $t4                   #   answer = t4;

        move $v0, $v0                   #   return $v0;
        jr $ra
                                        # }
