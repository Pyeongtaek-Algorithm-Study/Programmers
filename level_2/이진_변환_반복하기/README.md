### Level 2 :이진 변환 반복하기

- **문제 사이트** : [이진 변환 반복하기](https://school.programmers.co.kr/learn/courses/30/lessons/70129)
- **알고리즘 유형** : *문자열*

---

### 풀이

1. 문자열이 `"1"`이 될 때까지 반복한다.
2. 현재 문자열 길이를 저장한다.
3. `replace()`로 모든 `0`을 제거한다.
4. 원본 길이와 제거 후 길이 차이만큼 `0` 개수를 누적한다.
5. 남은 `1`의 개수를 2진수 문자열로 변환한다.
6. 반복할 때마다 이진 변환 횟수를 증가시킨다.

---

### 핵심 코드

<details>
<summary>핵심 코드 보기</summary>

```java
while (!"1".equals(s)) {
    answer[0]++; // 이진 변환 횟수 증가

    int originalLen = s.length();

    // 모든 0 제거
    s = s.replace("0", "");

    // 제거한 0 개수 누적
    answer[1] += originalLen - s.length();

    // 남은 1의 개수를 2진수 문자열로 변환
    s = Integer.toBinaryString(s.length());
}
```

* 문자열 처리 문제로 접근한다.
* `replace()`를 이용해 `0`을 제거한다.
* 길이 차이로 제거한 `0` 개수를 계산한다.
* 남은 `1`의 개수를 2진수 문자열로 변환하며 반복한다.

</details>