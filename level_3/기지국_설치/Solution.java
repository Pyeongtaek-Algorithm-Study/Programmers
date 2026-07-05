class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        // 아파트의 기지국 범위
        int range = w * 2 + 1;

        int start = 1;

        for (int station : stations) {

            // 현재 기지국이 커버하기 직전 위치
            int end = station - w - 1;

            if (start <= end) {
                int length = end - start + 1;

                // 해당 비어있는 범위 내의 기지국 설치 개수 (올림 나눗셈)
                answer += (length + range - 1) / range;
            }

            start = station + w + 1;
        }

        // 마지막 기지국 이후 전파가 닿지 않는 구간
        if (start <= n) {

            // 마지막 범위
            int length = n - start + 1;

            // 필요한 기지국 개수 (올림 나눗셈)
            answer += (length + range - 1) / range;
        }

        return answer;
    }
}