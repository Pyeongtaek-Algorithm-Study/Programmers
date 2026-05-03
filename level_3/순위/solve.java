import java.util.*;

/**
 * Level 3 : 순위
 * 카테고리 : 그래프
 * @link : https://velog.io/@suk13574/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4Java-%EC%88%9C%EC%9C%84
 */
class Solution {
    
    private final static int WIN = 1;
    
    private final static int LOSE = -1;
    
    public int solution(int n, int[][] results) {

        int ans = 0;
        int[][] matched = new int[n+ 1][n + 1];
        
        for (int[] result : results) {
            int winer = result[0];
            int loser = result[1];
            
            // 승자의 결과 기록
            matched[winer][loser] = WIN;
            // 패자의 결과 기록
            matched[loser][winer] = LOSE;
        }
        
        // 워셜-플로이드 알고리즘
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    
                    // i와 k번째 선수의 결과가 k와 j번째 선수 결과와 같으면
                    // i와 j의 권투 결과는 i와 k번째 결과와 같다.
                    // 따라서, i가 j를 이겼으면, j는 i에게 진 결과이다.
                    if (matched[i][k] == matched[k][j] && matched[i][k] != 0) {
                        
                        // i와 j의 결과는 서로 반대 결과
                        matched[i][j] = matched[i][k];
                        matched[j][i] = -1 * matched[i][k]; 
                    }
                }
            }
        }  
        
        for (int i = 1; i <= n; i++) {
            
            // i번째 선수의 승패 횟수
            int count = 0;
            
            for (int j = 1; j <= n; j++) {
                
                // i번째 선수가 j 선수와 비교할 때 승패를 알 수 있으면 count 증가
                if (matched[i][j] != 0) {
                    count++;
                }     
            }
            
            // i번째 선수의 승패 결과 개수가 다른 인원만큼 이면 해당 선수의 순위를 파악 가능
            if (count == n - 1) {
                ans++;
            }
        }
        
        return ans;
    }
}
