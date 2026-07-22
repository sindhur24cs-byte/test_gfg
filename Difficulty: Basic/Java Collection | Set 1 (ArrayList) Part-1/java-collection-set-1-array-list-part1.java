import java.util.ArrayList;

class Solution {
    ArrayList<Integer> solve(int N, ArrayList<Integer> A, int Q, ArrayList<Integer> Query) {
        if (Q == 1) {
            // Query 1: Insert value 'r' at index 'p'
            int p = Query.get(0); // Index
            int r = Query.get(1); // Value to insert
            
            A.add(p, r);
            return A;
        } else {
            // Query 2: Find the last index of element 'p'
            int p = Query.get(0); // Element to search
            
            int lastIdx = A.lastIndexOf(p);
            
            ArrayList<Integer> result = new ArrayList<>();
            result.add(lastIdx);
            return result;
        }
    }
}