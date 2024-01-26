package com.company.tree;

import java.util.ArrayList;
import java.util.List;

public class SideView {

    public List<Integer> leftSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        leftSideViewRecursive(root, 0, result);
        return result;
    }

    private void leftSideViewRecursive(TreeNode node, int index, List<Integer> result) {
        if (node == null) {
            return;
        }

        if (index == result.size()) {
            result.add(node.val);
        }

        leftSideViewRecursive(node.left, index + 1, result);
        leftSideViewRecursive(node.right, index + 1, result);
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        rightSideViewRecursive(root, 0, result);
        return result;
    }

    private void rightSideViewRecursive(TreeNode node, int index, List<Integer> result) {
        if (node == null) {
            return;
        }

        if (index == result.size()) {
            result.add(node.val);
        }

        rightSideViewRecursive(node.right, index + 1, result);
        rightSideViewRecursive(node.left, index + 1, result);
    }
}

