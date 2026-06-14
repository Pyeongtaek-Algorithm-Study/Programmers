class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        
//      투 포인터 선언
        int st = 0;
        int end = 0;
        
        int sum = 0;
        int size = sequence.length;
        
        for(end = 0; end < sequence.length; end++) {
            sum += sequence[end];
            
            while(end < sequence.length && sum > k) {
                sum -= sequence[st];
                st++;
            }
            
            if(sum == k && size > end - st) {
                size = end - st;
                answer[0] = st;
                answer[1] = end;
            }
        }

        return answer;
    }
}