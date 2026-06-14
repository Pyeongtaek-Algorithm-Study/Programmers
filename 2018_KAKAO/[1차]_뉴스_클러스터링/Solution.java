import java.util.*;

/**
 * 문제 : 뉴스 클러스터링
 * Level : 2
 * 알고리즘 유형 : 문자열, 해시맵
 */
class Solution {

    // 자카드 유사도 계산 시 사용하는 문제 고정값
    private static final int JACCARD_SCALE = 65536;

    public int solution(String str1, String str2) {

        // 문자열을 2-gram 다중집합(Map)으로 변환
        Map<String, Integer> map1 = makeMap(str1.toLowerCase());
        Map<String, Integer> map2 = makeMap(str2.toLowerCase());

        // 모든 2-gram 종류를 저장하기 위한 합집합 Set
        Set<String> keys = new HashSet<>();
        keys.addAll(map1.keySet());
        keys.addAll(map2.keySet());

        int intersection = 0;
        int union = 0;

        // 모든 2-gram 종류 순회
        for (String key : keys) {

            // 해당 2-gram의 등장 횟수 조회
            // 없는 경우 0으로 처리
            int cnt1 = map1.getOrDefault(key, 0);
            int cnt2 = map2.getOrDefault(key, 0);

            // 교집합 : 두 집합의 최소 개수
            intersection += Math.min(cnt1, cnt2);

            // 합집합 : 두 집합의 최대 개수
            union += Math.max(cnt1, cnt2);
        }

        // 두 집합이 모두 공집합인 경우
        if (union == 0) {
            return JACCARD_SCALE;
        }

        // 자카드 유사도 계산
        return (int) ((double) intersection / union * JACCARD_SCALE);
    }

    /**
     * 문자열을 2-gram 다중집합으로 변환, 등장 횟수 누적
     *
     * 예)
     * AAAAA
     * -> AA, AA, AA, AA
     * -> {AA=4}
     */
    private Map<String, Integer> makeMap(String str) {

        Map<String, Integer> map = new HashMap<>();

        // 2글자씩 잘라서 확인
        for (int i = 0; i < str.length() - 1; i++) {

            String twoGram = str.substring(i, i + 2);

            // 영문자 2개가 아니면 제외
            if (twoGram.matches("[a-z]{2}") == false) {
                continue;
            }

            // 등장 횟수 누적
            map.put(twoGram, map.getOrDefault(twoGram, 0) + 1);
        }

        return map;
    }
}