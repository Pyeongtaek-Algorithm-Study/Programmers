// Level_2 : 모든사전

import java.util.List;
import java.util.ArrayList;

class Solution {
    
    static String[] chs = {"A", "E", "I", "O", "U"};
    
    static List<String> dict;
    
    public int solution(String word) {
        
        int ans = 0;
        
        // 사전 알파벳으로 만들 수 있는 단어 저장 용도
        dict = new ArrayList<>();
        
        // dfs로 만들 수 있는 단어 모든 탐색
        dfs("");
        
        ans = dict.indexOf(word);
        
        return ans;
        
    }
    
    private void dfs(String tmpWord) {
        
        dict.add(tmpWord);
        
        if (tmpWord.length() == 5) {
            return;
        }
        
        for (int i = 0; i < 5; i++) {
            dfs(tmpWord + chs[i]);
        }
    }
}
