class Solution {
    public int maxPeopleDefeated(int p) {
        int count = 0;
        long sum = 0;

        while (true) {
            count++;
            sum += (long) count * count;

            if (sum > p) {
                return count - 1;
            }
        }
    }
}