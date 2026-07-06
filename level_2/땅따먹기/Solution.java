/**
 * level 2 : 땅따먹기
 * https://school.programmers.co.kr/learn/courses/30/lessons/12913
 */
class Solution {
    int solution(int[][] land) {
        int answer = 0;

        int[][] dp = new int[land.length][4];
        
        // 2차원 배열 복사 (깊은 복사)
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < 4; j++) {
                dp[i][j] = land[i][j];
            }
        }
        
        // BruteForce
        for (int i = 1; i < land.length; i++) {
            
            for (int j = 0; j < 4; j++) {
                
                for (int k = 0; k < 4; k++) {
                    
                    // 같은 열 제외
                    if (k == j) {
                        continue;     
                    }
                    
                    // 같은 열을 제외한 나머지 열의 각 합을 비교하여 최댓값 구하기
                    dp[i][j] = Math.max(dp[i][j], land[i][j] + dp[i - 1][k]);
                }
            }
        }

        // 마지막 행에서 가장 큰 값 구하기
        for (int i = 0; i < dp[dp.length - 1].length; i++) {
            answer = Math.max(answer, dp[dp.length - 1][i]);
        }

        return answer;
    }
}