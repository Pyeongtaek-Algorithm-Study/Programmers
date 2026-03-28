import java.io.*;
import java.util.*;

class Solution {
    
    public int[] solution(String[] operations) {
        
        // 초기 값 설정
        int[] answer = {0, 0};
        
        PriorityQueue<Integer> pqMax = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> pqMin = new PriorityQueue<>();
        
        for (String op : operations) {
            
            // 명령어 분리
            String[] tmp = op.split(" ");
            Integer num = Integer.parseInt(tmp[1]);
            
            if (tmp[0].equals("I")) {
                
                pqMax.offer(num);
                pqMin.offer(num);
                
            } else if (tmp[0].equals("D")) {
                if (num == 1) {
                    
                    // 최댓값 큐에서 값 삭제, 최솟값 큐에서 해당 값 삭제
                    pqMin.remove(pqMax.poll());
                    
                } else {
                    
                    // 최솟값 큐에서 값 삭제, 최댓값 큐에서 해당 값 삭제
                    pqMax.remove(pqMin.poll());
                }
            }
        }
        
        // 큐의 사이즈가 0이 아닐 경우 큐에 값이 남아있으니 값설정
        if (pqMax.size() != 0) {
            answer[0] = pqMax.poll();
            answer[1] = pqMin.poll();
        }
        
        return answer;
    }
}
