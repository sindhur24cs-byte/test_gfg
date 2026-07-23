class Solution {
    public int maxProduct(int[] arr) {
        int maxEnding = arr[0];
        int minEnding = arr[0];
        int answer = arr[0];

        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];

            if (current < 0) {
                int temp = maxEnding;
                maxEnding = minEnding;
                minEnding = temp;
            }

            maxEnding = Math.max(current, maxEnding * current);
            minEnding = Math.min(current, minEnding * current);

            answer = Math.max(answer, maxEnding);
        }

        return answer;
    }
}