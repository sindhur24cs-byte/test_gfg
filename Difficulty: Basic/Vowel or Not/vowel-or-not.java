class Solution {
    static String isVowel(char c) {
        
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
            c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
            return "YES";
        }
        
        return "NO";
    }
}
