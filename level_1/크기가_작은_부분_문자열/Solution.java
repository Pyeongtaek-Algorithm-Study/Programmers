class Solution {
    public int solution(String t, String p) {
        int answer = 0;

        int pLen = p.length();
        // p의 길이 최대 18자리
        Long pInt = Long.valueOf(p);

        for (int i = 0; i < t.length() - pLen + 1; i++) {

            // p길이 부분 숫자
            Long num = Long.parseLong(t.substring(i, i + pLen));

            // p보다 작거나 같은 수 횟수
            if (num <= pInt) {
                answer++;
            }
        }
        return answer;
    }
}