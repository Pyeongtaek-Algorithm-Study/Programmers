import java.util.Queue;
import java.util.LinkedList;
import java.util.*;
import java.io.*;

class Solution {
    
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int priority : priorities) {
            
            pq.offer(priority);
        }
        
        while (pq.isEmpty() == false) {
            
            for (int idx = 0; idx < priorities.length; idx++) {
                
                if (priorities[idx] == pq.peek()) {
                    
                    int tmp = pq.poll();
                    answer++;
                    
                    if (idx == location) {
                        return answer;
                    }
                }
            }
        }
        
        return answer;
    }
}
