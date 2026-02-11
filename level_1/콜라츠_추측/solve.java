// level 1 : 콜라츠_추측

class Solution {
    public int solution(long num) {
        int cnt = 0;
        
        for ( ; cnt < 500; cnt++) {
            if (num == 1) break;
            
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num = (num * 3) + 1;
            }
            // System.out.println(String.format("%d %d", num, cnt));
        }
        
        
        return cnt == 500 ? -1 : cnt;
    }
}
