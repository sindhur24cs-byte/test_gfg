class Solution {
    public int[] twoRepeated(int[] arr) {
        int n = arr.length - 2;

        boolean[] seen = new boolean[n + 1];
        int[] ans = new int[2];
        int k = 0;

        for (int x : arr) {
            if (seen[x]) {
                ans[k++] = x;
            } else {
                seen[x] = true;
            }

            if (k == 2)
                break;
        }

        return ans;
    }
}