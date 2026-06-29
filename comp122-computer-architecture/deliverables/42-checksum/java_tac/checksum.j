		public static int checksum () {

init:	;
		int sum = 0;
		int max_int = 255;
		int header_checksum = 0;

test:	for (int i = 0; i < 10; i++) {				//initialize integer reading for loop
			;
body:		mips.read_d();							
			int userInput = mips.retval();
			;
next:		if (i == 5) {
				header_checksum = userInput;		//6th value becomes checksum
			}
			else {
				sum = (userInput + sum);			//add int to the sum
			}
			i++;
		}

			int quotient = sum / (max_int + 1);
			int remainder = sum % (max_int + 1);

			int checksum = max_int - (quotient + remainder);

			int result = (header_checksum == checksum) ? 0 : checksum;

done:		return result;

	}