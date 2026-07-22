import java.util.TreeSet;

public class Solution {
    public String chooseSwap(String s) {
        TreeSet<Character> set = new TreeSet<>();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            set.add(s.charAt(i));
        }

        char ch1 = ' ', ch2 = ' ';
        boolean found = false;

        for (int i = 0; i < n; i++) {
            char curr = s.charAt(i);
            set.remove(curr);

            if (!set.isEmpty()) {
                char smallest = set.first();
                if (smallest < curr) {
                    ch1 = curr;
                    ch2 = smallest;
                    found = true;
                    break;
                }
            }
        }

        if (!found) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == ch1) {
                sb.append(ch2);
            } else if (c == ch2) {
                sb.append(ch1);
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}