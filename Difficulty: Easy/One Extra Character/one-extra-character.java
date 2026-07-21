class Solution {
    char extraChar(String s1, String s2) {
        int[] count = new int[26];

        for (char c : s1.toCharArray()) {
            count[c - 'a']++;
        }

        for (char c : s2.toCharArray()) {
            count[c - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                return (char) ('a' + i);
            }
        }

        return ' ';
    }
}