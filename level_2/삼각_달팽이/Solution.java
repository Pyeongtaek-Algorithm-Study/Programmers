import java.util.*;

class Solution {

    private static int[] dx = { 1, 0, -1 };
    private static int[] dy = { 0, 1, -1 };

    public int[] solution(int n) {

        // 내 풀이 방식
        return solve1(n);
        // 정답 방식
        // return solve2(n);

    }

    private int[] solve2(int n) {

        int[] answer = new int[(n * (n + 1)) / 2];
        int[][] matrix = new int[n][n];

        // 좌표 시작 위치
        int x = -1, y = 0;
        int num = 1;

        // i가 방향 같은 개념
        for (int i = 0; i < n; ++i) {
            // j는 해당 방향으로 몇 칸 할지 계산
            for (int j = i; j < n; ++j) {
                if (i % 3 == 0) {
                    ++x;
                } else if (i % 3 == 1) {
                    ++y;
                } else if (i % 3 == 2) {
                    --x;
                    --y;
                }
                matrix[x][y] = num++;
            }
        }

        int k = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == 0)
                    break;
                answer[k++] = matrix[i][j];
            }
        }

        return answer;
    }

    // 내 풀이 방식 : 2차원 배열 값 채우기
    private int[] solve1(int n) {
        int total = n * (n + 1) / 2;

        int[][] arr2 = new int[n + 1][n + 1];

        // 채워야할 숫자 개수

        int start = 1;

        int nx = 1;
        int ny = 1;

        int dir = 0;

        while (start <= total) {

            // 현재 위치 숫자 채우기
            arr2[nx][ny] = start++;

            // 다음 위치 계산
            int tx = nx + dx[dir];
            int ty = ny + dy[dir];

            // 다음 위치가 배열 내에 존재하는지 파악
            boolean isInArr = tx < 1 || tx > n || ty < 1 || ty > n;

            // 숫자를 채울 수 없는 칸일 경우 방향 바꾸기
            if (isInArr || arr2[tx][ty] != 0) {
                dir = (dir + 1) % 3;
            }

            nx += dx[dir];
            ny += dy[dir];
        }

        ArrayList<Integer> answer = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {

                if (arr2[i][j] == 0) {
                    break;
                }

                answer.add(arr2[i][j]);

            }
        }

        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}