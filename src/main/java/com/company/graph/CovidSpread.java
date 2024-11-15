package com.company.graph;

import java.util.LinkedList;
import java.util.Queue;

public class CovidSpread {
    private int[] rowIndex = new int[]{-1, 0, 0, 1};
    private int[] colIndex = new int[]{0, -1, 1, 0};

    public int covidSpread(int[][] hospital) {
        int distance = Integer.MIN_VALUE;
        boolean[][] visited = new boolean[hospital.length][hospital[0].length];
        int unInfectedPatients = 0;
        Queue<PointInfo> queue = new LinkedList<>();
        for (int i = 0; i < hospital.length; i++) {
            for (int j = 0; j < hospital[0].length; j++) {
                if (hospital[i][j] == 2) {
                    visited[i][j] = true;
                    queue.add(new PointInfo(i, j, 0));
                } else if (hospital[i][j] == 1) {
                    unInfectedPatients++;
                }
            }
        }

        if (unInfectedPatients == 0) {
            return 0;
        }

        while (!queue.isEmpty()) {
            PointInfo node = queue.poll();
            distance = Math.max(distance, node.distance);

            for (int i = 0; i < rowIndex.length; i++) {
                int row = node.x + rowIndex[i];
                int col = node.y + colIndex[i];
                if (row >= 0 && row < hospital.length && col >= 0 && col < hospital[0].length
                        && hospital[row][col] == 1 && !visited[row][col]) {
                    visited[row][col] = true;
                    queue.add(new PointInfo(row, col, node.distance + 1));
                    unInfectedPatients--;
                }
            }
        }


        return unInfectedPatients == 0 ? distance : -1;
    }

    private static class PointInfo {
        int x;
        int y;
        int distance;

        public PointInfo(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
}

/**
 *
 * Similar question link: https://www.geeksforgeeks.org/problems/rotten-oranges2536/1
 * Aterp is the head nurse at a city hospital. City hospital contains R*C number of wards and the structure of a hospital is in the form of a 2-D matrix.
 * Given a matrix of dimension R*C where each cell in the matrix can have values 0, 1, or 2 which has the following meaning:
 * 0: Empty ward
 * 1: Cells have uninfected patients
 * 2: Cells have infected patients
 *
 * An infected patient at ward [i,j] can infect other uninfected patient at indexes [i-1,j], [i+1,j], [i,j-1], [i,j+1] (up, down, left and right) in unit time. Help Aterp determine the minimum units of time after which there won't remain any uninfected patient i.e all patients would be infected. If all patients are not infected after infinite units of time then simply return -1.
 *
 *
 *
 *
 * Example 1:
 *
 * Input:
 * 3 5
 * 2 1 0 2 1
 * 1 0 1 2 1
 * 1 0 0 2 1
 * Output:
 * 2
 * Explanation:
 * Patients at positions {0,0}, {0, 3}, {1, 3}
 * and {2, 3} will infect patient at {0, 1},
 * {1, 0},{0, 4}, {1, 2}, {1, 4}, {2, 4} during 1st
 * unit time. And, during 2nd unit time, patient at
 * {1, 0} will get infected and will infect patient
 * at {2, 0}. Hence, total 2 unit of time is
 * required to infect all patients.
 * Example 2:
 *
 * Input:
 * 3 5
 * 2 1 0 2 1
 * 0 0 1 2 1
 * 1 0 0 2 1
 * Output:
 * -1
 * Explanation:
 * All patients will not be infected.
 */
