import java.util.*;

class Solution {

    private String[] user_id;

    private String[] banned_id;

    private boolean[] visited;

    private Map<String, Boolean> m = new HashMap<>();

    public int solution(String[] user_id, String[] banned_id) {

        // 전역 변수 초기 값 설정
        {
            this.user_id = user_id;
            this.banned_id = banned_id;
            this.visited = new boolean[user_id.length];
            this.m = new HashMap<>();
        }

        dfs(0);

        return answer;
    }

    private void dfs(int idx) {

    }
}