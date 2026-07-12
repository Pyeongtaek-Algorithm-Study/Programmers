import java.util.*;

class Solution {

    // 만들 수 없는 경우 판단을 위한 상수
    private static final int IMPOSIBLE = -2;

    public int solution(int[] queue1, int[] queue2) {
        int answer = -2;

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        long sum1 = 0;
        long sum2 = 0;

        for (int idx = 0; idx < queue1.length; idx++) {
            q1.offer(queue1[idx]);
            q2.offer(queue2[idx]);

            // 누적합
            sum1 += queue1[idx];
            sum2 += queue2[idx];
        }

        // cnt가 queue1의 원소가 모두 queue2로 갔다가 다시 queue1에 돌아오는 횟수를 최대 횟수라고 가정
        for (int cnt = 0; cnt < queue1.length * 2 * 2; cnt++) {

            if (sum1 == sum2) {
                answer = cnt;
                break;
            }

            // q1의 앞단 원소를 q2에 넘겨주기 (누적합도 갱신)
            if (sum1 > sum2) {

                int top = q1.poll();

                q2.offer(top);

                sum1 -= top;
                sum2 += top;

                // q2의 앞단 원소를 q1에 넘겨주기 (누적합도 갱신)
            } else if (sum1 < sum2) {
                int top = q2.poll();

                q1.offer(top);

                sum2 -= top;
                sum1 += top;
            }
        }

        return answer != IMPOSIBLE ? answer : -1;
    }
}