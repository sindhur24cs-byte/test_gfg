class Solution {
    public int maxSumSubarray(int[] arr) {
        int noDelete = arr[0];
        int oneDelete = Integer.MIN_VALUE;

        int answer = arr[0];

        for (int i = 1; i < arr.length; i++) {
            int oldNoDelete = noDelete;
            int oldOneDelete = oneDelete;

            // Delete the current element
            int deleteCurrent = oldNoDelete;

            // Use one deletion
            if (oldOneDelete != Integer.MIN_VALUE) {
                oneDelete = Math.max(
                    oldOneDelete + arr[i],
                    deleteCurrent
                );
            } else {
                oneDelete = deleteCurrent;
            }

            // No deletion
            noDelete = Math.max(
                oldNoDelete + arr[i],
                arr[i]
            );

            answer = Math.max(
                answer,
                Math.max(noDelete, oneDelete)
            );
        }

        return answer;
    }
}