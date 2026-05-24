import java.util.*;

/**
 * 문제 : [3차] 파일명 정렬
 * level : 2
 *
 * HEAD -> NUMBER 순으로 정렬
 * HEAD는 대소문자 구분 없이 비교
 * NUMBER는 숫자 기준 오름차순
 */
class Solution {

    private static final int NUM_LEN = 5;

    // 파일 정보
    class FileInfo {

        String originName;
        String head;
        int number;

        public FileInfo(
                String originName,
                String head,
                int number
        ) {
            this.originName = originName;
            this.head = head;
            this.number = number;
        }
    }

    public String[] solution(String[] files) {

        List<FileInfo> fileList = new ArrayList<>();

        // 파일 정보 파싱
        for (String file : files) {
            fileList.add(parseFile(file));
        }

        // 파일 정렬
        fileList.sort(this::compareFileInfo);

        String[] answer = new String[files.length];

        // 정렬된 원본 파일명 추출
        for (int i = 0; i < fileList.size(); i++) {
            answer[i] = fileList.get(i).originName;
        }

        return answer;
    }

    // 파일 정렬 기준 비교
    private int compareFileInfo(FileInfo o1, FileInfo o2) {

        // HEAD 기준 오름차순 (대소문자 무시)
        int headCompare =
                o1.head.compareToIgnoreCase(o2.head);

        if (headCompare != 0) {
            return headCompare;
        }

        // NUMBER 기준 오름차순
        return Integer.compare(o1.number, o2.number);
    }

    // 파일명 파싱
    private FileInfo parseFile(String file) {

        int idx = 0;
        int len = file.length();

        StringBuilder head = new StringBuilder();

        // HEAD 파싱
        while (idx < len) {

            char ch = file.charAt(idx);

            // 숫자가 나오면 종료
            if (Character.isDigit(ch)) {
                break;
            }

            head.append(ch);
            idx++;
        }

        StringBuilder number = new StringBuilder();

        // NUMBER 파싱
        while (idx < len && number.length() < NUM_LEN) {

            char ch = file.charAt(idx);

            // 숫자가 아니면 종료
            if (!Character.isDigit(ch)) {
                break;
            }

            number.append(ch);
            idx++;
        }

        return new FileInfo(
                file,
                head.toString(),
                Integer.parseInt(number.toString())
        );
    }
}