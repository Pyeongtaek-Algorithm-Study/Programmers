class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;

        while (a != b) {
            
            // 짝수 만들기
            if ((a & 1) == 1) {
                a += 1;
            }

            if ((b & 1) == 1) {
                b += 1;
            }
            
            // 다음 라운드 시 번호
            a = a >> 1;
            b = b >> 1;
            
            // 라운드 횟수 증가
            answer++;
        }

        return answer;
    }
}