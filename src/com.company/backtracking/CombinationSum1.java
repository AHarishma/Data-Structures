package backtracking;

import java.util.*;

class CombinationSum1 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList();
        generateCombinationSum(candidates, 0, target, new ArrayList(), result);
        return result;
    }

    private void generateCombinationSum(int[] candidates, int index, int target,List<Integer> currentList, List<List<Integer>> result) {
        if(target == 0) {
            result.add(new ArrayList<>(currentList));
            return;
        }

        if(target < 0) {
            return;
        }

        for(int i = index; i < candidates.length; i++) {
            currentList.add(candidates[i]);
            generateCombinationSum(candidates, i, target - candidates[i], currentList, result);
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
            CombinationSum1 combinationSum1 = new CombinationSum1();
            List<List<Integer>> result = combinationSum1.combinationSum(array, target);
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
 * Link - https://leetcode.com/problems/combination-sum/
 * Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
 *
 * The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the
 * frequency
 *  of at least one of the chosen numbers is different.
 *
 * The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
 *
 *
 *
 * Example 1:
 *
 * Input: candidates = [2,3,6,7], target = 7
 * Output: [[2,2,3],[7]]
 * Explanation:
 * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
 * 7 is a candidate, and 7 = 7.
 * These are the only two combinations.
 * Example 2:
 *
 * Input: candidates = [2,3,5], target = 8
 * Output: [[2,2,2,2],[2,3,3],[3,5]]
 * Example 3:
 *
 * Input: candidates = [2], target = 1
 * Output: []
 *
 *
 * Constraints:
 *
 * 1 <= candidates.length <= 30
 * 2 <= candidates[i] <= 40
 * All elements of candidates are distinct.
 * 1 <= target <= 40
 */