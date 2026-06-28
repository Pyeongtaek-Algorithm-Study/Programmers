import java.util.*;

class Solution {

    public int solution(int[] order) {

        int deliveredCount = 0;
        
        // Stack 클래스 보다 권장
        Deque<Integer> stack = new ArrayDeque<>();

        for (int box = 1; box <= order.length; box++) {

            stack.push(box);

            // 원하는 순서와 같으면 계속 출고
            while (!stack.isEmpty() && stack.peek() == order[deliveredCount]) {
                stack.pop();
                deliveredCount++;
            }
        }

        return deliveredCount;
    }
}