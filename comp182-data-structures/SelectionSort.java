public class SelectionSort {
    public static void main(String[] args) {
        int data [] = new int [15];
		for (int i = 0; i < data. length; i++)
			data [i] = (int)(Math.random() * (99-10+1)+10); //0-99

		printData (data); 		// OG data
		System.out.println();			
		selSort (data);
	}
	public static void printData (int [] data) {
	for (int i=0; i< data.length; i++)
		System.out.printf("%3d", data[i]);
	System.out.println();
	}
		public static void selSort (int [] data) {
		int MaxIndex;
		int lastIndex = data.length - 1;
		while (lastIndex > 0) {
			MaxIndex =0;
			for (int i = 1; i <= lastIndex; i++)
			if (data [i] < data [MaxIndex])
					MaxIndex = i;
				swap (data, MaxIndex, lastIndex);
			lastIndex --;
			printData (data);
		}
	}
	public static void swap (int [] data, int index1, int index2)
	{
		int temp = data [index1];
		data [index1] = data [index2];
		data [index2] = temp;

	}

}
