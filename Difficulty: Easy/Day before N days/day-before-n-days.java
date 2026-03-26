class Solution {
    public int dayBefore(int d, int n) {
        return (d - (n % 7) + 7) % 7;
    }
}