import java.util.Arrays;

class Solution {
    public int maxToys(int[] arr, int k) {
        // Step 1: Sort array in ascending order to buy cheapest toys first
        Arrays.sort(arr);
        
        int count = 0;
        
        // Step 2: Buy toys until budget runs out
        for (int price : arr) {
            if (k >= price) {
                k -= price;
                count++;
            } else {
                break; // Cannot afford the rest
            }
        }
        
        return count;
    }
}