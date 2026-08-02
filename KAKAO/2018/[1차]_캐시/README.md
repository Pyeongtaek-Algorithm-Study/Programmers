### 문제 이름 : [1차] 캐시

- **문제 사이트** : https://school.programmers.co.kr/learn/courses/30/lessons/17680
- **Level** : 2
- **알고리즘 유형** : Queue, Implementation
- **시간복잡도** : O(N)
- **참고 링크** :

---

### 풀이

1. 캐시 크기가 0이면 모든 요청을 Cache Miss로 처리
2. 도시 이름을 대문자로 변환해 대소문자 차이 제거
3. Deque를 LRU 캐시로 사용
4. Cache Hit이면 기존 위치에서 제거 후 맨 앞에 삽입
5. Cache Miss이면 실행 시간 5를 추가
6. 캐시가 가득 찼으면 가장 오래 사용한 도시 제거
7. 새로운 도시를 맨 앞에 삽입
8. Hit은 1, Miss는 5를 누적

---

### 핵심 코드

<details>
<summary>핵심 코드 보기</summary>

```java
Deque<String> dq = new ArrayDeque<>(cacheSize);

for (String city : cities) {

    // 대소문자 구분 X
    city = city.toUpperCase();

    if (dq.contains(city)) {

        answer++;

        // 재갱신
        dq.remove(city);
        dq.offerFirst(city);
    } else {
        answer += 5;

        // 캐시 크기가 가득 찼을 때, 마지막 도시 빼기
        if (dq.size() == cacheSize) {
            dq.removeLast();

        }

        dq.offerFirst(city);
    }
}
```

- Queue(Deque)를 이용한 LRU 캐시 구현
- Cache Hit 시 최근 사용한 도시를 맨 앞으로 이동
- Cache Miss 시 가장 오래 사용한 도시 제거 후 삽입
- 도시 이름을 대문자로 변환해 대소문자 구분 제거

</details>

### 후기

- Deque는 ArrayDeque나 LikedList로 사용
- 예제를 잘 살펴보기 (cache가 0인 경우도 존재, 대소문자 구분 X)