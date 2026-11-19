### 문제 이름 : k진수에서 소수 개수 구하기

- **문제 사이트** : https://school.programmers.co.kr/learn/courses/30/lessons/92335
- **Level** : 2
- **알고리즘 유형** : 진법 변환, 문자열, 소수 판별
- **시간복잡도** : O(N)

---

### 풀이

1. n을 k진수 문자열로 변환 (`Integer.toString(n, k)` 또는 직접 변환 후 `reverse`)
2. `split("0")`으로 0을 기준으로 나누어 P0, 0P, 0P0, P 조건을 한 번에 처리
3. 연속된 0 때문에 생긴 빈 문자열은 건너뜀
4. 각 조각을 **10진수로 그대로 읽어** `long`으로 변환
5. √num까지 나누어 소수인지 판별하고 개수 세기

---

### 핵심 코드

<details>
<summary>핵심 코드 보기</summary>

```java
// 나머지를 구하고 역순으로 반환하여 k진수 구하기
private String toBase(int n, int k) {
    StringBuilder sb = new StringBuilder();
    
    while (n > 0) {
        
        // 낮은 자리부터 쌓기
        sb.append(n % k);
        n /= k;
    }
    
    // 뒤집기
    return sb.reverse()
        .toString();
}
```

- 나머지 구하고 뒤집기 -> k진수 구하는 공식

</details>

### 후기

- 나머지를 append하면 낮은 자리부터 쌓이므로 `reverse()` 필요