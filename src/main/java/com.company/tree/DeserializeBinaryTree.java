package com.company.tree;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class DeserializeBinaryTree {
    public TreeNode solve(int[] A) {
        if (A.length == 0) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(A[0]);
        queue.add(root);
        int i = 1;
        while (i < A.length) {
            TreeNode current = queue.poll();
            if (A[i] != -1) {
                current.left = new TreeNode(A[i]);
                queue.add(current.left);
            }
            i++;
            if (i < A.length && A[i] != -1) {
                current.right = new TreeNode(A[i]);
                queue.add(current.right);
            }
            i++;
        }
        return root;
    }
}

/**
 * Deserialize Binary Tree:
 * <p>
 * Problem Description
 * You are given an integer array A denoting the Level Order Traversal of the Binary Tree.
 * <p>
 * You have to Deserialize the given Traversal in the Binary Tree and return the root of the Binary Tree.
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
 * -1 <= A[i] <= 105
 * <p>
 * <p>
 * <p>
 * Input Format
 * Only argument is an integer array A denoting the Level Order Traversal of the Binary Tree.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return the root node of the Binary Tree.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [1, 2, 3, 4, 5, -1, -1, -1, -1, -1, -1]
 * Input 2:
 * <p>
 * A = [1, 2, 3, 4, 5, -1, 6, -1, -1, -1, -1, -1, -1]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 1
 * /   \
 * 2     3
 * / \
 * 4   5
 * Output 2:
 * <p>
 * 1
 * /   \
 * 2     3
 * / \ .   \
 * 4   5 .   6
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * Each element of the array denotes the value of the node. If the val is -1 then it is the NULL/None child.
 * Since 3, 4 and 5 each has both NULL child we had represented that using -1.
 * Explanation 2:
 * <p>
 * Each element of the array denotes the value of the node. If the val is -1 then it is the NULL/None child.
 * Since 3 has left child as NULL while 4 and 5 each has both NULL child.
 */