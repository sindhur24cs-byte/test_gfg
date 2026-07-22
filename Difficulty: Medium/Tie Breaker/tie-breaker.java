import java.util.HashMap;
import java.util.Map;

class Solution {
    public String tieBreak(String[] arr) {
        // Step 1: Count frequency of each candidate using a HashMap
        Map<String, Integer> votes = new HashMap<>();
        for (String candidate : arr) {
            votes.put(candidate, votes.getOrDefault(candidate, 0) + 1);
        }

        String winner = "";
        int maxVotes = 0;

        // Step 2: Iterate through the map to find the candidate with max votes
        for (Map.Entry<String, Integer> entry : votes.entrySet()) {
            String candidate = entry.getKey();
            int count = entry.getValue();

            // Candidate with strictly more votes wins
            if (count > maxVotes) {
                maxVotes = count;
                winner = candidate;
            } 
            // In case of a tie, pick the lexicographically smaller candidate
            else if (count == maxVotes && candidate.compareTo(winner) < 0) {
                winner = candidate;
            }
        }

        return winner;
    }
}