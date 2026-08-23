### 문제 이름 : 스킬트리

- **문제 사이트** : https://school.programmers.co.kr/learn/courses/30/lessons/49993
- **Level** : 2
- **알고리즘 유형** : String
- **시간복잡도** : O(N^2)
- **참고 링크** : 

---

### 풀이

1. 각 스킬트리에서 `skill`에 포함된 스킬만 확인
2. 현재 필요한 스킬의 인덱스를 `matchIdx`로 관리
3. 현재 스킬이 `matchIdx`와 같으면 다음 스킬로 이동
4. 이미 배운 스킬이면 무시
5. 아직 배우지 않은 선행 스킬이면 해당 스킬트리 제외
6. 모든 스킬을 확인한 경우 가능한 스킬트리로 판단

---

### 핵심 코드

<details>
<summary>핵심 코드 보기</summary>

```java
int matchIdx = 0;

for (char ch : tree.toCharArray()) {
        
    // 현재 스킬트리 순서와 맞을 경우
    if (skill.indexOf(ch) == matchIdx) {
        matchIdx++;
    // 이전 스킬트리로 이미 배운 경우
    } else if (skill.indexOf(ch) < matchIdx) {
        continue;
    // 순서 스킬트리를 따르지 못할 경우
    } else {
        return false;
    }    
}
```

- skill.indexOf(ch)를 이용해 선행 스킬의 위치를 비교하는 방식

</detail>