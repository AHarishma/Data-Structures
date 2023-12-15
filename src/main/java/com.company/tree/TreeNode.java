package com.company.tree;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class TreeNode {
    int val;
    com.company.tree.TreeNode left;
    com.company.tree.TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

