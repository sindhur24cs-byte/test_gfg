class Solution {
    int maxSubstring(String s) {
        int maxSoFar = -1;
        int currentSum = 0;

        for (int i = 0; i < s.length(); i++) {
            int value = (s.charAt(i) == '0') ? 1 : -1;
            currentSum += value;

            if (currentSum > maxSoFar) {
                maxSoFar = currentSum;
            }

            if (currentSum < 0) {
                currentSum = 0;
            }
        }

        return maxSoFar;
    }
}