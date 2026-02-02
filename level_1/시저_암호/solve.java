// 시저 암호 (level 1)

class Solution {
    public void pl(Object o) {
        System.out.println(o);
    }
    
    public String solution(String s, int n) {
        String answer = "";
        
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        String Alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (ch >= 'A' && ch <= 'Z') {
                answer += Alpha.charAt((ch - 'A' + n) % 26);
            }
            else if (ch >= 'a' && ch <= 'z') {
                answer += alpha.charAt((ch - 'a' + n) % 26);
            }
            else {
                answer += ch;
            }
        }
        
        return answer;
    }
}
