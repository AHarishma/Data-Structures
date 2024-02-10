package com.company.tree;

import java.util.*;

public class DiagonalTraversal {

    public List<Integer> diagonal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        Map<Integer, List<Integer>> diagonalMap = new HashMap<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int diagonalLevel = 0;
            while (node != null) {
                diagonalMap.putIfAbsent(diagonalLevel, new ArrayList<>());
                diagonalMap.get(diagonalLevel).add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                node = node.right;
            }
            diagonalLevel++;
        }
        ArrayList<Integer> output = new ArrayList<>();
        for (int level : diagonalMap.keySet()) {
            output.addAll(diagonalMap.get(level));
        }
        return output;
    }
}

/**
 * Given a Binary Tree, print the diagonal traversal of the binary tree.
 * <p>
 * Consider lines of slope -1 passing between nodes. Given a Binary Tree, print all diagonal elements in a binary tree belonging to same line.
 * If the diagonal element are present in two different subtress then left subtree diagonal element should be taken first and then right subtree.
 * <p>
 * Example 1:
 * <p>
 * Input :
 * 8
 * /     \
 * 3      10
 * /   \      \
 * 1     6     14
 * /   \   /
 * 4     7 13
 * Output : 8 10 14 3 6 7 13 1 4
 */
