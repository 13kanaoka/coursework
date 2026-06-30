public class Driver {
    public static void main(String[] args) {

        // ========== AVL TREE ==========
        System.out.println("==== AVL TREE TEST ====");
        BalanceTree<Integer> avl = new AVL<>();
        avl.insert(10);
        avl.insert(20);
        avl.insert(5);
        avl.insert(6); //triggers rebalancing

        System.out.print("AVL (in-order with balance factors): ");
        ((AVL<Integer>) avl).printAVL();

        ((AVL<Integer>) avl).heightAVL(10);
        System.out.println("AVL Height: " + avl.height());
        System.out.println("Find 20 in AVL: " + avl.find(20));

        avl.delete(20);
        System.out.print("AVL after deleting 20: ");
        ((AVL<Integer>) avl).printAVL();

        System.out.println("\n");

        // ========== SPLAY TREE ==========
        System.out.println("==== SPLAY TREE TEST ====");
        BalanceTree<Integer> splay = new Splay<>();
        splay.insert(15);
        splay.insert(5);
        splay.insert(10); //should bring 10 to root via zig-zag

        System.out.print("Splay Tree (in-order with heights): ");
        ((Splay<Integer>) splay).printSplay();

        ((Splay<Integer>) splay).printRoot();
        System.out.println("Splay Height: " + splay.height());
        System.out.println("Find 5 in Splay: " + splay.find(5));
        ((Splay<Integer>) splay).printRoot(); //5 should be root now

        splay.delete(15);
        System.out.print("Splay after deleting 15: ");
        ((Splay<Integer>) splay).printSplay();

        System.out.println("\n");

        // ========== RED-BLACK TREE ==========
        System.out.println("==== RED-BLACK TREE TEST ====");
        BalanceTree<Integer> rbt = new RedBlack<>();
        rbt.insert(10);
        rbt.insert(20);
        rbt.insert(30); //causes rotations
        rbt.insert(5);
        rbt.insert(15);

        System.out.print("RBT (in-order with colors): ");
        ((RedBlack<Integer>) rbt).printRedBlack();
        ((RedBlack<Integer>) rbt).statusRB();

        System.out.println("Red-Black Height: " + rbt.height());
        System.out.println("Find 15 in RBT: " + rbt.find(15));

        rbt.delete(15); //not implemented
        System.out.print("RBT after attempting delete: ");
        ((RedBlack<Integer>) rbt).printRedBlack();

        System.out.println("\n");

        // ========== 2-3-4 TREE ==========
        System.out.println("==== 2-3-4 TREE TEST ====");
        BalanceTree<Integer> b234 = new B234<>();
        b234.insert(10);
        b234.insert(20);
        b234.insert(5);
        b234.insert(15);
        b234.insert(25);
        b234.insert(30);
        b234.insert(1); //forces a couple of splits

        System.out.print("2-3-4 (in-order with node types): ");
        ((B234<Integer>) b234).print234();
        ((B234<Integer>) b234).status234();

        System.out.println("2-3-4 Height: " + b234.height());
        System.out.println("Find 25 in 2-3-4: " + b234.find(25));

        b234.delete(25); //placeholder
        System.out.print("2-3-4 after attempting delete: ");
        ((B234<Integer>) b234).print234();

        System.out.println("\nAll tests done");
    }
}
