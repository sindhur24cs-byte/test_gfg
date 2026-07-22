import java.util.ArrayList;
import java.util.PriorityQueue;

class Solution {
    // Function to insert elements of ArrayList into a PriorityQueue
    public static PriorityQueue<Integer> insertion(ArrayList<Integer> arr) {
        // Option 1: Direct initialization from collection
        return new PriorityQueue<>(arr);
    }
}