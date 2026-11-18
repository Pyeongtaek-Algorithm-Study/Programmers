# ### 문제 이름 : n^2 배열 자르기

- **문제 사이트** : https://school.programmers.co.kr/learn/courses/30/lessons/87390
- **Level** : 2
- **알고리즘 유형** : Implementation, Math
- **시간복잡도** : O(N)
- **참고 링크** : 

---

## 풀이

1. `n`이 최대 $10^7$이므로 2차원 배열을 직접 만들면 메모리 및 시간 초과
2. `right - left`는 $10^5$ 미만이므로 필요한 구간만 계산
3. 1차원 인덱스 `idx`를 2차원 좌표로 변환 → 행 = `idx / n`, 열 = `idx % n`
4. `(행, 열)` 위치의 값은 `max(행, 열) + 1`
5. `left`, `right`가 `long`이므로 계산은 `long`, 결과 저장 시 `int`로 형변환

---

## 핵심 코드

<details>
<summary>핵심 코드 보기</summary>

```java
for (int i = 0; i < answer.length; i++) {
    // 1차원 배열의 위치
    long idx = left + i;
    long row = idx / n;
    long col = idx % n;

    // 행과 열 중에 가장 큰 값 + 1이 해당 위치번째의 2차원 배열의 값
    answer[i] = (int)Math.max(row, col) + 1;
}
```

- 2차원 배열을 만들지 않고 인덱스만으로 값 계산
- `idx / n`, `idx % n`으로 1차원 → 2차원 좌표 변환
- `max(row, col) + 1` 규칙으로 값 결정

</details>

### 후기

- 좌표(행, 열)는 구했지만 좌표와 값 사이의 규칙(`max + 1`)을 찾는 데 시간이 걸림
- `long` 타입을 배열 크기나 `int` 배열에 그대로 쓰면 컴파일 에러 → 형변환 필수
