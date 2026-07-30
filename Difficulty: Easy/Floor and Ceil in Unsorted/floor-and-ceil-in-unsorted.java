class Solution {
    public int[] getFloorAndCeil(int x, int[] arr) {
        int floor = -1;
        int ceil = -1;

        for (int num : arr) {
            if (num <= x) {
                floor = Math.max(floor, num);
            }

            if (num >= x) {
                if (ceil == -1 || num < ceil) {
                    ceil = num;
                }
            }
        }

        return new int[]{floor, ceil};
    }
}