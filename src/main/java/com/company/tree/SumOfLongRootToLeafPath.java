package com.company.tree;

public class SumOfLongRootToLeafPath {
    int maxSum = Integer.MIN_VALUE;
    int maxPathLength = Integer.MIN_VALUE;
    public int sumOfLongRootToLeafPath(TreeNode root)
    {
        sumOfLongRootToLeafPathRecursive(root, 0, 0);
        return maxSum;
    }

    private void sumOfLongRootToLeafPathRecursive(TreeNode node, int sum, int pathLength) {
        if(node == null) {
            return;
        }
        sum = sum + node.val;
        pathLength = pathLength + 1;
        sumOfLongRootToLeafPathRecursive(node.left, sum, pathLength);
        sumOfLongRootToLeafPathRecursive(node.right, sum, pathLength);
        if(pathLength > maxPathLength) {
            maxPathLength = pathLength;
            maxSum = sum;
        } else if(pathLength == maxPathLength){
            maxSum = Math.max(sum, maxSum);
        }
    }
}

/**
 * Given a binary tree of size N. Your task is to complete the function sumOfLongRootToLeafPath(),
 * that find the sum of all nodes on the longest path from root to leaf node.
 * If two or more paths compete for the longest path, then the path having maximum sum of nodes is being considered.
 *
 * Input:
 *         4
 *        / \
 *       2   5
 *      / \ / \
 *     7  1 2  3
 *       /
 *      6
 * Output: 13
 * Explanation:
 *         4
 *        / \
 *       2   5
 *      / \ / \
 *     7  1 2  3
 *       /
 *      6
 *
 * The highlighted nodes (4, 2, 1, 6) above are
 * part of the longest root to leaf path having
 * sum = (4 + 2 + 1 + 6) = 13
 *
 * Input:
 *           1
 *         /   \
 *        2     3
 *       / \   / \
 *      4   5 6   7
 * Output: 11
 */
