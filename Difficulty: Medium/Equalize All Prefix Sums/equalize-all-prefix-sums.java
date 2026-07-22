class Solution {
    public ArrayList<Integer> optimalArray(int[] arr) {
        int n = arr.length;

        ArrayList<Integer> ans = new ArrayList<>();

        long prefixSum = 0;

        // Store prefix sums
        for (int i = 0; i < n; i++) {
            prefixSum += arr[i];
            ans.add((int) prefixSum);
        }

        // Process from right to left
        for (int i = n - 1; i >= 0; i--) {
            int mid = i / 2;
            long median = arr[mid];

            long totalSum = ans.get(i);

            long leftSum = (mid == 0) ? 0 : ans.get(mid - 1);

            long rightSum = totalSum - leftSum - median;

            long leftCount = mid;
            long rightCount = i - mid;

            long cost =
                    median * leftCount - leftSum
                    + rightSum - median * rightCount;

            ans.set(i, (int) cost);
        }

        return ans;
    }
}