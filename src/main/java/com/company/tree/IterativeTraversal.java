package com.company.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativeTraversal {
    public List<Integer> inOrder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while (!stack.empty() || temp != null) {
            if (temp != null) {
                stack.add(temp);
                temp = temp.left;
            } else {
                TreeNode current = stack.pop();
                list.add(current.val);
                if (current.right != null) {
                    temp = current.right;
                }
            }
        }
        return list;
    }

    public List<Integer> preOrder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while (!stack.empty() || temp != null) {
            if (temp != null) {
                stack.add(temp);
                list.add(temp.val);
                temp = temp.left;
            } else {
                TreeNode current = stack.pop();
                if (current.right != null) {
                    temp = current.right;
                }
            }
        }
        return list;
    }

    public List<Integer> postOrder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        TreeNode prev = null;
        while (!stack.isEmpty() || temp != null) {
            if (temp != null) {
                stack.add(temp);
                temp = temp.left;
            } else {
                TreeNode current = stack.peek();
                if (current.right != null && current.right != prev) {
                    temp = current.right;
                } else {
                    prev = stack.pop();
                    list.add(prev.val);
                }
            }
        }
        return list;
    }
}
