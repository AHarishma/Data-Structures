package com.company.tree;

public class RemoveHalfNodes {

    public TreeNode removeHalfNodes(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }
        if (root.left != null && root.right != null) {
            root.left = removeHalfNodes(root.left);
            root.right = removeHalfNodes(root.right);
            return root;
        }

        return root.left == null ? removeHalfNodes(root.right) : removeHalfNodes(root.left);
    }
}

/**
 * Given A binary Tree. Your task is to remove all the half nodes (which has only one child).
 * <p>
 * <p>
 * Input:
 * 7
 * /   \
 * 7     8
 * /
 * 2
 * Output: 2 7 8
 * <p>
 * 2
 * /   \
 * 7     5
 * \      \
 * 9      1
 * /  \
 * 11   4
 * Output: 11 9 4 2 1
 */