package com.company.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class TopView {
    List<Integer> topView(TreeNode root) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        dfs(root, 0, map);
        return new ArrayList<Integer>(map.values());
    }

    private void dfs(TreeNode node, int horizontalDistance, TreeMap map) {
        if (node == null) {
            return;
        }

        if (!map.containsKey(horizontalDistance)) {
            map.put(horizontalDistance, node.val);
        }

        dfs(node.left, horizontalDistance - 1, map);
        dfs(node.right, horizontalDistance + 1, map);
    }
}
