import java.util.*;

class Solution {
    
    private int answer = 1;
    
    public int solution(String[][] clothes) {
        
        HashMap<String, Integer> clothesMap = new HashMap<>();
        
        for (String[] cloth : clothes) {
            clothesMap.put(cloth[1], clothesMap.getOrDefault(cloth[1], 0) + 1);
        }
        
        for (String key : clothesMap.keySet()) {
            
            // +1 : 입지 않았을 때 (종류별로 최대 1가지라는 뜻은 해당 종류에서 안 입을 수도 있다는 뜻)
            answer *= (clothesMap.get(key) + 1);
        }
        
        // 아무것도 입지 않은 경우를 제외
        answer--;
        
        return answer;
    }
}