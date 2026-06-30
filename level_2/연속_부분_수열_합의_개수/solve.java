import java.util.*;
import java.util.stream.*;

class Solution {

    public int solution(int[] elements) {
        
        int ans = 0;
        
        // List 배열로 풀기
        // 테스트 경과 : 500~1000ms, 130MB 소모
        // ans = solve_1(elements);
        
        // 3중 반복문 풀기
        // 테스트 경과 : 300~600ms, 100MB 소모
        ans = solve_2(elements);
        
        return ans;
    }

    private int solve_1(int[] elements) {

        HashSet<Integer> set = new HashSet<>();

        // int 배열 -> List 형변환
        List<Integer> list = Arrays.stream(elements)
                .boxed()
                .collect(Collectors.toList());
        
        // 기존 List를 2배 List로 변환
        list.addAll(list);
        
        // 원형 배열 크기
        int elLen = elements.length;
        
        for (int i = 0; i < elLen; i++) {
            for (int j = 1; j <= elLen; j++) {
                int sum = 0;
                
                // 연속 부분 수열 합산 구하기
                for (int li : list.subList(i, i + j)) {
                    sum += li;
                }
                
                set.add(sum);
            }
        }
        
        // set 크기 반환
        return set.size();
    }

    private int solve_2(int[] elements) {
        
        HashSet<Integer> set = new HashSet<>();
        
        int elLen = elements.length;
        
        // 부분 수열의 길이 
        for (int size = 1; size <= elLen; size++) {
            
            // 부분 수열의 시작 위치
            for (int st = 0; st < elLen; st++) {
                
                int sum = 0;
                
                // 연속 부분 수열 합산 구하기
                for (int idx = st; idx < st + size; idx++) {
                    sum += elements[idx % elLen];
                }
                
                set.add(sum);
            }
        }
        
        // set 크기 반환
        return set.size();
    }
}