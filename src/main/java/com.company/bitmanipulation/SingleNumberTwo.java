package com.company.bitmanipulation;

public class SingleNumberTwo {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int num : nums) {
                if ((1 << i & num) != 0) {
                    count++;
                }
            }
            if (count % 3 != 0) {
                result |= 1 << i;
            }
        }
        return result;
    }
}
