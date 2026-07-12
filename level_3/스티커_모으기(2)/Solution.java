import java.util.*;

class Solution {
    public int solution(int sticker[]) {
        int answer = 0;

        int len = sticker.length;

        // 스티커가 1개면은 1개가 최댓값
        if (len == 1)
            return sticker[0];

        int[][] dp = new int[len][2];

        // 첫 스티커를 뜯을 때 (마지막 사용 불가)
        dp[0][1] = sticker[0];
        dp[1][1] = dp[0][1];
        // 두번째 스티커를 뜯을 때 (마지막 사용 가능)
        dp[1][0] = sticker[1];

        for (int idx = 2; idx < len; idx++) {
            dp[idx][0] = Math.max(sticker[idx] + dp[idx - 2][0], dp[idx - 1][0]);
            dp[idx][1] = Math.max(sticker[idx] + dp[idx - 2][1], dp[idx - 1][1]);
        }

        return Math.max(dp[len - 1][0], dp[len - 2][1]);
    }
}