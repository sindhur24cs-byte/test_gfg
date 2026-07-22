import java.util.Arrays;

class Solution {
    // Function to sort string array lexicographically while ignoring case
    public static void sortByComparator(String arr[]) {
        Arrays.sort(arr, String.CASE_INSENSITIVE_ORDER);
    }
}