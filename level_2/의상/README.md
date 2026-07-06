### 문제 이름 : 의상

- **문제 사이트** : https://school.programmers.co.kr/learn/courses/30/lessons/42578
- **Level** : 2
- **알고리즘 유형** : Hash
- **시간복잡도** : O(N)
- **참고 링크** : https://carrot0911.tistory.com/238

---

### 풀이

1. 의상 종류별 개수를 HashMap에 저장
2. 같은 종류는 하나만 착용 가능
3. 각 종류마다 "입는 경우 + 안 입는 경우"를 계산
4. 모든 종류의 경우의 수를 곱셈으로 계산
5. 아무것도 입지 않은 경우 1개 제외

---

### 핵심 코드

<details>
<summary>핵심 코드 보기</summary>

```java
for (String[] cloth : clothes) {
    clothesMap.put(cloth[1], clothesMap.getOrDefault(cloth[1], 0) + 1);
}

for (String key : clothesMap.keySet()) {
    
    // +1 : 입지 않았을 때 (종류별로 최대 1가지라는 뜻은 해당 종류에서 안 입을 수도 있다는 뜻)
    answer *= (clothesMap.get(key) + 1);
}

// 아무것도 입지 않은 경우를 제외
answer--;
```

- HashMap으로 의상 종류별 개수 관리
- 각 종류마다 `(개수 + 1)`로 입지 않는 경우 포함
- 모든 종류의 경우의 수를 곱셈으로 계산
- 마지막에 아무것도 입지 않은 경우 제외

</details>