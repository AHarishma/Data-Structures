package com.company.tree;

public class DiameterOfTree {
    int max = 0;

    public int diameter(TreeNode root) {
        height(root);
        return max;
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        max = Math.max(max, leftHeight + rightHeight + 1);
        return 1 + Math.max(leftHeight, rightHeight);
    }
}

/**
 * https://practice.geeksforgeeks.org/problems/diameter-of-binary-tree/1
 * <p>
 * Diameter of a Binary Tree
 * The diameter of a tree (sometimes called the width) is the number of nodes on the longest path between two end nodes.
 * The diagram below shows two trees each with diameter nine, the leaves that form the ends of the longest path are shaded
 * (note that there is more than one path in each tree of length nine, but no path longer than nine nodes).
 * <p>
 * Input:
 * 10
 * /   \
 * 20    30
 * /   \
 * 40   60
 * Output: 4
 */
