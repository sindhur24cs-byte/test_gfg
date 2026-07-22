import java.util.List;

public class Solution {
    public int maxArea(List<Integer> height) {
        int left = 0;
        int right = height.size() - 1;
        int maxArea = 0;

        while (left < right) {
            int barsBetween = right - left - 1;
            int currentArea = Math.min(height.get(left), height.get(right)) * barsBetween;
            
            maxArea = Math.max(maxArea, currentArea);

            if (height.get(left) < height.get(right)) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}