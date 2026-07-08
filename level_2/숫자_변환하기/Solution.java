import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {

        int[] dp = new int[y + 1];

        // 매우 큰 값으로 배열 초기화
        Arrays.fill(dp, Integer.MAX_VALUE);

        // 시작 위치
        dp[x] = 0;

        for (int i = x; i <= y; i++) {

            // i 자연수를 구현할 수 있는 방법이 없음.
            if (dp[i] == Integer.MAX_VALUE) {
                continue;
            }

            // i + n 자연수를 구현할 수 있는 최소 연산 횟수
            if (i + n <= y) {
                dp[i + n] = Math.min(dp[i + n], dp[i] + 1);
            }

            // i * 2 자연수를 구현할 수 있는 최소 연산 횟수
            if (i * 2 <= y) {
                dp[i * 2] = Math.min(dp[i * 2], dp[i] + 1);
            }

            // i * 3 자연수를 구현할 수 있는 최소 연산 횟수
            if (i * 3 <= y) {
                dp[i * 3] = Math.min(dp[i * 3], dp[i] + 1);
            }
        }

        return dp[y] != Integer.MAX_VALUE ? dp[y] : -1;
    }

}