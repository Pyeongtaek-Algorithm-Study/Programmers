### 숫자의 표현

- **문제 사이트** : [숫자의 표현](https://school.programmers.co.kr/learn/courses/30/lessons/12924)
- **알고리즘 유형** : *누적합, 투 포인터*

---

### 풀이

1. 1부터 n까지의 누적합 배열을 생성한다.
2. `left`, `right`로 구간 합을 계산한다.
3. 구간 합이 n보다 작으면 `right`를 증가한다.
4. 구간 합이 n 이상이면 `left`를 증가한다.
5. 구간 합이 n과 같으면 경우의 수를 증가한다.
6. 투 포인터를 이동하며 모든 연속된 수의 합을 탐색한다.

---

### 핵심 코드

<details>
<summary>핵심 코드 보기</summary>

```java
while (left < right) {
    long sum = sumArr[right] - sumArr[left];

    if (sum < n) {
        right++;
    } else {
        if (sum == n) {
            answer++;
        }
        left++;
    }
}
```

- 누적합 배열로 구간 합을 O(1)에 계산한다.
- 투 포인터로 연속 구간을 탐색한다.
- 구간 합 크기에 따라 포인터를 이동한다.
- 구간 합이 n인 경우 정답을 증가한다.

</details>