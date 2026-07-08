import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) throws Exception {
        int answer = 0;

        // cache 크기가 0인 경우 (예제 6번)
        if (cacheSize == 0) {
            return 5 * cities.length;
        }

        Deque<String> dq = new ArrayDeque<>(cacheSize);

        for (String city : cities) {

            // 대소문자 구분 X
            city = city.toUpperCase();

            if (dq.contains(city)) {

                answer++;

                // 재갱신
                dq.remove(city);
                dq.offerFirst(city);
            } else {
                answer += 5;

                // 캐시 크기가 가득 찼을 때, 마지막 도시 빼기
                if (dq.size() == cacheSize) {
                    dq.removeLast();

                }

                dq.offerFirst(city);
            }
        }

        return answer;
    }
}