package com.company.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Heap {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        List<Integer> list = new ArrayList<>();
        inOrder(arr, 0, list);
        System.out.println("inorder " + list);
        System.out.println("-----------------------------------");

        int[] minHeapArr = {2, 3, 4, 5, 6};
        List<Integer> minHeapList = Arrays.stream(minHeapArr).boxed().collect(Collectors.toList());
        System.out.println("isMinHeap " + isMinHeap(minHeapArr));
        addElementInMinHeap(minHeapList, 1);
        System.out.println("add element " + minHeapList);
        removeElementFromMinHeap(minHeapList);
        System.out.println("remove element " + minHeapList);
        System.out.println("-----------------------------------");

        int[] maxHeapArray = {6, 5, 4, 2, 3};
        List<Integer> maxHeapList = Arrays.stream(maxHeapArray).boxed().collect(Collectors.toList());
        System.out.println("isMaxHeap " + isMaxHeap(maxHeapArray));
        addElementInMaxHeap(maxHeapList, 7);
        System.out.println("add element " + maxHeapList);
    }

    private static void inOrder(int[] arr, int index, List<Integer> list) {
        if (index >= arr.length) {
            return;
        }
        inOrder(arr, (2 * index) + 1, list);
        list.add(arr[index]);
        inOrder(arr, (2 * index) + 2, list);
    }

    private static boolean isMinHeap(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int left = (2 * i) + 1;
            int right = (2 * i) + 2;
            if ((left < arr.length && arr[left] < arr[i]) || (right < arr.length && arr[right] < arr[i])) {
                return false;
            }
            if (left >= arr.length || right >= arr.length) {
                break;
            }
        }
        return true;
    }

    private static boolean isMaxHeap(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int left = (2 * i) + 1;
            int right = (2 * i) + 2;
            if ((left < arr.length && arr[left] > arr[i]) || (right < arr.length && arr[right] > arr[i])) {
                return false;
            }
            if (left >= arr.length || right >= arr.length) {
                break;
            }
        }
        return true;
    }

    private static void addElementInMinHeap(List<Integer> list, int element) {
        list.add(element);
        int current = list.size() - 1;
        while (current != 0) {
            int parent = (current - 1) / 2;
            if (list.get(parent) > list.get(current)) {
                int temp = list.get(current);
                list.set(current, list.get(parent));
                list.set(parent, temp);
                current = parent;
            } else {
                break;
            }
        }
    }

    private static void addElementInMaxHeap(List<Integer> list, int element) {
        list.add(element);
        int current = list.size() - 1;
        while (current != 0) {
            int parent = (current - 1) / 2;
            if (list.get(parent) < list.get(current)) {
                int temp = list.get(current);
                list.set(current, list.get(parent));
                list.set(parent, temp);
                current = parent;
            } else {
                break;
            }
        }
    }

    private static void removeElementFromMinHeap(List<Integer> list) {
        list.set(0, list.get(list.size() - 1)); //2,3,4
        list.remove(list.size() - 1);
        int i = 0;
        while (i < list.size()) {
            int left = (2 * i) + 1;
            int right = (2 * i) + 2;
            int smallest = i;
            if (left < list.size() && list.get(left) < list.get(smallest)) {
                smallest = left;
            }
            if (right < list.size() && list.get(right) < list.get(smallest)) {
                smallest = right;
            }
            if (i == smallest) {
                break;
            }
            int temp = list.get(i);
            list.set(i, list.get(smallest));
            list.set(smallest, temp);
            i = smallest;
        }
    }
}
