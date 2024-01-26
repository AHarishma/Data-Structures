package com.company.tree;

import java.util.List;

public class KthSmallestElementInBST {
    public int kthSmallestElementInBST(TreeNode root, int k) {
        TreeNode current = root;
        while (current != null) {
            TreeNode temp = current.left;
            if (temp != null) {
                while (temp.right != null && temp.right != current) {
                    temp = temp.right;
                }
                if (temp.right == current) {
                    temp.right = null;
                    k--;
                    if (k == 0) {
                        return current.val;
                    }
                    current = current.right;
                } else {
                    temp.right = current;
                    current = current.left;
                }
            } else {
                k--;
                if (k == 0) {
                    return current.val;
                }
                current = current.right;
            }
        }
        return -1;
    }
}
