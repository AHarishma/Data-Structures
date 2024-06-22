package com.company.binarysearch;

public class ContinuousTaskCompletion {
    public int getMinimumTime(int[] tasks, int k) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int arr : tasks) {
            if (arr > max) {
                max = arr;
            }
            sum += arr;
        }
        int left = max;
        int right = sum;
        int answer = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int total = 0;
            int workers = 1;
            for (int task : tasks) {
                if (total + task <= mid) {
                    total += task;
                } else {
                    total = task;
                    workers = workers + 1;
                }
                if (workers > k) {
                    break;
                }
            }
            if (workers <= k) {
                right = mid - 1;
                answer = mid;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }
}

/**
 * Given a N tasks and K workers. A single worker can only do continuous set of tasks. All workers starts at the same time.
 * A single task can be performed by single worker. Find the minimum time in which all the tasks can be completed.
 * N= 4 [1, 5, 4, 3]
 * K = 3
 * <p>
 * 5 to 13
 * Result -> 6
 */
