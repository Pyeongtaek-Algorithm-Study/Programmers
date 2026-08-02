### 문제 이름 : 두 큐 합 같게 만들기

- **문제 사이트** : https://school.programmers.co.kr/learn/courses/30/lessons/118667
- **Level** : 2
- **알고리즘 유형** : Queue, Prefix sum
- **시간복잡도** : O(N)
- **참고 링크** : https://record-developer.tistory.com/168

---

### 풀이

1. queue1, queue2를 Queue로 생성하고 각각의 누적합 계산
2. 두 큐의 합이 같으면 현재 이동 횟수 반환
3. 합이 큰 큐의 앞 원소를 작은 큐로 이동
4. 원소 이동과 동시에 두 큐의 누적합 갱신
5. 모든 원소가 한 번씩 이동 후 다시 돌아오는 횟수를 최대 이동 횟수로 설정
6. 최대 횟수까지도 합을 맞추지 못하면 -1 반환

---

### 핵심 코드

<details>
<summary>핵심 코드 보기</summary>

```java
// cnt가 queue1의 원소가 모두 queue2로 갔다가 다시 queue1에 돌아오는 횟수를 최대 횟수라고 가정
for (int cnt = 0; cnt < queue1.length * 2 * 2; cnt++) {

    if (sum1 == sum2) {
        answer = cnt;
        break;
    }

    // q1의 앞단 원소를 q2에 넘겨주기 (누적합도 갱신)
    if (sum1 > sum2) {

        int top = q1.poll();

        q2.offer(top);

        sum1 -= top;
        sum2 += top;

        // q2의 앞단 원소를 q1에 넘겨주기 (누적합도 갱신)
    } else if (sum1 < sum2) {
        int top = q2.poll();

        q1.offer(top);

        sum2 -= top;
        sum1 += top;
    }
}
```

- Queue를 이용해 앞 원소를 다른 큐로 이동
- 누적합만 갱신하여 매번 합을 다시 계산하지 않음
- 큰 합에서 작은 합으로만 이동하여 탐색
- 최대 이동 횟수를 제한하여 무한 반복 방지

</details>

### 후기

- 누적합을 함께 갱신
- 단순 Queue 선언은 `LinkedList<>()`
- 최대 이동 횟수를 제한해 만들 수 없는 경우 처리