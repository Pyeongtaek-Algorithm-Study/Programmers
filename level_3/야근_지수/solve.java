// level_3: 야근_지수

import java.io.*;
import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        
        for (int work : works) {
            pq.add(work);
        }
        
        while (--n >= 0) {
            int afterWork = pq.poll() - 1;
            
            // 현재 남아 있는 작업량이 0보다 작으면, 남은 작업량이 없음.
            if (afterWork < 0) {
                break;
            }
            pq.add(afterWork);
        }
        
        System.out.println(pq);
        
        // pq에 남아있는 작업량 제곱
        while (pq.isEmpty() == false) {
            int remindWork = pq.poll();
            answer += remindWork * remindWork;
        }
        
        return answer;
    }
}
