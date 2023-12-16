package com.company.tree;

import java.util.*;

public class ZigZagLevelOrderTraversal {
    public int[][] zigZagLevelOrderTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> result = new ArrayList<>();
        boolean isReverse = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (isReverse) {
                    level.add(0, node.val);
                } else {
                    level.add(node.val);
                }

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            result.add(level);
            isReverse = !isReverse;
        }
        int[][] zigZagArray = new int[result.size()][];
        for (int i = 0; i < result.size(); i++) {
            List<Integer> levelList = result.get(i);
            zigZagArray[i] = new int[levelList.size()];
            for (int j = 0; j < levelList.size(); j++) {
                zigZagArray[i][j] = levelList.get(j);
            }
        }

        return zigZagArray;
    }
}

/**
 * ZigZag Level Order Traversal Binary Tree:
 * <p>
 * Problem Description
 * Given a binary tree, return the zigzag level order traversal of its nodes values. (ie, from left to right, then right to left for the next level and alternate between).
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= number of nodes <= 105
 * <p>
 * <p>
 * <p>
 * Input Format
 * First and only argument is root node of the binary tree, A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return a 2D integer array denoting the zigzag level order traversal of the given binary tree.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * Input 2:
 * <p>
 * 1
 * / \
 * 6   2
 * /
 * 3
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * [
 * [3],
 * [20, 9],
 * [15, 7]
 * ]
 * Output 2:
 * <p>
 * [
 * [1]
 * [2, 6]
 * [3]
 * ]
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * Return the 2D array. Each row denotes the zigzag traversal of each level.
 */
