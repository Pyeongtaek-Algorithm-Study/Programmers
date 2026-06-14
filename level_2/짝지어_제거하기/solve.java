import java.util.*;

/**
 * 문제 : 짝지어 제거하기
 * Level : 2
 * 알고리즘 유형 : 스택
 */
class Solution {
    public int solution(String s) {
        
        Stack<Character> st = new Stack<>();

        // 문자열을 문자 배열로 변환
        char[] chars = s.toCharArray();

        // 각 문자 순회
        for (char c : chars) {
            
            // 스택이 비어있지 않고 스택의 최상단 값이 현재 문자와 같으면 짝지은 문자열임으로 제거
            if (!st.empty() && st.peek() == c) {
                st.pop();
            // 그렇지 않으면 스택에 문자 추가
            } else {
                st.push(c);
            }
            
        }

        // 스택의 값 없음 -> 모든 문자열 짝지음, 스택의 값 있음 -> 짝 짓지 못한 문자열 존재
        int answer = st.empty() ? 1 : 0;

        return answer;
    }
}