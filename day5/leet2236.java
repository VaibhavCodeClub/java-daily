// Root Equals Sum of Children
// You are given the root of a binary tree that consists of exactly 3 nodes: the root, its left child, and its right child.

// Return true if the value of the root is equal to the sum of the values of its two children, or false otherwise.

/**
 * Definition for a binary tree node.
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

public class leet2236 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(10, new TreeNode(4), new TreeNode(6));
        System.out.println(checkTree(treeNode));
    }

    public static boolean checkTree(TreeNode root) {
        if (root == null)
            return true;
        return root.val == root.right.val + root.left.val;
    }
}
