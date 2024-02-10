package com.company.graph;

import java.util.*;

public class TopologicalSort {
    public List<Integer> topologicalSort(int[][] edges, int n) {
        int[] incomingEdges = getIncomingEdges(edges, n);
        Map<Integer, List<Integer>> graph = generateGraph(edges);
        Queue<Integer> queue = new LinkedList();
        for(int i = 1; i <= n; i++) {
            if(incomingEdges[i] == 0) {
                queue.add(i);
            }
        }
        List<Integer> result = new ArrayList<>();
        while(!queue.isEmpty()) {
            Integer vertex = queue.poll();
            result.add(vertex);
            for(int adjacent : graph.getOrDefault(vertex, new ArrayList<>())) {
                incomingEdges[adjacent]--;
                if(incomingEdges[adjacent] == 0) {
                    queue.add(adjacent);
                }
            }
        }
        return result;
    }

    private int[] getIncomingEdges(int[][] edges, int n) {
        int[] count = new int[n+1];
        Arrays.fill(count, 0);
        for(int[] edge : edges) {
            count[edge[1]]++;
        }
        return count;
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
 * Topological sort is an arrangement of all the vertices in an order such that if vertex i is pointing to vertex j then vertex i should come before vertex j.
 *
 * i	-> 	j
 * Topological sort: i, j
 *
 * 1, 2, 4, 3, 5, 6
 * 1, 2, 3, 4, 5, 6
 *
 * You are given a directed acyclic graph. Print in topological sorting order.
 *
 * [1, 2, 4, 3, 5, 6]
 * [
 * 	[1, 2],
 * 	[1, 4],
 * 	[2, 3],
 * 	[4, 3],
 * 	[4, 5],
 * 	[3, 6],
 * 	[5, 6]
 * ]
 *
 * * Dependency order of the job
 *  * 6, 3, 5, 2, 4, 1
 *  * // reverse order of topological sorting order.
 */