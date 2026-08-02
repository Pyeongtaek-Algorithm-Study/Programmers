### 문제 이름 : [1차] 비밀지도

- **문제 사이트** : https://school.programmers.co.kr/learn/courses/30/lessons/17681
- **Level** : 1
- **알고리즘 유형** : Bit Manipulation
- **시간복잡도** : O(N²)
- **참고 링크** :

---

### 풀이

1. 같은 행의 두 숫자를 비트 OR 연산으로 합침
2. OR 결과를 이진수 문자열로 변환
3. 문자열 길이가 `n`보다 짧으면 앞을 `0`으로 채움
4. `1`을 `#`, `0`을 공백으로 변환
5. 변환한 문자열을 정답 배열에 저장

---

### 핵심 코드

<details>
<summary>핵심 코드 보기</summary>

```java
// 비트 합산의 숫자를 이진수 문자열로 변환
String binary = Integer.toBinaryString(arr1[i] | arr2[i]);

// 패딩 채우기
binary = String.format("%" + n + "s", binary)
    .replace(' ', '0');

// 1 -> # / 0 -> 0
binary = binary.replace('1', '#')
        .replace('0', ' ');
```

- 비트 OR 연산으로 두 지도 병합
- 이진수 문자열을 `n`자리로 맞춤
- 문자 치환으로 지도 형태 생성

</details>

### 후기

- 비트 연산으로 한 번에 지도 합치기
- `String.format()`으로 패딩 처리가 가능 (특히, n에 따라 패딩 맞추는 로직 신기)