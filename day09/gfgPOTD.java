// Minimum element in BST
// Given the root of a Binary Search Tree. The task is to find the minimum valued element in this given BST. 
// The task is to complete the function minValue() which takes root as the argument and returns the minimum element of BST. If the tree is empty, there is no minimum element, so return -1 in that case.

class Node {
    int val;
    Node left;
    Node right;

    Node(int x) {
        val = x;
        left = null;
        right = null;
    }
}

public class gfgPOTD {

    public static int findMinimum(Node root) {
        Node current = root;
        while (current.left != null) {
            current = current.left;
        }

        return current.val;
    }

    public static void main(String[] args) {
        // Constructing a BST
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(7);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right.left = new Node(6);
        root.right.right = new Node(8);

        // Finding the minimum value
        int minimumValue = findMinimum(root);
        System.out.println("Minimum value in the BST: " + minimumValue);
    }
}
