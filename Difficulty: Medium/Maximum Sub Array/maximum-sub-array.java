class Solution {
    public ArrayList<Integer> findSubarray(int[] arr) {

        ArrayList<Integer> ans = new ArrayList<>();

        long maxSum = -1;
        long currSum = 0;

        int start = 0;
        int bestStart = -1;
        int bestEnd = -1;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] >= 0) {
                currSum += arr[i];
            } else {

                if (start <= i - 1) {
                    int currLen = i - start;
                    int bestLen = (bestStart == -1) ? 0 : bestEnd - bestStart + 1;

                    if (currSum > maxSum ||
                       (currSum == maxSum && currLen > bestLen)) {
                        maxSum = currSum;
                        bestStart = start;
                        bestEnd = i - 1;
                    }
                }

                currSum = 0;
                start = i + 1;
            }
        }

        if (start < arr.length) {
            int currLen = arr.length - start;
            int bestLen = (bestStart == -1) ? 0 : bestEnd - bestStart + 1;

            if (currSum > maxSum ||
               (currSum == maxSum && currLen > bestLen)) {
                maxSum = currSum;
                bestStart = start;
                bestEnd = arr.length - 1;
            }
        }

        if (bestStart == -1) {
            ans.add(-1);
            return ans;
        }

        for (int i = bestStart; i <= bestEnd; i++) {
            ans.add(arr[i]);
        }

        return ans;
    }
}