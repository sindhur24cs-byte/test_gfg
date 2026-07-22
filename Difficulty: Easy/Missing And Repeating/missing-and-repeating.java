class Solution {
    ArrayList<Integer> findTwoElement(int arr[]) {
        ArrayList<Integer> result = new ArrayList<>();
        int repeating = -1;
        int missing = -1;

        // Phase 1: Mark visited numbers using negation
        for (int i = 0; i < arr.length; i++) {
            int val = Math.abs(arr[i]);
            int index = val - 1;

            if (arr[index] < 0) {
                // If already negative, val is the repeating number
                repeating = val;
            } else {
                arr[index] = -arr[index];
            }
        }

        // Phase 2: The index with a positive value corresponds to the missing number
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                missing = i + 1;
                break;
            }
        }

        result.add(repeating);
        result.add(missing);
        return result;
    }
}