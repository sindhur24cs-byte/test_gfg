import java.util.*;

class Solution {
    public static int minimumVerticalSum(ArrayList<ArrayList<Integer>> arr) {

        int minSum = Integer.MAX_VALUE;

        // Find maximum column size
        int max = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).size() > max) {
                max = arr.get(i).size();
            }
        }

        // Calculate vertical sums
        for (int col = 0; col < max; col++) {
            int sum = 0;

            for (int row = 0; row < arr.size(); row++) {
                if (col < arr.get(row).size()) {
                    sum = sum + arr.get(row).get(col);
                }
            }

            if (sum < minSum) {
                minSum = sum;
            }
        }

        return minSum;
    }
}
