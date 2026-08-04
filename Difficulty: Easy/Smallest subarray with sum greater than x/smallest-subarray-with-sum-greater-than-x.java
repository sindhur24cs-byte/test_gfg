class Solution {
    public int smallestSubWithSum(int x, int[] arr) {
        int n = arr.length;
        int start = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;

        for (int end = 0; end < n; end++) {
            sum += arr[end];

            while (sum > x) {
                ans = Math.min(ans, end - start + 1);
                sum -= arr[start];
                start++;
            }
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}