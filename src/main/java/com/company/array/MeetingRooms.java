package com.company.array;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRooms {

    public static int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= minHeap.peek()) {
                minHeap.poll();
            }
            minHeap.add(intervals[i][1]);
        }
        return minHeap.size();
    }

    public static void main(String[] args) {
        int[][] intervals = {{0, 15}, {5, 10}, {10, 25}, {15, 20}};


        System.out.println("Minimum number of meeting rooms required: " + minMeetingRooms(intervals));
    }
}
