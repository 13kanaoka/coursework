public static int decode() {

	int count = 0;
	for (; ) {

		//read 1 hex value, save it to v_1
		mips.read_c();
		String input = mips.retval();
		char v_1 = input.charAt(0);

		//if input is greater than base16, end loop
		if (v_1 > 0xFF) {
			break;
		}

		//DECODE//
		//determine byte count
		int b = bytes_to_read(v_1);

		//if value is not between 0x0000 and 0x10FFFF, end loop
		if (b == -1) {
			break;
		}
		//eliminate framing bits from v_1
		else if (b == 0) {
			v_1 = v_1 & 0x7F;   //0x7F == 0b0111 1111
		}
		else if (b == 1) {
			v_1 = v_1 & 0x1F;   //0x1F == 0b0001 1111
		}
		else if (b == 2) {
			v_1 = v_1 & 0x0F;   //0x0F == 0b0000 1111
		}
		else if (b == 3) {
			v_1 = v_1 & 0x07;   //0x07 == 0b0000 0111
		}


		count++;
	}
}


public static int bytes_to_read(int v) {

	if (0x0000 <= v <= 0x7f) {
		return 1;
		break;
	}
	else if (0x0080 <= v <= 0x7FF) {
		return 2;
		break;
	}
    else if (0x0800 <= v <= 0xFFFF) {
    	return 3;
    	break;
    }
    else if (0x1000 <= v <= 0x10FFFF) {
    	return 4;
    	break;
    }
    else {
    	return -1;
    }

}


public static int isContinuation(int value) {

    //   format of value: | ff dd dddd |
    //   where  'f' denotes a framing bit
    //   where  'd' denotes a data bit

    int retval;
 
    retval = -1;
    // eliminate the data bits from value
    value = value & 0xC0;  // 0xC0 == 0b1100 0000

    // ensure the frame bits are "10"
    if (value == 0x80) {   // 0x80 == 0b1000 0000
     retval = 0;
    }
    return retval;

}