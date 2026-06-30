### 문제 이름 : 연속된 부분 수열의 합

- **문제 사이트** : https://school.programmers.co.kr/learn/courses/30/lessons/178870
- **Level** : 2
- **알고리즘 유형** : Two Pointer

---

### 풀이

1. 시작 포인터(st), 끝 포인터(end) 사용
2. end를 이동하며 구간 합 누적
3. 구간 합이 k보다 크면 st를 이동하며 합 감소
4. 구간 합이 k와 같으면 구간 길이 확인
5. 기존 정답보다 짧은 구간이면 정답 갱신
6. 가장 짧은 연속 부분 수열의 시작, 종료 인덱스 반환

---

### 핵심 코드

<details>
<summary>핵심 코드 보기</summary>

```java
for(end = 0; end < sequence.length; end++) {
    sum += sequence[end];
    
    while(end < sequence.length && sum > k) {
        sum -= sequence[st];
        st++;
    }
    
    if(sum == k && size > end - st) {
        size = end - st;
        answer[0] = st;
        answer[1] = end;
    }
}
```
- 연속 구간 탐색에 Two Pointer 사용
- 구간 합을 유지하며 한 번만 순회
- 합이 초과되면 시작 포인터 이동
- 가장 짧은 구간 발견 시 정답 갱신

</details>