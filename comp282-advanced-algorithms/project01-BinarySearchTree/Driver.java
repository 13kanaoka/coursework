public class Driver {
    public static void main(String[] args) {
        System.out.println("Welcome to my demo of Project 1:");

        //create a new binary search tree instance
        myBST<String> bst = new myBST<>();

        //insert elements into the BST
        bst.insert("dog");
        bst.insert("cat");
        bst.insert("pig");
        bst.insert("horse");

        //display tree height and check the presence of certain elements
        System.out.println("The height of the BST is: " + bst.treeHeight());
        System.out.println("pig is present: " + bst.find("pig"));
        System.out.println("pig status is: " + bst.status("pig"));
        System.out.println("pig is in a leaf node: " + bst.isLeaf("pig"));
        System.out.println("pig height is: " + bst.itemHeight("pig"));
        System.out.println("horse is in a leaf node: " + bst.isLeaf("horse"));
        System.out.println("horse height is: " + bst.itemHeight("horse"));

        //delete pig and check if it still exists
        bst.delete("pig");
        System.out.println("pig is present: " + bst.find("pig"));

        //insert more elements into the BST
        bst.insert("mango");
        bst.insert("apple");
        bst.insert("mangrove");
        bst.insert("igloo");

        //display the BST contents
        bst.display();

        //display tree height and subtree heights for a specific element
        System.out.println("The height of the BST is: " + bst.treeHeight());
        System.out.println("horse height is: " + bst.itemHeight("horse"));
        System.out.println("The height of the left subtree of horse is: " + bst.leftHeight("horse"));
        System.out.println("The height of the right subtree of horse is: " + bst.rightHeight("horse"));
    }
}
