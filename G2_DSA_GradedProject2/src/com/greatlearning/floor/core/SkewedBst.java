package com.greatlearning.floor.core;

//creation of tree by declaring key,left and right for node. 
class TreeNode {
    int key;
    TreeNode left, right;
    //constructor
    public TreeNode(int item) {
        key = item;
        left = right = null;
    }
}
public class SkewedBst {
    TreeNode root;

    // Perform right rotation to convert BST to skewed tree
    private TreeNode rightRotate(TreeNode y) {
        TreeNode x = y.left;
        y.left = x.right;
        x.right = y;
        return x;
    }

    // Convert BST to skewed tree using right rotation
    private TreeNode convertToSkewedTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        // Performing in-order traversal and right rotation for each node
        while (root.left != null) {
            root = rightRotate(root);
        }

        // Recursively convert right subtree
        root.right = convertToSkewedTree(root.right);

        return root;
    }

    // In-order traversal to display node values in ascending order
    private void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.key + " ");
            inOrder(root.right);
        }
    }

    public static void main(String[] args) {
        SkewedBst bst = new SkewedBst();

        
        bst.root = new TreeNode(50);
        bst.root.left = new TreeNode(30);
        bst.root.right = new TreeNode(60);
        bst.root.left.left = new TreeNode(10);
        //bst.root.left.right = new TreeNode(45);
        bst.root.right.left = new TreeNode(55);

       
        // Converting BST to skewed tree
        TreeNode skewedRoot = bst.convertToSkewedTree(bst.root);
        //after converting into skewed tree ,arranging in ascending order using inorder traversal.
        System.out.println("Skewed Tree (ascending order):");
        bst.inOrder(skewedRoot);
    }
}
/**
 * Team members:
 * 1.Shivam Kumar Raj
 * 2.Syed Shoebuddin
 * 3.Ishika Nehra
 * 4.Sandeep
 */
 
