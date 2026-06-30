public class Splay<E extends Comparable<E>> implements BalanceTree<E> {

    private class Node {
        E data;
        Node left, right;

        Node(E data) {
            this.data = data;
        }
    }

    private Node root;

    public Splay() {
        root = null;
    }

    @Override
    public void insert(E item) {
        if (root == null) {
            root = new Node(item);
            return;
        }

        root = splay(root, item);

        int cmp = item.compareTo(root.data);
        if (cmp == 0) return; //already exists

        Node newNode = new Node(item);
        if (cmp < 0) {
            newNode.left = root.left;
            newNode.right = root;
            root.left = null;
        } else {
            newNode.right = root.right;
            newNode.left = root;
            root.right = null;
        }
        root = newNode;
    }

    @Override
    public boolean find(E item) {
        root = splay(root, item);
        return root != null && root.data.equals(item);
    }

    @Override
    public void delete(E item) {
        if (root == null) {
            return;
        }
        root = splay(root, item);

        if (!root.data.equals(item)) {
            return;
        }
        //if we get here, item == root
        if (root.left == null) {
            root = root.right;
        } else {
            Node temp = root.right;
            root = root.left;
            root = splay(root, item); //splay max in left subtree
            root.right = temp;
        }
    }

    @Override
    public int height() {
        return heightHelper(root);
    }

    public void printRoot() {
        if (root == null) {
            System.out.println("The tree is empty.");
        } else {
            System.out.println("The root contains: " + root.data);
        }
    }

    public void printSplay() {
        printSplayHelper(root);
        System.out.println();
    }

    private void printSplayHelper(Node node) {
        if (node == null) {
            return;
        }
        printSplayHelper(node.left);
        System.out.print("(" + node.data + "," + heightHelper(node) + ")");
        printSplayHelper(node.right);
    }

    private int heightHelper(Node node) {
        if (node == null) {
            return -1;
        }
        return 1 + Math.max(heightHelper(node.left), heightHelper(node.right));
    }

    //core splay operation
    private Node splay(Node root, E key) {
        if (root == null || root.data.equals(key)) {
            return root;
        }
        int cmp = key.compareTo(root.data);

        //zigzig or zigzag
        if (cmp < 0 && root.left != null) {
            if (key.compareTo(root.left.data) < 0) {
                root.left.left = splay(root.left.left, key);
                root = rotateRight(root);
            } else if (key.compareTo(root.left.data) > 0) {
                root.left.right = splay(root.left.right, key);
                if (root.left.right != null)
                    root.left = rotateLeft(root.left);
            }
            return root.left == null ? root : rotateRight(root);
        }

        if (cmp > 0 && root.right != null) {
            if (key.compareTo(root.right.data) < 0) {
                root.right.left = splay(root.right.left, key);
                if (root.right.left != null)
                    root.right = rotateRight(root.right);
            } else if (key.compareTo(root.right.data) > 0) {
                root.right.right = splay(root.right.right, key);
                root = rotateLeft(root);
            }
            return root.right == null ? root : rotateLeft(root);
        }

        return root; //not found
    }

    private Node rotateLeft(Node x) {
        Node y = x.right;
        x.right = y.left;
        y.left = x;
        return y;
    }

    private Node rotateRight(Node x) {
        Node y = x.left;
        x.left = y.right;
        y.right = x;
        return y;
    }
}
