class Solution {
    public char extraChar(String s1, String s2) {
        
        int sum = 0;

        for (int i = 0; i < s2.length(); i++) {
            sum += s2.charAt(i);
        }

        for (int i = 0; i < s1.length(); i++) {
            sum -= s1.charAt(i);
        }

        return (char) sum;
    }
}