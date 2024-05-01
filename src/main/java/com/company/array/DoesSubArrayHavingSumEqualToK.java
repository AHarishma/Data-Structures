package com.company.array;

import java.util.HashSet;
import java.util.Set;

public class DoesSubArrayHavingSumEqualToK {
    public boolean doesSubArraysHavingSumEqualToK(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        set.add(0);
        for (int num : nums) {
            sum += num;
            if (set.contains(sum - k)) {
              return true;
            }
            set.add(sum);
        }
        return false;
    }
}
