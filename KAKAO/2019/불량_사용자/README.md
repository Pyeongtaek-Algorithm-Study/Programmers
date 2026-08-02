# README.md

### 문제 이름 : 불량 사용자

- **문제 사이트** : https://school.programmers.co.kr/learn/courses/30/lessons/64064
- **Level** : 3
- **알고리즘 유형** : Backtracking, DFS, HashSet
- **시간복잡도** : O(n!)
- **참고 링크** :

---

### 풀이

1. DFS로 불량 사용자 수만큼 사용자 조합 생성
2. HashSet으로 동일한 사용자 중복 선택 방지
3. 선택된 사용자 목록을 불량 아이디 순서와 비교
4. 길이가 다르면 즉시 제외
5. `*`는 모든 문자와 일치하도록 처리
6. 모든 패턴이 일치하면 경우의 수 저장
7. HashSet<HashSet<String>>으로 동일 조합 중복 제거

---

### 핵심 코드

<details>
<summary>핵심 코드 보기</summary>

```java
private void dfs(HashSet<String> hs) {
    
    if (hs.size() == banned_id.length) {
        
        if (isBanList(hs)) {
            answer.add(new HashSet<>(hs));
        }

        return;
    }

    for (String userId : user_id) {

        if (hs.add(userId)) {
            
            dfs(hs);

            hs.remove(userId);
        }
    }
}
```

- 백트래킹으로 가능한 사용자 조합 생성
- HashSet으로 동일 사용자 선택 방지
- 완성된 조합만 불량 아이디 패턴과 비교
- HashSet<HashSet<String>>으로 중복 조합 제거

</details>

### 후기

- 사용자 조합 생성과 패턴 검사를 분리
- HashSet을 이용해 동일 조합 제거
- 순열 생성 후 검증하는 방식으로 구현