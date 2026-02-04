import java.util.Arrays;
import java.util.Collections;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);
        
        // B = Arrays.stream(B)
        //             .boxed()
        //             .sorted(Collections.reverseOrder())
        //             .mapToInt(Integer::intValue)
        //             .toArray();
        
        // System.out.println(Arrays.toString(A));
        // System.out.println(Arrays.toString(B));
        
        int arrLen = A.length;
        for (int i = 0; i < arrLen; i++) {
            answer += (A[i] * B[arrLen - i - 1]);
        }

        return answer;
    }
}
