import java.util.*;

/**
 * @link : https://serendev.tistory.com/273
 */
class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        int len = topping.length;
        
        int[] leftCnt = new int[len];
        int[] rightCnt = new int[len];
        
        Set<Integer> leftSet = new HashSet<>();
        for (int l = 0; l < len; l++) {
            leftSet.add(topping[l]);
            
            // leftSet의 순차적 토핑 개수
            leftCnt[l] = leftSet.size();
        }
        
        Set<Integer> rightSet = new HashSet<>();
        for (int r = len - 1; r >= 0; r--) {
            rightSet.add(topping[r]);
            
            // rightSet의 순차적 토핑 개수
            rightCnt[r] = rightSet.size();
        }
        
        // Cnt 비교
        for (int i = 0; i < len - 1; i++) {
            
            // left : i번째까지의 토핑 개수 vs right : i + 1번째부터의 토핑 개수
            if (leftCnt[i] == rightCnt[i + 1]) {
                answer++;
            }
        }

        return answer;
    }
}
