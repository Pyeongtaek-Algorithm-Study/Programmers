import java.util.*;

class Solution {
    
    // 흩어진 종리 조각으로 만들 수 있는 수 목록
    private Set<Integer> conbinedNums = new HashSet<>();
    
    public int solution(String numbers) {
        int answer = 0;
        
        boolean[] visited = new boolean[numbers.length()];
        
        // DFS로 숫자 조합
        dfs(numbers, "", visited);
        
        for (Integer num : conbinedNums) {
            
            // 조합 숫자가 소수일 경우, answer 증가
            if (isPrime(num) == true) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private void dfs(
        String nums, 
        String curNums, 
        boolean[] visited
    ) {
       
        if (curNums.isBlank() == false) {
            conbinedNums.add(Integer.parseInt(curNums));
        }
        
        for (int i = 0; i < nums.length(); i++) {
            
            // 이미 사용한 숫자
            if (visited[i] == true) {
                continue;
            }
            
            // Back-Tracking
            visited[i] = true;
            dfs(nums, curNums + nums.charAt(i), visited);
            visited[i] = false;
        }
    }
    
    // 소수 판별
    private boolean isPrime(int number) {
        
        // 2 미만의 수는 소수 아님.
        if (number < 2) {
            return false;
        }
        
        for (int i = 2; i <= Math.sqrt(number); i++) {
            
            if (number % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}
