### 문제 이름 : 호텔 대실

- **문제 사이트** : https://school.programmers.co.kr/learn/courses/30/lessons/155651
- **Level** : 2
- **알고리즘 유형** : DP
- **시간복잡도** : O(N × T) (T = 1450, 사실상 O(N))
- **참고 링크** : 

---

### 풀이

1. 시간을 `분` 단위 정수로 변환.
2. 퇴실 시간에 청소 시간 10분 추가.
3. 예약된 시간 범위만큼 `booking` 배열에 이용 인원 누적.
4. 각 시간대의 최대 이용 인원을 `answer`에 저장.

---

### 핵심 코드

<details>
<summary>핵심 코드 보기</summary>

```java
int from = toMinutes(book[0]);
int end = toMinutes(book[1]) + CLEANING_TIME;

for (int time = from; time < end; time++) {
    // 예약 시간 동안 사용 중인 객실 수를 누적
    booking[time]++;
    answer = Math.max(answer, booking[time]);
}
```

* 문제 접근 방식 : 시간 배열을 이용한 구간 누적
* 핵심 아이디어 : 예약 구간마다 이용 인원을 증가시켜 최대값 계산
* 주의 사항 : 퇴실 후 청소 시간 10분까지 예약 구간에 포함
* 시간 복잡도 : O(N × T), T가 최대 1450으로 고정되어 사실상 O(N)

</details>