import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};
        HashMap<String, Integer> playersMap = new HashMap<>();
        
        for (int i = 0; i < players.length; i++) {
            playersMap.put(players[i], i);
        }
        
        for (String name : callings) {
            int idx = playersMap.get(name);
            
            String frontPlayer = players[idx - 1];
            players[idx - 1] = name;
            players[idx] = frontPlayer;
            
            playersMap.put(name, idx - 1);
            playersMap.put(frontPlayer, idx);
        }
        
        answer = players;
        return answer;
    }
}