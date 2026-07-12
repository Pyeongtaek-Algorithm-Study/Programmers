# ### 문제 이름 : 삼각 달팽이

- **문제 사이트** : https://school.programmers.co.kr/learn/courses/30/lessons/68645
- **Level** : 2
- **알고리즘 유형** : Implementation
- **시간복잡도** : O(N²)
- **참고 링크** : 

---

## 풀이

1. `n`번의 방향 전환 반복
2. 현재 방향에서 이동해야 할 칸 수를 `n - i`로 계산
3. `i % 3`으로 아래, 오른쪽, 왼쪽 위 방향 결정
4. 이동한 위치에 숫자를 순차적으로 저장
5. 2차원 배열을 행 순서대로 순회하며 0이 나오기 전까지 결과 배열에 저장

---

## 핵심 코드

<details>
<summary>핵심 코드 보기</summary>

```java
// 좌표 시작 위치
int x = -1, y = 0;
int num = 1;

// i가 방향 같은 개념
for (int i = 0; i < n; ++i) {
    // j는 해당 방향으로 몇 칸 할지 계산
    for (int j = i; j < n; ++j) {
        if (i % 3 == 0) {
            ++x;
        } else if (i % 3 == 1) {
            ++y;
        } else if (i % 3 == 2) {
            --x;
            --y;
        }
        matrix[x][y] = num++;
    }
}
```

- 구현 중심 풀이
- `i % 3`으로 이동 방향 순환
- `n - i`만큼 이동하며 삼각 달팽이 완성
- 별도의 방문 배열이나 방향 전환 조건 없이 구현

</details>

### 후기

- List -> Array 바꾸는 비용이 오래 소모