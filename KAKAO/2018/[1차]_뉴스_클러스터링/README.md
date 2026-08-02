### 문제 이름 : 뉴스 클러스터링

- **문제 사이트** : https://school.programmers.co.kr/learn/courses/30/lessons/17677
- **Level** : 2
- **알고리즘 유형** : 문자열, 해시맵

---

### 풀이

1. 문자열을 소문자로 변환 (대소문자 구분 없음)
2. 문자열을 2-gram 단위로 분리
3. 영문자 2개로 이루어진 문자열만 사용
4. HashMap으로 2-gram 등장 횟수를 저장
5. 두 Map의 key 값으로 전체 집합 구현
6. 교집합은 각 문자열의 최소 등장 횟수를 누적
7. 합집합은 각 문자열의 최대 등장 횟수를 누적
8. 합집합이 0이면 65536을 반환
9. `(교집합 / 합집합) * 65536`을 계산하여 반환

---

### 핵심 코드

<details>
<summary>핵심 코드 보기</summary>

```java
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
```

* 문자열을 2-gram 단위로 분리한다.
* 영문자 2개인 경우만 사용한다.
* HashMap으로 등장 횟수를 누적한다.
* 다중집합을 Map으로 구현한다.

</details>

