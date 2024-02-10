package com.company.tree;

public class InsertNodeInBST {
    public TreeNode insert(TreeNode root, int key) {
       if(root == null) {
           return new TreeNode(key);
       }
        if(root.val == key) {
            return root;
        }

       if(key > root.val) {
            root.right = insert(root.right, key);
       } else {
            root.left = insert(root.left, key);
       }
       return root;
    }
}

/**
 * Given a BST and a key K. If K is not present in the BST, Insert a new Node with a value equal to K into the BST. If K is already present in the BST, don't modify the BST.
 *
 * Example 1:
 *
 * Input:
 *      2
 *    /   \
 *   1     3
 * K = 4
 * Output:
 * 1 2 3 4
 * Explanation:
 * After inserting the node 4
 * Inorder traversal will be 1 2 3 4.
 * Example 2:
 *
 * Input:
 *         2
 *       /   \
 *      1     3
 *              \
 *               6
 * K = 4
 * Output:
 * 1 2 3 4 6
 * Explanation:
 * After inserting the node 4
 * Inorder traversal of the above tree will be 1 2 3 4 6.
 */
