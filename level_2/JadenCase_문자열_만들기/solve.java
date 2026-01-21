class Solution {
    public String solution(String s) {
        String answer = "";
        String[] words = s.split(" ");
        
        for (String word : words) {
            if (word.length() == 0) {
                answer += " ";
            }
            else {
                answer += word.substring(0, 1).toUpperCase();
                answer += word.substring(1).toLowerCase();
                answer += " ";
            }
        }
        
        // 원래 문자열에 마지막이 공백일 경우 그대로 제출
        if (s.charAt(s.length() - 1) == ' ') {
            return answer.substring(0, answer.length());
        }
        // 원래 문자열에 공백이 없으면 공백 제거 후 제출
        return answer.substring(0, answer.length() - 1);
    }
}
