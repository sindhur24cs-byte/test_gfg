class Solution {
    int getOddOccurrence(int[] arr) {
        int ans = 0;

        for (int x : arr) {
            ans = ans ^ x;
        }

        return ans;
    }
}