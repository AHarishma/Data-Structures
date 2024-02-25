package com.company.array;

import java.util.ArrayList;
import java.util.List;

public class DoesSubArrayHavingSumEqualToK {
    public boolean doesSubArraysHavingSumEqualToK(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        list.add(0);
        for (int num : nums) {
            sum += num;
            if (list.contains(sum - k)) {
              return true;
            }
            list.add(sum);
        }
        return false;
    }
}
