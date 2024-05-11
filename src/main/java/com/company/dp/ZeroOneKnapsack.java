package com.company.dp;

public class ZeroOneKnapsack {
    public int knapsack(int W, int wt[], int val[]) {
        int[][] dpTable = new int[wt.length + 1][W + 1];
        for (int i = 1; i <= wt.length; i++) {
            for (int j = 1; j <= W; j++) {
                if (j < wt[i - 1]) {
                    dpTable[i][j] = dpTable[i - 1][j];
                } else {
                    dpTable[i][j] = Math.max(dpTable[i - 1][j], val[i - 1] + dpTable[i - 1][j - wt[i - 1]]);
                }
            }
        }
        return dpTable[wt.length][W];
    }
}

/**
 * Given N items where each item has some weight and profit associated with it and also given a bag with capacity W, [i.e., the bag can hold at most W weight in it]. The task is to put the items into the bag such that the sum of profits associated with them is the maximum possible.
 * <p>
 * Note: The constraint here is we can either put an item completely into the bag or cannot put it at all [It is not possible to put a part of an item into the bag].
 * <p>
 * Input: N = 3, W = 4, profit[] = {1, 2, 3}, weight[] = {4, 5, 1}
 * Output: 3
 * Explanation: There are two items which have weight less than or equal to 4. If we select the item with weight 4, the possible profit is 1. And if we select the item with weight 1, the possible profit is 3. So the maximum possible profit is 3. Note that we cannot put both the items with weight 4 and 1 together as the capacity of the bag is 4.
 * <p>
 * Input: N = 3, W = 3, profit[] = {1, 2, 3}, weight[] = {4, 5, 6}
 * Output: 0
 */