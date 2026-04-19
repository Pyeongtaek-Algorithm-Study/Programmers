/**
 * Level 2 : 쿼드 압축 후 개수 세기
 * https://school.programmers.co.kr/learn/courses/30/lessons/68936?language=java
 * 
 * 참고 블로그
 * @see https://velog.io/@qodlstjd12/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%BF%BC%EB%93%9C%EC%95%95%EC%B6%95-%ED%9B%84-%EA%B0%9C%EC%88%98-%EC%84%B8%EA%B8%B0-Java
 */
class Solution {
    
    // 출력할 정답 0, 1 개수
    private int[] answer;
    // 쿼드 배열 원본
    private int[][] quadArr;
    
    public int[] solution(int[][] arr) {
        
        // 초기값 설정
        quadArr = arr;
        answer = new int[2];
        
        quad(0, 0, arr[0].length);
        
        return answer;
    }
    
    private void quad(int x, int y, int size) {
        
        // 압축이 불가능한지 확인
        if (zip(x, y, size) == false) {
            
            int half = size / 2;
            
            // 4등분하여 재귀
            quad(x, y, half); // 1사분면
            quad(x, y + half, half); // 2사분면
            quad(x + half, y, half); // 3사분면
            quad(x + half, y + half, half); // 4사분면
        } else {
            
            // 압축 가능하다면 해당 값이 0인지 1인지에 따라 정답 배열에 개수 추가
            if (quadArr[x][y] == 0) {
                answer[0]++;
            } else {
                answer[1]++;
            }
        }
    }
    
    private boolean zip(int x, int y, int size) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                
                // 해당 구역의 시작점 값과 다른 값이 있다면 압축 불가능
                if (quadArr[i][j] != quadArr[x][y]) {
                    return false;
                }
            }
        }

        return true;
    }
}