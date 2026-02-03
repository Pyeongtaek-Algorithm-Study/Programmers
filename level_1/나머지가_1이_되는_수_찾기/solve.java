// 나머지가 1이 되는 수 찾기 (level 1)

class Solution {
    public int solution(int n) {
        int answer = 2;
        
        while (true) {
            if (n % answer == 1) {
                break;
            }
            answer++;
        }
        return answer;
    }
}
