package com.company.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class ConnectedComponentsCount {
    public int countConnectedComponents(ArrayList<ArrayList<Integer>> graph) {
        int count = 0;
        boolean[] visited = new boolean[graph.size()];
        Arrays.fill(visited, false);
        for (int i = 1; i < graph.size(); i++) {
            if (!visited[i]) {
                count++;
                dfs(graph, i, visited);
            }
        }
        return count;
    }

    private void dfs(ArrayList<ArrayList<Integer>> graph, int vertex, boolean[] visited) {
        visited[vertex] = true;
        for(int adjacency : graph.get(vertex)) {
            if(!visited[adjacency]) {
                dfs(graph, adjacency, visited);
            }
        }
    }
}

/**
 * https://leetcode.com/problems/number-of-provinces/
 */
