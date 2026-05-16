import java.util.*;

class Solution {

    public int solution(int n, int k, int[] enemy) {

        if (k >= enemy.length) {
            return enemy.length;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(k + 1);

        for (int i = 0; i < enemy.length; i++) {

            // 우선 무적권 후보에 추가
            pq.offer(enemy[i]);

            // 무적권 개수 초과 시 가장 작은 라운드를 병사 처리
            if (pq.size() > k) {
                n -= pq.poll();
            }

            // 병사 부족 시 종료
            if (n < 0) {
                ans = i;
                break;
            }
        }

        return ans;
    }
}