import java.util.*;

// Time: O(N)
// Space: O(K) This is due to the HasMap
class Program {
    public String tournamentWinner(
            ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
        HashMap<String, Integer> teamScores = new HashMap<String, Integer>();

        for (int i = 0; i < results.size(); ++i) {
            String winnerName;
            Integer winner = results.get(i);
            if (winner.equals(1)) {
                winnerName = competitions.get(i).get(0);
            } else {
                winnerName = competitions.get(i).get(1);
            }

            if (teamScores.containsKey(winnerName)) {
                teamScores.put(winnerName, teamScores.get(winnerName) + 3);
            } else {
                teamScores.put(winnerName, 3);
            }
        }

        // Logic to find the team with the highest score
        String topTeam = "";
        int maxScore = -1;
        for (Map.Entry<String, Integer> entry : teamScores.entrySet()) {
            if (entry.getValue() > maxScore) {
                maxScore = entry.getValue();
                topTeam = entry.getKey();
            }
        }

        return topTeam;
    }
}
