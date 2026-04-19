import java.util.*;

/**
 * level 2 : 뒤에 있는 큰 수 찾기
 * 문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/154539
 */
class Solution {
    
    public int[] solution(int[] numbers) {

        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < numbers.length; i++) {
            int current = numbers[i];

            while (!stack.isEmpty() && numbers[stack.peek()] < current) {
                answer[stack.pop()] = current;
            }

            stack.push(i);
        }

        return answer;
    }
}
