class Solution {
    public int getSecondLargest(int[] arr) {
        int largest = -1;
        int secondLargest = -1;

        for (int num : arr) {
            if (num > largest) {
                // Shift largest to secondLargest, update largest
                secondLargest = largest;
                largest = num;
            } else if (num < largest && num > secondLargest) {
                // Update secondLargest if strictly between secondLargest and largest
                secondLargest = num;
            }
        }

        return secondLargest;
    }
}