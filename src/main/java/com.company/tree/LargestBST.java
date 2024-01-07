package com.company.tree;

import lombok.AllArgsConstructor;

public class LargestBST {

    @AllArgsConstructor
    class Range {
        int minValue;
        int maxValue;
        int maxSize;
    }

    public int findLargestBST(TreeNode node) {
        return findLargestBSTSubtree(node).maxSize;
    }

    private Range findLargestBSTSubtree(TreeNode node) {
        if (node == null) {
            return new Range(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }
        Range leftSubTree = findLargestBSTSubtree(node.left);
        Range rightSubTree = findLargestBSTSubtree(node.right);

        if (leftSubTree.maxValue < node.val && node.val < rightSubTree.minValue) {
            return new Range(Math.min(node.val, leftSubTree.minValue), Math.max(node.val, leftSubTree.maxValue), 1 + leftSubTree.maxSize + rightSubTree.maxSize);
        }
        return new Range(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(leftSubTree.maxSize, rightSubTree.maxSize));
    }

}

/**
 * Given a binary tree. Find the size of its largest subtree that is a Binary Search Tree.
 * Note: Here Size is equal to the number of nodes in the subtree.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * 1
 * /   \
 * 4     4
 * /   \
 * 6     8
 * Output: 1
 * Explanation: There's no sub-tree with size
 * greater than 1 which forms a BST. All the
 * leaf Nodes are the BSTs with size equal
 * to 1.
 * <p>
 * Input: 6 6 3 N 2 9 3 N 8 8 2
 * 6
 * /       \
 * 6         3
 * \      /   \
 * 2    9     3
 * \  /  \
 * 8 8    2
 * Output: 2
 * Explanation: The following sub-tree is a
 * BST of size 2:
 * 2
 * /    \
 * N      8
 */
