class Solution {
    public int[] solution(int brown, int yellow) {
        
        // 완전 탐색
        for (int w = 1; w <= yellow; w++) {
            
            // 노란색 크기가 가로 길이만큼 나눠질 때
            if (yellow % w == 0) {
                
                int h = yellow / w;
                
                // 카펫의 가로 길이는 세로 길이보다 같거나 크다.
                boolean isSameBrown = ((w + h) * 2 + 4 == brown);
                
                if (w >= h && isSameBrown) {
                    return new int[]{w + 2, h + 2};
                }
            }
        }
        
        // 없는 경우가 없음
        return new int[]{};
    }
}