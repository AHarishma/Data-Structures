package com.company.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EdgesListDfs {
    public void depthFirstSearch(int[][] edges, int n) {
        Map<Integer, List<Integer>> graph = generateGraph(edges);
        boolean[] visited = new boolean[n];
        dfs(graph, 0, visited);
    }

    private void dfs(Map<Integer, List<Integer>> graph, int vertex, boolean[] visited) {
        visited[vertex] = true;
        for(int adjacent : graph.getOrDefault(vertex, new ArrayList<>())) {
            if(!visited[adjacent]) {
                dfs(graph, adjacent, visited);
            }
        }
    }

    private Map<Integer, List<Integer>> generateGraph(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] edge: edges) {
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.get(edge[0]).add(edge[1]);
        }
        return graph;
    }
}

/**
 * Given an edges list, do dfs/bfs of the graph.
 * [{703, 703}, {279, 279}, {279, 43}, {279, 703}, {43, 279}, {43, 703}, {43, 45}]
 */
