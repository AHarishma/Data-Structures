package com.company.tree;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

public class BinarySearchTreeValidator {
    public boolean validateBinarySearchTree(TreeNode root) {
        return validateBST(root, new Range(Long.MIN_VALUE, Long.MAX_VALUE));
    }

    private boolean validateBST(TreeNode root, Range range) {
        if (root == null) {
            return true;
        }
        if (root.val <= range.min || root.val >= range.max) {
            return false;
        }
        return validateBST(root.left, new Range(root.val, range.max)) && validateBST(root.right, new Range(range.min, root.val));
    }

    @NoArgsConstructor
    @AllArgsConstructor
    class Range {
        long min;
        long max;
    }
}

/**
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 *
 * A valid BST is defined as follows:
 *
 * The left
 * subtree
 *  of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 */
