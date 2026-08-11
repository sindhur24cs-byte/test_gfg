class Solution {
    public int countZeroes(int[] arr) {
        int count = 0;

        for (int num : arr) {
            if (num == 0) {
                count++;
            }
        }

        return count;
    }
}