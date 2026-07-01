import java.util.*;

// 문제 : 괄호_회전하기
// level: 2
class Solution {
    public int solution(String s) {
        int answer = 0;
        
        // 방법 1
        int sLen = s.length();
        
        // s칸 만큼 회전 문자열
        for (int rotate = 0; rotate < sLen; rotate++) {
            
            StringBuilder sb = new StringBuilder();
            
            for (int idx = rotate; idx < rotate + sLen; idx++) {
                sb.append(s.charAt(idx % sLen));
            }
            
            // System.out.println(sb.toString());
            
            if(upright(sb.toString()) == true) {
                answer++;    
            }
        }
        
        // 방법 1 : 회전된 문자열을 각 문자를 확인하여 stack으로 해결
        // return answer;
        
        // 방법 2 : 회전된 문자열을 Map과 Deque를 통해 해결
        return refactSolution(s);
    }
    
    // 문자열이 올바른지 확인
    private boolean upright(String str) {
        
        Stack<Character> st = new Stack<>();
        
        for (int idx = 0; idx < str.length(); idx++) {
            if (!st.isEmpty()) {
                // 닫는 괄호들일 때 스택 최상단 값 확인 후 꺼내기
                switch (str.charAt(idx)) {
                        
                    case ')':
                        
                        if (st.peek() == '(') {
                            st.pop();
                        }

                        break;
                        
                    case '}':
                        
                        if (st.peek() == '{') {
                            st.pop();
                        }
                        
                        break;
                        
                    case ']':

                        if (st.peek() == '[') {
                            st.pop();
                        }
                        
                        break;
                    // 여는 괄호는 스택 넣기
                    default:
                        st.push(str.charAt(idx));
                }
                
            } else {
                st.push(str.charAt(idx));
            }
        }
        
        return st.size() == 0 ? true : false;
    }
    
    // 방법 2 : 더 효율적인 풀이
    private int refactSolution(String s) {
        
        int answer = 0;
        int len = s.length();
        
        // 회전 문자열을 위한 2배 길이
        String doubled = s + s;
        
        for (int start = 0; start < len; start++) {
            
            String rotated = doubled.substring(start, start + len);
            
            if (isUpright(rotated)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private boolean isUpright(String str) {
        
        Deque<Character> stack = new ArrayDeque<>();
        
        // 최대 10개 쌍만 가능
        Map<Character, Character> pair = Map.of(
            ')', '(',
            '}', '{',
            ']', '['
        );
        
        for (char ch : str.toCharArray()) {
            
            // 여는 괄호
            if (!pair.containsKey(ch)) {
                stack.push(ch);
                continue;
            }
            
            // 닫는 괄호
            if (stack.isEmpty() || stack.pop() != pair.get(ch)) {
                return false;
            }
        }
        
        // stack 비어있으면 올바른 괄호
        return stack.isEmpty();
    }
}
