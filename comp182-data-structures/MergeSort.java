public class MergeSort {
    public static void main(String[] args) {
        int sizeX = (int) (Math.random() * (20-15+1)+15);
        // int sizeY = (int) (Math.random() * (12-10+1)+10);
        int x [] = new int [sizeX];
        //int y [] = new int [sizeY];
        //int z [] = new int [sizeX + sizeY];
        //ranSorted (x);
        //ranSorted (y);
        randomize (x);

        printParArray (x, 0, x.length);
        // mergeArrays(x, y, z);
        //printParArray (y, 0, y.length);
        mergeSort (x);
        printParArray (x, 0, x.length);
            System.out.print("Matthew Rohde");
    }
    static void ranSorted (int x[])
    {
    x [0] = (int)(Math.random() * (20-10+1)+10);
    for (int i = 1; i < x.length; i++)
        x[i]=x [i-1] + (int)(Math.random() * (5-2+1)+2);
}

    static void randomize (int x[]) {
        x [0] = (int)(Math.random() * (20-10+1)+10);
    for (int i = 0; i < x.length; i++)
        x[i]=(int)(Math.random() * (99-10+1)+10);
    }

    static void printParArray  (int x [], int from, int to) {
    for (int i = from; i < to; i++)
        System.out.printf("%4d", x [i]);
        System.out.println();
    }

    static void mergeArrays (int x[], int y[], int z[]) {
        int xIndex = 0;
        int yIndex = 0;
        int zIndex = 0;

while (xIndex < x.length && yIndex < y.length) {
    if (x [xIndex] < y [yIndex])
        z [zIndex++] = x [xIndex++];
    else
        z [zIndex++] = y [yIndex++];
    }

    //printParArray (z, 0, zIndex);
    while (xIndex < x.length)
        z [zIndex++] = x [xIndex++];
    //printParArray (z, 0, zIndex);
    while (yIndex < y.length)
        z[zIndex++] = y [yIndex++];

    //printParArray (z, 0, zIndex);
    }
static void mergeSort (int x[]) {
    if (x.length > 1) {
        int firstHalf [] = new int [x.length /2];
        System.arraycopy(x, 0, firstHalf, 0, x.length/2);
        mergeSort (firstHalf);

    int secondHalfSize = x.length - x.length /2;
    int secondHalf []= new int [secondHalfSize];
    System.arraycopy (x, x.length/2, secondHalf, 0, secondHalfSize);
    mergeSort (secondHalf);

    mergeArrays (firstHalf, secondHalf, x);
    printParArray (x, 0, x.length);


        }
    }
}
