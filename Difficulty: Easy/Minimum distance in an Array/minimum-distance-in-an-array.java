class Solution {
    int minDist(int arr[], int x, int y) {
        int last = -1;
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x || arr[i] == y) {
                if (last != -1 && arr[i] != arr[last]) {
                    ans = Math.min(ans, i - last);
                }
                last = i;
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}