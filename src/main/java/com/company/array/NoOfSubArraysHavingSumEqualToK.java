package com.company.array;

import java.util.HashMap;
import java.util.Map;

public class NoOfSubArraysHavingSumEqualToK {
    public int noOfSubArraysHavingSumEqualToK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int sum = 0;
        map.put(0, 1);
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
