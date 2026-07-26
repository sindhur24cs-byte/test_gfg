class Solution {
    public static boolean checkEqual(int a[], int b[]) {
        if (a.length != b.length)
            return false;

        java.util.Arrays.sort(a);
        java.util.Arrays.sort(b);

        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i])
                return false;
        }

        return true;
    }
}