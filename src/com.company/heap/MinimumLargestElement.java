package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumLargestElement {

    private int solve(int[] arr, int b) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                int result = o1.value - o2.value;
                if(result != 0) {
                   return result;
                }
                return o1.original - o2.original;
            }
        });

        for (int i = 0; i < arr.length; i++) {
            priorityQueue.add(new Node(arr[i], arr[i]));
        }

        while( b > 0) {
            Node element = priorityQueue.poll();
            element.value += element.original;
            priorityQueue.add(element);
            b--;
        }
        int max = Integer.MIN_VALUE;
        while(!priorityQueue.isEmpty()) {
               max = priorityQueue.poll().value;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 1, 4, 2};
        int b = 5;
        MinimumLargestElement minimumLargestElement = new MinimumLargestElement();
        int result = minimumLargestElement.solve(arr, b);
        System.out.println(result);
    }

    private class Node {
        int value;
        int original;

        Node(int value, int original) {
            this.value = value;
            this.original = original;
        }
    }
}


/**
 * Minimum Largest Element
 * <p>
 * Problem Description
 * Given an array A of N numbers, you have to perform B operations. In each operation, you have to pick any one of the N elements and add the original value(value stored at the index before we did any operations) to its current value. You can choose any of the N elements in each operation.
 * <p>
 * Perform B operations in such a way that the largest element of the modified array(after B operations) is minimized.
 * Find the minimum possible largest element after B operations.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= N <= 106
 * 0 <= B <= 105
 * -104 <= A[i] <= 104
 * <p>
 * <p>
 * <p>
 * Input Format
 * The first argument is an integer array A.
 * The second argument is an integer B.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return an integer denoting the minimum possible largest element after B operations.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [1, 2, 3, 4]
 * B = 3
 * Input 2:
 * <p>
 * A = [5, 1, 4, 2]
 * B = 5
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 4
 * Output 2:
 * <p>
 * 5
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * Apply operation on element at index 0, the array would change to [2, 2, 3, 4]
 * Apply operation on element at index 0, the array would change to [3, 2, 3, 4]
 * Apply operation on element at index 0, the array would change to [4, 2, 3, 4]
 * Minimum possible largest element after 3 operations is 4.
 * Explanation 2:
 * <p>
 * Apply operation on element at index 1, the array would change to [5, 2, 4, 2]
 * Apply operation on element at index 1, the array would change to [5, 3, 4, 2]
 * Apply operation on element at index 1, the array would change to [5, 4, 4, 2]
 * Apply operation on element at index 1, the array would change to [5, 5, 4, 2]
 * Apply operation on element at index 3, the array would change to [5, 5, 4, 4]
 * Minimum possible largest element after 5 operations is 5.
 */
