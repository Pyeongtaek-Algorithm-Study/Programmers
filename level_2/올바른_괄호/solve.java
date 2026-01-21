class Solution {
    boolean solution(String s) {
        int num = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                num++;
            }
            else {
                num--;
            }
            
            if (num < 0) {
                break;
            }
        }

        return num == 0;
    }
}
