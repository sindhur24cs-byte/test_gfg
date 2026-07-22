import java.util.ArrayList;

class Solution {
    public static ArrayList<Integer> maxNeighbour(ArrayList<Integer> arr) {
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < arr.size() - 1; i++) {
            int maxVal = Math.max(arr.get(i), arr.get(i + 1));
            result.add(maxVal);
        }

        return result;
    }
}