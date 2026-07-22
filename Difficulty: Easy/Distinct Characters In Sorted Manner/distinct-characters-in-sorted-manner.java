import java.util.TreeSet;

class Solution {
    public String sortedDistinct(String str) {
        // Step 1: Use a TreeSet to maintain unique characters in ascending sorted order
        TreeSet<Character> set = new TreeSet<>();
        
        for (char c : str.toCharArray()) {
            set.add(c);
        }

        // Step 2: Construct the output string
        StringBuilder result = new StringBuilder();
        for (char c : set) {
            result.append(c);
        }

        return result.toString();
    }
}