### 문제 이름 : 점프와 순간 이동

- **문제 사이트** : https://school.programmers.co.kr/learn/courses/30/lessons/12980
- **Level** : 2
- **알고리즘 유형** : Bitmasking, Greedy
- **시간복잡도** : O(log N)
- **참고 링크** : https://frombasics.tistory.com/285

---

### 풀이

1. 순간이동은 건전지를 사용하지 않음
2. 건전지는 1칸 점프할 때만 사용
3. 목적지에서 시작 위치까지 역추적
4. 현재 위치가 홀수면 1칸 점프한 경우이므로 `-1` 수행 후 사용량 증가
5. 현재 위치가 짝수면 순간이동이 가능하므로 `2`로 나누기
6. 위치가 `0`이 될 때까지 반복
7. 홀수의 개수가 최소 건전지 사용량

---

### 핵심 코드

<details>
<summary>핵심 코드 보기</summary>

```java
while (n != 0) {

    // 홀수면 점프 사용
    if ((n & 1) == 1) {
        n--;
        usage++;
    // 짝수면 순간이동
    } else {
        n /= 2;
    }
}
```

- Bit Manipulation으로 홀수와 짝수 판별
- 역추적으로 순간이동과 점프 구분
- 홀수일 때만 건전지 사용량 증가
- DP 대신 O(log N)으로 해결

</details>

### 후기

- Bottom-Up 방식은 O(N²)으로 메모리와 시간 모두 비효율
- Top-Down 방식과 비트 연산으로 단순 해결
- 홀수의 개수가 정답이라는 점이 핵심 => `Integer.bitCount`