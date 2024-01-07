package com.company.tree;

import java.util.ArrayList;
import java.util.List;

public class PathSum2 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        pathSumRecursive(root, targetSum, new ArrayList<>(), result);
        return result;
    }

    private void pathSumRecursive(TreeNode node, int targetSum, List<Integer> currentList, List<List<Integer>> result) {
        if(node == null) {
            return;
        }
        currentList.add(node.val);
        if(node.left == null && node.right == null && targetSum == node.val) {
            result.add(new ArrayList<>(currentList));
        }
        pathSumRecursive(node.left, targetSum - node.val,  currentList, result);
        pathSumRecursive(node.right, targetSum - node.val, currentList, result);
        currentList.remove(currentList.size() - 1);
    }
}

/**
 * Given the root of a binary tree and an integer targetSum,
 * return all root-to-leaf paths where the sum of the node values in the path equals targetSum.
 * Each path should be returned as a list of the node values, not node references.
 *
 * A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.
 *
 * Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * Output: [[5,4,11,2],[5,8,4,5]]
 * Explanation: There are two paths whose sum equals targetSum:
 * 5 + 4 + 11 + 2 = 22
 * 5 + 8 + 4 + 5 = 22
 */