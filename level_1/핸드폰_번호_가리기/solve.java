// level - 1 : 핸드폰_번호_가리기
class Solution {
    public String solution(String phone_number) {
        String answer = "";
        
        answer = solve_1(phone_number);
        // answer = solve_2(phone_number);
        
        return answer;
    }
    
    private String solve_1(String number) {
        String solve_1_ans = "";
        int pNumberLen = number.length();
        
        for (int i = 0; i < pNumberLen - 4; i++) {
            solve_1_ans += '*';
        }
        solve_1_ans += number.substring(pNumberLen - 4, pNumberLen);
        
        return solve_1_ans;
    }
    
    private String solve_2(String number) {
        String solve_2_ans = "";
        int pNumberLen = number.length();
        
        for (int i = 0; i < pNumberLen; i++) {
            if (i < pNumberLen - 4) {
                solve_2_ans += '*';
            }
            else {
                solve_2_ans += number.charAt(i);
            }
        }
        
        return solve_2_ans;
    }
}
