public class AVL<E extends Comparable<E>> implements BalanceTree<E> {

    private class Node {
        E data;
        Node left, right;
        int height;

        Node(E data) {
            this.data = data;
            height = 0;
        }
    }

    private Node root;

    public AVL() {
        root = null;
    }

    @Override
    public void insert(E item) {
        root = insert(root, item);
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
        root = delete(root, item);
    }

    @Override
    public int height() {
        return getHeight(root);
    }

    //prints height of a specific node
    public void heightAVL(E item) {
        Node node = findNode(root, item);
        if (node == null) {
            System.out.println("Item not found");
        } else {
            System.out.println("node height = " + node.height);
        }
    }

    //in-order traversal with balance factors
    public void printAVL() {
        printInOrder(root);
        System.out.println();
    }

    private Node insert(Node node, E item) {
        if (node == null) return new Node(item);

        int cmp = item.compareTo(node.data);
        if (cmp < 0) {
            node.left = insert(node.left, item);
        }
        else if (cmp > 0) {
            node.right = insert(node.right, item);
        }
        else return node; //

        updateHeight(node);
        return balance(node);
    }

    private Node delete(Node node, E item) {
        if (node == null) return null;

        int cmp = item.compareTo(node.data);
        if (cmp < 0) {
            node.left = delete(node.left, item);
        }
        else if (cmp > 0) node.right = delete(node.right, item);
        else {
            //found it, now remove
            if (node.left == null || node.right == null) {
                return (node.left != null) ? node.left : node.right;
            }

            //replace with successor
            Node successor = getMin(node.right);
            node.data = successor.data;
            node.right = delete(node.right, successor.data);
        }

        updateHeight(node);
        return balance(node);
    }

    private Node findNode(Node node, E item) {
        while (node != null) {
            int cmp = item.compareTo(node.data);
            if (cmp == 0) return node;
            node = (cmp < 0) ? node.left : node.right;
        }
        return null;
    }

    private Node getMin(Node node) {
        while (node.left != null) node = node.left;
        return node;
    }

    private int getHeight(Node node) {
        return node == null ? -1 : node.height;
    }

    private void updateHeight(Node node) {
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    private int getBalance(Node node) {
        return getHeight(node.left) - getHeight(node.right);
    }

    private Node balance(Node node) {
        int balance = getBalance(node);

        if (balance > 1) {
            if (getBalance(node.left) < 0)
                node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        if (balance < -1) {
            if (getBalance(node.right) > 0)
                node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    private Node rotateRight(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        updateHeight(y);
        updateHeight(x);

        return x;
    }

    private Node rotateLeft(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        updateHeight(x);
        updateHeight(y);

        return y;
    }

    private void printInOrder(Node node) {
        if (node == null) {
            return;
        }
        printInOrder(node.left);
        System.out.print("(" + node.data + "," + getBalance(node) + ")");
        printInOrder(node.right);
    }
}
