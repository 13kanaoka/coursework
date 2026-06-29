static char [] buffer = new char[256];

public static int nextInt (int radix) {

    int number;
    int digit;

    digit = glyph2int(radix);

init:   ;
        number = 0;

loop:   for(; digit != -1 ;) {

body:     ;
          number = number * radix;
          number = number + digit;

next:     ;          
          digit = glyph2int(radix);
          continue loop;
        }
done:   ;    
        return number;
    }
    
    public static int glyph2int(int radix) {
    
        boolean t3;
        boolean t4;
        boolean t5;
        boolean t6;
        boolean t7;
        boolean t8;
        boolean t9;
        int input;
        int digit;
    
        mips.read_c();
        input = mips.retval();
    
        t3 = ('0' <= input);
        t4 = (input <= '9');
        t5 = ('A' <= input);
        t6 = (input <= 'Z');
        t7 = ('a' <= input);
        t8 = (input <= 'z');
    
init:   ;    
cond:   if (t3 && t4) {
cons:      ;
           digit = input - '0';
           break cond;
        }
        else 
next_1: if (t5 && t6) {
           digit = input - 'A';
           digit = digit + 10;
           break cond;
        }
        else 
next_2: if (t7 && t8) {
           digit = input - 'a';
           digit = digit + 10;
           break cond;
        }
        else {
next_4:     ;
            digit = -1;
            break cond;
        }
done:   ;

init:
cond:   if (digit > (radix - 1)) {
cons:       ;    
            digit = -1;
        }
done:   ;
    
        return digit;
    }