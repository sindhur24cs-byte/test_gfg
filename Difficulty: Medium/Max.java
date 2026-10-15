class Solution {
    public static int maxValue(int n) {
        int[] bits = new int[32];
        // Extract bits
        for (int i = 31; i >= 0; i--) {
            if ((n & (1 << i)) != 0) {
                bits[i] = 1;
            }
        }
        
        // Check for three consecutive set bits from left to right
        for (int i = 31; i >= 2; i--) {
            if (bits[i] == 1 && bits[i - 1] == 1 && bits[i - 2] == 1) {
                bits[i - 2] = 0;
            }
        }
        
        // Reconstruct result
        int ans = 0;
        for (int i = 31; i >= 0; i--) {
            if (bits[i] == 1) {
                ans |= (1 << i);
            }
        }
        return ans;
    }
}
