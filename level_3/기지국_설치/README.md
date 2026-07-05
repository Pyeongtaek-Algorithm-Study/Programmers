### 문제 이름 : 기지국 설치

- **문제 사이트** : https://school.programmers.co.kr/learn/courses/30/lessons/12979
- **Level** : 3
- **알고리즘 유형** : Greedy
- **시간복잡도** : O(N)
- **참고 링크** : GPT

---

### 풀이

1. 기지국 1개의 커버 범위(`2 * w + 1`) 계산
2. 아직 전파가 닿지 않은 시작 위치를 `start = 1`로 설정
3. 각 기지국마다 커버 직전 위치(`end`) 계산
4. `start ~ end` 구간이 존재하면 길이 계산
5. 올림 나눗셈으로 필요한 기지국 개수 계산
6. `start`를 현재 기지국이 커버한 다음 위치로 이동
7. 마지막 기지국 이후 남은 구간도 동일하게 처리

---

### 핵심 코드

<details>
<summary>핵심 코드 보기</summary>

```java
int range = 2 * w + 1;
int start = 1;

for (int station : stations) {
    int end = station - w - 1;

    if (start <= end) {
        int length = end - start + 1;

        // 비어 있는 구간에 필요한 기지국 개수 계산
        answer += (length + range - 1) / range;
    }

    // 현재 기지국이 커버한 다음 위치부터 탐색
    start = station + w + 1;
}

if (start <= n) {
    int length = n - start + 1;

    // 마지막 남은 구간 처리
    answer += (length + range - 1) / range;
}
```

- 구간을 순차적으로 탐색
- 커버되지 않은 구간만 계산
- 올림 나눗셈으로 필요한 기지국 개수 계산
- 추가 배열 없이 O(1) 공간 사용

</details>