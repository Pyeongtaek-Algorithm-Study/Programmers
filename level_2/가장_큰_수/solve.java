// 가장 큰 수 - level 2

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";

        List<String> strList = new ArrayList<>();
        for (int number : numbers) {
            strList.add(String.valueOf(number));
        }
        
        String[] strArr = strList.toArray(new String[0]);
        // compareTo : 첫번째 문자열이 두번째 문자열보다 작으면 음수, 크면 양수, 같으면 0
        // 106 vs 610의 결과가 음수 -> 그대로 냅두기
        Arrays.sort(strArr, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));
        
        for (int idx = 0; idx < numbers.length; idx++) {
            answer += strArr[idx];
        }

        // 문자열의 모든 값이 0인 경우, 0을 출력
        return answer.charAt(0) != '0' ? answer : "0";
    }
}
