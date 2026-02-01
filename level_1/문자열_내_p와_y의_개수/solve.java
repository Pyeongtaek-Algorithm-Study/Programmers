// level_1 : 문자열_내_p와_y의_개수

class Solution {
    boolean solution(String s) {
        long pCnt = s.toLowerCase().chars().filter(ch -> ch == 'p').count();
        long yCnt = s.toLowerCase().chars().filter(ch -> ch == 'y').count();

        return pCnt == yCnt;
    }
}
