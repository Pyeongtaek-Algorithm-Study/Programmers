// Level_2 : 방문길이

import java.util.Set;
import java.util.HashSet;

class Solution {
    public int solution(String dirs) {

        // 중복 경로 제거
        Set<String> visited = new HashSet<>();
        
        // 시작 위치
        int currentX = 0;
        int currentY = 0;
        
        for (int i = 0; i < dirs.length(); i++) {
            
            int nxtX = currentX;
            int nxtY = currentY;
            String path = "";
            
            // 동일 구간에서 위 -> 아래, 아래 -> 위나 같은 경우
            // 00>01, 01>00 같은 경로임으로 01>00을 문자열로 00>01로 저장(즉, 같은 경로임을 표시)
            switch (dirs.charAt(i)) {
                case 'U':
                    nxtY++;
                    path = currentX + "" + currentY + ">" + nxtX + nxtY;
                    break;
                case 'D':
                    nxtY--;
                    path = nxtX + "" + nxtY + ">" +currentX + currentY;
                    break;
                case 'R':
                    nxtX++;
                    path = currentX + "" + currentY + ">" + nxtX + nxtY;
                    break;
                case 'L':
                    nxtX--;
                    path = nxtX + "" + nxtY + ">" + currentX + currentY;
                    break;
                default:
                    break;
            }
            
            // 다음 칸의 이동이 칸을 넘어설 경우 건너뛰기
            if (nxtX < -5 || nxtX > 5 || nxtY < -5 || nxtY > 5) {
                continue;
            }
            
            visited.add(path);
            
            currentX = nxtX;
            currentY = nxtY;
        }
        
        // System.out.println(visited.toString());
        
        // visited에는 캐릭터가 간 경로중에 중복 제거된 경로들만 존재
        return visited.size();
    }
}
