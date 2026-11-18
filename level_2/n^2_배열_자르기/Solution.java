import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right - left + 1)];
        
        // left부터 right번째까지 배열 만들기
        for (int i = 0; i < answer.length; i++) {
            
            // 1차원 배열의 위치
            long idx = left + i; 
            long row = idx / n;
            long col = idx % n;
            
            // 행과 열 중에 가장 큰 값 + 1이 해당 위치번째의 2차원 배열의 값
            answer[i] = (int)Math.max(row, col) + 1;
        }
        
        
        return answer;
    }
}
