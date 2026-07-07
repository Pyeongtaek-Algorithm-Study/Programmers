### 문제 이름 : 카펫

- **문제 사이트** : https://school.programmers.co.kr/learn/courses/30/lessons/42842
- **Level** : 2
- **알고리즘 유형** : Brute Force
- **시간복잡도** : O(n)
- **참고 링크** :

---

### 풀이

1. 노란색 영역의 가로 길이를 1부터 `yellow`까지 탐색
2. `yellow`가 현재 가로 길이로 나누어질 때만 세로 길이 계산
3. 갈색 테두리 개수를 `(w + h) * 2 + 4`로 계산
4. 입력된 `brown`과 같으면 정답 확인
5. 가로가 세로 이상인 경우만 반환
6. 최종 카펫 크기는 테두리를 포함해 `(w + 2, h + 2)` 반환

---

### 핵심 코드

<details>
<summary>핵심 코드 보기</summary>

```java
for (int w = 1; w <= yellow; w++) {
            
    // 노란색 크기가 가로 길이만큼 나눠질 때
    if (yellow % w == 0) {
        
        int h = yellow / w;
        
        // 카펫의 가로 길이는 세로 길이보다 같거나 크다.
        boolean isSameBrown = ((w + h) * 2 + 4 == brown);
        
        if (w >= h && isSameBrown) {
            return new int[]{w + 2, h + 2};
        }
    }
}
```

- 완전 탐색으로 노란색 영역의 모든 약수 탐색
- 약수 쌍으로 가로 * 세로 길이 계산
- 갈색 테두리 개수 공식으로 정답 검증
- 가로 >= 세로 조건만 만족하는 경우 반환

</details>