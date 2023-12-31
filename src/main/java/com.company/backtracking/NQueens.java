package com.company.backtracking;

import java.util.*;

public class NQueens {
    public List<List<Integer>> solveNQueens(int n) {
        List<List<Integer>> result = new ArrayList<>();
        solve(n, 0, new ArrayList<>(), result);
        return result;
    }

    private void solve(int n, int row, List<Integer> currentList, List<List<Integer>> result) {
        if (row == n) {
            result.add(new ArrayList<>(currentList));
            return;
        }

        for (int i = 1; i <= n; i++) {
            currentList.add(i);
            if (isValidPosition(currentList)) {
                solve(n, row + 1, currentList, result);
            }
            currentList.remove(currentList.size() - 1);
        }
    }

    private boolean isValidPosition(List<Integer> currentList) {
        int row = currentList.size() - 1;
        for (int i = row - 1; i >= 0; i--) {
            int columnDistance = Math.abs(currentList.get(i) - currentList.get(row));
            int rowDistance = row - i;
            if (columnDistance == 0 || rowDistance == columnDistance) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        NQueens nQueens = new NQueens();
        List<List<Integer>> result = nQueens.solveNQueens(4);
        System.out.println(result);
    }
}

/**
 * one or many base cases
 * for each index in the input ( str, array ), we will have for loop starting from that index till the length of the input
 * recur with i + 1 as next index a p p l e
 * -- a -- p -- p -- l --- e ( base condition and for loop is completed )
 * -- le
 * -- pl-- e
 * -- ple
 * -- pp -- l -- e
 * -- pp -- le
 * -- pple
 * -- ap- p - l - e
 * -- ap - p - le
 * -- ap - ple
 * -- apple
 */