import java.util.Arrays;

class Solution {
    public int maxUsingStreams(int[] arr) {
        return Arrays.stream(arr)
                     .max()
                     .getAsInt();
    }
}