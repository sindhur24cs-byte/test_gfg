import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public static int kthSmallest(int[] arr, int k) {
        // Max-Heap to store the k smallest elements seen so far
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int num : arr) {
            maxHeap.add(num);

            // Keep heap size at most k
            if (maxHeap.size() > k) {
                maxHeap.poll(); // Removes the largest among the current k+1 elements
            }
        }

        // The root of the Max-Heap is the kth smallest element
        return maxHeap.peek();
    }
}