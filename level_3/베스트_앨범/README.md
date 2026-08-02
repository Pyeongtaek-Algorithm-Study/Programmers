### 문제 이름 : 베스트앨범

- **문제 사이트** : https://school.programmers.co.kr/learn/courses/30/lessons/42579
- **Level** : 3
- **알고리즘 유형** : Hash, Priority Queue, Sorting
- **시간복잡도** : O(N log N)
- **참고 링크** : https://velog.io/@ewoo97/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%ED%95%B4%EC%8B%9C-%EB%B2%A0%EC%8A%A4%ED%8A%B8-%EC%95%A8%EB%B2%94-Java

---

### 풀이

1. 장르별 총 재생 횟수를 HashMap에 누적
2. 장르별 PriorityQueue를 생성하여 노래를 저장
3. PriorityQueue는 재생 횟수 내림차순, 같으면 고유번호 오름차순으로 정렬
4. 장르를 총 재생 횟수 내림차순으로 정렬
5. 각 장르에서 최대 2곡씩 꺼내 정답에 저장

---

### 핵심 코드

<details>
<summary>핵심 코드 보기</summary>

```java
// 장르가 처음 등장하면 해당 장르의 우선순위 큐 생성
if (!genreSongs.containsKey(genre)) {
    genreSongs.put(genre, new PriorityQueue<>((a, b) -> {

        // 재생 횟수가 같으면 고유번호가 작은 노래를 우선
        if (a[1] == b[1]) {
            return a[0] - b[0];
        }

        // 재생 횟수가 많은 노래를 우선
        return b[1] - a[1];
    }));
}

// 장르별 노래 저장
genreSongs.get(genre).add(new int[]{i, play});

// 장르를 총 재생 횟수 내림차순으로 정렬
List<String> sortedGenres = new ArrayList<>(genreTotal.keySet());
sortedGenres.sort((g1, g2) -> genreTotal.get(g2) - genreTotal.get(g1));

// 장르별 최대 2곡 선택
for (String genre : sortedGenres) {
    PriorityQueue<int[]> songs = genreSongs.get(genre);
    answerList.add(songs.poll()[0]);

    if (!songs.isEmpty()) {
        answerList.add(songs.poll()[0]);
    }
}
```

- HashMap으로 장르별 총 재생 횟수 관리
- PriorityQueue로 장르별 노래 우선순위 관리
- Comparator를 이용해 재생 횟수와 고유번호 기준 정렬
- 총 재생 횟수 순으로 장르를 탐색하며 최대 2곡 선택

</details>

### 후기

- 