class Solution {
    public int countSubstring(String s) {
        int n = s.length();

        // Prefix sum ranges from -n to +n
        int size = 2 * n + 3;
        int offset = n + 1;

        int[] bit = new int[size];

        int prefix = 0;
        long answer = 0;

        // Add prefix sum 0
        update(bit, offset, 1);

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1')
                prefix++;
            else
                prefix--;

            int index = prefix + offset;

            // Count previous prefix sums smaller than current prefix
            answer += query(bit, index - 1);

            update(bit, index, 1);
        }

        return (int) answer;
    }

    private void update(int[] bit, int index, int value) {
        while (index < bit.length) {
            bit[index] += value;
            index += index & -index;
        }
    }

    private int query(int[] bit, int index) {
        int sum = 0;

        while (index > 0) {
            sum += bit[index];
            index -= index & -index;
        }

        return sum;
    }
}