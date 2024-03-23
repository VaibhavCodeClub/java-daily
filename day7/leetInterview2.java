/*
You are given the root node of a binary search tree (BST) and a value to insert into the tree. Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.

Notice that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return any of them.
 */

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class leetInterview2 {
    public static void main(String[] args) {
        // Create a BST
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        // Print the original BST
        System.out.println("Original BST:");
        printBST(root);

        // Insert a new value into the BST
        int newValue = 5;
        Solution solution = new Solution();
        TreeNode modifiedRoot = solution.insertIntoBST(root, newValue);

        // Print the modified BST
        System.out.println("\nBST after inserting " + newValue + ":");
        printBST(modifiedRoot);
    }

    // Helper method to print the BST in in-order traversal
    public static void printBST(TreeNode root) {
        if (root != null) {
            printBST(root.left);
            System.out.print(root.val + " ");
            printBST(root.right);
        }
    }
}

class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // If the root is null, create a new node with the given value and return it
        if (root == null) {
            return new TreeNode(val);
        }

        // If the value is less than the root's value, insert into the left subtree
        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        }
        // If the value is greater than or equal to the root's value, insert into the
        // right subtree
        else {
            root.right = insertIntoBST(root.right, val);
        }

        // Return the modified root node
        return root;
    }
}