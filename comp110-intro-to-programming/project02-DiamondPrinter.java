public class TrianglePrinter {
        static int n;
    public static void main(String[] args) {
        System.out.println("Matthew Rohde");
        n = (11 + (int)(Math.random() * 20));
        if (n % 2 == 0) n++;

        System.out.println("Number of lines: " + n);

        MRPrintUpperTriangle();
        MRPrintMiddleTriangle();
        MRPrintLowerTriangle();
    }
        public static void MRPrintUpperTriangle() {
        int c;
        for (int r = 1; r < n; r++) {
            for (int sp = (n - r); sp >= 1; sp--) {
             System.out.print(" ");
            }
            for (c = 1; c <= (r * 2) - 1; c++) {
             System.out.print("M");
            }
                    System.out.print("\n");
        }
    }
        public static void MRPrintMiddleTriangle() {
        for (int j = 0; j <= (n * 2 - 2); j++) {
            System.out.print("=");
            }
            System.out.print("\n");
        }

        public static void MRPrintLowerTriangle() {
            int i, j;
            for(i = n; i >= 1; i--)
            {
                for(j = i; j <= n; j++)
                {
                    System.out.print(" ");
                }
                for(j = 1; j <= (2 * i - 3); j++)
                {
                    System.out.print("R");
                }
                System.out.println("");
            }
        }
    }
