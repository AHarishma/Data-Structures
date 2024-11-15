package com.company.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingsInOneRoom {
    public int maxMeetings(int start[], int end[], int n) {
        int[][] times = new int[n][1];
        for (int i = 0; i < n; i++) {
            times[i] = new int[]{start[i], end[i]};
        }
        Arrays.sort(times, new Comparator<int[]>() {
            @Override
            public int compare(int[] time1, int[] time2) {
                return time1[1] - time2[1];
            }
        });
        int endTime = -1;
        int noOfMeetings = 0;
        for (int i = 0; i < n; i++) {
            if (times[i][0] > endTime) {
                endTime = times[i][1];
                noOfMeetings++;
            }
        }
        return noOfMeetings;
    }
}

//endtime = 8
//      no of meetings = 2
//[2, 7]
//[5, 8]
//[7, 9]

/**
 * There is one meeting room in a firm. There are N meetings in the form of (start[i], end[i]) where start[i] is start time of meeting i and end[i] is finish time of meeting i.
 * What is the maximum number of meetings that can be accommodated in the meeting room when only one meeting can be held in the meeting room at a particular time?
 * <p>
 * Note: Start time of one chosen meeting can't be equal to the end time of the other chosen meeting.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input:
 * N = 6
 * start[] = {1,3,0,5,8,5}
 * end[] =  {2,4,6,7,9,9}
 * Output:
 * 4
 * Explanation:
 * Maximum four meetings can be held with
 * given start and end timings.
 * The meetings are - (1, 2),(3, 4), (5,7) and (8,9)
 * Example 2:
 * <p>
 * Input:
 * N = 3
 * start[] = {10, 12, 20}
 * end[] = {20, 25, 30}
 * Output:
 * 1
 * Explanation:
 * Only one meetings can be held
 * with given start and end timings.
 */
