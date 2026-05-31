import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        // 누적합 배열 선언
        long[] sumArr = new long[n + 1];

        // 누적합 배열 생성
        for (int i = 1; i <= n; i++) {
            sumArr[i] = sumArr[i - 1] + i;
        }

        // 누적합의 좌우 위치
        int left = 0;
        int right = 1;
        
        while (left < right) {
            
            long sum = sumArr[right] - sumArr[left];

            // 구간 배열의 합이 n보다 작은 경우, right 증가
            if (sum < n) {
                right++;
                
            // 구간 배열의 합이 n 이상인 경우, left 증가
            } else {
                
                // 구간 배열 합이 n인 경우, answer 증가
                if (sum == n) {
                    answer++;
                }

                left++;
            }
        }
        
        return answer;
    }
}