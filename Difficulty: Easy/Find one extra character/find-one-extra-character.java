class Solution {
    char extraChar(String s1, String s2) {

        char result = 0;

        for (int i = 0; i < s1.length(); i++) {
            result ^= s1.charAt(i);
        }

        for (int i = 0; i < s2.length(); i++) {
            result ^= s2.charAt(i);
        }

        return result;
    }
}
