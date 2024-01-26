package com.company.tree;

import java.util.*;

public class OddAndEvenLevels {
    public int solve(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int oddSum = 0;
        int evenSum = 0;
        boolean isOddLevel = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (isOddLevel) {
                    oddSum += node.val;
                } else {
                    evenSum += node.val;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            isOddLevel = !isOddLevel;
        }
        return oddSum - evenSum;
    }
}

/**
 * Odd and Even Levels
 * <p>
 * Problem Description
 * Given a binary tree of integers. Find the difference between the sum of nodes at odd level and sum of nodes at even level.
 * <p>
 * NOTE: Consider the level of root node as 1.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= Number of nodes in binary tree <= 100000
 * <p>
 * 0 <= node values <= 109
 * <p>
 * <p>
 * <p>
 * Input Format
 * First and only argument is a root node of the binary tree, A
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return an integer denoting the difference between the sum of nodes at odd level and sum of nodes at even level.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * 1
 * /   \
 * 2     3
 * / \   / \
 * 4   5 6   7
 * /
 * 8
 * Input 2:
 * <p>
 * 1
 * / \
 * 2   10
 * \
 * 4
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 10
 * Output 2:
 * <p>
 * -7
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * Sum of nodes at odd level = 23
 * Sum of ndoes at even level = 13
 * Explanation 2:
 * <p>
 * Sum of nodes at odd level = 5
 * Sum of ndoes at even level = 12
 */
