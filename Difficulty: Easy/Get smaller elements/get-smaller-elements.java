import java.util.ArrayList;

class Solution {
    public static ArrayList<Integer> getSmaller(int[] arr, int x) {
        ArrayList<Integer> result = new ArrayList<>();
        
        // Iterate through the array to find elements strictly less than x
        for (int val : arr) {
            if (val < x) {
                result.add(val);
            }
        }
        
        return result;
    }
}