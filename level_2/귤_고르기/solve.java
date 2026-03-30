// Level_2 : 귤_고르기

import java.util.*;
import java.io.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int sum = 0;
        int cnt = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : tangerine) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        // System.out.println(map.values().toString());
        
        List<Integer> valueList = new ArrayList<>(map.values());
        
        // 갯수를 기준으로 내림차순 정렬
        Collections.sort(valueList, Collections.reverseOrder());
        
        // System.out.println(valueList.toString());
        
        for (int v : valueList) {
            // 귤의 개수가 k 개 이상일 시 탐색 종료
            if (sum + v >= k) {
                cnt++;
                break;
            // 귤의 개수가 k 개 미만일 때 해당 크기 귤을 카운트
            } else {
                sum += v;
                cnt++;
            }
        }
        
        return cnt;
    }
}
