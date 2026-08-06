class Solution {
    public int countMinOperations(int[] arr) {
        int count = 0;

        while (true) {
            boolean allZero = true;
            boolean allEven = true;

            for (int num : arr) {
                if (num != 0)
                    allZero = false;
                if (num % 2 != 0)
                    allEven = false;
            }

            if (allZero)
                break;

            if (allEven) {
                for (int i = 0; i < arr.length; i++) {
                    arr[i] /= 2;
                }
                count++;
            } else {
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i] % 2 != 0) {
                        arr[i]--;
                        count++;
                    }
                }
            }
        }

        return count;
    }
}