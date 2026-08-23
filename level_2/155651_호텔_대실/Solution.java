class Solution {
    
    private static final int MINUTES_DAY = 24 * 60;
    private static final int CLEANING = 10;
    
    public int solution(String[][] book_time) {
        int answer = 0;
        int[] booking = new int[MINUTES_DAY + CLEANING];
        
        for (String[] book : book_time) {
            int from = toMinutes(book[0]);
            int end = toMinutes(book[1]) + CLEANING;
            
            for (int time = from; time < end; time++) {
                // 예약 시간 동안 사용 중인 객실 수를 누적
                booking[time]++;
                answer = Math.max(answer, booking[time]);
            }
        }
        
        return answer;
    }
    
    private int toMinutes(String time) {
        String[] parts = time.split(":");
        
        return Integer.parseInt(parts[0]) * 60
                + Integer.parseInt(parts[1]);
    }
}