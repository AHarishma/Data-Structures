package com.company.heap;

import java.util.*;

public class NMaxPairCombination {

    private ArrayList<Integer> findNMaxPairCombination(List<Integer> a, List<Integer> b) {
        Collections.sort(a);
        Collections.sort(b);
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((o1, o2) -> {
            int sum1 = a.get(o1[0]) + b.get(o1[1]);
            int sum2 = a.get(o2[0]) + b.get(o2[1]);
            return sum2 - sum1;
        });
        Set<String> set = new HashSet<>();
        set.add((a.size() - 1) + "|" + (b.size() - 1));

        maxHeap.add(new int[]{a.size() - 1, b.size() - 1});
        int n = a.size();
        ArrayList<Integer> result = new ArrayList<>();
        while (n > 0 && !maxHeap.isEmpty()) {
            int[] polledElement = maxHeap.poll();
            if (polledElement[0] - 1 >= 0 && set.add(polledElement[0] - 1 + "|" +polledElement[1])) {
                maxHeap.add(new int[]{polledElement[0] - 1, polledElement[1]});
            }
            if (polledElement[1] - 1 >= 0 && set.add(polledElement[0] + "|" + (polledElement[1] - 1))) {
                maxHeap.add(new int[]{polledElement[0], polledElement[1] - 1});
            }
            result.add(a.get(polledElement[0]) + b.get(polledElement[1]));
            n--;
        }
        return result;
    }

    public static void main(String[] args) {
        NMaxPairCombination nMaxPairCombination = new NMaxPairCombination();
        List<Integer> a1 = Arrays.asList(1, 2, 3, 4);
        List<Integer> b1 = Arrays.asList(1, 2, 5, 6);
        System.out.println(nMaxPairCombination.findNMaxPairCombination(a1, b1));

        List<Integer> a2 = Arrays.asList(2, 4, 1, 1);
        List<Integer> b2 = Arrays.asList(-2, -3, 2, 4);

        System.out.println(nMaxPairCombination.findNMaxPairCombination(a2, b2));
    }
}
