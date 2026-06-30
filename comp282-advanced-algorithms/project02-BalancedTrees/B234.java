import java.util.ArrayList;

public class B234<E extends Comparable<E>> implements BalanceTree<E> {

    //internal node class — holds multiple items and possibly children
    private class Node {
        ArrayList<E> items = new ArrayList<>();
        ArrayList<Node> children = new ArrayList<>();

        boolean isLeaf() {
            return children.isEmpty();
        }
    }

    private Node root;

    public B234() {
        root = new Node();
    }

    @Override
    public void insert(E item) {
        //if the root is full, split it first
        if (root.items.size() == 3) {
            Node newRoot = new Node();
            newRoot.children.add(root);
            splitChild(newRoot, 0);
            root = newRoot;
        }
        insertNonFull(root, item);
    }

    private void insertNonFull(Node node, E item) {
        int i = node.items.size() - 1;

        if (node.isLeaf()) {
            node.items.add(null); //create space
            while (i >= 0 && item.compareTo(node.items.get(i)) < 0) {
                node.items.set(i + 1, node.items.get(i));
                i--;
            }
            node.items.set(i + 1, item);
        } else {
            while (i >= 0 && item.compareTo(node.items.get(i)) < 0) {
                i--;
            }
            i++; //this is the child index to go down

            if (node.children.get(i).items.size() == 3) {
                splitChild(node, i);
                if (item.compareTo(node.items.get(i)) > 0) {
                    i++; //adjust if item should go right
                }
            }
            insertNonFull(node.children.get(i), item);
        }
    }

    private void splitChild(Node parent, int index) {
        Node full = parent.children.get(index);
        Node left = new Node();
        Node right = new Node();

        //split the items
        left.items.add(full.items.get(0));
        right.items.add(full.items.get(2));
        E middle = full.items.get(1);

        //split the children too, if not a leaf
        if (!full.isLeaf()) {
            for (int j = 0; j < 2; j++) left.children.add(full.children.get(j));
            for (int j = 2; j < 4; j++) right.children.add(full.children.get(j));
        }

        //rebuild parent
        parent.items.add(index, middle);
        parent.children.set(index, left);
        parent.children.add(index + 1, right);
    }

    @Override
    public boolean find(E item) {
        return findHelper(root, item);
    }

    private boolean findHelper(Node node, E item) {
        int i = 0;
        while (i < node.items.size() && item.compareTo(node.items.get(i)) > 0) {
            i++;
        }

        if (i < node.items.size() && item.equals(node.items.get(i))) {
            return true;
        }
        if (node.isLeaf()) {
            return false;
        }
        return findHelper(node.children.get(i), item);
    }

    @Override
    public void delete(E item) {
        System.out.println("delete() not implemented for 2-3-4 tree.");
    }

    @Override
    public int height() {
        return heightHelper(root);
    }

    private int heightHelper(Node node) {
        if (node == null || node.isLeaf()) {
            return 0;
        }
        return 1 + heightHelper(node.children.get(0));
    }

    //this will tell you how many 2-, 3-, and 4-nodes exist
    public void status234() {
        int[] count = new int[3]; // 0=two, 1=three, 2=four
        countNodes(root, count);
        System.out.println("two = " + count[0] + " three = " + count[1] + " four = " + count[2]);
    }

    private void countNodes(Node node, int[] count) {
        if (node == null) return;
        int size = node.items.size();
        if (size == 1) count[0]++;
        else if (size == 2) count[1]++;
        else if (size == 3) count[2]++;

        for (Node child : node.children) {
            countNodes(child, count);
        }
    }

    //print the nodes in-order with their type (two/three/four)
    public void print234() {
        printHelper(root);
        System.out.println();
    }

    private void printHelper(Node node) {
        if (node == null) return;

        int i = 0;
        for (; i < node.items.size(); i++) {
            if (!node.isLeaf()) printHelper(node.children.get(i));
            System.out.print("(" + node.items.get(i) + ", " + getType(node.items.size()) + ") ");
        }
        if (!node.isLeaf()) printHelper(node.children.get(i));
    }

    private String getType(int size) {
        return size == 1 ? "two" : size == 2 ? "three" : "four";
    }
}
