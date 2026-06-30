public class RedBlack<E extends Comparable<E>> implements BalanceTree<E> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node {
        E data;
        Node left, right, parent;
        boolean color;

        Node(E data) {
            this.data = data;
            this.color = RED;
        }
    }

    private Node root;

    public RedBlack() {
        root = null;
    }

    @Override
    public void insert(E item) {
        Node newNode = new Node(item);
        root = bstInsert(root, newNode);
        fixInsert(newNode);
    }

    @Override
    public boolean find(E item) {
        Node node = root;
        while (node != null) {
            int cmp = item.compareTo(node.data);
            if (cmp == 0) {
                return true;
            }
            node = (cmp < 0) ? node.left : node.right;
        }
        return false;
    }

    @Override
    public void delete(E item) {
        System.out.println("delete() not implemented");
    }

    @Override
    public int height() {
        return heightHelper(root);
    }

    public void statusRB() {
        int[] count = new int[2]; // [0] = red, [1] = black
        countColors(root, count);
        int blackHeight = getBlackHeight(root);
        System.out.println("R = " + count[0] + " B = " + count[1] + " BH = " + blackHeight);
    }

    public void printRedBlack() {
        printHelper(root);
        System.out.println();
    }

    private Node bstInsert(Node root, Node node) {
        if (root == null) return node;

        int cmp = node.data.compareTo(root.data);
        if (cmp < 0) {
            root.left = bstInsert(root.left, node);
            root.left.parent = root;
        } else if (cmp > 0) {
            root.right = bstInsert(root.right, node);
            root.right.parent = root;
        }
        return root;
    }

    private void fixInsert(Node k) {
        while (k != root && k.parent.color == RED) {
            Node parent = k.parent;
            Node grandparent = parent.parent;

            if (parent == grandparent.left) {
                Node uncle = grandparent.right;

                if (uncle != null && uncle.color == RED) {
                    parent.color = BLACK;
                    uncle.color = BLACK;
                    grandparent.color = RED;
                    k = grandparent;
                } else {
                    if (k == parent.right) {
                        k = parent;
                        rotateLeft(k);
                    }
                    parent.color = BLACK;
                    grandparent.color = RED;
                    rotateRight(grandparent);
                }
            } else {
                Node uncle = grandparent.left;

                if (uncle != null && uncle.color == RED) {
                    parent.color = BLACK;
                    uncle.color = BLACK;
                    grandparent.color = RED;
                    k = grandparent;
                } else {
                    if (k == parent.left) {
                        k = parent;
                        rotateRight(k);
                    }
                    parent.color = BLACK;
                    grandparent.color = RED;
                    rotateLeft(grandparent);
                }
            }
        }
        root.color = BLACK;
    }

    private void rotateLeft(Node x) {
        Node y = x.right;
        x.right = y.left;
        if (y.left != null) y.left.parent = x;

        y.parent = x.parent;
        if (x.parent == null) root = y;
        else if (x == x.parent.left) x.parent.left = y;
        else x.parent.right = y;

        y.left = x;
        x.parent = y;
    }

    private void rotateRight(Node x) {
        Node y = x.left;
        x.left = y.right;
        if (y.right != null) y.right.parent = x;

        y.parent = x.parent;
        if (x.parent == null) root = y;
        else if (x == x.parent.right) x.parent.right = y;
        else x.parent.left = y;

        y.right = x;
        x.parent = y;
    }

    private int heightHelper(Node node) {
        if (node == null) {
            return -1;
        }
        return 1 + Math.max(heightHelper(node.left), heightHelper(node.right));
    }

    private void countColors(Node node, int[] count) {
        if (node == null) {
            return;
        }
        if (node.color == RED) count[0]++;
        else count[1]++;
        countColors(node.left, count);
        countColors(node.right, count);
    }

    private int getBlackHeight(Node node) {
        int height = 0;
        while (node != null) {
            if (node.color == BLACK) height++;
            node = node.left;
        }
        return height;
    }

    private void printHelper(Node node) {
        if (node == null) return;
        printHelper(node.left);
        System.out.print("(" + node.data + "," + (node.color ? "R" : "B") + ")");
        printHelper(node.right);
    }
}
