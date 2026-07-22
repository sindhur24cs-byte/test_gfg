class Solution {
    public int minDeletions(int[] arr) {
        int n = arr.length;
        int[] tails = new int[n];
        int len = 0;

        for (int num : arr) {
            int left = 0, right = len;

            while (left < right) {
                int mid = left + (right - left) / 2;

                if (tails[mid] >= num)
                    right = mid;
                else
                    left = mid + 1;
            }

            tails[left] = num;

            if (left == len)
                len++;
        }

        return n - len;
    }
}