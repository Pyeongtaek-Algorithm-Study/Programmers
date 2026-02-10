// level 2 : 최댓값_최솟값

import java.util.Arrays;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        // answer = solve1(s);
        answer = solve2(s);
        
        return answer;
    }
    
    // 내 풀이
    private String solve1(String s) {
        String[] sSpl = s.split(" ");
        int[] sIntArr = new int[sSpl.length];
        
        for (int idx = 0; idx < sSpl.length; idx++) {
            sIntArr[idx] = Integer.parseInt(sSpl[idx]);
        }
        Arrays.sort(sIntArr);
        
        return sIntArr[0] + " " + sIntArr[sIntArr.length - 1];
    }
    
    // 효율 방안
    private String solve2(String s) {
        int[] sArr = Arrays.stream(s.split(" "))
                            .mapToInt(Integer::parseInt)
                            .sorted()
                            .toArray();
        
        return sArr[0] + " " + sArr[sArr.length - 1];
    }
}
