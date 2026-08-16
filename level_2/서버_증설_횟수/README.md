### 문제 이름 : 서버 증설 횟수

* **문제 사이트** : https://school.programmers.co.kr/learn/courses/30/lessons/389479
* **Level** : 2
* **알고리즘 유형** : Greedy
* **시간복잡도** : O(N)
* **참고 링크** :

---

### 풀이

1. 시간대별로 필요한 증설 서버 수를 `players[tx] / m`으로 계산.
2. `servers[tx]`에서 현재 운영 중인 증설 서버 수를 확인.
3. 필요한 서버가 더 많으면 부족한 만큼 서버를 증설.
4. 증설한 서버를 현재 시간부터 `k`시간 동안 `servers`에 반영.
5. 모든 시간대를 순회하며 증설 횟수를 누적.

---

### 핵심 코드

<details>
<summary>핵심 코드 보기</summary>

```java
// 현재 이용자 수를 기준으로 필요한 증설 서버 수 계산
int maintain = players[tx] / m;

// 필요한 서버 수에서 현재 운영 중인 서버 수를 제외한 부족한 서버 수
int needs = maintain - servers[tx];

if (needs > 0) {
    
    // answer에 서버 증설 개수 추가
    answer += needs;
    
    // 증설 서버는 현재 시간부터 k시간 동안 운영
    for (int p = tx; p < tx + k && p < MAX_TIME; p++) {
        servers[p] += needs;
    }
}
```

* 문제 접근 방식 : 시간대별 배열로 운영 중인 서버 수 관리
* 핵심 아이디어 : 현재 필요한 서버 수와 운영 중인 서버 수의 차이만큼 증설
* 증설한 서버 : 현재 시간부터 `k`시간 동안 운영

</details>

### 후기

- 각 시간대 별로 운영 서버 수를 저장하여 증설 필요한지 파악
