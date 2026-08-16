import java.util.*;

class Solution {
    
    private static final int MAX_TIME = 24;
    
    public int solution(int[] players, int m, int k) {
        
        int answer = 0;
        
        // 해당 시간대에 운영 중인 서버 수 저장용
        int[] servers = new int[MAX_TIME];
        
        for (int tx = 0; tx < MAX_TIME; tx++) {
            
            // 현재 이용자 수를 기준으로 필요한 증설 서버 수 계산
            int maintain = players[tx] / m;
            
            // 필요한 서버 수에서 현재 운영 중인 서버 수를 제외한 부족한 서버 수
            int needs = maintain - servers[tx];

            if (needs > 0) {
                
                // answer에 서버 증설 개수 추가
                answer += needs;
                
                // 증설 서버는 현재 시간부터 k시간 동안 운영
                for (int p = tx; p < tx + k && p < MAX_TIME; p++) {
                    servers[p] += needs;
                }
            }
        }
        
        return answer;
    }
}