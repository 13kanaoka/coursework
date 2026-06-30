public class SwapDemo {
    public static void main(String[] args) {
        
        int x = 7, y = 9;
        System.out.println("x = " + x + ", y = " + y);
        swap1 (x, y);
        System.out.println("x = " + x + "y = " + y);
        int data [] = {6, 15};
        System.out.println("data[0] = " + data[0] + ", data[1] = " + data[1]);
        swap2 (data);
        System.out.println("data[0] = " + data[0] + ", data[1] = " + data[1]);
        swap1 (data[0], data[1]);
        System.out.println("data[0] = " + data[0] + ", data[1] = " + data[1]);
    }
    public static void swap1 (int a, int b)
    {
        int temp = a;
        a = b;
        b = temp;
    }
    public static void swap2 (int [] data)
    {
        int temp = data [0];
        data [0] = data [1];
        data [1] = temp;
    }
}
