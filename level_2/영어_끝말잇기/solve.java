import java.util.*;

class Solution {

    public int[] solution(int n, String[] words) {

        Set<String> usedWords = new HashSet<>();
        usedWords.add(words[0]);

        for (int i = 1; i < words.length; i++) {

            String preWord = words[i - 1];
            String curWord = words[i];

            boolean invalidWord = preWord.charAt(preWord.length() - 1)
                != curWord.charAt(0);

            // 끝말잇기 실패 또는 중복 단어
            if (invalidWord || !usedWords.add(curWord)) {
                return new int[] {(i % n) + 1, (i / n) + 1};
            }
        }

        // 끝말잇기 성공
        return new int[] {0, 0};
    }
}