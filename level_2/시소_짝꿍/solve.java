/**
 * Level 2 : 시소 짝꿍
 * 
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/152996
 * 유형 : 해시, 정렬
 */

import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;

        // 무게 배열 정렬
        Arrays.sort(weights); 
        HashMap<Double, Integer> map = new HashMap<>();

        for (int weight : weights) {
            
            // 현재 weight의 짝꿍 무게 비율 계산
            double[] ratios = {
                weight * 1.0,       // 2m vs 2m
                weight * 2.0 / 3.0, // 2m vs 3m
                weight * 0.5,       // 2m vs 4m
                weight * 0.75       // 3m vs 4m
            };

            for (double ratio : ratios) {

                // 현재 weight의 짝꿍 무게 비율이 이미 map에 존재하는 경우 => 시소 짝궁
                if (map.containsKey(ratio)) {
                    answer += map.get(ratio);
                }
            }

            map.put(weight * 1.0, map.getOrDefault(weight * 1.0, 0) + 1);
        }

        return answer;
    }
}
