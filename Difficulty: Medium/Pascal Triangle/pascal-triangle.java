import java.util.*;

class Solution {
    public ArrayList<Integer> nthRowOfPascalTriangle(int n) {
        ArrayList<Integer> row = new ArrayList<>();

        long value = 1;

        for (int i = 0; i < n; i++) {
            row.add((int) value);

            value = value * (n - 1 - i) / (i + 1);
        }

        return row;
    }
}