import java.util.*;

class Solution {
    public String solution(String number, int k) {
        
        // 문자 보관용
        Deque<Character> dq = new ArrayDeque<>();
        
        // 뺀 횟수
        int cnt = 0;
        
        for (char ch : number.toCharArray()) {
            
            // dq 마지막 값과 ch값 비교하여 뒤 부터 큰 값 넣기
            while (!dq.isEmpty() && dq.peekLast() < ch && cnt < k) {
                cnt++;
                dq.pollLast();
            }
            
            dq.offerLast(ch);
        }
        // 남은 cnt 만큼 마지막 순서 값 제외
        while (cnt < k) {
            dq.pollLast();
            cnt++;
        }
        
        StringBuilder sb = new StringBuilder();
        
        // Deque 순차적으로 숫자 문자열 붙이기
        for (char ch : dq) {
            sb.append(ch);
        }

        return sb.toString();
    }
}