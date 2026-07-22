import java.util.Queue;
import java.util.ArrayList;

class Solution {
    public static ArrayList<Integer> queueTraversal(Queue<Integer> q) {
        ArrayList<Integer> result = new ArrayList<>();
        
        // Traverse through the Queue elements
        for (int x : q) {
            result.add(x);
        }
        
        return result;
    }
}