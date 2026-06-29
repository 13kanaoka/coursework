
class max {
   static MIPS_library mips = new MIPS_library();
// #line 0 "max.j"
public static int max(int a, int b) {
			int max;

			max = 0;

	init:	  ;
	champ:	if (a <= b) {
	cons:	  ;	
				max = b;
				break champ;
			} else {
	alt:  	  ;
				max = a;
				break champ;
			}
	done:	;

			return max;
}

  public static char[] string2charArray(String text) {
    int index;
    char [] A = new char[ text.length() + 2];

    for (index=0; index < A.length - 2; index++ ) {
      A[index] = (text).charAt(index);
    }
    A[index]   = '\0' ;   // the Null character
    A[index+1] = '\7' ;   // the Alert character
    return A;
  }

  public static void main(String[] args) {
  
    int index;
    int exit_status = 0;
    int  $a0   = 4;
    int  $a1   = 33;

    // Marshal the stack arguments:

    // List of BEFORE actions


    // Make the primary call to the subroutine
    int $v0 = max($a0, $a1);
    int $f0 = $v0;
exit_status = $v0;

    // List of AFTER actions

    // Print the return value from the routine
    mips.println_d($v0);
    mips.exit(exit_status);
    return;
  }
}
