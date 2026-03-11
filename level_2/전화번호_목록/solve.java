// level_2 : 전화번호_목록

import java.io.*;
import java.util.Arrays;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        // phone_book 오름차순 정렬
        Arrays.sort(phone_book);
        
        for (int i = 0; i < phone_book.length - 1; i++) {
            
            // 다음 phone_book의 값에 현재 phone_book의 값이 접두어로 포함될 때
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                return false;
            }
        }

        // 모든 경우를 확인 후, 다른 번호가 접두어인 경우가 없을 때
        return true;
    }
}
