import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        
        int answer = 0;

        // 오름차순 정렬
        Arrays.sort(A);
        Arrays.sort(B);

        int aPoint = 0;
        int bPoint = 0;

        // bPoint가 B 배열의 길이 초과 전까지 반복
        // aPoint가 초과하는 경우는 없지만, 방어적 코딩
        while (bPoint < B.length && aPoint < A.length) {

            // aPoint의 숫자 값보다 bPoint 숫자 값이 클 때가 승리 (비교 후 bPoint 위치 이동)
            if (A[aPoint] < B[bPoint]) {

                // 현재 aPoint 위치 숫자 값을 이기는 경우를 확인했으므로, 다음 위치 숫자로 이동
                aPoint++;
                answer++;
            }

            bPoint++;
        }

        return answer;
    }
}