class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for (int i = 0; i < n; i++) {
            
            // 비트 합산의 숫자를 이진수 문자열로 변환
            String binary = Integer.toBinaryString(arr1[i] | arr2[i]);
            
            // 패딩 채우기
            binary = String.format("%" + n + "s", binary)
                .replace(' ', '0');
            
            // 1 -> # / 0 -> 0
            binary = binary.replace('1', '#')
                    .replace('0', ' ');
            
            answer[i] = binary;
        }
        
        return answer;
    }
}