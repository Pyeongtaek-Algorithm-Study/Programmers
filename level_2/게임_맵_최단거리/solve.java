// level 2 - 게임_맵_최단거리

import java.util.Queue;
import java.util.LinkedList;

class Solution {
    
    private static final int[] dx = {0, -1, 0, 1};
    private static final int[] dy = {-1, 0, 1, 0};
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        return bfs(n, m, maps);
    }
    
    public int bfs(int n, int m, int[][] maps) {
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1});
        visited[0][0] = true;
        int cnt = -1;
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            cnt = cur[2];
            
            if (x == n - 1 && y == m - 1) break;
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (maps[nx][ny] == 0 || visited[nx][ny]) continue;
                
                visited[nx][ny] = true;
                queue.add(new int[]{nx, ny, cnt + 1});
            }
        
        }
        
        // 마지막 칸에 도달하지 못할 경우 -1 반환
        return (visited[n - 1][m - 1]) ? cnt : -1;
    }
}
