import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public String lexicographicallySmallest(String s, int k) {
        int n = s.length();

        if ((n & (n - 1)) == 0) {
            k /= 2;
        } else {
            k *= 2;
        }

        if (k >= n) {
            return "-1";
        }

        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            while (!stack.isEmpty() && k > 0 && stack.peek() > ch) {
                stack.pop();
                k--;
            }

            stack.push(ch);
        }

        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }

        if (stack.isEmpty()) {
            return "-1";
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}