package com.company.greedy;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class JobScheduling {
    public int jobSchedule(List<Job> jobs) {
        Collections.sort(jobs, new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                return o1.deadline - o2.deadline;
            }
        });
        PriorityQueue<Integer> minHeap = new PriorityQueue();
        for (Job job : jobs) {
            if (minHeap.size() == job.deadline) {
                int min = minHeap.poll();
                minHeap.add(job.rewards > min ? job.rewards : min);
            } else if (minHeap.size() < job.deadline) {
                minHeap.add(job.rewards);
            }
        }
        int total = 0;
        while (!minHeap.isEmpty()) {
            total += minHeap.poll();
        }
        return total;
    }
}

/**
 * Job Scheduling Algorithm
 * <p>
 * Given N jobs which has rewards and deadlines.
 * At any time, a single job can be performed
 * Each job take 1 unit of time to complete
 * Find the maximum total amount of reward that we can earn.
 * <p>
 * Job			Deadline			Reward
 * a						3					100
 * b						1					19
 * c						2					27
 * d						1					25
 * e						3					30
 * [_,_,_]
 * <p>
 * <p>
 * Sort deadline based on ascending order
 * Job			Deadline			Reward
 * b						1					19
 * d						1					25
 * c						2					27
 * e						3					30
 * a						3					100
 * <p>
 * Constraint: Deadline > 0
 * sum[100, 27, 30] => 157
 * Use MinHeap
 *
 * TC: O(NlogN)
 * SC: O(N)
 */
