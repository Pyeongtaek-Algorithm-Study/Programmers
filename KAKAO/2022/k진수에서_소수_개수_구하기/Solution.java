import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        // k진수 변환
        String s = Integer.toString(n, k);
        
        // 직접 k진수 변환
        // String s = toBase(n, k);
        
        for (String p : s.split("0")) {
            
            if (p.isEmpty()) continue;
            
            if (isPrime(Long.parseLong(p))) answer++;
        }
        
        return answer;
    }
    
    // 나머지를 구하고 역순으로 반환하여 k진수 구하기
    private String toBase(int n, int k) {
        StringBuilder sb = new StringBuilder();
        
        while (n > 0) {
            
            // 낮은 자리부터 쌓기
            sb.append(n % k);
            n /= k;
        }
        
        // 뒤집기
        return sb.reverse()
            .toString();
    }
    
    // 숫자 소수 판별
    private boolean isPrime(long num) {
        
        if (num < 2) return false;
        
        for (long i = 2; i * i <= num; i++) {
            
            if (num % i == 0) return false;
        }
        
        return true;
    }
}
