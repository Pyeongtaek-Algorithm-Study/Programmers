### 문제 이름 : 숫자 게임

- **문제 사이트** : https://school.programmers.co.kr/learn/courses/30/lessons/12987
- **Level** : 3
- **알고리즘 유형** : Sorting, Two Pointers
- **시간복잡도** : O(N log N)
- **참고 링크** : 

---

### 풀이

1. A, B 배열을 오름차순 정렬
2. A와 B를 각각 투 포인터로 순회
3. B의 현재 숫자가 A보다 크면 승리 처리
4. 승리 시 A 포인터와 정답 증가
5. B 포인터는 모든 경우 다음 숫자로 이동
6. B를 모두 확인하면 종료

---

### 핵심 코드

<details>
<summary>핵심 코드 보기</summary>

```java
while (aPoint < A.length && bPoint < B.length) {

    // B가 현재 A를 이기면 다음 A로 이동
    if (A[aPoint] < B[bPoint]) {
        aPoint++;
        answer++;
    }

    // B는 항상 다음 숫자 사용
    bPoint++;
}
```

- 정렬 후 작은 숫자부터 순차 비교
- 이길 수 있는 가장 작은 B 숫자 사용
- Greedy 방식으로 최대 승리 횟수 계산
- Two Pointers로 한 번만 순회

</details>