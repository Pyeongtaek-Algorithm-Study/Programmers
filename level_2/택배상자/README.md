### 문제 이름 : 택배상자

- **문제 사이트** : https://school.programmers.co.kr/learn/courses/30/lessons/131704
- **Level** : 2
- **알고리즘 유형** : Stack

---

### 풀이

1. 1번 상자부터 순서대로 보조 컨테이너 벨트에 넣는다.
2. 현재 상자가 원하는 순서와 같으면 꺼낸다.
3. 꺼낼 수 있는 동안 계속 꺼낸다.
4. 더 이상 꺼낼 수 없으면 다음 상자를 넣는다.
5. 최종적으로 꺼낸 상자 개수를 반환한다.

---

### 핵심 코드

<details>
<summary>핵심 코드 보기</summary>

```java
Deque<Integer> stack = new ArrayDeque<>();

for (int box = 1; box <= order.length; box++) {

    stack.push(box);

    // 원하는 순서와 같으면 계속 출고
    while (!stack.isEmpty() && stack.peek() == order[deliveredCount]) {
        stack.pop();
        deliveredCount++;
    }
}
```

- 보조 컨테이너 벨트를 스택으로 관리
- 상자를 순서대로 스택에 적재
- 스택 최상단과 원하는 순서 비교
- 연속 출고 가능한 동안 반복 처리

</details>