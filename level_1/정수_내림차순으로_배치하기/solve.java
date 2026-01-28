import java.util.Arrays;
import java.util.Collections;

class Solution {
    public void pl(Object o) {
        System.out.println(o);
    }
    
    public long solution(long n) {
        long answer = 0;
        String str = String.valueOf(n);
        String[] splitStr = str.split("");
        
        Arrays.sort(splitStr, Collections.reverseOrder());
        
        answer = Long.parseLong(String.join("", splitStr));
        return answer;
    }
}
