package com.company.tree;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class MorrisInorderTraversal {
    public List<Integer> morrisInorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        TreeNode current = root;
        while (current != null) {
            TreeNode temp = current.left;
            if (temp != null) {
                while (temp.right != null && temp.right != current) {
                    temp = temp.right;
                }
                if (temp.right == current) {
                    temp.right = null;
                    list.add(current.val);
                    current = current.right;
                } else {
                    temp.right = current;
                    current = current.left;
                }
            } else {
                list.add(current.val);
                current = current.right;
            }
        }
        return list;
    }
}

/**
 * Inorder Tree Traversal without recursion and without stack!
 * <p>
 * TC - O(N)
 * SC- O(1)
 */
