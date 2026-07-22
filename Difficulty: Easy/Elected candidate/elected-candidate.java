import java.util.HashMap;
import java.util.Map;

class Solution {
    // Function to find the winner of the election
    public static String electionWinner(String arr[]) {
        HashMap<String, Integer> voteCount = new HashMap<>();

        // Step 1: Count votes for each candidate
        for (String candidate : arr) {
            voteCount.put(candidate, voteCount.getOrDefault(candidate, 0) + 1);
        }

        // Step 2: Find the candidate with the highest votes
        String winner = "";
        int maxVotes = 0;

        for (Map.Entry<String, Integer> entry : voteCount.entrySet()) {
            if (entry.getValue() > maxVotes) {
                maxVotes = entry.getValue();
                winner = entry.getKey();
            }
        }

        return winner;
    }
}