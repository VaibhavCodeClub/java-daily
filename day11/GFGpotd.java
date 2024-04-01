// Closest Neighbour in BST
// Given the root of a binary search tree and a number n, find the greatest number in the binary search tree that is less than or equal to n. 
/*
n = 24
Output : 
21
Explanation : The greatest element in the tree which 
              is less than or equal to 24, is 21. 
              (Searching will be like 5->12->21)
 */
class Node {
    int key;
    Node left, right;

    Node(int x) {
        key = x;
        left = right = null;
    }

}

public class GFGpotd {
    public static void main(String[] args) {
        // Create a sample BST
        Node root = new Node(5);
        root.left = new Node(2);
        root.right = new Node(12);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.left = new Node(9);
        root.right.right = new Node(21);
        root.right.right.left = new Node(19);
        root.right.right.right = new Node(25);

        // Value to find the nearest element for
        int n = 24;

        // Find the nearest element to n in the BST
        int nearest = findMaxForN(root, n);

        // Print the nearest element found
        System.out.println("Nearest element to " + n + " in the BST: " + nearest);
    }

    public static int findMaxForN(Node root, int n) {
        int max = Integer.MIN_VALUE; // Initialize max to the minimum value

        // Traverse the BST
        while (root != null) {
            // If the current node's key is equal to the target value, return it
            if (root.key == n)
                return n;
            // If current node's key is less than or equal to n, update max and move to the
            // right child
            if (root.key <= n) {
                max = Math.max(max, root.key);
                root = root.right;
            }
            // If current node's key is greater than n, move to the left child
            else {
                root = root.left;
            }
        }
        return max;
    }
}
