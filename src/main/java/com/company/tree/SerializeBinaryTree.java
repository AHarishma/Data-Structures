package com.company.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SerializeBinaryTree {
    public int[] serializeBinaryTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.val != -1) {
                queue.add(node.left != null ? node.left : new TreeNode(-1));
                queue.add(node.right != null ? node.right : new TreeNode(-1));
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}

/**
 * Serialize Binary Tree
 * <p>
 * Problem Description
 * Given the root node of a Binary Tree denoted by A. You have to Serialize the given Binary Tree in the described format.
 * <p>
 * Serialize means encode it into a integer array denoting the Level Order Traversal of the given Binary Tree.
 * <p>
 * NOTE:
 * <p>
 * In the array, the NULL/None child is denoted by -1.
 * For more clarification check the Example Input.
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= number of nodes <= 105
 * <p>
 * <p>
 * <p>
 * Input Format
 * Only argument is a A denoting the root node of a Binary Tree.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return an integer array denoting the Level Order Traversal of the given Binary Tree.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * 1
 * /   \
 * 2     3
 * / \
 * 4   5
 * Input 2:
 * <p>
 * 1
 * /   \
 * 2     3
 * / \     \
 * 4   5     6
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * [1, 2, 3, 4, 5, -1, -1, -1, -1, -1, -1]
 * Output 2:
 * <p>
 * [1, 2, 3, 4, 5, -1, 6, -1, -1, -1, -1, -1, -1]
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * The Level Order Traversal of the given tree will be [1, 2, 3, 4, 5 , -1, -1, -1, -1, -1, -1].
 * Since 3, 4 and 5 each has both NULL child we had represented that using -1.
 * Explanation 2:
 * <p>
 * The Level Order Traversal of the given tree will be [1, 2, 3, 4, 5, -1, 6, -1, -1, -1, -1, -1, -1].
 * Since 3 has left child as NULL while 4 and 5 each has both NULL child.
 */
