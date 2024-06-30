package com.company.tree;

import lombok.AllArgsConstructor;

public class BalancedTree {
    boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isBalancedRecursive(root).isBalanced;
    }

    private NodeValue isBalancedRecursive(TreeNode node) {
        if (node == null) {
            return new NodeValue(0, true);
        }
        NodeValue left = isBalancedRecursive(node.left);
        if(!left.isBalanced) {
            return left;
        }
        NodeValue right = isBalancedRecursive(node.right);
        if(!right.isBalanced) {
            return right;
        }

        return new NodeValue(Math.max(left.height, right.height) + 1, Math.abs(left.height - right.height) <= 1);
    }

    @AllArgsConstructor
    class NodeValue {
        private int height;
        private boolean isBalanced;
    }
}

/**
 * Check for Balanced Tree
 * <p>
 * Given a binary tree, find if it is height balanced or not.
 * A tree is height balanced if difference between heights of left and right subtrees
 * is not more than one for all nodes of tree.
 */
