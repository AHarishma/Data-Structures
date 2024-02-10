package com.company.tree;
import java.util.*;

public class BottomView {
    public List<Integer> bottomView(Node root) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        bfs(root, map);
        return new ArrayList<>(map.values());
    }

    private void bfs(Node root, TreeMap map) {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        root.horizontalDistance = 0;
        queue.add(root);

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            map.put(node.horizontalDistance, node.val);

            if(node.left != null) {
                node.left.horizontalDistance = node.horizontalDistance - 1;
                queue.add(node.left);
            }

            if(node.right != null) {
                node.right.horizontalDistance = node.horizontalDistance + 1;
                queue.add(node.right);
            }
        }
    }
}

