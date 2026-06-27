### 문제 이름 : 영어 끝말잇기

- **문제 사이트** : https://school.programmers.co.kr/learn/courses/30/lessons/12981
- **Level** : 2
- **알고리즘 유형** : String, HashSet
---

### 풀이

1. 첫 단어를 HashSet에 저장
2. 두 번째 단어부터 순회
3. 이전 단어의 마지막 문자와 현재 단어의 첫 문자 비교
4. HashSet에 현재 단어 추가
5. 추가 실패 시 중복 단어 판단
6. 끝말잇기 규칙 위반 또는 중복 단어 발견 시 종료
7. 사람 번호와 차례 번호 반환
8. 끝까지 통과하면 `[0, 0]` 반환

---

### 핵심 코드

<details>
<summary>핵심 코드 보기</summary>

```java
boolean invalidWord = preWord.charAt(preWord.length() - 1)
    != curWord.charAt(0);

// 끝말잇기 실패 또는 중복 단어
if (invalidWord || !usedWords.add(curWord)) {
    return new int[] {(i % n) + 1, (i / n) + 1};
}

* HashSet으로 중복 단어 검사
* 이전 단어 마지막 문자와 현재 단어 첫 문자 비교
* HashSet.add() 반환값 활용
* 실패 즉시 사람 번호와 차례 번호 반환

</details>
