package com.company.tree;

import com.sun.source.tree.Tree;

public class BalancedTree {
    boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return Math.abs(leftHeight - rightHeight) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }
}

/**
 * Check for Balanced Tree
 * <p>
 * Given a binary tree, find if it is height balanced or not.
 * A tree is height balanced if difference between heights of left and right subtrees is not more than one for all nodes of tree.
 */
