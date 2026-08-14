import java.util.*;

class Solution {

    public boolean isPossible(int[] arr, int s, int x) {
        if (x == 0) return true;

        ArrayList<Long> nums = new ArrayList<>();

        long sum = s;
        nums.add((long) s);

        for (int i = 0; i < arr.length; i++) {
            long next = sum + arr[i];

            if (next > x)
                break;

            nums.add(next);
            sum += next;
        }

        int n = nums.size();
        int mid = n / 2;

        HashSet<Long> leftSums = new HashSet<>();

        generate(nums, 0, mid, 0, x, leftSums);

        return check(nums, mid, n, 0, x, leftSums);
    }

    private void generate(ArrayList<Long> nums, int index, int end,
                          long sum, long x, HashSet<Long> set) {

        if (sum > x)
            return;

        if (index == end) {
            set.add(sum);
            return;
        }

        // Don't take this number
        generate(nums, index + 1, end, sum, x, set);

        // Take this number
        generate(nums, index + 1, end,
                 sum + nums.get(index), x, set);
    }

    private boolean check(ArrayList<Long> nums, int index, int end,
                          long sum, long x, HashSet<Long> set) {

        if (sum > x)
            return false;

        if (index == end) {
            return set.contains(x - sum);
        }

        // Don't take this number
        if (check(nums, index + 1, end, sum, x, set))
            return true;

        // Take this number
        return check(nums, index + 1, end,
                     sum + nums.get(index), x, set);
    }
}