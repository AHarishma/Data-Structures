package com.company.tree;

import java.util.ArrayList;
import java.util.List;

public class DFSTraversal {

    public List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preOrderTraversalRecursive(root, result);
        return result;
    }

    private void preOrderTraversalRecursive(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        result.add(node.val);
        preOrderTraversalRecursive(node.left, result);
        preOrderTraversalRecursive(node.right, result);
    }

    public List<Integer> inOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inOrderTraversalRecursive(root, result);
        return result;
    }

    private void inOrderTraversalRecursive(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        inOrderTraversalRecursive(node.left, result);
        result.add(node.val);
        inOrderTraversalRecursive(node.right, result);
    }

    public List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postOrderTraversalRecursive(root, result);
        return result;
    }

    private void postOrderTraversalRecursive(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        postOrderTraversalRecursive(node.left, result);
        postOrderTraversalRecursive(node.right, result);
        result.add(node.val);
    }
}
