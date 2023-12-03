package com.company.backtracking;

import java.util.*;

public class CombinationSum2 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        generateCombinationSum(candidates, 0, target, new ArrayList(), result);
        return result;
    }

    private void generateCombinationSum(int[] candidates, int index, int target, List<Integer> currentList, List<List<Integer>> result) {
        if(target == 0) {
            result.add(new ArrayList<>(currentList));
            return;
        }
        if(index >= candidates.length || target < 0) {
            return;
        }

        for(int i = index; i< candidates.length; i++) {
            if(i > index && candidates[i] == candidates[i-1]) {
                continue;
            }
            currentList.add(candidates[i]);
            generateCombinationSum(candidates, i+1, target - candidates[i], currentList, result);
            currentList.remove(currentList.size() - 1);
        }
    }

    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);
        int t;
        System.out.print("Enter no of test cases : ");
        t = scanner.nextInt();
        while( t-- > 0) {
            System.out.print("Enter target : ");
            int target = scanner.nextInt();
            System.out.print("Enter size of array : ");
            int size = scanner.nextInt();
            int[] array = new int[size];
            for (int i = 0; i < size; i++) {
                System.out.print("Element " + (i + 1) + ": ");
                array[i] = scanner.nextInt();
            }
            CombinationSum2 combinationSum2 = new CombinationSum2();
            List<List<Integer>> result = combinationSum2.combinationSum(array, target);
            for(int i= 0; i< result.size(); i++) {
                List<Integer> cur = result.get(i);
                for(int j = 0; j < cur.size(); j++) {
                    System.out.print(cur.get(j) + " ");
                }
                System.out.println();
            }
        }
    }
}

/**
 * Link: https://leetcode.com/problems/combination-sum-ii/
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
 *
 * Each number in candidates may only be used once in the combination.
 *
 * Note: The solution set must not contain duplicate combinations.
 *
 *
 *
 * Example 1:
 *
 * Input: candidates = [10,1,2,7,6,1,5], target = 8
 * Output:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * Example 2:
 *
 * Input: candidates = [2,5,2,1,2], target = 5
 * Output:
 * [
 * [1,2,2],
 * [5]
 * ]
 *
 *
 * Constraints:
 *
 * 1 <= candidates.length <= 100
 * 1 <= candidates[i] <= 50
 * 1 <= target <= 30
 */

