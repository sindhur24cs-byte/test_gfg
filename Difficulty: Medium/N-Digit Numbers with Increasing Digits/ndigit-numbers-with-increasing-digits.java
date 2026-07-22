import java.util.*;

class Solution {
    public ArrayList<Integer> increasingNumbers(int n) {
        ArrayList<Integer> ans = new ArrayList<>();

        if (n > 10) {
            return ans;
        }

        if (n == 1) {
            for (int i = 0; i <= 9; i++) {
                ans.add(i);
            }
            return ans;
        }

        generate(0, 0, n, ans);

        return ans;
    }

    private void generate(int num, int lastDigit, int n,
                          ArrayList<Integer> ans) {

        if (n == 0) {
            ans.add(num);
            return;
        }

        for (int digit = lastDigit + 1; digit <= 9; digit++) {
            generate(num * 10 + digit, digit, n - 1, ans);
        }
    }
}