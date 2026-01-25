import java.util.*;

class Solution {
    static void pl(Object p) {
        System.out.println(p);
    }
    
    public int[] solution(long n) {
        int[] answer = {};
        
        // pl(new StringBuilder(String.valueOf(n)));
        // pl(new StringBuilder(String.valueOf(n)).reverse());
        // pl(new StringBuilder(String.valueOf(n)).reverse().toString());
        // pl(new StringBuilder(String.valueOf(n)).reverse().toString().chars());
        // pl(new StringBuilder(String.valueOf(n)).reverse().toString().chars().map(c -> c - '0'));
        // pl(new StringBuilder(String.valueOf(n)).reverse().toString().chars().map(c -> c - '0').toArray());
        
        answer = new StringBuilder(String.valueOf(n)).reverse().toString().chars().map(c -> c - '0').toArray();
        return answer;
    }
}
