import java.util.*;

class Solution {
    public double minMaxDist(int[] stations, int k) {

        double low = 0;
        double high = 0;

        // Find the maximum gap
        for (int i = 1; i < stations.length; i++) {
            high = Math.max(high, stations[i] - stations[i - 1]);
        }

        // Binary search
        for (int i = 0; i < 100; i++) {

            double mid = (low + high) / 2.0;

            int required = 0;

            // Count how many stations are needed
            for (int j = 1; j < stations.length; j++) {

                double gap = stations[j] - stations[j - 1];

                required += (int) Math.ceil(gap / mid) - 1;

                if (required > k) {
                    break;
                }
            }

            if (required <= k) {
                high = mid;
            } else {
                low = mid;
            }
        }

        return high;
    }
}