### 문제 이름 : 달리기 경주

- **문제 사이트** : https://school.programmers.co.kr/learn/courses/30/lessons/178871
- **Level** : 1
- **알고리즘 유형** : HashMap
- **참고 사이트** : https://blog.naver.com/eric5519/223969413473

---

### 풀이

1. 선수 이름과 현재 등수를 HashMap에 저장
2. 호출된 선수의 현재 위치 조회
3. 바로 앞 선수와 위치 교환
4. players 배열의 순서 갱신
5. HashMap의 등수 정보도 함께 갱신
6. 모든 호출 처리 후 players 반환

---

### 핵심 코드

<details>
<summary>핵심 코드 보기</summary>

````java
int idx = playersMap.get(name);

String frontPlayer = players[idx - 1];
players[idx - 1] = name;
players[idx] = frontPlayer;

playersMap.put(name, idx - 1);
playersMap.put(frontPlayer, idx);
````

* HashMap으로 선수 이름 → 현재 등수 관리
* 호출 시 O(1)로 현재 위치 조회
* 배열에서 앞 선수와 위치 교환
* 배열과 HashMap을 동시에 갱신

</details>
