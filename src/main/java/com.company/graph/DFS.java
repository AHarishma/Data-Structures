package com.company.graph;

import java.util.Arrays;

public class DFS {
    public void depthFirstSearch(int[][] graph) {
        boolean[] visited = new boolean[graph.length];
        Arrays.fill(visited, false);
        dfs(graph, 0, visited);
    }

    private void dfs(int[][] graph, int v, boolean[] visited) {
        visited[v] = true;
        for (int i = 0; i < graph[v].length; i++) {
            int adj = graph[v][i];
            if (adj == 1 && !visited[i]) {
                dfs(graph, i, visited);
            }
        }
    }
}

/**
 * TC: O(V + E)
 * SC: O(V)
 */
