// level 2 : 무인도 여행
// 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/154540
// 카테고리 : BFS, DFS

import java.util.*;

class Solution {
    
    private int height, width;
    private boolean[][] visited;
    private int[] dx = {0, -1, 0, 1};
    private int[] dy = {-1, 0, 1, 0};
    
    public int[] solution(String[] maps) {
        
        List<Integer> ans = new ArrayList<>();
        
        // 전역 값 설정
        height = maps.length;
        width = maps[0].length();
        visited = new boolean[height][width];
        
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (visited[i][j] == true || maps[i].charAt(j) == 'X') {
                    continue;
                }
                
                ans.add(bfs(i, j, maps));
            }
        }
        
        if (ans.isEmpty()) {
            return new int[]{-1};
        }
        
        // 오름차순 정렬
        Collections.sort(ans);
        
        return ans.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
    
    private int bfs(int x, int y, String[] maps) {
        
        Queue<int[]> q = new LinkedList<>();
        
        q.offer(new int[]{x, y});
        visited[x][y] = true;
        
        int sum = 0;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            sum += maps[cur[0]].charAt(cur[1]) - '0';
            
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];
                
                // maps 범위 내에 탐색
                if (nx < 0 || nx >= height || ny < 0 || ny >= width) continue;
                // 방문했던 칸이나 바다인 경우 제외
                if (visited[nx][ny] || maps[nx].charAt(ny) == 'X') continue;
                
                q.offer(new int[]{nx, ny});
                visited[nx][ny] = true;
            }
        }
        
        return sum;
    }
}
