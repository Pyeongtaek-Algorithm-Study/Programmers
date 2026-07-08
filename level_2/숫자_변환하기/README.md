### 문제 이름 : 숫자 변환하기

- **문제 사이트** : https://school.programmers.co.kr/learn/courses/30/lessons/154538
- **Level** : 2
- **알고리즘 유형** : Dynamic Programming
- **시간복잡도** : O(N)
- **참고 링크** : https://velog.io/@subbni/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-Lv.2-%EC%88%AB%EC%9E%90-%EB%B3%80%ED%99%98%ED%95%98%EA%B8%B0

---

### 풀이

1. `dp[i]`에 숫자 `i`를 만드는 최소 연산 횟수 저장
2. DP 배열을 `Integer.MAX_VALUE`로 초기화
3. 시작 숫자 `x`의 연산 횟수를 `0`으로 설정
4. `x`부터 `y`까지 순차 탐색
5. 현재 숫자를 만들 수 없는 경우 건너뜀
6. `+n`, `*2`, `*3` 연산 결과가 범위 내이면 최소 연산 횟수 갱신
7. `dp[y]`가 갱신되지 않았다면 `-1` 반환

---

### 핵심 코드

<details>
<summary>핵심 코드 보기</summary>

```java
for (int i = x; i <= y; i++) {

    // i 자연수를 구현할 수 있는 방법이 없음.
    if (dp[i] == Integer.MAX_VALUE) {
        continue;
    }

    // i + n 자연수를 구현할 수 있는 최소 연산 횟수
    if (i + n <= y) {
        dp[i + n] = Math.min(dp[i + n], dp[i] + 1);
    }

    // i * 2 자연수를 구현할 수 있는 최소 연산 횟수
    if (i * 2 <= y) {
        dp[i * 2] = Math.min(dp[i * 2], dp[i] + 1);
    }

    // i * 3 자연수를 구현할 수 있는 최소 연산 횟수
    if (i * 3 <= y) {
        dp[i * 3] = Math.min(dp[i * 3], dp[i] + 1);
    }
}
```

- DP 배열로 각 숫자의 최소 연산 횟수 관리
- 작은 숫자부터 큰 숫자 방향으로 상태 전이
- 세 가지 연산 결과를 최소 횟수로 갱신
- 만들 수 없는 숫자는 건너뛰어 불필요한 연산 제거

</details>

### 후기

- BFS 대신 DP로 해결 가능
- 단일 반복으로 최소 연산 횟수 계산