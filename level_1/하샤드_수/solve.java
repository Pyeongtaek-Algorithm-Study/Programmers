class Solution {
    private void pl(Object o) {
        System.out.println(o);
    }
    
    public boolean solution(int x) {
        boolean answer = true;
        
        answer = solveWay1(x);
        // answer = solveWay2(x);
        
        return answer;
    }
    
    private boolean solveWay1(int x) {
        int sum = String.valueOf(x).chars().map(ch -> ch - '0').sum();
        return x % sum == 0;
    }
    
    private boolean solveWay2(int x) {
        String[] splitX = Integer.toString(x).split("");
        int sum = 0;
        
        for (String ch : splitX) {
            sum += Integer.parseInt(ch);    
        }
        
        return x % sum == 0;
    }
}
