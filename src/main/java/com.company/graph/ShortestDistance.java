package com.company.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistance {
    public int[] shortestDistance(ArrayList<ArrayList<Integer>> graph, int vertex) {
        int[] distance = new int[graph.size()];
        distance[vertex] = 0;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[graph.size()];
        queue.add(vertex);
        visited[vertex] = true;
        while (!queue.isEmpty()) {
            Integer v = queue.poll();
            for (int adjacent : graph.get(v)) {
                if (!visited[adjacent]) {
                    queue.add(adjacent);
                    visited[adjacent] = true;
                    distance[adjacent] = distance[v] + 1;
                }
            }
        }
        return distance;
    }
}

/**
 * Given an undirected graph, find the shortest distance between a given node and all other edges.
 */
