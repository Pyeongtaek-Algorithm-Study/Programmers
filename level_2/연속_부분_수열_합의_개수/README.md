### 문제 이름 : 연속 부분 수열 합의 개수

- **문제 사이트** : https://school.programmers.co.kr/learn/courses/30/lessons/131701
- **Level** : 2
- **알고리즘 유형** : Brute Force, HashSet

---

### 풀이

1. 부분 수열의 길이를 1 ~ N까지 순회
2. 각 길이마다 시작 위치를 0 ~ N-1까지 순회
3. 원형 수열 처리를 위해 인덱스에 `% N` 적용
4. 연속 부분 수열의 합 계산
5. 중복 제거를 위해 HashSet에 저장
6. HashSet 크기 반환

---

### 핵심 코드

<details>
<summary>핵심 코드 보기</summary>

```java
for (int size = 1; size <= elLen; size++) {
    for (int st = 0; st < elLen; st++) {

        int sum = 0;

        // 원형 수열의 연속 부분 수열 합 계산
        for (int idx = st; idx < st + size; idx++) {
            sum += elements[idx % elLen];
        }

        set.add(sum);
    }
}
```

- 원형 수열 처리(`% N` 연산으로 처음 위치와 연결)
- 완전 탐색
- 길이와 시작 위치를 모두 탐색
- 연속 부분 수열 합 계산


</details>