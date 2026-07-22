import java.util.ArrayList;

class Solution {
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0, j = 0;
        int n = a.length, m = b.length;

        // Helper function/lambda to add non-duplicate element
        while (i < n && j < m) {
            if (a[i] < b[j]) {
                addIfNotDuplicate(result, a[i]);
                i++;
            } else if (a[i] > b[j]) {
                addIfNotDuplicate(result, b[j]);
                j++;
            } else { // both are equal
                addIfNotDuplicate(result, a[i]);
                i++;
                j++;
            }
        }

        // Process remaining elements of array a
        while (i < n) {
            addIfNotDuplicate(result, a[i]);
            i++;
        }

        // Process remaining elements of array b
        while (j < m) {
            addIfNotDuplicate(result, b[j]);
            j++;
        }

        return result;
    }

    private static void addIfNotDuplicate(ArrayList<Integer> list, int val) {
        if (list.isEmpty() || list.get(list.size() - 1) != val) {
            list.add(val);
        }
    }
}