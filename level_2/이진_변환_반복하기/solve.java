import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        while (!"1".equals(s)) {
            // 이진 변환 횟수 증가
            answer[0]++;
            
            // s의 원래 길이
            long sLen = s.length();
            
            // s 문자열에서 0 문자 지우기
            s = s.replace("0", "");
            
            // 지운 0 개수 증가 (0 개수 : 원본 길이 - 1의 길이)
            answer[1] += sLen - s.length();

            // 1의 길이 -> 2진법 표현
            s = Long.toBinaryString(s.length());
        }
        
        return answer;
    }
}