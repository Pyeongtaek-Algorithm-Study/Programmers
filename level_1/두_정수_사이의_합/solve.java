class Pair {
    int x;
    int y;
    
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public void swap() {
        x = x ^ y;
        y = x ^ y;
        x = x ^ y;
    }
}

class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        Pair pair = new Pair(a, b);
        if (b < a) {
            pair.swap();
        }
        
        long sum = 0;
        for (int i = pair.x; i <= pair.y; i++) {
            sum += i;
        }
        
        answer = sum;
        return answer;
    }
}
