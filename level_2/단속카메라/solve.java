// Level 2 : 단속카메라
// 카테고리 : 그리디

import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        // routes 2차원 배열 오름차순 정렬 (진출 지점 기준)
        Arrays.sort(routes, (a, b) -> {
            
            return Integer.compare(a[1], b[1]);
        });
        
        // 차량의 진입 지점의 최소 이전 값 설정
        int cameraIdx = -30001;
        
        for (int[] route : routes) {
            
            // 카메라 설치 위치가 차량 진입 지점보다 이전이면 새롭게 설치
            if (cameraIdx < route[0]) {
                
                // 카메라 설치를 해당 route의 진출지점에 설치
                cameraIdx = route[1];
                answer++;
            }
        }
        
        return answer;
    }
}
