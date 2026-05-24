/**
 * level 2 : 땅따먹기
 * https://school.programmers.co.kr/learn/courses/30/lessons/12913
 */

class Solution {
    int solution(int[][] land) {
        int answer = 0;

        int[][] dp = new int[land.length][land[0].length];

        for (int i = 1; i < land.length; i++) {
            for (int j = 0; j < 4; j++) {

                if (j == 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j + 1]) + land[i][j];
                } else if (j == land[i].length - 1) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + land[i][j];
                } else {
                    dp[i][j] = Math.max(Math.max(dp[i - 1][j - 1], dp[i - 1][j]), dp[i - 1][j + 1]) + land[i][j];
                }
            }
        }

        for (int i = 0; i < dp[length - 1].length; i++) {
            answer = Math.max(answer, dp[dp.length - 1][i]);
        }

        return answer;
    }
}