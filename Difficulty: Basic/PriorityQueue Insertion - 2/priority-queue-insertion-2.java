import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    // Function to insert elements into a Max-Heap PriorityQueue
    public static PriorityQueue<Integer> insertion(ArrayList<Integer> arr) {
        // Create a PriorityQueue with max-heap ordering
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        // Insert all elements from the ArrayList
        for (int num : arr) {
            pq.add(num);
        }

        return pq;
    }
}