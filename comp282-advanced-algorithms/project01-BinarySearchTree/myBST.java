public class myBST<E extends Comparable<E>> implements BinaryTree<E> {
    private class Node {
        E data;
        Node left, right;

        //initalize node
        Node(E item) {
            data = item;
            left = right = null;
        }
    }

    private Node root;

    //insert a new item into the BST
    @Override
    public void insert(E item) {
        root = insertRec(root, item);  //start recursive insertion
    }

    //recursive insertion
    private Node insertRec(Node root, E item) {
        //if current node = null, create new node
        if (root == null) return new Node(item);

        //if item is less than current node's data, insert in left subtree
        if (item.compareTo(root.data) < 0)
            root.left = insertRec(root.left, item);
        //if item is greater than current node's data, insert in right subtree
        else if (item.compareTo(root.data) > 0)
            root.right = insertRec(root.right, item);

        return root;  //return the current node after insertion
    }

    //deletes the specified item from the BST
    @Override
    public void delete(E item) {
        root = deleteRec(root, item);  //start recursive deletion
    }

    //recursive deletion
    private Node deleteRec(Node root, E item) {
        if (root == null) return root;  //if root = null, nothing to delete

        //if item to be deleted is smaller, go left
        if (item.compareTo(root.data) < 0)
            root.left = deleteRec(root.left, item);
        //if item to be deleted is greater, go right
        else if (item.compareTo(root.data) > 0)
            root.right = deleteRec(root.right, item);
        else {
            //if node has one or no children
            if (root.left == null) return root.right;  //if no left child, return right child
            if (root.right == null) return root.left;  //if no right child, return left child

            root.data = minValue(root.right);
            root.right = deleteRec(root.right, root.data);
        }
        return root;  //return new root
    }

    //find the minimum value node in the given subtree
    private E minValue(Node root) {
        E min = root.data;
        while (root.left != null) {
            min = root.left.data;
            root = root.left;
        }
        return min;
    }

    //finds if an item is present in the BST
    @Override
    public boolean find(E item) {
        return findRec(root, item);
    }

    private boolean findRec(Node root, E item) {
        if (root == null) return false;
        if (item.compareTo(root.data) == 0) return true;
        return item.compareTo(root.data) < 0 ? findRec(root.left, item) : findRec(root.right, item);
    }

    //returns the height of the entire tree
    @Override
    public int treeHeight() {
        return height(root);
    }

    //returns the height of the tree starting from the given item
    @Override
    public int itemHeight(E item) {
        Node node = findNode(root, item);
        return node == null ? -1 : height(node);
    }

    //returns the height of the left subtree of the item
    @Override
    public int leftHeight(E item) {
        Node node = findNode(root, item);
        return (node == null || node.left == null) ? -1 : height(node.left);
    }

    //returns the height of the right subtree of the item
    @Override
    public int rightHeight(E item) {
        Node node = findNode(root, item);
        return (node == null || node.right == null) ? -1 : height(node.right);
    }

    //check if node with given item is leaf
    @Override
    public boolean isLeaf(E item) {
        Node node = findNode(root, item);
        return node != null && node.left == null && node.right == null;
    }

    //returns the status of the node
    @Override
    public int status(E item) {
        if (root == null) return -1;  //if the tree is empty return -1
        if (root.data.equals(item)) return 0;  //if the root is the item return 0
        return statusRec(root, item);  //otherwise
    }

    //recursive status checking
    private int statusRec(Node root, E item) {
        if (root == null) return -1;
        if (root.left != null && root.left.data.equals(item)) return 1;
        if (root.right != null && root.right.data.equals(item)) return 2;
        return item.compareTo(root.data) < 0 ? statusRec(root.left, item) : statusRec(root.right, item);
    }

    //displays the tree in descending order
    @Override
    public void display() {
        displayDesc(root);
        System.out.println();
    }

    //reverse in-order traversal
    private void displayDesc(Node root) {
        if (root != null) {
            displayDesc(root.right);
            System.out.print(root.data + " ");
            displayDesc(root.left);
        }
    }

    //finds the node containing the given item
    private Node findNode(Node root, E item) {
        if (root == null || root.data.equals(item)) return root;
        return item.compareTo(root.data) < 0 ? findNode(root.left, item) : findNode(root.right, item);
    }

    //calculate the height of a given node
    private int height(Node node) {
        if (node == null) return -1;
        return 1 + Math.max(height(node.left), height(node.right));
    }
}
