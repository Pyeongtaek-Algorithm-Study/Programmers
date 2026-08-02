import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {

        // 각 장르 별 총 재생 횟수
        Map<String, Integer> genreTotal = new HashMap<>();

        // 각 장르별 노래의 재생 횟수 별 내림차순
        Map<String, PriorityQueue<int[]>> genreSongs = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {

            String genre = genres[i];
            int play = plays[i];

            // genre의 재생 수 누적
            genreTotal.put(genre, genreTotal.getOrDefault(genre, 0) + play);

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

            // genreSongs 각 장르별로 PriorityQueue를 생성 -> 각 노래의 인덱스와 재생 횟수 배열 저
            //PrirorityQueue로 재생 횟수가 높은 노래부터 우선순위
            genreSongs.get(genre).add(new int[]{i, play});
        }

        // Key 값을 리스트로 추출 -> 각 장르의 총 재생 횟수로 정렬
        List<String> sortedGenres = new ArrayList<>(genreTotal.keySet());
        sortedGenres.sort((g1, g2) -> genreTotal.get(g2) - genreTotal.get(g1));

        List<Integer> answerList = new ArrayList<>();

        for (String genre : sortedGenres) {
            PriorityQueue<int[]> songs = genreSongs.get(genre);
            answerList.add(songs.poll()[0]);

            // 두 개의 노래 추출
            if (!songs.isEmpty()) {
                answerList.add(songs.poll()[0]);
            }
        }

        int[] answer = new int[answerList.size()];

        // 추출된 노래 정답 배열에 저장
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}