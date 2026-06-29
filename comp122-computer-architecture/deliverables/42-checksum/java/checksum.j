public static int checksum () {

	int sum = 0;
	int max_int = 255;
	int header_checksum = 0;

	for (int i = 0; i < 10; i++) {				//initialize integer reading for loop
		mips.read_d();							
		int userInput = mips.retval();

		if (i == 5) {
			header_checksum = userInput;		//6th value becomes checksum
		}
		else {
			sum = (userInput + sum);			//add int to the sum
		}
	}

		int quotient = sum / (max_int + 1);
		int remainder = sum % (max_int + 1);

		int checksum = max_int - (quotient + remainder);

		int result = (header_checksum == checksum) ? 0 : checksum;

		return result;

}