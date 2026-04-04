// level_2 : 구명보트

import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        
        // 한사람 당 구명보트 1개씩
        int boat = people.length;
        
        // 사람 오름차순 정렬
        Arrays.sort(people);
        
        int left = 0;
        int right = people.length - 1;
        
        // 투 포인터
        while (left < right) {
            
            // 몸무게가 큰 사람과 작은사람으로 무게 측정
            if (people[left] + people[right] <= limit) {
                
                left++;
                right--;
                
                // 해당 두 사람일 때 같은 배를 탈 수 있으므로, 배 총량 감소
                boat--;
            } else {
                
                // 무게 제한 초과임으로 더 낮은 무게 사람 위치로 이동
                right--;
            }
        }
        
        return boat;
    }
}