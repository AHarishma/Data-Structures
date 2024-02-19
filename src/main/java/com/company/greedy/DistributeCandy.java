package com.company.greedy;

public class DistributeCandy {
    public int distributeCandy(int[] arr) {
        int[] result = new int[arr.length];
        int chocolate = 1;
        result[0] = chocolate;
        for (int i = 1; i < arr.length; i++) {
            chocolate = arr[i] > arr[i - 1] ? chocolate + 1 : 1;
            result[i] = chocolate;
        }
        chocolate = 1;
        result[arr.length - 1] = Math.max(chocolate, result[arr.length - 1]);
        for (int i = arr.length - 2; i >= 0; i--) {
            chocolate = arr[i] > arr[i + 1] ? chocolate + 1 : 1;
            result[i] = Math.max(chocolate, result[i]);
        }

        int sum = 0;
        for (int i = 0; i < result.length; i++) {
            sum += result[i];
        }

        return sum;
    }

}
/**
 * Distribute Candy to Children
 * There are N children each children has ratings
 * You have to give candies to all the children
 * Child with higher rating than it’s neighbour should get more candy than neighbour
 * Goal is to minimise the total number of candies distributed.
 * <p>
 * A: [1, 3, 2, 4, 5, 3, 2, 1, 4, 6]
 * L: [1, 2, 1, 2, 3, 1, 1, 1, 2, 3]
 * R: [1, 2, 1, 1, 4, 3, 2, 1, 1, 1]
 * Max[1, 2, 1, 2, 4, 3, 2, 1, 2, 3]
 * Sum[21]
 * <p>
 * TC: O(N)
 * SC: O(N)
 * <p>
 * <p>
 * https://leetcode.com/problems/candy/description/
 * <p>
 * There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.
 * <p>
 * You are giving candies to these children subjected to the following requirements:
 * <p>
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * Return the minimum number of candies you need to have to distribute the candies to the children.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: ratings = [1,0,2]
 * Output: 5
 * Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
 * Example 2:
 * <p>
 * Input: ratings = [1,2,2]
 * Output: 4
 * Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
 * The third child gets 1 candy because it satisfies the above two conditions.
 */
