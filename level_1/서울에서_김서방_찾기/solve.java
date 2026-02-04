// 서울에서 김서방 찾기 (level 1)
import java.util.Arrays;

class Solution {
    public String solution(String[] seoul) {
        int kimIdx = Arrays.asList(seoul).indexOf("Kim");
        
        return String.format("김서방은 %d에 있다", kimIdx);
    }
}
