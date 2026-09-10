import java.util.*;

class Solution {
    
    private static int[] dx = new int[]{0, -1, 0, 1};
    private static int[] dy = new int[]{-1, 0, 1, 0};
    
    public int solution(String[] board) {
        
        // board의 크기 파악
        int n = board.length;
        int m = board[0].length();
        
        int rx = 0;
        int ry = 0;
        
        // Red 칸의 위치 찾기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                
                if (board[i].charAt(j) == 'R') {
                    rx = i;
                    ry = j;
                }
            }
        }
        
        // 방문 기록용
        int visited[][] = new int[n][m];
        
        // 시작 위치 셋팅
        visited[rx][ry] = 1;
        
        
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offerLast(new int[]{rx, ry});
        
        while (!dq.isEmpty()) {
            
            int[] cur = dq.pollFirst();
            int x = cur[0];
            int y = cur[1];
            
            for (int dir = 0; dir < 4; dir++) {
                
                int nx = x;
                int ny = y;
                
                // 장애물이나 게임판 가장 자리까지 부딪히기 전까지 계속 이동
                while (nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx].charAt(ny) != 'D') {
                    nx += dx[dir];
                    ny += dy[dir];
                }
                
                // 부딪힌 자리는에 있을 수 없으므로, 바로 이전 칸으로 이동
                nx -= dx[dir];
                ny -= dy[dir];
                
                // 도착 지점일 경우 움직인 횟수 반환
                if (board[nx].charAt(ny) == 'G') {
                    return visited[x][y];
                }
                
                // 방문한 적이 없는 칸일 경우 횟수 증가 및 다음 출발 칸 추가
                if (visited[nx][ny] == 0) {
                    visited[nx][ny] = visited[x][y] + 1;
                    dq.offerLast(new int[]{nx, ny});
                }
            }
            
        }
        
        return -1;
    }
}
