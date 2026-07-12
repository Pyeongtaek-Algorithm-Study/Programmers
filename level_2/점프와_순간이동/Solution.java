import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;

        // ans = failWay(n);
        // ans = successWay(n);

        // 홀수의 개수는 곧 비트의 개수
        return Integer.bitCount(n);
    }

    private int successWay(int n) {

        int usage = 0;

        // Top-Down 방식
        while (n != 0) {

            // 홀수일 경우 -1을 하여
            if ((n & 1) == 1) {
                n--;
                usage++;
                // 짝수일 경우 2로 나누기
            } else {
                n /= 2;
            }
        }

        return usage;

    }

    // 메모리 초과 발생 (Bottom-Up 방식)
    private int failWay(int n) {

        int dp[] = new int[n + 1];

        // 점프일 때의 건전지 사용량 대입
        for (int i = 0; i <= n; i++) {
            dp[i] = i;
        }

        for (int i = 1; i <= n; i++) {

            // 순간이동 위치
            if (i * 2 <= n) {
                dp[i * 2] = Math.min(dp[i * 2], dp[i]);
            }

            // i번째 뒤 배열들의 최소 건전지 사용량 갱신
            for (int j = 1; j <= n - i; j++) {
                dp[i + j] = Math.min(dp[i + j], dp[i] + j);
            }
        }

        return dp[n];
    }
}