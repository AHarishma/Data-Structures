package com.company.tree;

public class IsValidBstInConstantSpace {
    public boolean isValidBst(TreeNode root) {
        TreeNode current = root;
        TreeNode previous = null;
        while (current != null) {
            TreeNode temp = current.left;
            if (temp != null) {
                while (temp.right != null && temp.right != current) {
                    temp = temp.right;
                }
                if (temp.right == current) {
                    temp.right = null;
                    if (previous.val >= current.val) {
                        return false;
                    }
                    previous = current;
                    current = current.right;
                } else {
                    temp.right = current;
                    current = current.left;
                }
            } else {
                if (previous != null && previous.val >= current.val) {
                    return false;
                }
                previous = current;
                current = current.right;
            }
        }
        return true;
    }
}
