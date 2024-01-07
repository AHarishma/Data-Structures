package com.company.tree;

import lombok.AllArgsConstructor;

public class SumTree {
    boolean isSumTree(TreeNode root) {
        Result result = sumTree(root);
        return result.isSumTree;
    }

    private Result sumTree(TreeNode root) {
        if (root == null) {
            return new Result(true, 0);
        }
        Result leftResult = sumTree(root.left);
        Result rightResult = sumTree(root.right);

        if (root.left == null && root.right == null) {
            return new Result(true, root.val);
        }

        if (!leftResult.isSumTree || !rightResult.isSumTree || (root.val != leftResult.sum + rightResult.sum)) {
            return new Result(false, 0);
        }

        return new Result(true, leftResult.sum + rightResult.sum + root.val);
    }

    @AllArgsConstructor
    class Result {
        public boolean isSumTree;
        public int sum;
    }
}

/**
 * Given a Binary Tree. Return true if, for every node X in the tree other than the leaves,
 * its value is equal to the sum of its left subtree's value and its right subtree's value. Else return false.
 * <p>
 * An empty tree is also a Sum Tree as the sum of an empty tree can be considered to be 0. A leaf node is also considered a Sum Tree.
 * <p>
 * Input:
 * 3
 * /   \
 * 1     2
 * <p>
 * Output: 1
 * Explanation:
 * The sum of left subtree and right subtree is
 * 1 + 2 = 3, which is the value of the root node.
 * Therefore,the given binary tree is a sum tree.
 */