package com.company.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelection {

    public int getNoOfActivities(int[][] times) {
        Arrays.sort(times, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int endTime = 0;
        int activityCount = 0;
        for (int i = 0; i < times.length; i++) {
            if (times[i][0] >= endTime) {
                endTime = times[i][1];
                activityCount++;
            }
        }
        return activityCount;
    }
}

/**
 * Greedy Algorithm
 * <p>
 * Think greedily at every step without considering the future outcomes.
 * <p>
 * Given N activities [s,e] for all s < e.
 * At a given time, you can perform only one activity.
 * Find the maximum number of activities you can perform.
 * Input:
 * [
 * [1, 2]
 * [3, 4]
 * [0, 6]
 * [8, 9]
 * [5, 7]
 * [5, 9]
 * ]
 * <p>
 * Sort based on end time in ascending order:
 * [
 * [1, 2]
 * [3, 4]
 * [0, 6]
 * [5, 7]
 * [8, 9]
 * [5, 9]
 * ]
 * <p>
 * TC: O(NlogN)
 * SC: O(1)
 */